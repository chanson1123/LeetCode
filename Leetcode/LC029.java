package Leetcode;

public class LC029 {
	public int divide(int dividend, int divisor) {
		boolean isNegative = false;
		if((dividend > 0 && divisor < 0) ||(dividend < 0 && divisor > 0)) {
			isNegative = true;
		}
		long newDividend = Math.abs((long)dividend);
		long newDivisor = Math.abs((long)divisor);
		long sum = 0;
		long res = 0;
		while(sum < newDividend) {
			sum += newDivisor;
			if(sum > newDividend) {
				break;
			}
			res++;
		}
		if(isNegative) {
			return -(int)res;
		}else {
			return (int)res;
		}
	}
}
