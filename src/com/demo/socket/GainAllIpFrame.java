package com.demo.socket;

import java.awt.Container;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class GainAllIpFrame extends JFrame {
 public static void main(String[] args) {
	JFrame jFrame = new JFrame("获取局域网内所有IP");
	Container container = jFrame.getContentPane();
	container.setLayout(null);
	
	JButton jButton = new JButton("获取所有IP");
	jButton.setBounds(10, 10, 100, 40);
	jButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	});
	container.add(jButton);
	
	jFrame.setVisible(true);
	jFrame.setBounds(300, 200, 500, 300);
	jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	
}
}
