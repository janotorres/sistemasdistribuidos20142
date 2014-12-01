package br.com.emailmanager.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import br.com.emailmanager.common.User;
import EmailBoxServer.Email;

public interface Server extends Remote {
	public Boolean sendEmail(Email email, int userId) throws RemoteException;
	public int saveNewUser(User user)  throws RemoteException;
	public int authenticate(User user)  throws RemoteException;
}

