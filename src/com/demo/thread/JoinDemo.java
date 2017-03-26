package com.demo.thread;
/**
 * 线程合并的信义是将几个并行线程合并为一个单线程执行
 * 应用场景是当一个线程必须等待另一个线程执行完毕才能执行时可以使用join方法
 * @author cg
 *
 */
public class JoinDemo {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new JoinThread1();
		t1.start();
		Thread.sleep(300);
		
		for (int i = 0; i < 20; i++) {
			System.err.println("主线程第" + i + "次执行");
			Thread.sleep(100);
			if (i > 2) {
				//t1线程合并到主线程中，主线程停止执行过程，转而执行t1线程，直到t1线程执行完毕后继续
				t1.join();
			}
		}
	}
}

class JoinThread1 extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 20; i++) {
			System.out.println("线程1第" + i + "次执行");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
