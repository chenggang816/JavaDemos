package com.demo.gui.components;
import java.awt.*;
import javax.swing.*;
public class JTabbedPaneDemo extends JFrame{
    //�������
    JPanel jp1, jp2, jp3, jp4;
    JLabel jl1, jl2, jl3, jl4, jl5;
    JTextField jtf1;
    JPasswordField jpf1;
    JCheckBox jcb1, jcb2;
    JButton jb1, jb2, jb3, jb4;
    JTabbedPane jtp;
    //���캯��
    public JTabbedPaneDemo(){
        //�������
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();

        jl1 = new JLabel(new ImageIcon("images/image01.jpg"));
        jl2 = new JLabel("�˺�");
        jl3 = new JLabel("����");
        jl4 = new JLabel("��������");
        jl4.setForeground(Color.BLUE);
        jl5 = new JLabel("<html><a href='http://blog.csdn.net/q547550831'>����</a>");
        jl5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        jtf1 = new JTextField(10);
        jpf1 = new JPasswordField(10);

        jcb1 = new JCheckBox("�����¼");
        jcb2 = new JCheckBox("��ס����");

        jb1 = new JButton("�������");
        jb2 = new JButton("��¼");
        jb3 = new JButton("ע��");
        jb4 = new JButton("ע��");

        jtp = new JTabbedPane();

        //���ò���
        jp1.setLayout(new GridLayout(3, 3));
        jp1.add(jl2);
        jp1.add(jtf1);
        jp1.add(jb1);
        jp1.add(jl3);
        jp1.add(jpf1);
        jp1.add(jl4);
        jp1.add(jcb1);
        jp1.add(jcb2);
        jp1.add(jl5);
        jp2.setBackground(Color.RED);
        jp3.setBackground(Color.BLUE);
        jtp.add("�˺�", jp1);
        jtp.add("�ֻ�����", jp2);
        jtp.add("�����ʼ�", jp3);

        jp4.add(jb2);
        jp4.add(jb3);
        jp4.add(jb4);

        //���뵽JFrame
        add(jl1, BorderLayout.NORTH);
        add(jtp);
        add(jp4, BorderLayout.SOUTH);

        //���ô���
        setTitle("��¼����");
        setIconImage((new ImageIcon("images/image02.jpg")).getImage());
        setSize(400, 300);
        setLocation(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
    public static void main(String[] args) {
        JTabbedPaneDemo gui1 = new JTabbedPaneDemo();
    }
}
