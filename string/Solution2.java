package string;

public class Solution2 {
	
	public String removeSpace(String input) {
		if(input == null || input.length() == 0) {
			return input;
		}
		char[] array = input.toCharArray();
		int j = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] == ' ' && (i == 0 || array[i - 1] == ' ')) {
				continue;
			}
			array[j++] = array[i];
		}
		if(j > 0 && array[j - 1] == ' ') {
			j--;
		}
		return new String(array, 0, j);
	}
	
}
