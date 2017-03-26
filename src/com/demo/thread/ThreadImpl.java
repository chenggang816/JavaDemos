package com.demo.thread;

public class ThreadImpl extends Thread{
	Thread t;
	String threadName;
	public ThreadImpl(String threadName) {
		// TODO Auto-generated constructor stub
		this.threadName = threadName;
	}
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(threadName + ":" + i);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Thread " + threadName + " is exited!");
	}
	public void start() {
		t = new Thread(this,threadName);
		t.start();
	}
}
