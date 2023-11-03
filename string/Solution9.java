package string;

public class Solution9 {

	//{ 1, 2, 3, 4, 5, 6} → { 1, 4, 2, 5, 3, 6 }
	public static void main(String[] args) {
		Solution9 s = new Solution9();
		String input = new String("123456");
		String result = s.shuffle(input);
		System.out.println(result);
	}
	
	public String shuffle(String input) {
		if(input == null || input.length() == 2) {
			return input;
		}
		char[] array = input.toCharArray();
		shuffle(array, 0, array.length - 1);
		return new String(array);
	}
	
	private void shuffle(char[] array, int left, int right) {
		int size = right - left + 1;
		if(size == 2) {
			return;
		}
		int mid = left + size / 2;
		int leftMid = left + size / 4;
		int rightMid = left + size * 3 / 4;
		//leftMid, rightMid, mid 都是第二段区间的首个字符
		reverse(array, leftMid, mid - 1);
		reverse(array, mid, rightMid - 1);
		reverse(array, leftMid, rightMid - 1);
		//坐标到个数，个数再到坐标
		//原第二个区间第一个坐标减去原第一个区间第一个坐标等于第一个区间元素总个数 = 1
		// 2*1 = 新的区间里拥有的元素总个数
		// -1 是因为元素总个数和对应坐标之间差个1
		shuffle(array, left, left + 2 * (leftMid - left) - 1);
		shuffle(array, left + 2 * (leftMid - left), right);
	}
	
	private void reverse(char[] array, int x, int y) {
		while(x < y) {
			char tmp = array[x];
			array[x] = array[y];
			array[y] = tmp;
			x++;
			y--;
		}
	}
	
}
