package com.demo.io;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IODemo5 {
	public static void main(String[] args) throws IOException{
		InputStreamReader isr = null;
		OutputStreamWriter osw = null;
		try {
			String str = System.getProperty("file.encoding");
			System.out.println("系统默认字符集：" + str);
			
			System.out.println("请输入数据：");
			
			int ch;
			isr = new InputStreamReader(System.in,"GBK");
			osw = new OutputStreamWriter(System.out);
			while ((ch = isr.read()) != '\n') {
				osw.write(ch);
			}
			osw.flush();
		} finally{
			if(isr != null){
				isr.close();
			}	
			if(osw != null){
				osw.close();
			}
		}
	}
}
