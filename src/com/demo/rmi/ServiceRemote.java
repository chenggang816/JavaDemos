package com.demo.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServiceRemote extends Remote {
	String doSomething() throws RemoteException;
}
