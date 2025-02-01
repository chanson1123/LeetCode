package Leetcode;

public class LC009 {

	public boolean isPalindrome(int x) {
		if(x < 0) {
			return false;
		}
		int y = x;
		long reverse = 0;
		while(x != 0) {
			reverse = reverse*10 + x%10;
			x = x/10;
		}
		if(y == reverse) {
			return true;
		}
		return false;
	}
	
}
