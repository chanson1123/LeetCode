package deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {

	public static void main(String[] args) {
		ValidParentheses s = new ValidParentheses();
		String input = "[[()]";
		System.out.println(s.isValid(input));
	}
	// 比较运算符 == 可以比较两个null,不可以比较null和一个常量
	public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(Character c : s.toCharArray()){
            if(!stack.isEmpty() && stack.peekFirst() == '(' && c == ')'){
                stack.pollFirst();
            }else if(!stack.isEmpty() && stack.peekFirst() == '[' && c == ']') {
            	stack.pollFirst();
            }else if(!stack.isEmpty() && stack.peekFirst() == '{' && c == '}') {
            	stack.pollFirst();
            }else {
            	stack.offerFirst(c);
            }
        }
        if(stack.isEmpty()) {
        	return true;
        }
        return false;
    }
	
}
