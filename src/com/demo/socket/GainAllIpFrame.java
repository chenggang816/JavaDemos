package com.demo.socket;

import java.awt.Container;
import java.awt.Frame;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class GainAllIpFrame {
 public static void main(String[] args) {
	JFrame jFrame = new JFrame("获取局域网内所有IP");
	Container container = jFrame.getContentPane();
	container.setLayout(null);
	
	final JLabel jLabel = new JLabel();
	jLabel.setBounds(60, 60, 300, 200);
	
	JButton jButton = new JButton("获取所有IP");
	jButton.setBounds(10, 10, 100, 40);
	jButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String str = "<html>本地ip信息:<br />";
			NetHelper netHelper = new NetHelper();
			//获取本机ip
			try {
				str += "主机名：" + netHelper.getLocalHostName() + "<br/>ip:";
				for (String ip : netHelper.getAllLocalHostIp()) {
					str += "\t" + ip + " | ";
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			//获取局域网ip
			str += "</html>";
			jLabel.setText(str);
		}
	});
	
	container.add(jButton);
	container.add(jLabel);
	jFrame.setVisible(true);
	jFrame.setBounds(300, 200, 500, 300);
	jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	
}
 
}
class NetHelper{
	 public String getLocalHostName() {
			String localHostName = null;
			 try {
				InetAddress inetAddress = InetAddress.getLocalHost();
				localHostName = inetAddress.getHostName();
			} catch (UnknownHostException e) {
				localHostName = null;
			}
			 return localHostName;
		 }
	public ArrayList<String> getAllLocalHostIp() throws UnknownHostException {
		String hostName = getLocalHostName();
		InetAddress[] addresses = InetAddress.getAllByName(hostName);
		ArrayList<String> ips = new ArrayList<String>();
		for (int i = 0; i < addresses.length; i++) {
			if(addresses[i] instanceof Inet4Address){
				ips.add(addresses[i].getHostAddress());
			}
		}
		return ips;
	}
}
