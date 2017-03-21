/**
 * 1.ͨ���������Ҽ�������һ��С����ƶ�
 */
package com.demo.gui;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class KeyEventDemo extends JFrame{
    //�������
    MyPanel3 mp =null;

    public KeyEventDemo(){
        mp = new MyPanel3();

        //mp����JFrame
        add(mp);

        //��Ӽ���
        addKeyListener(mp);

        //���ô���
        setTitle("С��");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        KeyEventDemo gui1 = new KeyEventDemo();
    }

}

//�����Լ������
class MyPanel3 extends JPanel implements KeyListener{
    private int x = 10;
    private int y = 10;

    public void paint(Graphics g){
        super.paint(g);
        //Բ
        g.fillOval(x, y, 20, 20);
    }

    //�����һ��������Ϣ
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        //System.out.println("typed");
    }

    //��ѹ
    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        //System.out.println("press");
        //���� ���� ���� ����
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            y += 2;
        } else if(e.getKeyCode() == KeyEvent.VK_UP){
            y -= 2;
        } else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            x -= 2;
        } else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            x += 2;
        }
        //����repaint()�������ػ����
        repaint();
    }

    //�ͷ�
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        //System.out.println("released" + (char)e.getKeyCode());
    }
}
