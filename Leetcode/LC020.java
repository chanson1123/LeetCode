package Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC020 {

	public boolean isValid(String s) {
		Deque<Character> stack = new ArrayDeque<>();
		for(int i=0;i<s.length();i++) {
			if(stack.isEmpty()) {
				stack.offerLast(s.charAt(i));
			}else if(stack.peekLast()=='(' && s.charAt(i)==')') {
				stack.pollLast();
			}else if(stack.peekLast()=='[' && s.charAt(i)==']') {
				stack.pollLast();
			}else if(stack.peekLast()=='{' && s.charAt(i)=='}') {
				stack.pollLast();
			}else {
				stack.offerLast(s.charAt(i));
			}
		}
		if(stack.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
}
