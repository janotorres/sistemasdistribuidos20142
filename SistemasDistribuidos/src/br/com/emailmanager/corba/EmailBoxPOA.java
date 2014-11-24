package br.com.emailmanager.corba;

import EmailBoxServer.Email_Box_ServerPOA;

public class EmailBoxPOA extends Email_Box_ServerPOA {

	@Override
	public void salvarEmail() {
		System.out.println("salvando e-mail");
		
	}

	@Override
	public String consultarEmail() {
		return "e-mail consultado";
	}

}
