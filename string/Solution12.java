package string;

import java.util.HashSet;
import java.util.Set;

public class Solution12 {

	public static void main(String[] agrs) {
		Solution12 s = new Solution12();
		String input = new String("cajhvcjahvdsdshvaaad");
		int result = s.maxSubStr(input);
		System.out.print(result);
	}
	
	public int maxSubStr(String input) {
		if(input == null) {
			return 0;
		}
		Set<Character> set = new HashSet<>();
		int slow = 0;
		int fast = 0;
		int res = 0;
		while(fast < input.length()) {
			if(set.contains(input.charAt(fast))) {
				set.remove(input.charAt(slow++));
			}else {
				set.add(input.charAt(fast++));
				res = Math.max(res, fast - slow);
			}
		}
		return res;
	}
	
}
