package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC015 {

	public List<List<Integer>> threeSum(int[] nums){
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		for(int i = 0; i < nums.length-2; i++) {
			int j = i+1;
			int k = nums.length-1;
			while(j < k) {
				if(nums[i]+nums[j]+nums[k]==0) {
					result.add(Arrays.asList(nums[i],nums[j],nums[k]));
					while(j<nums.length-1 && nums[j]==nums[j+1]) {
						j++;
					}
					while(k>=2 && nums[k]==nums[k-1]) {
						k--;
					}
					j++;
					k--;
				}else if(nums[i]+nums[j]+nums[k]<0) {
					j++;
				}else {
					k--;
				}
			}
			while(i<nums.length-2 && nums[i]==nums[i+1]) {
				i++;
			}
		}
		return result;
	}
	
}
