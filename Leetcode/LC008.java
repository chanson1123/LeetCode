package Leetcode;

public class LC008 {

	public int myAtoi(String s) {
		char[] arr = s.toCharArray();
		int i = 0;
		long res = 0;
		while(i < arr.length && arr[i] == ' ') {
			i++;
		}
		boolean sign = true;
		if(i < arr.length && arr[i] == '+') {
			sign = true;
			i++;
			if(i < arr.length && arr[i] == '-') {
				return 0;
			}
		}
		if(i < arr.length && arr[i] == '-') {
			sign = false;
			i++;
			if(i < arr.length && arr[i] == '+') {
				return 0;
			}
		}
		while(i < arr.length && arr[i] == '0') {
			i++;
		}
		while(i < arr.length) {
			if(arr[i] >= '0' && arr[i] <= '9') {
				res = res*10 + arr[i] - '0';
				if(sign == true && res > Integer.MAX_VALUE) {
					return Integer.MAX_VALUE;
				}
				if(sign == false && res > Integer.MAX_VALUE) {
					return Integer.MIN_VALUE;
				}
			}else {
				break;
			}
			i++;
		}
		if(sign == false) {
			return -(int)res;
		}
		return (int)res;
	}
	
}
