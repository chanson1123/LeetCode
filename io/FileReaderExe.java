package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExe {

	// I/O stream 分类：
	// 			输入流			输出流
	//字节流		InputStream		OutputStream
	//字符流		Reader			Writer
	
	public static void main(String[] args) {
		FileReader fileReader = null;
		try {
			File file = new File("src/io/abc/abc.txt");
			fileReader = new FileReader(file);
			int data = fileReader.read();
			while(data != -1) {
				System.out.print((char)data);
				data = fileReader.read();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileReader != null) {
					fileReader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		FileReader fileReader2 = null;
		try {
			File file2 = new File("src/io/abc/def.txt");
			fileReader2 = new FileReader(file2);
			char[] cbuf = new char[5];
			int num = fileReader2.read(cbuf);
			while(num != -1) {
				for(int i = 0; i < num; i++) {
					System.out.print(cbuf[i]);
				}
				num = fileReader2.read(cbuf);
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fileReader2 != null) {
					fileReader2.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
