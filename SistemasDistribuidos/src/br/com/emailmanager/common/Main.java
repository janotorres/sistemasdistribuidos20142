package br.com.emailmanager.common;

import java.util.Scanner;

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
				port.saveNewUser(user.getUser(),
						user.getPassword());
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
			
			option = scanner.nextInt();
			
			if (option == 1) {
				System.out.println("Destinatário:");
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
