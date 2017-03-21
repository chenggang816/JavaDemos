/**
 * �߽粼��
 */
package com.demo.gui;

import java.awt.*;
import javax.swing.*;

//1.�̳�JFrame
public class BorderLayoutDemo extends JFrame{
    //2.�������
    JButton jb1, jb2, jb3, jb4, jb5;

    public BorderLayoutDemo(){
        //3.�������
        jb1 = new JButton("�в�");
        jb2 = new JButton("����");
        jb3 = new JButton("����");
        jb4 = new JButton("�ϲ�");
        jb5 = new JButton("����");

        //4.��Ӹ������
        add(jb1, BorderLayout.CENTER);
        add(jb2, BorderLayout.NORTH);
        add(jb3, BorderLayout.EAST);
        add(jb4, BorderLayout.SOUTH);
        add(jb5, BorderLayout.WEST);

        //5.���ô�������
        setTitle("�߽粼��");
        setSize(300, 200);
        setLocation(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//6.��ʾ����
        setVisible(true);
    }
    public static void main(String[] args) {
        BorderLayoutDemo gui1 = new BorderLayoutDemo();
    }
}
