package com.test;

public class Hello {
	public static void main(String[] args){
		while(true)
		try {
			Thread.sleep(500);
			Thread.currentThread().interrupt();
			for(int i = 0; i < 1000000; i++){
				int k = i * i * i * i;
			}
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
