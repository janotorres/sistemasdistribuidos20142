package br.com.emailmanager.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import EmailBoxServer.Email;

public class ConnectionDBSQL {

	Connection connection;
	Statement stmt;

	public ConnectionDBSQL() {
		try {
			String driverName = "com.mysql.jdbc.Driver";
			Class.forName(driverName);
		} catch (java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}

		try {

			// Configurando a nossa conex�o com um banco de dados
			String serverName = "localhost";
			// caminho do servidor do BD
			String mydatabase = "emailmanager";
			// nome do seu banco de dados
			String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
			String username = "root";
			// nome de um usu�rio de seu BD '
			String password = "123456"; // sua senha de acesso
			connection = DriverManager.getConnection(url, username, password);
			stmt = connection.createStatement();

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
	}

	public void closeConnection() {
		try {
			connection.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int existsAnyUser(User user) {
		String query = "select id from EmailUser where userName='"
				+ user.getUser() + "' and userPassword='" + user.getPassword()
				+ "';";
		try {
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				return rs.getInt("id");
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public Email[] getEmails(int userId, Date date) {
		Email[] arrayEmails;

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
				"yyyy-MM-dd 00:00:00");
		String currentTime = sdf.format(date);

		String query = "select * from EmailSent where sender=" + userId
				+ " and dt='" + currentTime + "'";
		try {
			ResultSet rs = stmt.executeQuery(query);

			int aux = 0;
			int rowcount = 0;

			if (rs.last()) {
				rowcount = rs.getRow();
				rs.beforeFirst();
			}
			arrayEmails = new Email[rowcount];

			while (rs.next() && aux != rowcount) {
				Email email = new Email(rs.getInt("id"),
						rs.getString("messageEmail"), rs.getString("toEmail"),
						" ");

				arrayEmails[aux] = email;
				aux++;
			}
			return arrayEmails;

		} catch (Exception e) {
			return null;
		}
	}

	public void saveEmails(Email email, int userId) throws SQLException {

		java.util.Date dt = new java.util.Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
				"yyyy-MM-dd");
		String currentTime = sdf.format(dt);

		String query = "insert into EmailSent(sender, dt, toEmail, messageEmail) values (";
		query += userId + ",'";
		query += currentTime + "','";
		query += email.To + "','";
		query += email.Message + "')";

		stmt.executeUpdate(query);

	}

	public void deleteEmail(int emailId) throws SQLException {
		String query = "delete from EmailSent where id =" + emailId;
		stmt.executeUpdate(query);
	}

	public int saveNewUser(User user) throws SQLException {
		String query = "insert into EmailUser(userName, userPassword)  values (";
		query += "'" + user.getUser() + "'" + ",";
		query += "'" + user.getPassword() + "'" + ")";

		stmt.executeUpdate(query);

		query = "select max(id) from EmailUser as id";
		try {
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				return rs.getInt("id");
			}
			return 0;
		} catch (Exception e) {
			return 0;
		}
	}
}
