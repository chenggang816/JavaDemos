package com.demo.gui.components;

import java.awt.*;

import javax.swing.*;
public class JCheckBoxDemo extends JFrame{
    //�������
    JPanel jp1, jp2, jp3;
    JLabel jl1, jl2;
    JButton jb1, jb2;
    JCheckBox jcb1, jcb2, jcb3;
    JRadioButton jrb1, jrb2;
    ButtonGroup bg;
    //���캯��
    public JCheckBoxDemo(){
        //�������
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jl1 = new JLabel("��ϲ�����˶���");
        jl2 = new JLabel("��ϲ�����˶���");
        jb1 = new JButton("ע���û�");
        jb2 = new JButton("ȡ��ע��");

        jcb1 = new JCheckBox("����");
        jcb2 = new JCheckBox("����");
        jcb3 = new JCheckBox("����");

        jrb1 = new JRadioButton("��");
        jrb2 = new JRadioButton("Ů");
        //��ѡ���һ��Ҫ���뵽һ��ButtonGroup
        //������Ļ������Զ�ѡ
        bg = new ButtonGroup();
        bg.add(jrb1);
        bg.add(jrb2);

        //���ò��ֹ�����
        setLayout(new GridLayout(3, 1));

        //������
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

        //���ô���
        setTitle("���鱨��");
        setSize(300, 300);
        setLocation(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        JCheckBoxDemo gui1 = new JCheckBoxDemo();
    }
}