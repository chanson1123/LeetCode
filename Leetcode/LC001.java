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
			int remainder = target - nums[i];
			if(map.containsKey(remainder)) {
				return new int[] {i, map.get(remainder)};
			}
			map.put(nums[i], i);
		}
		return new int[] {-1,-1};
	}
	
}
