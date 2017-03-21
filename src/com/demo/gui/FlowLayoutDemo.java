/**
 * 流式布局
 */
package com.demo.gui;

import java.awt.*;
import javax.swing.*;
public class FlowLayoutDemo extends JFrame{
    //定义组件
    JButton jb1, jb2, jb3, jb4, jb5, jb6;
    //构造函数
    public FlowLayoutDemo(){
        //创建组件
        jb1 = new JButton("Button1");
        jb2 = new JButton("Button2");
        jb3 = new JButton("Button3");
        jb4 = new JButton("Button4");
        jb5 = new JButton("Button5");
        jb6 = new JButton("Button6");
        //添加组件
        add(jb1);
        add(jb2);
        add(jb3);
        add(jb4);
        add(jb5);
        add(jb6);
        //设置流式布局
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        //设置窗体属性
        setTitle("流式布局");
        setSize(300, 200);
        setLocation(200, 200);
        //禁止用户改变窗体大小
//        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        FlowLayoutDemo gui1 = new FlowLayoutDemo();
    }
}