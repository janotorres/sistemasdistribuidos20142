package br.com.emailmanager.webservice;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.com.emailmanager.common.Email;
import br.com.emailmanager.rmi.Server;

@WebService
public class AuthenticationServer {

	private User usuarioAutenticado;
	
	@WebMethod
	public void autenticar(String user, String password)
	{
		usuarioAutenticado = new User();
		usuarioAutenticado.setUser(user);
		usuarioAutenticado.setPassword(password);
	}
	
	@WebMethod
	public void EnviarEmail(String to, String message)
	{
		try {
			Email email = new Email();
			email.setFrom(usuarioAutenticado.getUser());
			email.setMessage(message);
			email.setTo(to);
			
			Server obj = (Server)Naming.lookup("//localhost/EmailServer");
			obj.EnviarEmail();
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
