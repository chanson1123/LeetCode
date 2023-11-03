package searching;

public class Solution1 {

	public static void main(String[] args) {
		Solution1 s = new Solution1();
		int[] input = new int[] {1,2,3,4,5};
		int result = s.binarySearch(input, 3);
		System.out.println(result);
	}
	
	public int binarySearch(int[] array, int target) {
		if(array == null || array.length == 0) {
			return -1;
		}
		int left = 0;
		int right = array.length - 1;
		while(left <= right) {
			int mid = left + (right - left) / 2;
			if(array[mid] == target) {
				return mid;
			}else if(array[mid] < target) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		return -1;
	}
	
}
