package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// every element can be used once
public class CombinationSumII {

	public static void main(String[] args) {
		CombinationSumII s = new CombinationSumII();
		int[] candidates = {10,1,2,7,6,1,5};
		List<List<Integer>> result = s.combinationSum2(candidates,8);
		result.stream().forEach(l -> {
			l.stream().forEach(System.out::print);
			System.out.println();
		});
	}
	
	//input = [10,1,2,7,6,1,5], target = 8
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, 0, target, list, output);
        return output;
    }
	
	private void helper(int[] input, int start, int target, List<Integer> list, List<List<Integer>> output) {
		if(target == 0) {
			output.add(new ArrayList<Integer>(list));
			return;
		}
		for(int i = start; i < input.length; i++) {
			//remove duplicates
			if (i > start && input[i - 1] == input[i]) {
                continue;
            }
			if(input[i] <= target) {
				list.add(input[i]);
				helper(input, i + 1, target - input[i], list, output);
				list.remove(list.size() - 1);
			}
		}
	}
	
}
