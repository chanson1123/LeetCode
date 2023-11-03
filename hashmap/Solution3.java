package hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.*;

public class Solution3 {

	public static void main(String[] args) {
		Solution3 s = new Solution3();
		String[] input = new String[] {"bo", "bo", "cc", "cc", "cc"};
		String[] result = s.topK(input, 1);
		Arrays.asList(result).stream().forEach(System.out :: println);
	}
	
	public String[] topK(String[] input, int k) {
		Map<String, Integer> map = buildMap(input);
		Queue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, 
				new Comparator<Map.Entry<String, Integer>>(){
			@Override
			public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
				return entry1.getValue().compareTo(entry2.getValue());
			}
		});
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			if(minHeap.size() < k) {
				minHeap.offer(entry);
			}else if(minHeap.peek().getValue() < entry.getValue()) {
				minHeap.poll();
				minHeap.offer(entry);
			}
		}
		String[] result = buildRes(minHeap);
		return result;
	}
	
	private Map<String, Integer> buildMap(String[] input){
		Map<String, Integer> map = new HashMap<>();
		for(String s : input) {
			Integer count = map.get(s);
			if(count == null) {
				map.put(s, 1);
			}else {
				map.put(s, count + 1);
			}
		}
		return map;
	}
	
	private String[] buildRes(Queue<Map.Entry<String, Integer>> minHeap) {
		String[] res = new String[minHeap.size()];
		for(int i = res.length - 1; i >= 0; i--) {
			res[i] = minHeap.poll().getKey();
		}
		return res;
	}
	
}
