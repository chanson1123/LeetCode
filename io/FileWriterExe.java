package io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExe {

	public static void main(String[] args) {
		FileWriter fileWriter1 = null;
		try {
			File file = new File("src/io/abc/abc.txt");
			fileWriter1 = new FileWriter(file, true);
			fileWriter1.write("\nsleepy bee");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileWriter1 != null) {
					fileWriter1.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		FileReader fileReader = null;
		FileWriter fileWriter = null;
		try {
			File file2 = new File("src/io/abc/def.txt");
			File file3 = new File("src/io/abc/dest.txt");
			fileReader = new FileReader(file2);
			fileWriter = new FileWriter(file3, true);
			
			int num;
			char[] cbuf = new char[5];
			while((num = fileReader.read(cbuf)) != -1) {
				fileWriter.write(cbuf, 0, num);
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileReader != null) {
					fileReader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (fileWriter != null) {
					fileWriter.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
