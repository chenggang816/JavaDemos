package com.demo.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Main {
	public static void main(String[] args) {
		try {
			ServiceImpl service = new ServiceImpl();
			//ע�᷽��һ
			//          Registry registry = LocateRegistry.createRegistry(9889) ;
			//          registry.rebind("myRemote", service);
			//ע�᷽����
			LocateRegistry.createRegistry(6600);
			Naming.rebind("rmi://127.0.0.1:6600/myRemote", service);
			System.out.println("�����������ɹ�!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
