package com.demo.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientImpl {
	public static void main(String[] args) {
		try {
			ServiceRemote remote = (ServiceRemote) Naming.lookup("rmi://127.0.0.1:6600/myRemote");
            //����Զ�̷���
            String s = remote.doSomething();
            //���
            System.out.println("�ͻ��˽�����Ϣ:" + s);
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
	}
}
