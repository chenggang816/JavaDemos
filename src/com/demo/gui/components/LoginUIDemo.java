package com.demo.gui.components;
import java.awt.*;
import javax.swing.*;
public class LoginUIDemo extends JFrame{
    //定义组件
    JPanel jp1, jp2, jp3;
    JLabel jlb1, jlb2;
    JButton jb1, jb2;
    JTextField jtf;
    JPasswordField jpf;
    //构造方法
    public LoginUIDemo(){
        //创建组件
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();

        jlb1 = new JLabel("用户名：");
        jlb2 = new JLabel("密   码：");

        jb1 = new JButton("登录");
        jb2 = new JButton("取消");

        jtf = new JTextField(10);
        jpf = new JPasswordField(10);

        //设置布局管理器
        setLayout(new GridLayout(3, 1));

        //加入组件
        jp1.add(jlb1);
        jp1.add(jtf);
        jp2.add(jlb2);
        jp2.add(jpf);
        jp3.add(jb1);
        jp3.add(jb2);

        //加入到JFrame
        add(jp1);
        add(jp2);
        add(jp3);

        //设置窗体
        setTitle("登录界面");
        setSize(300, 150);
        setLocation(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        LoginUIDemo gui1 = new LoginUIDemo();

    }
}