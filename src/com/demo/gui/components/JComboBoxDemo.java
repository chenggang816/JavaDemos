package com.demo.gui.components;

import java.awt.*;
import javax.swing.*;
public class JComboBoxDemo extends JFrame{
    //�������
    JPanel jp1, jp2;
    JLabel jl1, jl2;
    JComboBox jcb;
    JList jlist;
    JScrollPane jsp;
    //���췽��
    public JComboBoxDemo(){
        //�������
        jp1 = new JPanel();
        jp2 = new JPanel();

        jl1 = new JLabel("��ļ��᣺");
        jl2 = new JLabel("���εص㣺");

        String[] jg = {"����", "�Ϻ�", "���", "����"};
        jcb = new JComboBox(jg);

        String[] dd = {"��կ��", "�ʹ�", "����", "�찲��","Բ��԰","�ú�԰"};
        jlist = new JList(dd);
        //������ʾѡ�����
        jlist.setVisibleRowCount(4);
        jlist.setSize(300, 500);
        jsp = new JScrollPane(jlist);


        //���ò���
        setLayout(new GridLayout(3, 1));

        //������
        jp1.add(jl1);
        jp1.add(jcb);
        jp2.add(jl2);
        jp2.add(jsp);

        add(jp1);
        add(jp2);

        //���ô���
        setTitle("����");
        setSize(300, 300);
        setLocation(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        JComboBoxDemo gui1 = new JComboBoxDemo();
    }
}