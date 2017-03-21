/**
 * 1.通过上下左右键来控制一个小球的移动
 */
package com.demo.gui;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class KeyEventDemo extends JFrame{
    //定义组件
    MyPanel3 mp =null;

    public KeyEventDemo(){
        mp = new MyPanel3();

        //mp加入JFrame
        add(mp);

        //添加监听
        addKeyListener(mp);

        //设置窗体
        setTitle("小球");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        KeyEventDemo gui1 = new KeyEventDemo();
    }

}

//定义自己的面板
class MyPanel3 extends JPanel implements KeyListener{
    private int x = 10;
    private int y = 10;

    public void paint(Graphics g){
        super.paint(g);
        //圆
        g.fillOval(x, y, 20, 20);
    }

    //输入的一个具体信息
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        //System.out.println("typed");
    }

    //按压
    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        //System.out.println("press");
        //向下 向上 向左 向右
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            y += 2;
        } else if(e.getKeyCode() == KeyEvent.VK_UP){
            y -= 2;
        } else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            x -= 2;
        } else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            x += 2;
        }
        //调用repaint()方法，重绘面板
        repaint();
    }

    //释放
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        //System.out.println("released" + (char)e.getKeyCode());
    }
}
