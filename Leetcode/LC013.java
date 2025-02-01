package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC013 {

	public int romanToInt(String s) {
		char[] arr = s.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		int i = arr.length - 1;
		int res = map.get(arr[i--]);
		while(i >= 0) {
			if(map.get(arr[i]) >= map.get(arr[i+1])) {
				res += map.get(arr[i]);
			}else {
				res -= map.get(arr[i]);
			}
			i--;
		}
		return res;
	}
	
}
