package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedExe {
	
	public static void main(String[] args) {
		File file1 = new File("src/io/abc/abc.txt");
		File file2 = new File("src/io/abc/dest.txt");
		FileReader fileReader = null;
		FileWriter fileWriter = null;
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		int num;
		try {
			fileReader = new FileReader(file1);
			fileWriter = new FileWriter(file2);
			bufferedReader = new BufferedReader(fileReader);
			bufferedWriter = new BufferedWriter(fileWriter);
			char[] cbuf = new char[5];
			while((num = bufferedReader.read(cbuf)) != -1) {
				bufferedWriter.write(cbuf, 0, num);
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedWriter != null) {
					bufferedWriter.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
