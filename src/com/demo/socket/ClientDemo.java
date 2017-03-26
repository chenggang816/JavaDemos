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
				while(socket.isConnected()){
					System.out.println("Server:" + in.readLine());
				}	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				
			}
		}
	}
}
