package string;

public class Solution8 {

	public static void main(String[] args) {
		Solution8 s = new Solution8();
		String input = new String("A1B2C3D");
		String result = s.shuffle(input);
		System.out.println(result);
	}
	
	public String shuffle(String input) {
		if(input == null || input.length() == 1) {
			return input;
		}
		char[] array = input.toCharArray();
		char[] result = shuffle(array, 0, array.length - 1);
		return new String(result);
	}
	
	private char[] shuffle(char[] array, int left, int right) {
		if(left == right) {
			return new char[] {array[left]};
		}
		int mid = left + (right - left) / 2;
		char[] one = shuffle(array, left, mid);
		char[] two = shuffle(array, mid+1, right);
		return merge(one, two);
	}
	
	private char[] merge(char[] one, char[] two) {
		char[] result = new char[one.length + two.length];
		int p1 = 0;
		int p2 = 0;
		int p = 0;
		while(p1 < one.length && p2 < two.length) {
			if(compare(one[p1], two[p2])) {
				result[p++] = one[p1++];
			}else {
				result[p++] = two[p2++];
			}
		}
		while(p1 < one.length) {
			result[p++] = one[p1++];
		}
		while(p2 < two.length) {
			result[p++] = two[p2++];
		}
		return result;
	}
	
	private boolean compare(char a, char b) {
		if(a >= 'A' && a <= 'Z' && b >= '0' && b <= '9') {
			return true;
		}else if(a >= '0' && a <= '9' && b >= 'A' && b <= 'Z') {
			return false;
		}else {
			return a < b;
		}
	}
	
}
