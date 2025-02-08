package Leetcode;

public class LC043 {
	public String multiply(String num1, String num2) {
		char[] n1 = num1.toCharArray();
		char[] n2 = num2.toCharArray();
		int[] res = new int[n1.length+n2.length];
		for(int i=n1.length-1; i>=0; i--) {
			for(int j=n2.length-1; j>=0; j--) {
				res[i+j+1] += (n1[i]-'0')*(n2[j]-'0');
				res[i+j] += res[i+j+1]/10;
				res[i+j+1] = res[i+j+1]%10;
			}
		}
		int start = 0;
		while(start < res.length && res[start] == 0) {
			start++;
		}
		StringBuilder builder = new StringBuilder();
		while(start < res.length) {
			builder.append(res[start++]);
		}
		return builder.length() == 0 ? "0" : builder.toString();
	}
}
