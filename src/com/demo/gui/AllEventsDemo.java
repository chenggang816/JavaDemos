package com.demo.gui;
import java.awt.*;
//4.���ڱ仯(�رգ���С�������)
import javax.swing.*;
import java.awt.event.*;
public class AllEventsDemo extends JFrame implements WindowListener{
    //�������
    MyPanel4 mp = null;

    //���췽��
    public AllEventsDemo(){
        mp = new MyPanel4(); //mp�䵱�����ߣ����Ǽ����߲�һ����Ҫ�ǿؼ��������ԣ�ֻҪ��ʵ����Listener�ӿڵ��඼ ����

        //mp����JFrame
        add(mp);
        //ע�����
        addMouseListener(mp);
        addKeyListener(mp);
        addMouseMotionListener(mp);
        addWindowListener(this);
        //���ô���
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    //����
    //���ڴ�
    @Override
    public void windowOpened(WindowEvent e) {
        // TODO Auto-generated method stub
    	System.out.println("���ڴ�");
    }
    //�������ڹر�
    @Override
    public void windowClosing(WindowEvent e) {
        // TODO Auto-generated method stub
    	System.out.println("�������ڹر�");
    }
    //���ڹر�
    @Override
    public void windowClosed(WindowEvent e) {
        // TODO Auto-generated method stub
    	System.out.println("�����Ѿ��ر�");
    }
    //������С��
    @Override
    public void windowIconified(WindowEvent e) {
        // TODO Auto-generated method stub
    	System.out.println("������С��");
    }
    //������С������ʾ
    @Override
    public void windowDeiconified(WindowEvent e) {
        // TODO Auto-generated method stub
    	System.out.println("���ڴ���С���ָ�");
    }
    //���ڱ�������
    @Override
    public void windowActivated(WindowEvent e) {
        // TODO Auto-generated method stub
    	System.out.println("���ڱ�������");
    }
    //���ڱ�ɷǼ����
    @Override
    public void windowDeactivated(WindowEvent e) {
        // TODO Auto-generated method stub
    	System.out.println("���ڱ�ɷǼ����");
    }
    
    public static void main(String[] args) {
        AllEventsDemo gui1 = new AllEventsDemo();

    }

}

//1 ��갴��������꣬�Ƴ������룬���£��ͷ�
//2.�������¶�Ӧ�ַ�
//3.����ƶ�����ק
//�����Լ������
class MyPanel4 extends JPanel implements MouseListener, KeyListener, MouseMotionListener{
    public void paint(Graphics g){
        super.paint(g);
    }
    //���
    //�����
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("������� x = " + e.getX() + " y = " + e.getY());
    }
    //��갴��
    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("��갴��");
    }
    //����ɿ�
    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("����ɿ�");
    }
    //����ƶ���MyPanel4
    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("����Ƴ�");
    }
    //����Ƴ�MyPanel4
    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("������");
    }

    //�����ק
    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
    	System.out.println("�����ק�У���ǰ����x = " + e.getX() + " Y = " + e.getY());
    }

    //����ƶ�
    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("��굱ǰ����x = " + e.getX() + " Y = " + e.getY());
    }


    //����
    //���������Ϣ
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    	System.out.println(e.getKeyChar() + "����Typed");
    }
    //����
    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        System.out.println(e.getKeyChar() + "��������");
    }
    //�ͷ�
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
    	System.out.println(e.getKeyChar() + "�����ͷ�");
    }



}
