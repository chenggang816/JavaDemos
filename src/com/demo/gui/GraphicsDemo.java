package com.demo.gui;

import java.awt.*;
import javax.swing.*;
public class GraphicsDemo extends JFrame{

    MyPanel mp = null;
    public GraphicsDemo(){
        mp = new MyPanel();
        add(mp);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        GraphicsDemo gui1 = new GraphicsDemo();

    }

}

//����һ��MyPanel,���ڻ�ͼ����ʾ��ͼ������
class MyPanel extends JPanel{
    //����JPanel��paint����
    //Graphics�ǻ�ͼ����Ҫ�࣬�ȼ��ڻ���
    public void paint(Graphics g){
        //1.���ø��෽������ɳ�ʼ��
        super.paint(g);
        //����Բ
        g.drawOval(10, 10, 30, 30);
        //ֱ��
        g.drawLine(10, 10, 40, 40);
        //���ľ���
        g.drawRect(10, 10, 40, 60);
        //������
        g.setColor(Color.BLUE);
        g.fillRect(70, 10, 40, 60);
        g.setColor(Color.RED);
        g.fillRect(70, 80, 40, 60);
        
        //������ϻ���ͼƬ
//        Image im = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("images/new.jpg"));
//        g.drawImage(im, 10, 10, 200, 150, this);

        //�ַ�
        g.setColor(Color.green);
        g.setFont(new Font(("����"), Font.BOLD, 30));
        g.drawString("String �ַ���", 150, 100);
        //Բ������
        g.drawArc(100, 100, 100, 100, 20, 300);
    }
}