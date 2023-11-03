package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution10 {

	public static void main(String[] args) {
		Solution10 s = new Solution10();
		String input = new String("abac");
		List<String> result = s.allSets(input);
		result.stream().forEach(System.out :: println);
	}
	
	public List<String> allSets(String input){
		if(input == null || input.length() <= 1) {
			List<String> list = new ArrayList<>();
			list.add(input);
			return list;
		}
		char[] array = input.toCharArray();
		List<String> res = new ArrayList<>();
		permute(array, 0, res);
		return res;
	}
	
	private void permute(char[] array, int index, List<String> res) {
		if(index == array.length) {
			res.add(new String(array));
		}
		Set<Character> set = new HashSet<>();
		for(int i = index; i < array.length; i++) {
			if(set.contains(array[i])) {
				continue;
			}
			set.add(array[i]);
			swap(array, i, index);
			permute(array, index + 1, res);
			swap(array, i, index);
		}
	}
	
	private void swap(char[] array, int x, int y) {
		char tmp = array[x];
		array[x] = array[y];
		array[y] = tmp;
	}
	
}
