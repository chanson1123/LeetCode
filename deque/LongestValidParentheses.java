package deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestValidParentheses {

	public static void main(String[] args) {
		LongestValidParentheses s = new LongestValidParentheses();
		System.out.println(s.longestValidParentheses(")()())"));
	}
	
	public int longestValidParentheses(String s) {
		if(s.length() < 2) {
        	return 0;
        }
        int length = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.offerFirst(-1);
        for(int i = 0; i < s.length(); i++) {
        	if(s.charAt(i) == '(') {
        		stack.offerFirst(i);
        	}else {
        		stack.pollFirst();
        		if(stack.isEmpty()) {
        			stack.offerFirst(i);
        		}else {
        			length = Math.max(length, i - stack.peekFirst());
        		}
        	}
        }
        return length;
	}
	
	public int longestValidParentheses2(String s) {
        if(s.length() < 2) {
        	return 0;
        }
        int length = 0;
        for(int i = 0; i < s.length(); i++) {
        	for(int j = s.length() - 1; j > i; j--) {
        		String substr = s.substring(i, j + 1);
        		if(isValid(substr)) {
        			length = Math.max(length, substr.length());
        			break;
        		}
        	}
        }
        return length;
    }
	
	private boolean isValid(String s) {
		Deque<Character> stack = new ArrayDeque<>();
		for(int i = 0; i < s.length(); i++) {
			if(!stack.isEmpty() && stack.peekFirst() == '(' && s.charAt(i) == ')') {
				stack.pollFirst();
			}else {
				stack.offerFirst(s.charAt(i));
			}
		}
		if(stack.isEmpty()) {
			return true;
		}
		return false;
	}
	
}
