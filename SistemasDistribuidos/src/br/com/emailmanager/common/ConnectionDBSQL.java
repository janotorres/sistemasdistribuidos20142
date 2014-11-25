package br.com.emailmanager.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import br.com.emailmanager.webservice.User;

public class ConnectionDBSQL {

	Connection connection;
	Statement stmt;

	public ConnectionDBSQL() {
		try {
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");

		} catch (java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}

		try {

			String connectionUrl = "jdbc:sqlserver://WS534/SQLEXPRESS;"
					+ "databaseName=EmailManager;user=pronim;password=PRO2010nim;";
			connection = DriverManager.getConnection(connectionUrl);
			stmt = connection.createStatement();

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
	}

	public void CloseConnection() {
		try {
			connection.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Boolean AnyUser(User usuario) {
		String query = "select Count(*) from EmailUser where userName='"
				+ usuario.getUser() + "' and userPassword='"
				+ usuario.getPassword() + "' as total";
		try {
			ResultSet rs = stmt.executeQuery(query);
			return rs.getInt("total") > 0;
		} catch (Exception e) {
			return false;
		}
	}

	public ArrayList<Email> GetEmails(int userId, Date date) {
		ArrayList<Email> listEmails = new ArrayList<Email>();

		String query = "select * from EmailSent where sender='" + userId
				+ "' and dt='" + date + "'";
		try {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Email email = new Email();		
				email.setTo(rs.getString("toEmail"));
				email.setMessage(rs.getString("messageEmail"));

				listEmails.add(email);
			}
			return listEmails;
		} catch (Exception e) {
			return null;
		}
	}

	public void SaveEmails(Email email, int userId) throws SQLException {
		String query = "insert into EmailSent values (";
		query += userId + ",";
		query += new Date() + ",";
		query += email.getTo() + ",";
		query += email.getMessage() + ")";

		stmt.executeQuery(query);

	}
}
