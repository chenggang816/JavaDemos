/**
 * ��ʽ����
 */
package com.demo.gui;

import java.awt.*;
import javax.swing.*;
public class FlowLayoutDemo extends JFrame{
    //�������
    JButton jb1, jb2, jb3, jb4, jb5, jb6;
    //���캯��
    public FlowLayoutDemo(){
        //�������
        jb1 = new JButton("Button1");
        jb2 = new JButton("Button2");
        jb3 = new JButton("Button3");
        jb4 = new JButton("Button4");
        jb5 = new JButton("Button5");
        jb6 = new JButton("Button6");
        //������
        add(jb1);
        add(jb2);
        add(jb3);
        add(jb4);
        add(jb5);
        add(jb6);
        //������ʽ����
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        //���ô�������
        setTitle("��ʽ����");
        setSize(300, 200);
        setLocation(200, 200);
        //��ֹ�û��ı䴰���С
//        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        FlowLayoutDemo gui1 = new FlowLayoutDemo();
    }
}