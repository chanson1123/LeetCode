package Leetcode;

import java.util.Arrays;

public class LC016 {

	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int minDiff = Integer.MAX_VALUE;
		int sum = 0;
		for(int i = 0; i < nums.length-2; i++) {
			int j = i+1;
			int k = nums.length-1;
			while(j < k) {
				int diff = Math.abs(nums[i]+nums[j]+nums[k]-target);
				if(diff==0) {
					return target;
				}
				if(diff <= minDiff) {
					sum = nums[i]+nums[j]+nums[k];
					minDiff = diff;
				}
				if(nums[i]+nums[j]+nums[k]<target) {
					j++;
				}else {
					k--;
				}
			}
		}
		return sum;
	}
	
}
