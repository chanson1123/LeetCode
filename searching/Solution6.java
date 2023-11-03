package searching;

public class Solution6 {

	public static void main(String[] args) {
		Solution6 s = new Solution6();
		int[] input = new int[] {1,2,3,3,6,9,10};
		int[] result = s.kClosest(input, 3, 4);
		for(int x : result) {
			System.out.println(x);
		}
	}
	
	public int[] kClosest(int[] array, int target, int k) {
		if(array == null || array.length == 0) {
			return array;
		}
		int left = largestOrLastEqual(array, target);
		int right = left + 1;
		int[] result = new int[k];
		for(int i = 0; i < k; i++) {
			if(left < 0 || (right < array.length && (array[right] - target < array[left] - target))) {
				result[i] = array[right++];
			}else {
				result[i] = array[left--];
			}
		}
		return result;
	}
	
	private int largestOrLastEqual(int[] array, int target) {
		int left = 0;
		int right = array.length - 1;
		while(left < right - 1) {
			int mid = left + (right - left) / 2;
			if(array[mid] == target) {
				left = mid;
			}else if(array[mid] < target) {
				left = mid;
			}else {
				right = mid - 1;
			}
		}
		if(array[right] <= target) {
			return right;
		}
		if(array[left] <= target) {
			return left;
		}
		return -1;
	}
	
}
