package com.demo.socket;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
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
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class GainAllIpFrame {
 public static void main(String[] args) {
	JFrame jFrame = new JFrame("获取局域网内所有IP");
	Container container = jFrame.getContentPane();
	
	JPanel jp1 = new JPanel();
	JPanel jp2 = new JPanel();
	
	final JLabel jLabel = new JLabel("结果信息如下：");
	
	final JTextArea jTextArea = new JTextArea();
	JScrollPane jScrollPane = new JScrollPane(jTextArea);
	jScrollPane.setBounds(20,90,400,300);
	
	JButton jButton = new JButton("获取所有IP");
	jButton.setBounds(10, 10, 100, 40);
	jButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String str = "本地ip信息:\n";
			NetHelper netHelper = new NetHelper();
			//获取本机ip
			try {
				str += "\t主机名：" + netHelper.getLocalHostName() + "\n\tip:";
				for (String ip : netHelper.getAllLocalHostIp()) {
					str += "\n\t" + ip;
				}
				
				str += "\n局域网ip与主机名：\n";
				List<String> ips = netHelper.getIPs();
				Map<String,String> mapIps = netHelper.getHostnames(ips);
				for (Map.Entry<String,String> entry : mapIps.entrySet()) {
					str += "\t" +  entry.getKey() + "   :   " + entry.getValue() + "\n";
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			//获取局域网ip
			str += "------------------------------------------------------------------\n结束";
			jTextArea.setText(str);
		}
	});
	jp1.setLayout(new GridLayout(2,1,5,5));
	jp2.setLayout(new FlowLayout(FlowLayout.LEFT));
	jp2.add(jButton);
	jp1.add(jp2);
	jp1.add(jLabel);
	container.add(jp1,BorderLayout.NORTH);
	container.add(jScrollPane,BorderLayout.CENTER);
	jFrame.setVisible(true);
	jFrame.setBounds(300, 200, 500, 500);
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
        Runtime r = Runtime.getRuntime();
        Process p;
        try {
            p = r.exec("arp -a");
            BufferedReader br = new BufferedReader(new InputStreamReader(p
                    .getInputStream()));
            String inline;
            while ((inline = br.readLine()) != null) {
            	System.out.println(inline);
                if(inline.contains("接口") || inline.contains("Internet") || inline.equals("")){
                    continue;
                }
                
                //有效IP
                String[] str=inline.split(" {4}");
                list.add(str[0].trim());
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        HashSet<String> hashSet = new HashSet<String>(list);
        list.clear();
        list.addAll(hashSet);
        
        for (int i=0;i<list.size();i++) {
        	String string = list.get(i);
			if(string.equals("255.255.255.255")){
				list.remove(string);
				i--;
			}
		}
        System.out.println(list);
        return list;
    }
	/*
	 * 根据IP提取主机名
	 * http://blog.csdn.net/havedream_one/article/details/47071393
	 */
	public Map<String,String> getHostnames(final List<String> ips) throws InterruptedException{
		
        final Map<String,String> map = new HashMap<String,String>();
        class MonitorObj{
        	private int finishedIpNum = 0;
			public int getFinishedIpNum() {
				return finishedIpNum;
			}
			public void addFinishedIpNum(int value) {
				this.finishedIpNum += value;
			}
			public void doNotify(){
				synchronized (this) {
					this.notify();
				}
			}
        }
        final MonitorObj monitorObj = new MonitorObj();
        class PingIp extends Thread{
			private String ip;
			public PingIp(String threadName,String ip) {
				this.setName(threadName);
				this.ip = ip;
			}
			@Override
			public void run() {
				String hostname = getHostNameByIp(ip);
	        	if(hostname != null){
	        		System.out.println(ip + ":" + hostname);
	        		map.put(ip,hostname);
	        	}else {
	        		map.put(ip,"unknown");
				}
	        	System.out.println("线程" + this.getName() + "已结束退出");
	        	monitorObj.addFinishedIpNum(1);
	        	if(monitorObj.getFinishedIpNum() >= ips.size()){
	        		monitorObj.doNotify();
	        	}
			}
		}
        
        System.out.println("正在提取hostname...");
//        Thread mainThread = Thread.currentThread();
//        System.out.println(mainThread.getName());
        System.out.println("共有" + ips.size() + "个线程");
        for(int i=0;i<ips.size();i++){
        	String ip = ips.get(i);
        	PingIp pingIp = new PingIp(String.valueOf(i),ip);
        	pingIp.start();
        }
        synchronized (monitorObj) {
        	monitorObj.wait();
		}
        
        System.out.println("提取结束！");         
        return map;
    }
	
	private static String getHostNameByIp(String ip) {
		String command = "ping -a -n 1 -w 10 " + ip;
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
                    return hostname;
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
	}
}
