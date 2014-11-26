package br.com.emailmanager.corba;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.emailmanager.common.ConnectionDBSQL;
import EmailBoxServer.Email_Box_ServerPOA;

public class EmailBoxPOA extends Email_Box_ServerPOA {

	@Override
	public void saveEmail(int userId, String toEmail, String messageEmail) {
		EmailBoxServer.Email email = new EmailBoxServer.Email(messageEmail, toEmail, null);

		ConnectionDBSQL connection = new ConnectionDBSQL();
		try {
			connection.saveEmails(email, userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		connection.closeConnection();
	}

	@Override
	public EmailBoxServer.Email[] getEmails(int userId, String date) {
		ConnectionDBSQL connection = new ConnectionDBSQL();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	    Date result = null;
		try {
			result = df.parse(date);
		} catch (ParseException e) {			
			e.printStackTrace();
		}  
		return connection.getEmails(userId, result);
	}

}
