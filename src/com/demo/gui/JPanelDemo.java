/**
 * ���ֲ��ֹ�������ʹ��
 */
package com.demo.gui;

import java.awt.*;
import javax.swing.*;

public class JPanelDemo extends JFrame{
    //�������
    JPanel jp1, jp2;
    JButton jb1, jb2, jb3, jb4, jb5, jb6;
    //���췽��
    public JPanelDemo(){
        //�������
        //JPanel����Ĭ����FlowLayout
        jp1 = new JPanel();
        jp2 = new JPanel();

        jb1 = new JButton("Button1");
        jb2 = new JButton("Button2");
        jb3 = new JButton("Button3");
        jb4 = new JButton("Button4");
        jb5 = new JButton("Button5");
        jb6 = new JButton("Button6");

        //���JPanel
        jp1.add(jb1);
        jp1.add(jb2);
        jp2.add(jb3);
        jp2.add(jb4);
        jp2.add(jb5);

        //��JPanel����JFrame
        add(jp1, BorderLayout.NORTH);
        add(jb6, BorderLayout.CENTER);
        add(jp2, BorderLayout.SOUTH);

        //���ô���
        setTitle("���ֲ��ֹ�������ʹ��");
        setSize(300, 300);
        setLocation(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String args[]){
        JPanelDemo gui1 = new JPanelDemo();
    }
}