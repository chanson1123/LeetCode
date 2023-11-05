package searching;

import java.util.Arrays;

public class FindFirstLast {

	public static void main(String[] args) {
		FindFirstLast s = new FindFirstLast();
		int[] nums = { 5, 7, 7, 8, 8, 10 };
		int[] result = s.searchRange(nums, 8);
		Arrays.stream(result).forEach(System.out::println);
	}

	// [5,7,7,8,8,10]
	public int[] searchRange(int[] nums, int target) {
		if (nums.length == 0) {
			return new int[] { -1, -1 };
		}
		int first = findFirst(nums, target);
		int last = first;
		if (first == -1) {
			return new int[] { -1, -1 };
		}
		while (last < nums.length && nums[last] == nums[first]) {
			last++;
		}
		return new int[] { first, last - 1 };
	}

	private int findFirst(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left < right - 1) {
			int mid = (left + right) / 2;
			if (nums[mid] == target) {
				right = mid;
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		if (nums[left] == target) {
			return left;
		}
		if (nums[right] == target) {
			return right;
		}
		return -1;
	}

}
