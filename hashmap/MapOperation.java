package hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MapOperation {

	public static void main(String[] args) {
		Map<String, List<String>> map = new HashMap<>();
		//method 1: entrySet()
		for(Map.Entry<String, List<String>> entrySet : map.entrySet()) {
			System.out.println(entrySet.getKey() + entrySet.getValue());
		}
		//method 2: keySet()
		for(String key : map.keySet()) {
			System.out.println(map.get(key));
		}
		//method 3: values()
		new ArrayList<>().add(map.values());
		//method 4: iterator()
		Iterator<Map.Entry<String, List<String>>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()) {
			Map.Entry<String, List<String>> entry = iterator.next();
			System.out.println(entry.getKey() + entry.getValue());
		}
		//method 5: java8 forEach()
		List<List<String>> list = new ArrayList<>();
		map.forEach((key, value) -> {
			System.out.println(key);
			list.add(value);
		});
		//method 6: java8 stream()
		map.entrySet().stream().forEach(entry -> System.out.print(entry.getKey()));
	}
}
