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
		if (option == 1) {
			System.out.println("Usuário:");
			user.setUser(scanner.next());
			System.out.println("Senha:");
			user.setPassword(scanner.next());
		} else if (option == 2) {
			System.out.println("Usuário:");
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

		String to = scanner.next();
		String message = scanner.next();

		port.sendEmail(to, message);

		scanner.close();
	}

}
