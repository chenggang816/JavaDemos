package com.demo.gui;

import javax.swing.*;
import java.awt.*;

public class JFrameDemo extends JFrame {
	//需要的swing组件，定义到这里
    JButton jb1 = null;
	public JFrameDemo() {
		// TODO Auto-generated constructor stub
		// 创建了一个Button按钮
        jb1 = new JButton("按钮");
        // 添加组件
        add(jb1);

        // 给窗体设置标题
        setTitle("hello,world!");

        // 设置大小，按像素计算
        setSize(200, 200);
        // 设置初始位置
        setLocation(100, 100);
        // 设置当窗口关闭时，保证JVM也退出
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 显示
        setVisible(true);
	}
	public static void main(String[] args) {
		JFrameDemo gui1 = new JFrameDemo();
	}
}
