package Leetcode;

public class LC038 {
	//array的四类index操作
	//两头index夹的子类：binary search
	//一头index记录长度/计数分两类：和自己前后比设一个count；设两个index i,j相减得到长度。
	public String countAndSay1(int n) {
		if(n == 1) {
			return "1";
		}
		char[] src = countAndSay1(n-1).toCharArray();
		StringBuilder builder = new StringBuilder();
		int j = 0;
		for(int i=0; i<src.length; i++) {
			if(src[i] != src[j]) {
				builder.append(i-j).append(src[j]);
				j = i;
			}
		}
		builder.append(src.length-j).append(src[j]);
		return builder.toString();
	}
	
	public String countAndSay2(int n) {
		if(n == 1) {
			return "1";
		}
		char[] src = countAndSay2(n-1).toCharArray();
		StringBuilder builder = new StringBuilder();
		int count = 1;
		for(int i=0; i<src.length-1; i++) {
			if(src[i] == src[i+1]) {
				count++;
			}else {
				builder.append(count).append(src[i]);
				count = 1;
			}
		}
		builder.append(count).append(src[src.length-1]);
		return builder.toString();
	}
}
