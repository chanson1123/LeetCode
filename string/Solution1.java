package string;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {

	public static void main(String[] args) {
		Solution1 s = new Solution1();
		String input = new String("abcde");
		String target = new String("bcd");
		String result = s.removeChars(input, target);
		System.out.println(result);
	}
	
	public String removeChars(String input, String target) {
		if(input == null || input.length() == 0) {
			return input;
		}
		Set<Character> set = buildSet(target);
		char[] array = input.toCharArray();
		int j = 0;
		for(int i = 0; i < array.length; i++) {
			if(!set.contains(array[i])) {
				array[j++] = array[i];
			}
		}
		return new String(array, 0, j);
	}
	
	private Set<Character> buildSet(String target){
		Set<Character> set = new HashSet<>();
		for(int i = 0; i < target.length(); i++) {
			set.add(target.charAt(i));
		}
		return set;
	}
	
}
