/**
 * 边界布局
 */
package com.demo.gui;

import java.awt.*;
import javax.swing.*;

//1.继承JFrame
public class BorderLayoutDemo extends JFrame{
    //2.定义组件
    JButton jb1, jb2, jb3, jb4, jb5;

    public BorderLayoutDemo(){
        //3.创建组件
        jb1 = new JButton("中部");
        jb2 = new JButton("北部");
        jb3 = new JButton("东部");
        jb4 = new JButton("南部");
        jb5 = new JButton("西部");

        //4.添加各个组件
        add(jb1, BorderLayout.CENTER);
        add(jb2, BorderLayout.NORTH);
        add(jb3, BorderLayout.EAST);
        add(jb4, BorderLayout.SOUTH);
        add(jb5, BorderLayout.WEST);

        //5.设置窗体属性
        setTitle("边界布局");
        setSize(300, 200);
        setLocation(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//6.显示窗体
        setVisible(true);
    }
    public static void main(String[] args) {
        BorderLayoutDemo gui1 = new BorderLayoutDemo();
    }
}
