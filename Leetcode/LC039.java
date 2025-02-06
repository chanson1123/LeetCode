package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC039 {
	public List<List<Integer>> combinationSum(int[] candidates, int target){
		List<List<Integer>> output = new ArrayList<>();
		backtrack(candidates, target, 0, new ArrayList<>(), output);
		return output;
	}
	//candidates中每个元素只有一个，但可以使用多次
	private void backtrack(int[] candidates, int target, int start, 
			List<Integer> combination, List<List<Integer>> output) {
		if(target < 0) {
			return;
		}
		if(target == 0) {
			output.add(new ArrayList<>(combination));
		}
		//一个元素使用多次：递归下一层的时候start不变
		//去重：for-loop中i++时候，start改变
		for(int i=start; i<candidates.length; i++) {
			combination.add(candidates[i]);
			backtrack(candidates, target-candidates[i], i, combination, output);
			combination.remove(combination.size()-1);
		}
	}
}
