package br.com.emailmanager.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Server extends Remote {
	public Boolean EnviarEmail() throws RemoteException;

}
