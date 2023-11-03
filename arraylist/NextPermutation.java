package arraylist;

import java.io.File;
import java.util.Arrays;

public class NextPermutation {

	public static void main(String[] args) {
		NextPermutation s = new NextPermutation();
		int[] arr = {3,2,1};
		s.nextPermutation(arr);
		Arrays.stream(arr).forEach(System.out::println);
		File file = new File("src/io/abc/abc.txt");
		System.out.println(file.getAbsolutePath());
	}
	
	public void nextPermutation(int[] arr) {
		//1.找到 break point，从后往前看有减小的值才有不同permutation可能
		//2.从后往前找 great point
		//3.swap bp & gp, reverse the right half
		//112653 -> 113256 (可以假设只有53), 因为有减小的趋势，所以65肯定比2大，所以reverse
		int bp = -1;
		for(int i = arr.length - 2; i >= 0; i--) {
			if(arr[i] < arr[i + 1]) {
				bp = i;
				break;
			}
		}
		if(bp == -1) {
			reverse(arr, 0, arr.length - 1);
			return;
		}
		for(int j = arr.length - 1; j >= 0; j--) {
			if(arr[j] > arr[bp]) {
				swap(arr, bp, j);
				break;
			}
		}
		reverse(arr, bp + 1, arr.length - 1);
	}
	
	private void swap(int[] nums, int x, int y) {
		int tmp = nums[x];
		nums[x] = nums[y];
		nums[y] = tmp;
	}
	
	private void reverse(int[] nums, int x, int y) {
		while(x < y) {
			int tmp = nums[x];
			nums[x] = nums[y];
			nums[y] = tmp;
			x++;
			y--;
		}
	}
	
}
