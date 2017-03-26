package com.demo.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServiceImpl extends UnicastRemoteObject implements ServiceRemote {

	protected ServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public String doSomething() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Service: A method is called !");
        return "Service doSomething .";
	}

}
