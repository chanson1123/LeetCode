package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Reduce {
	
	public static void main(String[] args) {
		Reduce r = new Reduce();
		
		//reduce用于求和类
		List<Integer> list = Arrays.asList(1,2,3,4);
		Integer result = list.stream().reduce(0, (a, b) -> a + b);
		System.out.print(result);
		System.out.println();
		
		List<String> aList = Arrays.asList("aaaa", "abc");
		System.out.println(aList.stream().filter(str -> r.startWithA(str)).mapToInt(s -> r.length(s)).max());
		//reduce用于最值类
		int[] nums = new int[] {1,3,5,6,8};
		int max = Arrays.stream(nums).reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b);
		System.out.println(max);
		
		//string 的 split 和 join
		String str = "aa,bb,cc";
		String[] strArr = str.split(",");
		Arrays.stream(strArr).forEach(s -> System.out.println(s));
		String[] strSet = new String[] {"a","b","c"};
		String res = String.join("|", strSet);
		System.out.println(res);
		
		String[] strs = {"a","b","c","d"};
		String r2 = Arrays.stream(strs).reduce("", (a,b) -> {
			if(a.equals("")) {
				return b;
			}else {
				return a + "|" + b;
			}
		});
		System.out.println(r2);
	
		
	}

	public boolean startWithA(String str) {
		return str.startsWith("a");
	}
	
	public int length(String str) {
		return str.length();
	}
}
