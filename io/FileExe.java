package io;

import java.io.File;
import java.util.Arrays;

public class FileExe {

	public static void main(String[] args) {
		File file1 = new File("/Users/changche/eclipse-workspace/code/test.txt");
		System.out.println(file1.getName());
		System.out.println(file1.getAbsolutePath());
		System.out.println(file1.getParent());
		System.out.println(file1.length());
		System.out.println(file1.lastModified());
		
		File file2 = new File("src/io/abc/def.txt");
		System.out.println(file2.getName());
		System.out.println(file2.getParent());
		System.out.println(file2.getAbsolutePath());
		System.out.println(file2.length());
		System.out.println(file2.exists());
		System.out.println(file2.isFile());
		
		File file3 = new File("src/io/abc");
		String[] files = file3.list();
		File[] files2 = file3.listFiles();
		Arrays.stream(files).forEach(System.out::println);
		System.out.println(file3.isDirectory());
		
		//在abc.txt相同目录下创建def.txt
		File file4 = new File("src/io/abc/abc.txt");
		File file5 = new File(file4.getAbsoluteFile().getParent(), "def.txt");
		System.out.println(file5.getAbsolutePath());
		
		//判断一个文件夹下是否有txt文件，有的话打印这些文件名
		File directory = new File("src/io/abc");
		if(directory.exists()) {
			String[] fileNames = directory.list();
			Arrays.stream(fileNames).filter(f -> f.endsWith(".txt")).forEach(System.out::println);
		}
		
		FileExe s = new FileExe();
		s.printFileName(new File("src/io/abc"));
		System.out.println(s.calculateSize(new File("src/io/abc")));
		
	}
	
	//打印文件目录下所有文件名
	public void printFileName(File file) {
		if(file.exists() && file.isFile()) {
			System.out.println(file.getName());
		}else if(file.exists() && file.isDirectory()) {
			File[] files = file.listFiles();
			Arrays.stream(files).forEach(f -> printFileName(f));
		}
	}
	
	//计算文件目录下所有文件大小
	//recursion = smaller problem + recursion rule + base case
	public long calculateSize(File file) {
		long size = 0;
		if(file.exists() && file.isFile()) {
			size += file.length();
		}else if(file.exists() && file.isDirectory()) {
			File[] files = file.listFiles();
			long sum = Arrays.stream(files).mapToLong(f -> calculateSize(f)).sum();
			size += sum;
		}
		return size;
	}
	
}
