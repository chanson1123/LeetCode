package searching;

public class SearchRotatedArray {

	public static void main(String[] args) {
		SearchRotatedArray s = new SearchRotatedArray();
		int[] nums = {4,5,6,0,1,2,3};
		System.out.println(s.search(nums, 3));
	}
	
	// 4 5 6 0 1 2 3
	// 4 5 6 7 0 1 2
	public int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while(left <= right) {
			int mid = (left + right) / 2;
			if(nums[mid] == target) {
				return mid;
			}
			if(nums[left] < nums[mid]) {
				if(nums[left] <= target && nums[mid] > target) {
					right = mid - 1;
				}else {
					left = mid + 1;
				}
			}else {
				if(nums[mid] < target && nums[right] >= target) {
					left = mid + 1;
				}else {
					right = mid - 1;
				}
			}
		}
		return -1;
	}
	
}
