package com.demo.socket;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;

public class ClientSimple {
	public static void main(String args[]) throws Exception {  
		//Ϊ�˼���������е��쳣��ֱ��������  
		String host = "127.0.0.1";  //Ҫ���ӵķ����IP��ַ  
		int port = 8899;   //Ҫ���ӵķ���˶�Ӧ�ļ����˿�  
		//�����˽�������  
		Socket client = new Socket(host, port);  
		//�������Ӻ�Ϳ����������д������  
		Writer writer = new OutputStreamWriter(client.getOutputStream());  
		writer.write("Hello Server.");  
		writer.write("eof");  
		writer.flush();//д���Ҫ�ǵ�flush  
		//д���Ժ���ж�����  
		Reader reader = new InputStreamReader(client.getInputStream());  
		char chars[] = new char[64];  
		int len;  
		StringBuilder sb = new StringBuilder();  
	      String temp;  
	      int index;  
	      while ((len=reader.read(chars)) != -1) {  
	         temp = new String(chars, 0, len);  
	         if ((index = temp.indexOf("eof")) != -1) {//����eofʱ�ͽ�������  
	            sb.append(temp.substring(0, index));  
	            break;  
	         }  
	         sb.append(temp);  
	      }  
	      System.out.println("from Server: " + sb);  
		writer.close();  
		reader.close();  
		client.close(); 
	}  
}
