package Leetcode;

public class LC031 {
	public void nextPermutation(int[] arr) {
		int breakpoint = -1;
		for(int i=arr.length-2; i>=0; i--) {
			if(arr[i] < arr[i+1]) {
				breakpoint = i;
				break;
			}
		}
		if(breakpoint == -1) {
			reverse(arr, 0);
			return;
		}
		for(int j=arr.length-1; j>breakpoint; j--) {
			if(arr[j] > arr[breakpoint]) {
				swap(arr, breakpoint, j);
				reverse(arr, breakpoint+1);
				break;
			}
		}
	}
	
	private void swap(int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
	
	private void reverse(int[] arr, int start) {
		int end = arr.length-1;
		while(start < end) {
			swap(arr, start, end);
			start++;
			end--;
		}
	}
}
