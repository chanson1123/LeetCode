package string;

public class Solution3 {

	public static void main(String[] args) {
		Solution3 s = new Solution3();
		String input = new String("aabcadddeeaf");
		String result = s.deDup2(input);
		System.out.println(result);
	}
	
	public String deDup1(String input) {
		if(input == null || input.length() <= 1) {
			return input;
		}
		char[] array = input.toCharArray();
		int j = 1;
		for(int i = 1; i < array.length; i++) {
			if(array[i] == array[j - 1]) {
				continue;
			}else {
				array[j++] = array[i];
			}
		}
		return new String(array, 0, j);
	}
	
	public String deDup2(String input) {
		if(input == null || input.length() <= 1) {
			return input;
		}
		char[] array = input.toCharArray();
		int j = -1;
		for(int i = 0; i < array.length; i++) {
			if(j == -1 || array[i] != array[j]) {
				array[++j] = array[i];
			}else {
				while(i < array.length - 1 && array[i] == array[i+1]) {
					i++;
				}
				j--;
			}
		}
		return new String(array, 0, j+1);
	}
	
}
