package com.demo.thread;
/**
 * �̺߳ϲ��������ǽ����������̺߳ϲ�Ϊһ�����߳�ִ��
 * Ӧ�ó����ǵ�һ���̱߳���ȴ���һ���߳�ִ����ϲ���ִ��ʱ����ʹ��join����
 * @author cg
 *
 */
public class JoinDemo {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new JoinThread1();
		t1.start();
		Thread.sleep(300);
		
		for (int i = 0; i < 20; i++) {
			System.err.println("���̵߳�" + i + "��ִ��");
			Thread.sleep(100);
			if (i > 2) {
				//t1�̺߳ϲ������߳��У����߳�ִֹͣ�й��̣�ת��ִ��t1�̣߳�ֱ��t1�߳�ִ����Ϻ����
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
