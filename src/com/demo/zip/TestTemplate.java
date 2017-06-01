package com.demo.zip;

public abstract class TestTemplate {
	public abstract void testMethod();
	public void run(int times, String methodName){
		long avgCost = 0;
		long minCost = Long.MAX_VALUE;
		long maxCost = Long.MIN_VALUE;
		for(int i = 0; i < times; i++){
			long start = System.currentTimeMillis();
			testMethod();
			long end = System.currentTimeMillis();
			long cost = end - start;
			if(minCost > cost) minCost = cost;
			if(maxCost < cost) maxCost = cost;
			avgCost += cost;
			System.err.printf("\t%s | 第%d次测试耗时: %d ms\n",methodName,i + 1,cost);
		}
		avgCost /= times;
		System.err.println("\n\t---------------------------------------------------");
		System.err.printf("\t%s | %d次测试平均耗时: %d ms\t最短耗时: %d\t最长耗时: %d\n ",
				methodName,times,avgCost,minCost,maxCost);
		System.err.println("\t---------------------------------------------------\n\n");
	}
	public void run(int times){
		run(times,"test");
	}
	public void run(){
		run(3);
	}
}
