package br.com.emailmanager.webservice;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.mail.MessagingException;

import br.com.emailmanager.common.ConnectionDBSQL;
import br.com.emailmanager.common.User;
import br.com.emailmanager.rmi.Server;

@WebService
public class AuthenticationServer {

	private User user;

	@WebMethod
	public Boolean authenticate(String userEmail, String password) {
		user = new User();
		user.setUser(userEmail);
		user.setPassword(password);

		ConnectionDBSQL connection = new ConnectionDBSQL();
		Boolean existsUser = connection.existsAnyUser(user);
		connection.closeConnection();
		return existsUser;
	}

	@WebMethod
	public void sendEmail(String to, String message) {
		try {
			EmailBoxServer.Email email = new EmailBoxServer.Email(message, to,
					user.getUser());

			Server obj = (Server) Naming.lookup("//localhost/EmailServer");

			obj.sendEmail(email);

		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
