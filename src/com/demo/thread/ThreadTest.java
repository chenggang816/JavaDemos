package com.demo.thread;

public class ThreadTest {
	public static void main(String[] args) {
		RunnableImpl r1 = new RunnableImpl("Thread1");
		r1.Start();
		RunnableImpl r2 = new RunnableImpl("Thread2");
		r2.Start();
		
		ThreadImpl t3 = new ThreadImpl("Thread3");
		t3.start();
		ThreadImpl t4 = new ThreadImpl("Thread4");
		t4.start();
	}
}
