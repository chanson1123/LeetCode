package sorting;

import java.util.Random;

public class Solution3 {

	public static void main(String[] args) {
		Solution3 s = new Solution3();
		int[] array = new int[] {2,64,73,2,7,2,5,8,11};
		int[] result = s.quickSort(array);
		for(int x : result) {
			System.out.println(x);
		}
	}
	
	public int[] quickSort(int[] array) {
		if(array == null || array.length == 0) {
			return array;
		}
		return quickSort(array, 0, array.length - 1);
	}
	
	private int[] quickSort(int[] array, int left, int right) {
		if(left >= right) {
			return array;
		}
		int pivot = new Random().nextInt(right - left + 1) + left;
		swap(array, right, pivot);
		int i = 0;
		int j = right - 1;
		while(i <= j) {
			if(array[i] <= array[right]) {
				i++;
			}else {
				swap(array, i, j);
				j--;
			}
		}
		swap(array, i, right);
		quickSort(array, left, i - 1);
		quickSort(array, i + 1, right);
		return array;
	}
	
	private void swap(int[] array, int x, int y) {
		int tmp = array[x];
		array[x] = array[y];
		array[y] = tmp;
	}
	
}
