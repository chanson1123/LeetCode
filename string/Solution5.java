package string;

public class Solution5 {

	public static void main(String[] args) {
		Solution5 s = new Solution5();
		String input = "abcde";
		String result = s.reverse(input);
		System.out.println(result);
	}
	
	public String reverse(String input) {
		if(input == null || input.length() <= 1) {
			return input;
		}
		char[] array = input.toCharArray();
		int i = 0;
		int j = array.length - 1;
		while(i < j) {
			swap(array, i, j);
			i++;
			j--;
		}
		return new String(array);
	}
	
	private void swap(char[] array, int i, int j) {
		char tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
}
