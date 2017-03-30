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
	//δͬ������������һ�������һ��Ϊ3000
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
