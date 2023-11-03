package string;

public class Solution6 {

	public static void main(String[] args) {
		Solution6 s = new Solution6();
		String sentence = new String("I love MS");
		String result = s.reverse(sentence);
		System.out.println(result);
	}
	
	public String reverse(String sentence) {
		char[] array = sentence.toCharArray();
		reverse(array, 0, array.length - 1);
		int j = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] == ' ') {
				reverse(array, j, i-1);
				j = i + 1;
			}
		}
		reverse(array, j, array.length - 1);
		return new String(array);
	}
	
	private void reverse(char[] array, int i, int j) {
		while(i < j) {
			char tmp = array[i];
			array[i] = array[j];
			array[j] = tmp;
			i++;
			j--;
		}
	}
	
}
