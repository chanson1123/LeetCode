package Leetcode;

public class LC026 {
	public int removeDuplicates(int[] nums) {
		int k = 1;
		int i = 0;
		for(int j = 0; j < nums.length; j++) {
			if(nums[j] != nums[i]) {
				nums[++i] = nums[j];
				k++;
			}
		}
		return k;
	}
}
