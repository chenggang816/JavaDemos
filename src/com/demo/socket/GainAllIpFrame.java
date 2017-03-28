package com.demo.socket;

import java.awt.Container;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
					str += ip + "<br />";
				}
				
				str += "局域网ip与主机名：<br />";
				List<String> ips = netHelper.getIPs();
				Map<String,String> mapIps = netHelper.getHostnames(ips);
				for (Map.Entry<String,String> entry : mapIps.entrySet()) {
					str += entry.getKey() + ":" + entry.getValue() + "<br />";
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
	/*
	 * 提取局域网IP
	 * http://blog.csdn.net/havedream_one/article/details/47071393
	 */
	public List<String> getIPs()
    {
        List<String> list = new ArrayList<String>();
        boolean flag = false;
        int count=0;
        Runtime r = Runtime.getRuntime();
        Process p;
        try {
            p = r.exec("arp -a");
            BufferedReader br = new BufferedReader(new InputStreamReader(p
                    .getInputStream()));
            String inline;
            while ((inline = br.readLine()) != null) {
                if(inline.indexOf("接口") > -1){
                    flag = !flag;
                    if(!flag){
                        //碰到下一个"接口"退出循环
                        break;
                    }
                }
                if(flag){
                    count++;
                    if(count > 2){
                        //有效IP
                        String[] str=inline.split(" {4}");
                        list.add(str[0]);
                    }
                }
                System.out.println(inline);
            }
            br.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(list);
        return list;
    }
	/*
	 * 根据IP提取主机名
	 * http://blog.csdn.net/havedream_one/article/details/47071393
	 */
	public Map<String,String> getHostnames(List<String> ips){

        Map<String,String> map = new HashMap<String,String>();
        System.out.println("正在提取hostname...");
        for(String ip : ips){
            String command = "ping -a " + ip;
            Runtime r = Runtime.getRuntime();
            Process p;
            try {
                p = r.exec(command);
                BufferedReader br = new BufferedReader(new InputStreamReader(p
                        .getInputStream()));
                String inline;
                while ((inline = br.readLine()) != null) {
                    if(inline.indexOf("[") > -1){
                        int start = inline.indexOf("Ping ");
                        int end = inline.indexOf("[");
                        String hostname = inline.substring(start+"Ping ".length(),end-1);
                        System.out.println(hostname);
                        map.put(ip,hostname);
                    }
                }
                br.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("提取结束！");
        return map;
    }
}
