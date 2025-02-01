package Leetcode;

import java.util.Arrays;

public class LC014 {

	public String longestCommonPrefix(String[] strs) {
		Arrays.sort(strs);
		char[] firstStr = strs[0].toCharArray();
		char[] lastStr = strs[strs.length-1].toCharArray();
		int end = -1;
		for(int i = 0; i < firstStr.length && i < lastStr.length; i++) {
			if(firstStr[i] == lastStr[i]) {
				end = i;
			}else {
				break;
			}
		}
		return strs[0].substring(0, end+1);
	}
	
}
