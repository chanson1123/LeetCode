package searching;

public class Solution5 {

	public int binarySearch(int[] array, int target) {
		if(array == null || array.length == 0) {
			return -1;
		}
		int left = 0;
		int right = array.length - 1;
		while(left < right - 1) {
			int mid = left + (right - left) / 2;
			if(array[mid] == target) {
				right = mid;
			}else if(array[mid] > target) {
				right = mid;
			}else {
				left = mid + 1;
			}
		}
		if(array[left] >= target) {
			return left;
		}
		if(array[right] >= target) {
			return right;
		}
		return -1;
	}
	
}
