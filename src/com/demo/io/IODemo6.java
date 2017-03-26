package com.demo.io;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IODemo6 {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("output2.txt");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		DataOutputStream out = new DataOutputStream(bos);
		out.writeInt(1);
		out.writeDouble(79.00);
		out.writeUTF("张三");
		out.close();
		
		DataInputStream in = new DataInputStream(new FileInputStream("output2.txt"));
		int number = in.readInt();
		double score = in.readDouble();
		String name = in.readUTF();
		System.out.format("学号：%d 姓名： %s 成绩：%.2f\n",number,name,score);
		in.close();
	}
}
