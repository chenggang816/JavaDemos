package com.demo.gui.components;

import java.awt.*;

import javax.swing.*;
public class JCheckBoxDemo extends JFrame{
    //定义组件
    JPanel jp1, jp2, jp3;
    JLabel jl1, jl2;
    JButton jb1, jb2;
    JCheckBox jcb1, jcb2, jcb3;
    JRadioButton jrb1, jrb2;
    ButtonGroup bg;
    //构造函数
    public JCheckBoxDemo(){
        //创建组件
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jl1 = new JLabel("你喜欢的运动：");
        jl2 = new JLabel("你喜欢的运动：");
        jb1 = new JButton("注册用户");
        jb2 = new JButton("取消注册");

        jcb1 = new JCheckBox("足球");
        jcb2 = new JCheckBox("篮球");
        jcb3 = new JCheckBox("网球");

        jrb1 = new JRadioButton("男");
        jrb2 = new JRadioButton("女");
        //单选组件一定要放入到一个ButtonGroup
        //不放入的话，可以多选
        bg = new ButtonGroup();
        bg.add(jrb1);
        bg.add(jrb2);

        //设置布局管理器
        setLayout(new GridLayout(3, 1));

        //添加组件
        jp1.add(jl1);
        jp1.add(jcb1);
        jp1.add(jcb2);
        jp1.add(jcb3);

        jp2.add(jl2);
        jp2.add(jrb1);
        jp2.add(jrb2);

        jp3.add(jb1);
        jp3.add(jb2);

        add(jp1);
        add(jp2);
        add(jp3);

        //设置窗体
        setTitle("调查报告");
        setSize(300, 300);
        setLocation(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        JCheckBoxDemo gui1 = new JCheckBoxDemo();
    }
}