package br.com.emailmanager.common;

import java.util.Date;
import java.util.Scanner;

import javax.jws.WebMethod;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import EmailBoxServer.Email;
import EmailBoxServer.Email_Box_Server;
import EmailBoxServer.Email_Box_ServerHelper;
import br.com.emailmanager.webservice.cliente.AuthenticationServerService;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Escolha uma opção:");
		System.out.println("1 - Criar usuário");
		System.out.println("2 - Autenticar usuário");

		int option = scanner.nextInt();

		br.com.emailmanager.webservice.cliente.AuthenticationServer port = new AuthenticationServerService()
				.getAuthenticationServerPort();
		User user = new User();

		try {
			if (option == 1) {
				System.out.println("Usuário:");
				user.setUser(scanner.next());
				System.out.println("Senha:");
				user.setPassword(scanner.next());
				port.saveNewUser(user.getUser(), user.getPassword());
			} else if (option == 2) {
				System.out.println("Usuário/e-mail:");
				user.setUser(scanner.next());
				System.out.println("Senha:");
				user.setPassword(scanner.next());

				Boolean userExists = port.authenticate(user.getUser(),
						user.getPassword());
				if (!userExists) {
					System.out.println("Usuário e/ou senha inválidos");
					System.exit(0);
				}
			} else {
				System.exit(0);
			}

			System.out.println("Escolha uma opção:");
			System.out.println("1 - Enviar e-mail");
			System.out.println("2 - Consultar e-mails");
			System.out.println("3 - Deletar e-mail");

			option = scanner.nextInt();

			if (option == 1) {
				System.out.println("Destinatário:");
				String to = scanner.next();
				System.out.println("Mensagem:");
				String message = scanner.next();

				port.sendEmail(to, message);
			} else {
				try {
					args = new String[2];
					args[0] = "-ORBInitialHost";
					args[1] = "localhost";
					/*
					 * args[2] = "-ORBInitialPort"; args[3] = "2222";
					 */

					ORB orb = ORB.init(args, null);
					org.omg.CORBA.Object objRef = orb
							.resolve_initial_references("NameService");
					NamingContextExt ncRef = NamingContextExtHelper
							.narrow(objRef);
					String name = "Email_Box_Server";
					Email_Box_Server server = Email_Box_ServerHelper
							.narrow(ncRef.resolve_str(name));
					if (option == 2) {
						java.util.Date dt = new java.util.Date();
						java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
								"yyyy-MM-dd 00:00:00");
						String currentTime = sdf.format(dt);
						Email[] emails = server.getEmails(port
								.getAuthenticateUser().getId(), currentTime);

						if (emails.length > 0) {
							for (int i = 0; i < emails.length; i++) {
								System.out.println(emails[i].emailId + " - " + emails[i].To + " - "
										+ emails[i].Message);
							}
						} else {
							System.out.println("Nenhum e-mail encontrado");
						}

					}
					if (option == 3) {
						System.out.println("E-mail id:");
						server.deleteEmail(scanner.nextInt());
					}
				} catch (Exception e) {
					System.out.println("ERROR : " + e);
					e.printStackTrace(System.out);
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		scanner.close();
		System.exit(0);
	}

}
