package Leetcode;

public class LC005 {

	public String longestPalindrome(String s) {
		char[] arr = s.toCharArray();
		int start = 0;
		int end = 0;
		for(int i = 0; i < arr.length; i++) {
			int left = i;
			int right = i;
			while(left >= 0 && arr[left] == arr[i]) {
				left--;
			}
			while(right < arr.length && arr[right] == arr[i]) {
				right++;
			}
			while(left >= 0 && right < arr.length) {
				if(arr[left] != arr[right]) {
					break;
				}else {
					left--;
					right++;
				}
			}
			left += 1;
			if(right - left >= end - start) {
				start = left;
				end = right;
			}
		}
		return s.substring(start, end);
	}
	
}
