package com.demo.thread;

public class Demo1 {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new JoinThread();
		t1.start();
		Thread.sleep(300);
		
		for (int i = 0; i < 20; i++) {
			System.err.println("���̵߳�" + i + "��ִ��");
			Thread.sleep(100);
			if (i > 2) {
				t1.join();
			}
		}
	}
}

class JoinThread extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 20; i++) {
			System.out.println("�߳�1��" + i + "��ִ��");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
