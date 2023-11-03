package deque;

import java.util.ArrayDeque;
import java.util.Queue;

public class MyStack {

	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack.top());
	}
	
	private Queue<Integer> queue = new ArrayDeque<>(); 
	
	public boolean push(Integer x) {
		queue.offer(x);
		return true;
	}
	
	public Integer pop() {
		if(queue.size() == 0) {
			return null;
		}
		int size = queue.size();
		for(int i = 1; i< size; i++) {
			queue.offer(queue.poll());
		}
		return queue.poll();
	}
	
	public Integer top() {
		if(queue.size() == 0) {
			return null;
		}
		Integer res = this.pop();
		queue.offer(res);
		return res;
	}
	
}
