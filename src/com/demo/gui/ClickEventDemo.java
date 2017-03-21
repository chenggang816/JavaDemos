/**
 * 功能：事件处理机制
 */
package com.demo.gui;
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

public class ClickEventDemo extends JFrame implements ActionListener{
    //定义组件
    Panel mp = null;
    JButton jb1, jb2;

    public ClickEventDemo(){
        mp = new Panel();
        //设置背景颜色
        mp.setBackground(Color.black);
        jb1 = new JButton("黑色");
        jb2 = new JButton("红色");

        add(jb1, BorderLayout.NORTH);
        add(mp);
        add(jb2, BorderLayout.SOUTH);


        //注册监听
        jb1.addActionListener(this);
        jb2.addActionListener(this);

        //事件源是jb1,jb2,事件监听者是gui14的对象

        //指定action命令
        jb1.setActionCommand("黑色");
        jb2.setActionCommand("红色");

        //设置窗体
        setSize(300, 200);
        setLocation(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        ClickEventDemo gui1 = new ClickEventDemo();
    }

    //对事件处理的方法
    @Override
    public void actionPerformed(ActionEvent e) {
        //判断是哪个按钮被点击
        if(e.getActionCommand().equals("黑色")){
            //System.out.println("黑色");
            mp.setBackground(Color.black);

        } else if(e.getActionCommand().equals("红色")){
            //System.out.println("红色");
            mp.setBackground(Color.red);

        } else {

        }


    }

}
