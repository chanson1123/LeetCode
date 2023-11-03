package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


public class Solution1 {

	public static void main(String[] args) {
		Solution1 s = new Solution1();
		int[] input = new int[] {4,7,3,2,7,8,2,1,4,6};
		int[] result = s.kSmall(input, 4);
		for(int x : result) {
			System.out.println(x);
		}
	}
	
	public int[] kSmall(int[] input, int k) {
		Queue<Integer> maxHeap = new PriorityQueue<>(k, 
				new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1.equals(o2)) {
					return 0;
				}
				return o1 > o2 ? -1 : 1;
			}
		});
		for(int num : input) {
			if(maxHeap.size() < k) {
				maxHeap.offer(num);
			}else if(maxHeap.peek() > num) {
				maxHeap.poll();
				maxHeap.offer(num);
			}
		}
		int[] res = new int[k];
		for(int i = k - 1; i >= 0; i--) {
			res[i] = maxHeap.poll();
		}
		return res;
	}
	
}
