package com.demo.gui.components;

import java.awt.*;
import javax.swing.*;
public class JTextAreaDemo extends JFrame{
    //�������
    JTextArea jta = null;
    JPanel jp1 = null;
    JComboBox jcb = null;
    JTextField jtf = null;
    JButton jb = null;
    JScrollPane jsp = null;

    //���췽��
    public JTextAreaDemo(){
        jta = new JTextArea();
        jsp = new JScrollPane(jta);
        jp1 = new JPanel();
        String[] chatter = {"����","����"};
        jcb = new JComboBox(chatter);
        jtf = new JTextField(10);
        jb = new JButton("����");


        //������
        jp1.add(jcb);
        jp1.add(jtf);
        jp1.add(jb);

        //����JFrame
        add(jsp);
        add(jp1, BorderLayout.SOUTH);

        //���ô���
        setIconImage((new ImageIcon("images/image01.jpg")).getImage());
        setTitle("����");
        setSize(400, 300);
        setLocation(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        JTextAreaDemo gui1 = new JTextAreaDemo();
    }
}