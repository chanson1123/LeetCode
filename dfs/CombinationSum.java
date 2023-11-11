package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		CombinationSum s = new CombinationSum();
		int[] candidates = {2,3,6,7};
		List<List<Integer>> result = s.combinationSum(candidates, 7);
		result.stream().forEach(l -> {l.stream().forEach(System.out::print); 
									  System.out.println();
		});
		List<Integer> list = Arrays.asList(1,2,3);
		List<Integer> list2 = new ArrayList<Integer>(list);
		list2.stream().forEach(System.out::print);
	}
	
	//Input: candidates = [2,3,6,7], target = 7
	//Output: [[2,2,3],[7]]
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(candidates, 0, target, list, output);
        return output;
    }
	
	private void helper(int[] input, int start, int target, List<Integer> list, List<List<Integer>> output) {
		if(target == 0) {
			//list是reference value，之后remove()操作会对list elements进行修改，所以此处new ArrayList()
			output.add(new ArrayList<Integer>(list));
			return;
		}
		for(int i = start; i < input.length; i++) {
			if(input[i] <= target) {
				list.add(input[i]);
				helper(input, i, target - input[i], list, output);
				list.remove(list.size() - 1);
			}
		}
	}
	
}
