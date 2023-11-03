package sorting;

public class Solution2 {

	public static void main(String[] args) {
		Solution2 s = new Solution2();
		int[] input = new int[] {3,6,2,8,4,8,4,5};
		int[] result = s.mergeSort(input);
		for(int x : result) {
			System.out.println(x);
		}
	}
	
	public int[] mergeSort(int[] array) {
		if(array == null || array.length == 0) {
			return array;
		}
		return mergeSort(array, 0, array.length - 1);
	}
	
	private int[] mergeSort(int[] array, int left, int right) {
		if(left == right) {
			return new int[]{array[left]};
		}
		int mid = left + (right - left) / 2;
		int[] one = mergeSort(array, left, mid);
		int[] two = mergeSort(array, mid + 1, right);
		return merge(one, two);
	}
	
	private int[] merge(int[] one, int[] two) {
		int[] res = new int[one.length + two.length];
		int p = 0;
		int p1 = 0;
		int p2 = 0;
		while(p1 < one.length && p2 < two.length) {
			if(one[p1] <= two[p2]) {
				res[p++] = one[p1++];
			}else {
				res[p++] = two[p2++];
			}
		}
		while(p1 < one.length) {
			res[p++] = one[p1++];
		}
		while(p2 < two.length) {
			res[p++] = two[p2++];
		}
		return res;
	}
	
}
