package Leetcode;

public class LC045 {
	public int jump(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = 0;
		for(int i=0; i<nums.length; i++) {
			if(nums[i] > 0) {
				int jumpLength = nums[i];
				for(int j=1; j<=jumpLength; j++) {
					if(i+j < nums.length && dp[i+j] == 0) {
						dp[i+j] = dp[i]+1;
					}
				}
			}
		}
		return dp[nums.length-1];
	}
}
