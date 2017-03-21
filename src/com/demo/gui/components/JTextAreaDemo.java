package com.demo.gui.components;

import java.awt.*;
import javax.swing.*;
public class JTextAreaDemo extends JFrame{
    //定义组件
    JTextArea jta = null;
    JPanel jp1 = null;
    JComboBox jcb = null;
    JTextField jtf = null;
    JButton jb = null;
    JScrollPane jsp = null;

    //构造方法
    public JTextAreaDemo(){
        jta = new JTextArea();
        jsp = new JScrollPane(jta);
        jp1 = new JPanel();
        String[] chatter = {"张三","李四"};
        jcb = new JComboBox(chatter);
        jtf = new JTextField(10);
        jb = new JButton("发送");


        //添加组件
        jp1.add(jcb);
        jp1.add(jtf);
        jp1.add(jb);

        //加入JFrame
        add(jsp);
        add(jp1, BorderLayout.SOUTH);

        //设置窗体
        setIconImage((new ImageIcon("images/image01.jpg")).getImage());
        setTitle("聊天");
        setSize(400, 300);
        setLocation(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        JTextAreaDemo gui1 = new JTextAreaDemo();
    }
}