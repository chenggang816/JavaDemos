package com.demo.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class IODemo4L {
	public static void main(String[] args) throws IOException{
		BufferedReader in = null;
		BufferedWriter out = null;
		try {
//			FileReader fr = new FileReader("input.txt");
//			in = new BufferedReader(fr);
			in = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt"),"GBK"));
			out = new BufferedWriter(new FileWriter("output1.txt"));
			
			String s = null;
			while ((s = in.readLine()) != null) {
				out.write(s + "\n");
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
