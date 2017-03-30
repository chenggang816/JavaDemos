package com.demo.thread;

public class SynchronizedDemo {
	public static void main(String[] args) {
		Counter counter = new Counter();
		new Thread(new MyRunnable(counter)).start();
		new Thread(new MyRunnable(counter)).start();
		new Thread(new MyRunnable(counter)).start();
	}
	
	
}
class MyRunnable implements Runnable{
	Counter counter = null;
	public MyRunnable(Counter c) {
		counter = c;
	}
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			counter.add();
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(counter.getC());
	}
}
class Counter{
	private int c = 0;
	//未同步，输出的最后一个结果不一定为3000
	public void add() {
	c++;
	}
	
//	public synchronized void add() {
//		c++;
//	}
	
//	public void add() {
//		synchronized (this) {
//			c++;
//		}
//	}
	public int getC() {
		return c;
	}
}
