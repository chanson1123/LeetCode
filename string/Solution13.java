package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution13 {

	public static void main(String[] agrs) {
		Solution13 s = new Solution13();
		String[] input = new String[] {"abc","abc","bca","cc"};
		List<List<String>> res = s.findAnagrams(input);
		for(int i = 0; i < res.size(); i++) {
			for(String x : res.get(i)) {
				System.out.println(x);	
			}
			System.out.println("~");
		}
	}
	
	public List<List<String>> findAnagrams(String[] input){
		List<List<String>> res = new ArrayList<>();
		if(input == null) {
			return res;
		}
		Map<String, List<String>> map = new HashMap<>();
		for(String s : input) {
			char[] arr = s.toCharArray();
			Arrays.sort(arr);
			String key = new String(arr);
			if(!map.containsKey(key)) {
				List<String> value = new ArrayList<>();
				map.put(key, value);
			}
			map.get(key).add(s);
		}
		res.addAll(map.values());
		return res;
	}
	
}
