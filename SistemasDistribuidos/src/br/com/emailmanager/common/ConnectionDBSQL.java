package br.com.emailmanager.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
}
