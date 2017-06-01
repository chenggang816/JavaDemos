package com.domo.innerclass;

public class InnerClassDemo { 
	private static final InnerClassDemo outer = new InnerClassDemo(); 
	static InnerClassDemo.Inner inner = outer.new Inner(); 
    public static void main(String[] args) { 
        inner.print("Outer.new"); 
 
        inner = outer.getInner(); 
        inner.print("Outer.get"); 
    } 
 
    // 个人推荐使用getxxx()来获取成员内部类，尤其是该内部类的构造函数无参数时 
    public Inner getInner() { 
        return new Inner(); 
    } 
 
    public class Inner { 
        public void print(String str) { 
            System.out.println(str); 
        } 
    } 
} 