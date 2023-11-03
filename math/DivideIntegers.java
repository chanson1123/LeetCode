package math;

//Bit Operation
public class DivideIntegers {

	public static void main(String[] args) {
		DivideIntegers s = new DivideIntegers();
		System.out.println(s.divide(-10, 3));
	}
	
	public int divide(int dividend, int divisor) {
		boolean isNegative = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
		//转化成long防止溢出
		long absDividend = (long)Math.abs(dividend); //10
		long absDivisor = (long)Math.abs(divisor); //3
		long result = 0;
		while(absDividend > absDivisor) {
			long tmpDivisor = absDivisor;
			long count = 1;
			//快进键 10=3*2+3*1+1
			while(tmpDivisor<<1 <= absDividend) {
				tmpDivisor<<=1;
				count<<=1;
			}
			result += count;
			absDividend -= tmpDivisor;
		}
		return isNegative?(-1)*(int)result:(int)result;
	}
	
	
}
