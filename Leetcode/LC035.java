package Leetcode;

public class LC035 {
	public int searchInsert(int[] nums, int target) {
		int left = 0;
		int right = nums.length-1;
		while(left < right-1) {
			int mid = (left+right)/2;
			if(nums[mid] == target) {
				return mid;
			}else if(nums[mid] < target) {
				left = mid;
			}else {
				right = mid;
			}
		}
		if(nums[left] >= target) {
			return left;
		}
		if(nums[right] >= target) {
			return right;
		}
		return right+1;
	}
}
