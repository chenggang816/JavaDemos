package com.demo.thread;

public class CommunicationDemo {
	public static void main(String[] args) throws InterruptedException {
		long start = System.currentTimeMillis();
		
		final MySignal mySignal = new MySignal();
		final Sumer sum = new Sumer();
		mySignal.setCount(20);
		for (int i = 0; i < 20; i++) {
//			Thread.sleep(100);
//			sum.add(5);		
			
			Thread thread = new Thread(){
				public void run() {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (mySignal) {
						sum.add(5);
						mySignal.reduceCount(1);
						mySignal.doNotify();
					}
				};
			};
			thread.start();
		}
		synchronized(mySignal){
			mySignal.wait();
		}
		long end = System.currentTimeMillis();
		long costtime = end - start;
		System.out.println("用时：" + costtime + "ms\n结果：" + sum.getSum());
	}
}
class MySignal{
	private int count = 0;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public void reduceCount(int value) {
		this.count -= value;
	}
	public void doNotify() {
		if (count <= 0) {
			synchronized (this) {
				this.notify();
			}
		}
	}
}
class Sumer{
	private int sum = 0;

	
	public int getSum() {
		return sum;
	}


	public void setSum(int sum) {
		this.sum = sum;
	}


	public void add(int value) {
		this.sum += value;
	}
}