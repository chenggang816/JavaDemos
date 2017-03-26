package com.demo.io;

import java.io.IOException;

public class IODemo1 {
	public static void main(String[] args) throws IOException{
		String s = "计算机";
		String str = null;
		byte[] bytesDefault = s.getBytes();
		byte[] bytesGBK = s.getBytes("GBK");
		byte[] bytesUTF8 = s.getBytes("UTF8");
		byte[] bytesUnicode = s.getBytes("unicode");
		System.out.println("OS默认字符集表示：" + arrayToString(bytesDefault));
		System.out.println("GBK字符集表示：" + arrayToString(bytesGBK));
		System.out.println("UTF8字符集表示：" + arrayToString(bytesUTF8));
		System.out.println("Unicode字符集表示：" + arrayToString(bytesUnicode));
		
		System.out.println("\nOS默认字符集十六进制表示：" + encodeHex(bytesDefault));
		System.out.println("GBK字符集十六进制表示：" + encodeHex(bytesGBK));
		System.out.println("UTF8字符集十六进制表示：" + encodeHex(bytesUTF8));
		System.out.println("Unicode字符集十六进制表示：" + encodeHex(bytesUnicode));
		
		str = new String(bytesUTF8,"utf-8");
		System.out.println("\n输入的原始字符串是：" + str);
	}
	
	private static String arrayToString(byte[] bytes) {
		StringBuilder buff = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			buff.append(bytes[i]).append(" ");
		}
		return buff.toString();
	}
	
	private static String encodeHex(byte[] bytes) {
		StringBuilder buff = new StringBuilder(bytes.length * 2);
		String b = null;
		for (int i = 0; i < bytes.length; i++) {
			b = Integer.toHexString(bytes[i]);
			buff.append(b.length() > 2 ? b.substring(6):b).append(" ");
		}
		return buff.toString();
	}
}
