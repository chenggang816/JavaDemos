package com.demo.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientDemo {
	
	static Socket socket;
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.err.println("Client");
//		socket = new Socket("192.168.101.133",8000);
		socket = new Socket("127.0.0.1",8000);
		
		Thread serverSay = new ServerSay();
		serverSay.start();
		
		//
		PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
		//
		BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		System.out.println("����������......���롰�ټ����˳�");
		while (!(line = sin.readLine()).equals("�ټ�")) {
			out.println(line);
			if(line == null){
				break;
			}			
		}
		
		out.close();
		sin.close();
		socket.close();
		System.out.println("Client���˳���");
	}
	static class ServerSay extends Thread {
		@Override
		public void run() {
			BufferedReader in = null;
			//���շ������˵�����
			try {
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String line ;
				while((line= in.readLine()) != null){
					System.out.println("Server:" + line);
				}	
			} catch (IOException e) {
				System.out.println("�����ѶϿ�");
//				e.printStackTrace();
			}finally{
				
			}
		}
	}
}
