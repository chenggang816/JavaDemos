package com.demo.gui.components;
import java.awt.*;
import javax.swing.*;
public class LoginUIDemo extends JFrame{
    //�������
    JPanel jp1, jp2, jp3;
    JLabel jlb1, jlb2;
    JButton jb1, jb2;
    JTextField jtf;
    JPasswordField jpf;
    //���췽��
    public LoginUIDemo(){
        //�������
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();

        jlb1 = new JLabel("�û�����");
        jlb2 = new JLabel("��   �룺");

        jb1 = new JButton("��¼");
        jb2 = new JButton("ȡ��");

        jtf = new JTextField(10);
        jpf = new JPasswordField(10);

        //���ò��ֹ�����
        setLayout(new GridLayout(3, 1));

        //�������
        jp1.add(jlb1);
        jp1.add(jtf);
        jp2.add(jlb2);
        jp2.add(jpf);
        jp3.add(jb1);
        jp3.add(jb2);

        //���뵽JFrame
        add(jp1);
        add(jp2);
        add(jp3);

        //���ô���
        setTitle("��¼����");
        setSize(300, 150);
        setLocation(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        LoginUIDemo gui1 = new LoginUIDemo();

    }
}