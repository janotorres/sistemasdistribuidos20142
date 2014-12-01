package br.com.emailmanager.webservice;

import javax.xml.ws.Endpoint;

public class PublishesAuthenticationServer {

	public static void main(String[] args) {
		AuthenticationServer server = new AuthenticationServer();
		Endpoint.publish("http://localhost:2222/Authentication", server);
	}

}
