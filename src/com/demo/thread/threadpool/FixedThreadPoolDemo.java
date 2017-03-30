package com.demo.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolDemo {

	public static void main(String[] args) {
		System.out.println(test());
		System.out.println("completed");
	}
	
	public static String test() {
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
		final String a = "test";
		for (int i = 0; i < 10; i++) {  
			
			final int index = i;  
			fixedThreadPool.execute(new Runnable() {  
				public void run() {  
					try {  
						System.out.println(index);  
						Thread.sleep(1000);  
					} catch (InterruptedException e) {  
						e.printStackTrace();  
					}  
				}  
			});  
		}  //end for
		return a;
	}

}
