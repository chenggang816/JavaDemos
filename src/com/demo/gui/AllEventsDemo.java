package com.demo.gui;
import java.awt.*;
//4.窗口变化(关闭，最小化，最大化)
import javax.swing.*;
import java.awt.event.*;
public class AllEventsDemo extends JFrame implements WindowListener{
    //定义组件
    MyPanel4 mp = null;

    //构造方法
    public AllEventsDemo(){
        mp = new MyPanel4(); //mp充当监听者，但是监听者不一定需要是控件，经测试，只要是实现了Listener接口的类都 可以

        //mp加入JFrame
        add(mp);
        //注册监听
        addMouseListener(mp);
        addKeyListener(mp);
        addMouseMotionListener(mp);
        addWindowListener(this);
        //设置窗体
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    //窗口
    //窗口打开
    @Override
    public void windowOpened(WindowEvent e) {
        // TODO Auto-generated method stub
    	System.out.println("窗口打开");
    }
    //窗口正在关闭
    @Override
    public void windowClosing(WindowEvent e) {
        // TODO Auto-generated method stub
    	System.out.println("窗口正在关闭");
    }
    //窗口关闭
    @Override
    public void windowClosed(WindowEvent e) {
        // TODO Auto-generated method stub
    	System.out.println("窗口已经关闭");
    }
    //窗口最小化
    @Override
    public void windowIconified(WindowEvent e) {
        // TODO Auto-generated method stub
    	System.out.println("窗口最小化");
    }
    //窗口最小化到显示
    @Override
    public void windowDeiconified(WindowEvent e) {
        // TODO Auto-generated method stub
    	System.out.println("窗口从最小化恢复");
    }
    //窗口被激活了
    @Override
    public void windowActivated(WindowEvent e) {
        // TODO Auto-generated method stub
    	System.out.println("窗口被激活了");
    }
    //窗口变成非激活窗口
    @Override
    public void windowDeactivated(WindowEvent e) {
        // TODO Auto-generated method stub
    	System.out.println("窗口变成非激活窗口");
    }
    
    public static void main(String[] args) {
        AllEventsDemo gui1 = new AllEventsDemo();

    }

}

//1 鼠标按下输出坐标，移出，移入，按下，释放
//2.按键按下对应字符
//3.鼠标移动、拖拽
//定义自己的面板
class MyPanel4 extends JPanel implements MouseListener, KeyListener, MouseMotionListener{
    public void paint(Graphics g){
        super.paint(g);
    }
    //鼠标
    //鼠标点击
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("鼠标点击了 x = " + e.getX() + " y = " + e.getY());
    }
    //鼠标按下
    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("鼠标按下");
    }
    //鼠标松开
    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("鼠标松开");
    }
    //鼠标移动到MyPanel4
    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("鼠标移出");
    }
    //鼠标移出MyPanel4
    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("鼠标进入");
    }

    //鼠标拖拽
    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
    	System.out.println("鼠标拖拽中，当前坐标x = " + e.getX() + " Y = " + e.getY());
    }

    //鼠标移动
    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("鼠标当前坐标x = " + e.getX() + " Y = " + e.getY());
    }


    //键盘
    //输入具体信息
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    	System.out.println(e.getKeyChar() + "键被Typed");
    }
    //按下
    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        System.out.println(e.getKeyChar() + "键被按下");
    }
    //释放
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
    	System.out.println(e.getKeyChar() + "键被释放");
    }



}
