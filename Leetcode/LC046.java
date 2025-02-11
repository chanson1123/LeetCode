package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LC046 {
	public List<List<Integer>> permute(int[] nums){
		List<List<Integer>> output = new ArrayList<>();
		permute(nums, 0, output);
		return output;
	}
	//permutations里start代表位置(for-loop遍历所有元素和start位置的元素swap)
	//combination sums里start代表元素
	private void permute(int[] nums, int start, List<List<Integer>> output) {
		if(start == nums.length-1) {
			output.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
			return;
		}
		for(int i=start; i<nums.length; i++) {
			swap(nums, start, i);
			permute(nums, start+1, output);
			swap(nums, start, i);
		}
	}
	
	private void swap(int[] nums, int x, int y) {
		int temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
	}
}
