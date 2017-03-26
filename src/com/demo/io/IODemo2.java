package com.demo.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IODemo2 {
	public static void main(String[] args) throws IOException{
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream("input.txt");
			out = new FileOutputStream("output.txt");
//			int c;			
//			while ((c = in.read()) != -1) {
//				out.write(c);
//			}
			byte[] buff = new byte[1024];
			while (in.read(buff,0,1024) != -1) {
				out.write(buff);
			}
		} finally{
			if(in != null){
				in.close();
			}
			if(out != null){
				out.close();
			}
		}
	}
}
