package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC017 {

	public List<String> letterCombinations(String digits){
		List<String> output = new ArrayList<>();
		if(digits.length()==0) {
			return output;
		}
		String[] p_map = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		backtrack("",digits,p_map,output);
		return output;
	}
	
	private void backtrack(String combination, String input, String[] p_map, List<String> output) {
		if(input.length()==0) {
			output.add(combination);
			return;
		}
		String letters = p_map[input.charAt(0)-'2'];
		for(char letter : letters.toCharArray()) {
			backtrack(combination+letter,input.substring(1),p_map,output);
		}
	}
	
}
