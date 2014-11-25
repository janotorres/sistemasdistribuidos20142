package br.com.emailmanager.corba;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import br.com.emailmanager.common.ConnectionDBSQL;
import br.com.emailmanager.common.Email;
import EmailBoxServer.Email_Box_ServerPOA;

public class EmailBoxPOA extends Email_Box_ServerPOA {

	@Override
	public void salvarEmail(int userId, String toEmail, String messageEmail) {
		Email email = new Email();
		email.setMessage(messageEmail);
		email.setTo(toEmail);

		ConnectionDBSQL connection = new ConnectionDBSQL();
		try {
			connection.SaveEmails(email, userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		connection.CloseConnection();
	}

	@Override
	public String consultarEmail(int userId, String date) {
		ConnectionDBSQL connection = new ConnectionDBSQL();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	    Date result = null;
		try {
			result = df.parse(date);
		} catch (ParseException e) {			
			e.printStackTrace();
		}  
		connection.GetEmails(userId, result);
		return null;
	}

}
