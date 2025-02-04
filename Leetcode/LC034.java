package Leetcode;

public class LC034 {
	public int[] searchRange(int[] nums, int target) {
		if(nums.length == 0) {
			return new int[] {-1,-1};
		}
		int first = searchFirst(nums, target);
		if(first == -1) {
			return new int[] {-1,-1};
		}
		int last = first;
		while(last < nums.length && nums[last] == nums[first]) {
			last++;
		}
		return new int[] {first,last-1};
	}
	
	private int searchFirst(int[] nums, int target) {
		int left = 0;
		int right = nums.length-1;
		while(left < right-1) {
			int mid = (left+right)/2;
			if(nums[mid] == target) {
				right = mid;
			}else if(nums[mid] < target) {
				left = mid+1;
			}else {
				right = mid-1;
			}
		}
		if(nums[left] == target) {
			return left;
		}
		if(nums[right] == target) {
			return right;
		}
		return -1;
	}
}
