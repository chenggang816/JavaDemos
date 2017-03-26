package com.demo.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class IODemo3_FileReader {
	public static void main(String[] args) throws IOException{
		FileReader in = null;
		FileWriter out = null;
		try {
			in = new FileReader("input.txt");
			out = new FileWriter("output.txt");
			int c;			
			while ((c = in.read()) != -1) {
				out.write(c);
			}
//			char[] buff = new char[1024];
//			while (in.read(buff,0,1024) != -1) {
//				out.write(buff);
//			}
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
