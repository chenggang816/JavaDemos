package com.demo.gui;

import javax.swing.*;
import java.awt.*;

public class JFrameDemo extends JFrame {
	//��Ҫ��swing��������嵽����
    JButton jb1 = null;
	public JFrameDemo() {
		// TODO Auto-generated constructor stub
		// ������һ��Button��ť
        jb1 = new JButton("��ť");
        // ������
        add(jb1);

        // ���������ñ���
        setTitle("hello,world!");

        // ���ô�С�������ؼ���
        setSize(200, 200);
        // ���ó�ʼλ��
        setLocation(100, 100);
        // ���õ����ڹر�ʱ����֤JVMҲ�˳�
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // ��ʾ
        setVisible(true);
	}
	public static void main(String[] args) {
		JFrameDemo gui1 = new JFrameDemo();
	}
}
