package br.com.emailmanager.common;

import java.util.Scanner;

import br.com.emailmanager.webservice.User;
import br.com.emailmanager.webservice.cliente.AuthenticationServerService;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Escolha uma opção:");
		System.out.println("1 - Criar usuário");
		System.out.println("2 - Autenticar usuário");
		
		int opcao = scanner.nextInt();
		
		br.com.emailmanager.webservice.cliente.AuthenticationServer port = new AuthenticationServerService().getAuthenticationServerPort();
		User usuario = new User();
		if (opcao == 1) {
			System.out.println("Usuário:");
			usuario.setUser(scanner.next());
			System.out.println("Senha:");
			usuario.setPassword(scanner.next());
		}
		else if (opcao == 2) {
			System.out.println("Usuário:");
			usuario.setUser(scanner.next());
			System.out.println("Senha:");
			usuario.setPassword(scanner.next());			
			
			port.autenticar(usuario.getUser(), usuario.getPassword());			
		}
		else
		{
			System.exit(0);
		}
		
		String to = scanner.next();
		String message = scanner.next();	
		
		port.enviarEmail(to, message);		
		
		scanner.close();		
	}

}
