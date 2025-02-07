package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC040 {
	public List<List<Integer>> combinationSum2(int[] candidates, int target){
		Arrays.sort(candidates);
		List<List<Integer>> output = new ArrayList<>();
		backtrack(candidates, target, 0, new ArrayList<>(), output);
		return output;
	}
	//candidates中每个元素有多个，但只能使用一次
	private void backtrack(int[] candidates, int target, int start, 
			List<Integer> combination, List<List<Integer>> output) {
		if(target < 0) {
			return;
		}
		if(target == 0) {
			output.add(new ArrayList<>(combination));
			return;
		}
		//每个元素使用一次，递归到下一层的时候start+1
		//for-loop中i++时候start也变化
		//index i 从start开始遍历candidates，寻找合适的sub-problem solver
		for(int i=start; i<candidates.length; i++) {
			if(i > start && candidates[i] == candidates[i-1]) {
				continue;
			}
			combination.add(candidates[i]);
			backtrack(candidates, target-candidates[i], i+1, combination, output);
			combination.remove(combination.size()-1);
		}
	}
}
