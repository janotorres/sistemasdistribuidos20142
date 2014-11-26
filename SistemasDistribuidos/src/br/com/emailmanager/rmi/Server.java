package br.com.emailmanager.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import javax.mail.MessagingException;

import EmailBoxServer.Email;

public interface Server extends Remote {
	public Boolean sendEmail(Email email) throws RemoteException, MessagingException;

}

