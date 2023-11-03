package dfs;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {

	public static void main(String[] args) {
		LetterCombinations s = new LetterCombinations();
		String digits = "23";
		List<String> result = s.letterCombinations(digits);
		result.stream().forEach(System.out::println);
	}
	
	public List<String> letterCombinations(String digits){
		List<String> output = new ArrayList<>();
		String[] mapping = new String[] {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		dfs("", digits, mapping, output);
		return output;
	}
	
	private void dfs(String combination, String input, String[] mapping, List<String> output) {
		if(input.length() == 0) {
			output.add(combination);
			return;
		}else {
			String letters = mapping[input.charAt(0) - '2']; //不需要Map
			for(Character letter : letters.toCharArray()) {
				//str.substring(length) -> an empty string
				dfs(combination + letter, input.substring(1), mapping, output);
			}
		}
	}
	
}
