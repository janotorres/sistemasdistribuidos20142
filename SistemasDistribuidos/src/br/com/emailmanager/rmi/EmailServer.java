package br.com.emailmanager.rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

import EmailBoxServer.Email;

public class EmailServer extends UnicastRemoteObject implements Server{

	protected EmailServer() throws RemoteException {
		super();
	}

	@Override
	public Boolean sendEmail(Email email) throws RemoteException, MessagingException {
		Properties properties = System.getProperties();
		properties.put("mail.smtp.starttls.enable", "true"); 
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.user", "manitur.heloisa@gmail.com"); // User name
		properties.put("mail.smtp.password", "senha"); // password
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		Session session = Session.getDefaultInstance(properties);
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(email.From));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(email.To));
		message.setSubject("E-mail enviando via RMI");
		message.setText(email.Message);
		Transport.send(message);
		return true;
	}
	
	public static void main(String[] args) {
		try {
			EmailServer object = new EmailServer();
			Naming.rebind("//localhost/EmailServer", object);				
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
