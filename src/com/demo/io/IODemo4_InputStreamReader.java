package com.demo.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class IODemo4_InputStreamReader {
	public static void main(String[] args) throws IOException{
		InputStreamReader isr = null;
		try {
			String str = System.getProperty("file.encoding");
			System.out.println("系统默认字符集：" + str);
			
			int ch;
			isr = new InputStreamReader(new FileInputStream("input.txt"),"GBK");
			while ((ch = isr.read()) != -1) {
				System.out.print((char)ch);
			}
		} finally{
			if(isr != null){
				isr.close();
			}			
		}
	}
}
