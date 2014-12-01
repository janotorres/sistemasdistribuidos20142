package br.com.emailmanager.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import EmailBoxServer.Email;

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

			String connectionUrl = "jdbc:sqlserver:";
			connection = DriverManager.getConnection(connectionUrl);
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
				+ "' as id";
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

	public Email[] getEmails(int userId, Date date) {
		Email[] arrayEmails;

		String query = "select * from EmailSent where sender='" + userId
				+ "' and dt='" + date + "'";
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
				Email email = new Email(rs.getInt("id"), rs.getString("messageEmail"),
						rs.getString("toEmail"), null);

				arrayEmails[aux] = email;
				aux++;
			}
			return arrayEmails;

		} catch (Exception e) {
			return null;
		}
	}

	public void saveEmails(Email email, int userId) throws SQLException {
		String query = "insert into EmailSent values (";
		query += userId + ",";
		query += new Date() + ",";
		query += email.To + ",";
		query += email.Message + ")";

		stmt.executeQuery(query);

	}
	
	public void deleteEmail(int emailId) throws SQLException {
		String query = "delete * from EmailSent where id =" + emailId;
		stmt.executeQuery(query);
	}

	public int saveNewUser(User user) throws SQLException {
		String query = "insert into EmailUser values (";
		query += user.getUser() + ",";
		query += user.getPassword() + ")";

		stmt.executeQuery(query);
		
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
