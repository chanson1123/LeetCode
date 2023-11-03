package string;

public class Solution4 {

	public static void main(String[] args) {
		Solution4 s = new Solution4();
		String par = new String("abcde");
		String sub = new String("dcb");
		System.out.println(s.isSubstring(sub, par));
	}
	
	public boolean isSubstring(String sub, String par) {
		for(int i = 0; i <= par.length() - sub.length(); i++) {
			if(check(par, i, sub)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean check(String par, int start, String sub) {
		for(int i = 0; i < sub.length(); i++) {
			if(par.charAt(start + i) != sub.charAt(i)) {
				return false;
			}
		}
		return true;
	}
	
}
