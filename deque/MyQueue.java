package deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyQueue {

	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.push(1);
		queue.push(2);
		queue.push(3);
		for(int i = 1; i <= 3; i++) {
			System.out.println(queue.pop());
		}
	}
	
	private Deque<Integer> in_stack = new ArrayDeque<>();
	private Deque<Integer> out_stack = new ArrayDeque<>();
	
	public void push(Integer x) {
		in_stack.offerFirst(x);
	}
	
	public Integer pop() {
		move();
		return out_stack.isEmpty() ? null : out_stack.pollFirst();
	}
	
	public Integer top() {
		move();
		return out_stack.isEmpty() ? null : out_stack.peekFirst();
	}
	
	private void move() {
		if(out_stack.isEmpty()) {
			while(!in_stack.isEmpty()) {
				out_stack.offerFirst(in_stack.poll());
			}
		}
	}
	
}
