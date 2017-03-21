package com.demo.gui.components;

import java.awt.*;
import javax.swing.*;
public class JSplitPaneDemo extends JFrame{
    //定义组件
    JSplitPane jsp;
    JList jlist;
    JLabel jl;
    //构造方法
    public JSplitPaneDemo(){
        //创建组件
        String[] words = {"boy", "girl", "bird"};
        jlist = new JList(words);
        jl = new JLabel(new ImageIcon("images/image01.jpg"));
        //拆分窗格
        jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jlist, jl);
        //可以变化
        jsp.setOneTouchExpandable(true);

        //添加组件
        add(jsp);

        //设置窗体
        setTitle("分割");
        setSize(400, 300);
        setLocation(500, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        JSplitPaneDemo gui1 = new JSplitPaneDemo();
    }
}