package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC001 {

	public static void main(String[] args) {
		LC001 lc = new LC001();
		int[] nums = new int[] {-2,-1,0,1,2};
		int[] result = lc.twoSum(nums,2);
		Arrays.stream(result).forEach(System.out::println);
	}
	
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i])) {
				return new int[] {map.get(nums[i]), i};
			}
			map.put(target - nums[i], i);
		}
		return new int[] {-1,-1};
	}
	
}
