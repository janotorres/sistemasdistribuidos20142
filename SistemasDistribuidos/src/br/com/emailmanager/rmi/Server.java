package br.com.emailmanager.rmi;

import java.rmi.Remote;

import EmailBoxServer.Email;

public interface Server extends Remote {
	public Boolean sendEmail(Email email);

}

