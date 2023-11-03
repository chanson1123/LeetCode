package dfs;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	
	public static void main(String[] args) {
		GenerateParentheses s = new GenerateParentheses();
		List<String> result = s.generateParenthesis(3);
		result.stream().forEach(System.out::println);
	}
	
	public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<>();
        int left = n;
        int right = n;
        dfs("", left, right, output);
        return output;
    }
	
	private void dfs(String combination, int left, int right, List<String> output) {
		if(left == 0 && right == 0) {
			output.add(combination);
			return;
		}
		//如果把 left right 定义在dfs()之外，就是对局部变量的修改了
		if(left > 0) {
			dfs(combination + '(', left - 1, right, output);
		}
		if(left < right) {
			dfs(combination + ')', left, right - 1, output);
		}
		
	}

}
