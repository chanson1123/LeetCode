package Leetcode;

public class LC055 {
	public boolean canJump(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = 1;
		for(int i=0; i<nums.length; i++) {
			if(dp[i] == 1 && nums[i] > 0) {
				int jumpLength = nums[i];
				for(int j=1; j<=jumpLength; j++) {
					if(i+j < nums.length && dp[i+j] == 0) {
						dp[i+j] = 1;
					}
				}
			}
		}
		if(dp[nums.length-1] == 0) {
			return false;
		}else {
			return true;
		}
	}
}
