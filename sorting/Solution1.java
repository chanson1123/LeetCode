package sorting;

public class Solution1 {

	public static void main(String[] args) {
		Solution1 s = new Solution1();
		int[] input = new int[] {3,6,9,8,2,1,1};
		int[] res = s.selectionSort(input);
		for(int x : res) {
			System.out.println(x);
		}
	}
	
	public int[] selectionSort(int[] input) {
		if(input == null || input.length == 0) {
			return input;
		}
		for(int i = 0; i < input.length - 1; i++) {
			int minIndex = i;
			for(int j = i + 1; j < input.length; j++) {
				if(input[j] < input[minIndex]) {
					minIndex = j;
				}
			}
			swap(input, minIndex, i);
		}
		return input;
	}
	
	private void swap(int[] array, int x, int y) {
		int tmp = array[x];
		array[x] = array[y];
		array[y] = tmp;
	}
}
