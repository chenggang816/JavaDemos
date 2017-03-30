package com.demo.heap;

public class StringDemo {
	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = "abc";
		String str3 = new String("abc");
		System.out.println(str1 == str2);
		/*
		 * 注意，我们这里并不用str1.equals(str2)；的方式，因为这将比较两个字符串的值是否相等。
		 * ==号，根据JDK的说明，只有在两个引用都指向了同一个对象时才返回真值。而我们在这里要看的是，
		 * str1与str2是否都指向了同一个对象。 结果说明，JVM创建了两个引用str1和str2，但只创建
		 * 了一个对象，而且两个引用都指向了这个对象。
		 */

		System.out.println(str1 == str3);
		/*
		 * 上面代码说明，只要是用new()来新建对象的，都会在堆中创建，而且其字符串是单独存值的，即使与
		 * 栈中的数据相同，也不会与栈中的数据共享。
		 * 
		 * 事实上，String类被设计成为不可改变(immutable)的类。如果你要改变其值，可以，但JVM
		 * 在运行时根据新值悄悄创建了一个新对象，然后将这个对象的地址返回给原来类的引用。这个创建过程
		 * 虽说是完全自动进行的，但它毕竟占用了更多的时间。在对时间要求比较敏感的环境中，会带有一定的
		 * 不良影响。
		 * 由于String类的immutable性质，当String变量需要经常变换其值时，应该考虑使用
		 * StringBuffer类，以提高程序效率。 
		 */
		

	}
}
