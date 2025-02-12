package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LC049 {
	public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sortedStr = new String(arr);
            if(map.containsKey(sortedStr)){
                map.get(sortedStr).add(str);
            }else{
            	//Arrays.asList()返回一个特殊的固定长度的list
            	//new ArrayList<>(Arrays.asList())会把生成的list copy到新的array list
                map.put(sortedStr, new ArrayList<>(Arrays.asList(str)));
            }
        }
        map.forEach((key, value) -> res.add(value));
        return res;
    }
	
	//map的6种遍历方法
	public static void main(String[] args) {
		Map<String, List<String>> map = new HashMap<>();
		//method 1: entrySet() Set<Map.Entry<K,V>>
		for(Map.Entry<String, List<String>> entrySet : map.entrySet()) {
			System.out.println(entrySet.getKey() + entrySet.getValue());
		}
		//method 2: keySet() Set<K>
		for(String key : map.keySet()) {
			System.out.println(map.get(key));
		}
		//method 3: values() Collection<V>
		new ArrayList<List<String>>().addAll(map.values()); //Collection<List<String>>
		//method 4: iterator (Collection -> List Set Queue都实现了Iterator, Map间接实现)
		Iterator<Map.Entry<String, List<String>>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()) {
			Map.Entry<String, List<String>> entry = iterator.next();
			System.out.println(entry.getKey() + entry.getValue());
		}
		//method 5: Java8 forEach() (Collection + Map) 数组用Arrays.stream()转化
		map.forEach((key, value) -> {
			System.out.println(key + value);
		});
		//method 6: Java8 stream (Collection接口的实现类可以使用stream())
		map.entrySet().stream().forEach(entry -> {
			System.out.println(entry.getKey() + entry.getValue());
		});
	}
}
