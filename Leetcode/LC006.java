package Leetcode;

import java.util.Arrays;

public class LC006 {

	public String convert(String s, int numRows) {
		if(numRows == 1 || numRows >= s.length()) {
			return s;
		}
		StringBuilder[] builders = new StringBuilder[numRows];
		Arrays.setAll(builders, StringBuilder::new);
		int j = 0;
		int direction = 1;
		for(int i = 0; i < s.length(); i++) {
			builders[j].append(s.charAt(i));
			if(j == 0) {
				direction = 1;
			}
			if(j == numRows - 1) {
				direction = -1;
			}
			j += direction;
		}
		return Arrays.stream(builders)
				.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
				.toString();
	}
	
}
