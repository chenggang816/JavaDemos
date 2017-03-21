package com.demo.gui.components;

import java.awt.*;
import javax.swing.*;
public class JComboBoxDemo extends JFrame{
    //定义组件
    JPanel jp1, jp2;
    JLabel jl1, jl2;
    JComboBox jcb;
    JList jlist;
    JScrollPane jsp;
    //构造方法
    public JComboBoxDemo(){
        //创建组件
        jp1 = new JPanel();
        jp2 = new JPanel();

        jl1 = new JLabel("你的籍贯：");
        jl2 = new JLabel("旅游地点：");

        String[] jg = {"北京", "上海", "天津", "火星"};
        jcb = new JComboBox(jg);

        String[] dd = {"九寨沟", "故宫", "长城", "天安门","圆明园","颐和园"};
        jlist = new JList(dd);
        //设置显示选项个数
        jlist.setVisibleRowCount(4);
        jlist.setSize(300, 500);
        jsp = new JScrollPane(jlist);


        //设置布局
        setLayout(new GridLayout(3, 1));

        //添加组件
        jp1.add(jl1);
        jp1.add(jcb);
        jp2.add(jl2);
        jp2.add(jsp);

        add(jp1);
        add(jp2);

        //设置窗体
        setTitle("旅游");
        setSize(300, 300);
        setLocation(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        JComboBoxDemo gui1 = new JComboBoxDemo();
    }
}