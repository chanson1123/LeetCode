package searching;

public class Solution2 {

	public static void main(String[] args) {
		Solution2 s = new Solution2();
		int[][] matrix = new int[][]{{1,2,3},{4,5,7}};
		int[] result = s.binarySearch(matrix, 4);
		System.out.println(result[0]);
		System.out.println(result[1]);
	}
	
	public int[] binarySearch(int[][] matrix, int target) {
		if(matrix == null) {
			return new int[]{-1, -1};
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int left = 0;
		int right = m * n - 1;
		while(left <= right) {
			int mid = left + (right - left) / 2;
			if(matrix[mid / n][mid % n] == target) {
				return new int[]{mid / n, mid % n};
			}else if(matrix[mid / n][mid % n] < target) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		return new int[]{-1, -1};
	}
	
}
