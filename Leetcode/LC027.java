package Leetcode;

public class LC027 {
	public int removeElement(int[] nums, int val) {
		int k = 0;
		int i = 0;
		for(int j = 0; j < nums.length; j++) {
			if(nums[j] != val) {
				nums[i++] = nums[j];
				k++;
			}
		}
		return k;
	}
}
