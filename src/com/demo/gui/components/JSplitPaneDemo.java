package com.demo.gui.components;

import java.awt.*;
import javax.swing.*;
public class JSplitPaneDemo extends JFrame{
    //�������
    JSplitPane jsp;
    JList jlist;
    JLabel jl;
    //���췽��
    public JSplitPaneDemo(){
        //�������
        String[] words = {"boy", "girl", "bird"};
        jlist = new JList(words);
        jl = new JLabel(new ImageIcon("images/image01.jpg"));
        //��ִ���
        jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jlist, jl);
        //���Ա仯
        jsp.setOneTouchExpandable(true);

        //������
        add(jsp);

        //���ô���
        setTitle("�ָ�");
        setSize(400, 300);
        setLocation(500, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        JSplitPaneDemo gui1 = new JSplitPaneDemo();
    }
}