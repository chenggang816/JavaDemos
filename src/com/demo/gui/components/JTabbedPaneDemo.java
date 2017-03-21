package com.demo.gui.components;
import java.awt.*;
import javax.swing.*;
public class JTabbedPaneDemo extends JFrame{
    //定义组件
    JPanel jp1, jp2, jp3, jp4;
    JLabel jl1, jl2, jl3, jl4, jl5;
    JTextField jtf1;
    JPasswordField jpf1;
    JCheckBox jcb1, jcb2;
    JButton jb1, jb2, jb3, jb4;
    JTabbedPane jtp;
    //构造函数
    public JTabbedPaneDemo(){
        //创建组件
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();

        jl1 = new JLabel(new ImageIcon("images/image01.jpg"));
        jl2 = new JLabel("账号");
        jl3 = new JLabel("密码");
        jl4 = new JLabel("忘记密码");
        jl4.setForeground(Color.BLUE);
        jl5 = new JLabel("<html><a href='http://blog.csdn.net/q547550831'>访问</a>");
        jl5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        jtf1 = new JTextField(10);
        jpf1 = new JPasswordField(10);

        jcb1 = new JCheckBox("隐身登录");
        jcb2 = new JCheckBox("记住密码");

        jb1 = new JButton("清除号码");
        jb2 = new JButton("登录");
        jb3 = new JButton("注销");
        jb4 = new JButton("注册");

        jtp = new JTabbedPane();

        //设置布局
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
        jtp.add("账号", jp1);
        jtp.add("手机号码", jp2);
        jtp.add("电子邮件", jp3);

        jp4.add(jb2);
        jp4.add(jb3);
        jp4.add(jb4);

        //加入到JFrame
        add(jl1, BorderLayout.NORTH);
        add(jtp);
        add(jp4, BorderLayout.SOUTH);

        //设置窗体
        setTitle("登录界面");
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
