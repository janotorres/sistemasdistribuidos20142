package br.com.emailmanager.webservice;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.com.emailmanager.common.ConnectionDBSQL;
import br.com.emailmanager.common.User;
import br.com.emailmanager.rmi.Server;

@WebService
public class AuthenticationServer {

	private User user;

	@WebMethod
	public void saveNewUser(String userEmail, String password) {
		user = new User();
		user.setUser(userEmail);
		user.setPassword(password);

		/*ConnectionDBSQL connection = new ConnectionDBSQL();
		try {
			int id = connection.saveNewUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		connection.closeConnection();
		user.setId(id);*/
		
		System.out.println("Usuário criado com sucesso");
	}

	@WebMethod
	public Boolean authenticate(String userEmail, String password) {
		user = new User();
		user.setUser(userEmail);
		user.setPassword(password);		

		/*ConnectionDBSQL connection = new ConnectionDBSQL();
		int idUser = connection.existsAnyUser(user);
		connection.closeConnection();
		user.setId(idUser);
		return idUser != 0;*/
		return true;
	}

	@WebMethod
	public void sendEmail(String to, String message) {
		try {
			EmailBoxServer.Email email = new EmailBoxServer.Email(0, message,
					to, user.getUser());

			Server obj = (Server) Naming.lookup("//localhost:2121/EmailServer");

			obj.sendEmail(email, user.getId());

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
	
	@WebMethod
	public User getAuthenticateUser()
	{
		return user;
	}	
}
