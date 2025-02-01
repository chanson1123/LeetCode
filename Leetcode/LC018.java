package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC018 {
	
	public static void main(String[] args) {
		long x = 1000000000;
		System.out.print(4*x);
	}

	public List<List<Integer>> fourSum(int[] nums, int target){
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		if(nums.length<4) {
			return result;
		}
		for(int i=0;i<nums.length-3;i++) {
			for(int j=i+1;j<nums.length-2;j++) {
				int m=j+1;
				int n=nums.length-1;
				while(m<n) {
					long sum = (long)nums[i]+nums[j]+nums[m]+nums[n];
					if(sum==target) {
						result.add(Arrays.asList(nums[i],nums[j],nums[m],nums[n]));
						while(m<nums.length-1 && nums[m]==nums[m+1]) {
							m++;
						}
						while(n>=3 && nums[n]==nums[n-1]) {
							n--;
						}
						m++;
						n--;
					}else if(sum<target) {
						m++;
					}else {
						n--;
					}
				}
				while(j<nums.length-2 && nums[j]==nums[j+1]) {
					j++;
				}
			}
			while(i<nums.length-3 && nums[i]==nums[i+1]) {
				i++;
			}
		}
		return result;
	}
	
}
