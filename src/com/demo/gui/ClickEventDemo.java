/**
 * ���ܣ��¼��������
 */
package com.demo.gui;
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

public class ClickEventDemo extends JFrame implements ActionListener{
    //�������
    Panel mp = null;
    JButton jb1, jb2;

    public ClickEventDemo(){
        mp = new Panel();
        //���ñ�����ɫ
        mp.setBackground(Color.black);
        jb1 = new JButton("��ɫ");
        jb2 = new JButton("��ɫ");

        add(jb1, BorderLayout.NORTH);
        add(mp);
        add(jb2, BorderLayout.SOUTH);


        //ע�����
        jb1.addActionListener(this);
        jb2.addActionListener(this);

        //�¼�Դ��jb1,jb2,�¼���������gui14�Ķ���

        //ָ��action����
        jb1.setActionCommand("��ɫ");
        jb2.setActionCommand("��ɫ");

        //���ô���
        setSize(300, 200);
        setLocation(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        ClickEventDemo gui1 = new ClickEventDemo();
    }

    //���¼�����ķ���
    @Override
    public void actionPerformed(ActionEvent e) {
        //�ж����ĸ���ť�����
        if(e.getActionCommand().equals("��ɫ")){
            //System.out.println("��ɫ");
            mp.setBackground(Color.black);

        } else if(e.getActionCommand().equals("��ɫ")){
            //System.out.println("��ɫ");
            mp.setBackground(Color.red);

        } else {

        }


    }

}
