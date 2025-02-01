package Leetcode;

import java.util.HashSet;
import java.util.Set;

public class LC003 {

	public int lengthOfLongestSubstring(String s) {
		char[] arr = s.toCharArray();
		Set<Character> set = new HashSet<>();
		int maxLength = 0;
		int start = 0;
		int end = 0;
		while(end < arr.length) {
			if(!set.contains(arr[end])) {
				set.add(arr[end++]);
				maxLength = Math.max(maxLength, end - start);
			}else {
				set.remove(arr[start++]);
			}
		}
		return maxLength;
	}
	
}
