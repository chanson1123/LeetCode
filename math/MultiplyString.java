package math;

public class MultiplyString {

	public static void main(String[] args) {
		MultiplyString s = new MultiplyString();
		System.out.print(s.multiply("123", "456"));
	}
	
	public String multiply(String num1, String num2) {
		if(num1.equals("0") || num2.equals("0")) {
			return "0";
		}
		int[] result = new int[num1.length() + num2.length()];
		for(int i = num1.length() - 1; i >= 0; i--) {
			for(int j = num2.length() - 1; j >= 0; j--) {
				result[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				result[i + j] += result[i + j + 1] / 10;
				result[i + j + 1] = result[i + j + 1] % 10;
			}
		}
		int i = 0;
		while(i < result.length && result[i] == 0) {
			i++;
		}
		StringBuilder sb = new StringBuilder();
		while(i < result.length) {
			sb.append(result[i]);
			i++;
		}
		return sb.toString();
	}
	
}
