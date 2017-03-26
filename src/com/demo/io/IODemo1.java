package com.demo.io;

import java.io.IOException;

public class IODemo1 {
	public static void main(String[] args) throws IOException{
		String s = "�����";
		String str = null;
		byte[] bytesDefault = s.getBytes();
		byte[] bytesGBK = s.getBytes("GBK");
		byte[] bytesUTF8 = s.getBytes("UTF8");
		byte[] bytesUnicode = s.getBytes("unicode");
		System.out.println("OSĬ���ַ�����ʾ��" + arrayToString(bytesDefault));
		System.out.println("GBK�ַ�����ʾ��" + arrayToString(bytesGBK));
		System.out.println("UTF8�ַ�����ʾ��" + arrayToString(bytesUTF8));
		System.out.println("Unicode�ַ�����ʾ��" + arrayToString(bytesUnicode));
		
		System.out.println("\nOSĬ���ַ���ʮ�����Ʊ�ʾ��" + encodeHex(bytesDefault));
		System.out.println("GBK�ַ���ʮ�����Ʊ�ʾ��" + encodeHex(bytesGBK));
		System.out.println("UTF8�ַ���ʮ�����Ʊ�ʾ��" + encodeHex(bytesUTF8));
		System.out.println("Unicode�ַ���ʮ�����Ʊ�ʾ��" + encodeHex(bytesUnicode));
		
		str = new String(bytesUTF8,"utf-8");
		System.out.println("\n�����ԭʼ�ַ����ǣ�" + str);
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
