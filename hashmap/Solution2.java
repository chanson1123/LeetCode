package hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {

	public static void main(String[] args) {
		Solution2 s = new Solution2();
		List<Integer> list1 = Arrays.asList(1,1,2,3,5,5,7);
		List<Integer> list2 = Arrays.asList(1,1,2,3);
		List<Integer> res = s.findCommon(list1, list2);
		res.stream().forEach(System.out::println);
	}
	
	public List<Integer> findCommon(List<Integer> list1, List<Integer> list2){
		List<Integer> result = new ArrayList<>();
		Map<Integer, Integer> map1 = new HashMap<>();
		for(Integer x : list1) {
			Integer count = map1.get(x);
			if(count == null) {
				map1.put(x, 1);
			}else {
				map1.put(x, count + 1);
			}
		}
		Map<Integer, Integer> map2 = new HashMap<>();
		for(Integer x : list2) {
			Integer count = map2.get(x);
			if(count == null) {
				map2.put(x, 1);
			}else {
				map2.put(x, count + 1);
			}
		}
		for(Map.Entry<Integer, Integer> entry1 : map1.entrySet()) {
			Integer count2 = map2.get(entry1.getKey());
			if(count2 != null) {
				int minValue = Math.min(entry1.getValue(), count2);
				for(int i = 1; i <= minValue; i++) {
					result.add(entry1.getKey());
				}
			}
		}
		return result;
	}
	
}
