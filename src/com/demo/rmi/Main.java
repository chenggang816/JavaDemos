package com.demo.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Main {
	public static void main(String[] args) {
		try {
			ServiceImpl service = new ServiceImpl();
			//注册方法一
			//          Registry registry = LocateRegistry.createRegistry(9889) ;
			//          registry.rebind("myRemote", service);
			//注册方法二
			LocateRegistry.createRegistry(6600);
			Naming.rebind("rmi://127.0.0.1:6600/myRemote", service);
			System.out.println("服务器启动成功!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
