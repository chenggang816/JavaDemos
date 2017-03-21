/**
 * 网格布局
 */
package com.demo.gui.layout;
import java.awt.*;
import javax.swing.*;
public class GridLayoutDemo extends JFrame{
    int size = 9;
    //定义组件;
    JButton[] jbs = new JButton[size];
    public GridLayoutDemo(){
        //创建组件
        for(int i = 0; i < size; i++){
            jbs[i] = new JButton("" + (i + 1));
        }
        //设置网格布局
        setLayout(new GridLayout(3, 3, 5, 5));
        //添加组件
        for(int i = 0; i < size; i++){
            add(jbs[i]);
        }

        //设置窗体属性
        setTitle("网格布局");
        setSize(300, 300);
        setLocation(200,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        GridLayoutDemo gui1 = new GridLayoutDemo();
    }
}