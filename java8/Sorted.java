package java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sorted {
	
	public static void main(String[] args) {
		Sorted s = new Sorted();
		String[] strs = new String[] {"abcd", "abtgeh", "abl"}; //abl, abtgeh, tecd
		System.out.println(s.longestCommonPrefix(strs));
	}
	
	public String longestCommonPrefix(String[] strs) {
		Arrays.sort(strs);
//		List<String> inputs = Arrays.stream(strs).sorted(Comparator.comparing(String::length))
//        		.collect(Collectors.toList());
		char[] strFirst = strs[0].toCharArray(); //abl
		char[] strLast = strs[strs.length - 1].toCharArray(); //abtgeh
		int end = -1;
		for(int i = 0; i < strFirst.length && i < strLast.length; i++) {
			if(strFirst[i] == strLast[i]) {
				end = i;
			}else {
				break;
			}
		}
		// 使用 toString() 打印出来的是地址
        return new String(strFirst).substring(0, end + 1);
    }

}
