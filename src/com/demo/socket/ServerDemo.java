package com.demo.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
	static Socket socket = null;
	static Thread clientSay = null;
	
	public static void main(String[] args) throws IOException {
		System.err.println("Server");
		System.out.println("等待客户端的连接......");
		
		ServerSocket server = new ServerSocket(8000);
		socket = server.accept();
		
		System.out.println("连接成功，请说话......输入“再见”退出");		
		clientSay = new ClientSay();
		clientSay.start();
		
		PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
		
		BufferedReader sin = new  BufferedReader(new InputStreamReader(System.in));
		String line = "";
		while (!line.equals("再见")) {			
			line = sin.readLine();
			out.println(line);
		}
		out.close();
		sin.close();
		socket.close();
		System.out.println("Server已退出！");
	}
	
	static class ClientSay extends Thread{
		BufferedReader in = null;
		@Override
		public void run() {
			if(socket != null){		
				try {
					in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					String line = null;
					while(socket.isConnected() && (line = in.readLine()) != null){
						System.out.println("Client:" + line);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
