package heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution2 {

	public static void main(String[] args) {
		Solution2 s = new Solution2();
		int[] input = new int[] {3,5,7,9,3,5,1};
		int[] result = s.kSmall(input, 4);
		for(int x : result) {
			System.out.println(x);
		}
	}
	
	public int[] kSmall(int[] input, int k) {
		Queue<Integer> minHeap = new PriorityQueue<>(input.length);
		for(int num : input) {
			minHeap.offer(num);
		}
		int[] res = new int[k];
		for(int i = 0; i < k; i++) {
			res[i] = minHeap.poll();
		}
		return res;
	}
	
}
