package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//有一个directory，下面很多text files，找出含相同content files，打印出他们的文件名和相同内容行数
public class FindCommonTxt {

	public static void main(String[] args) {
		FindCommonTxt s = new FindCommonTxt();
		File directory = new File("src/io/abc");
		File[] files = directory.listFiles();
		for(int i = 0; i < files.length - 1; i++) {
			for(int j = i+1; j < files.length; j++) {
				s.findCommonTxt(files[i], files[j]);
			}
		}
	}
	
	public void findCommonTxt(File file1, File file2) {
		String s;
		BufferedReader bufferedReader1 = null;
		BufferedReader bufferedReader2 = null;
		try {
			bufferedReader1 = new BufferedReader(new InputStreamReader(new FileInputStream(file1)));
			bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file2)));
			List<String> list1 = new ArrayList<>();
			List<String> list2 = new ArrayList<>();
			//写在while-loop中少写了初始条件&循环条件
			while((s = bufferedReader1.readLine()) != null) {
				list1.add(s);
			}
			while((s = bufferedReader2.readLine()) != null) {
				list2.add(s);
			}
			for(int i = 0; i < list1.size(); i++) {
				for(int j = 0; j < list2.size(); j++) {
					if(list1.get(i).equals(list2.get(j))) {
						System.out.println("content: " + list1.get(i) + "@ " + file1.getName() + (i+1) + "@ " + file2.getName() + (j+1));
					}
				}
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader1 != null) {
					bufferedReader1.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (bufferedReader2 != null) {
					bufferedReader2.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
