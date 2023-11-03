package string;

public class LongestPalindrome {
	
	public static void main(String[] args) {
		LongestPalindrome s = new LongestPalindrome();
		String input = "ebaaabf";
		String result = s.findTheOne(input);
		System.out.println(result);
	}
	
	public String findTheOne(String input) {
		char[] array = input.toCharArray();
		int start = 0;
		int end = 0;
		for(int i = 0; i < array.length; i++) {
			int left = i; 
			int right = i;
			while(left >= 0 && array[left] == array[i]) {
				left--;
			}
			while(right < array.length && array[right] == array[i]) {
				right++;
			}
			while(left >= 0 && right < array.length) {
				if(array[left] == array[right]) {
					left--;
					right++;
				}else {
					break;
				}
			}
			left++;
			if(right - left > end - start) {
				start = left;
				end = right;
			}
		}
		return input.substring(start, end);
	}
	
}
