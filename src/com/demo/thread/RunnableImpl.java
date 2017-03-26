package com.demo.thread;

public class RunnableImpl implements Runnable{

	private String threadName;
	private Thread thread;
	public RunnableImpl(String threadName) {
		// TODO Auto-generated constructor stub
		this.threadName = threadName;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
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

	public void Start() {
		thread = new Thread(this,threadName);
		thread.start();
	}
}
