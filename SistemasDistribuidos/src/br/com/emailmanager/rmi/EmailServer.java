package br.com.emailmanager.rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import br.com.emailmanager.common.ConnectionDBSQL;
import br.com.emailmanager.common.User;
import EmailBoxServer.Email;
import EmailBoxServer.Email_Box_Server;
import EmailBoxServer.Email_Box_ServerHelper;

public class EmailServer extends UnicastRemoteObject implements Server {

	final String username = "manitur.heloisa@gmail.com";
	final String password = "senha";

	protected EmailServer() throws RemoteException {
		super();
	}

	@Override
	public Boolean sendEmail(Email email, int userId) throws RemoteException {
		try {

			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class",
					"javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");

			Session session = Session.getInstance(props,
					new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(username,
									password);
						}
					});

			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(email.From));
				message.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(email.To));
				message.setSubject("Testing Subject RMI");
				message.setText(email.Message);

				Transport.send(message);

				System.out.println("E-mail enviado com sucesso");

				String args[] = new String[4];
				args[0] = "-ORBInitialHost";
				args[1] = "localhost";
				args[2] = "-ORBInitialPort";
				args[3] = "2222";
				ORB orb = ORB.init(args, null);
				org.omg.CORBA.Object objRef = orb
						.resolve_initial_references("NameService");
				NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
				String name = "Email_Box_Server";
				Email_Box_Server server = Email_Box_ServerHelper.narrow(ncRef
						.resolve_str(name));
				server.saveEmail(userId, email.To, email.Message);

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public int saveNewUser(User user)  throws RemoteException {
		ConnectionDBSQL connection = new ConnectionDBSQL();
		int id = 0;
		try {
			id = connection.saveNewUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		connection.closeConnection();
		System.out.println("Usuário criado com sucesso");
		return id;
	}

	@Override
	public int authenticate(User user)  throws RemoteException {
		ConnectionDBSQL connection = new ConnectionDBSQL();
		int id = connection.existsAnyUser(user);
		connection.closeConnection();
		return id;
	}

	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(2121);
			EmailServer object = new EmailServer();
			Naming.rebind("//localhost:2121/EmailServer", object);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
