package com.demo.thread;
/**
 * �̺߳ϲ��������ǽ����������̺߳ϲ�Ϊһ�����߳�ִ��
 * Ӧ�ó����ǵ�һ���̱߳���ȴ���һ���߳�ִ����ϲ���ִ��ʱ����ʹ��join����
 * @author cg
 *
 */
public class JoinDemo {
	public static void main(String[] args) throws InterruptedException {
		Thread t2 = new JoinThread1("T2");
		t2.start();
		
		Thread.sleep(500);
		
		Thread t1 = new JoinThread1("T1");
		t1.start();
		
		System.out.println("Thread T1 is goint to join");
		t1.join();
		
		System.out.println("Thread T2 is goint to join");
		t2.join();
		
		System.out.println("Main thread exited");
	}
}

class JoinThread1 extends Thread{
	public JoinThread1(String name) {
		setName(name);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 20; i++) {
			System.out.println("Thead:" + getName() + "\t" + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.printf("SubThread %s has exited.\n", getName());
	}
}
