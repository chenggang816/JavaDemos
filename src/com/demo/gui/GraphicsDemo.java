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

//定义一个MyPanel,用于绘图和显示绘图的区域
class MyPanel extends JPanel{
    //覆盖JPanel的paint方法
    //Graphics是绘图的重要类，等价于画笔
    public void paint(Graphics g){
        //1.调用父类方法，完成初始化
        super.paint(g);
        //空心圆
        g.drawOval(10, 10, 30, 30);
        //直线
        g.drawLine(10, 10, 40, 40);
        //空心矩形
        g.drawRect(10, 10, 40, 60);
        //填充矩形
        g.setColor(Color.BLUE);
        g.fillRect(70, 10, 40, 60);
        g.setColor(Color.RED);
        g.fillRect(70, 80, 40, 60);
        
        //在面板上画出图片
//        Image im = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("images/new.jpg"));
//        g.drawImage(im, 10, 10, 200, 150, this);

        //字符
        g.setColor(Color.green);
        g.setFont(new Font(("隶书"), Font.BOLD, 30));
        g.drawString("String 字符串", 150, 100);
        //圆的轮廓
        g.drawArc(100, 100, 100, 100, 20, 300);
    }
}