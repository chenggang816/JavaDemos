package com.demo.collection;

import java.util.*;

public class SimpleCollection {
	static int m;
	public static void main(String[] args){
//		Collection<Integer> c = new ArrayList<Integer>();
		Collection<Integer> c = new HashSet<Integer>();
		for(int i = 0; i < 10; i++){
			c.add(i);
		}
		c.add(1);
		for(Integer i : c){
			System.out.print(i + ", ");
		}
		System.out.println();
		System.out.print(Arrays.toString(c.toArray()) + "\n");
		System.out.print(Arrays.toString(c.toArray(new Integer[0])) + "\n");
		System.out.println(Arrays.toString(new Integer[0]));
		
		
		Random rand = new Random(47);
		SortedSet<Integer> intset = new TreeSet<Integer>();
		for(int i = 0; i < 10000; i++){
			intset.add(rand.nextInt(30));
		}
		System.out.print(intset + "\n");
		
		int[] ints;
		int n = 10;
		ints = new int[n];
		for(int i:ints){
			System.out.print(i + ",");
		}
		System.out.println("\n" + m + "\n");
		Queue<String> q = new LinkedList<String>(Arrays.asList("Learning Java day by day".split(" ")));
		while(q.isEmpty() == false){
			System.out.print(q.poll() + " ");
		}
	}
}
