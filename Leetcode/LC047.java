package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LC047 {
	public List<List<Integer>> permuteUnique(int[] nums){
		List<List<Integer>> output = new ArrayList<>();
		permute(nums, 0, output);
		return output;
	}
	
	private void permute(int[] nums, int start, List<List<Integer>> output) {
		if(start == nums.length-1) {
			output.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
			return;
		}
		for(int i=start; i<nums.length; i++) {
			//combination sum只需check前一个元素
            //permutations不行，因为swap会打乱顺序
            //permutations需要check start开始的所有元素：[-1,-1(start等待被替换的元素),1,0,1(i当前元素),0,2]
			if(hasDuplicates(nums, start, i)) {
				continue;
			}
			swap(nums, start, i);
			permute(nums, start+1, output);
			swap(nums, start, i);
		}
	}
	
	private boolean hasDuplicates(int[] nums, int start, int current) {
		for(int j=start; j<current; j++) {
			if(nums[j] == nums[current]) {
				return true;
			}
		}
		return false;
	}
	
	private void swap(int[] nums, int x, int y) {
		int temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
	}
}
