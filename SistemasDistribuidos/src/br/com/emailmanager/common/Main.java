package br.com.emailmanager.common;

import java.util.Scanner;

import br.com.emailmanager.webservice.cliente.AuthenticationServerService;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Escolha uma op��o:");
		System.out.println("1 - Criar usu�rio");
		System.out.println("2 - Autenticar usu�rio");
		
		int option = scanner.nextInt();

		br.com.emailmanager.webservice.cliente.AuthenticationServer port = new AuthenticationServerService()
				.getAuthenticationServerPort();
		User user = new User();

		try {
			if (option == 1) {
				System.out.println("Usu�rio:");
				user.setUser(scanner.next());
				System.out.println("Senha:");
				user.setPassword(scanner.next());
				port.saveNewUser(user.getUser(),
						user.getPassword());
			} else if (option == 2) {
				System.out.println("Usu�rio/e-mail:");
				user.setUser(scanner.next());
				System.out.println("Senha:");
				user.setPassword(scanner.next());

				Boolean userExists = port.authenticate(user.getUser(),
						user.getPassword());
				if (!userExists) {
					System.out.println("Usu�rio e/ou senha inv�lidos");
					System.exit(0);
				}
			} else {
				System.exit(0);
			}
			
			System.out.println("Escolha uma op��o:");
			System.out.println("1 - Enviar e-mail");
			System.out.println("2 - Consultar e-mails");
			
			option = scanner.nextInt();
			
			if (option == 1) {
				System.out.println("Destinat�rio:");
				String to = scanner.next();
				System.out.println("Mensagem:");
				String message = scanner.next();

				port.sendEmail(to, message);
			}
			else
			{
				
			}
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		scanner.close();
		System.exit(0);
	}

}
