package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC022 {
	public List<String> generateParenthesis(int n){
		List<String> output = new ArrayList<>();
		if(n==0) {
			return output;
		}
		dfs("",n,n,output);
		return output;
	}
	
	private void dfs(String combination, int left, int right, List<String> output) {
		if(left==0 && right==0) {
			output.add(combination);
			return;
		}
		if(left>0) {
			dfs(combination+"(",left-1,right,output);
		}
		if(left<right) {
			dfs(combination+")",left,right-1,output);
		}
	}
}
