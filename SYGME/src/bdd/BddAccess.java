package bdd;

import org.postgresql.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.sql.DriverManager;

public class BddAccess {

	private String url;
	private Connection connection;
	public BddAccess ()
	{}


	public void connect () {
	url = "jdbc:postgresql://127.0.0.1:5432/SYGIME";
	Connection db;
	try {
		db = DriverManager.getConnection(url, "user", "user");
	} catch (SQLException e) {
		System.out.println("Connection Failed! Check output console");
		e.printStackTrace();
		return;
	}
	connection = db;
	}
	
	
	public ResultSet select (String sqlQuery) throws SQLException{
		this.connect();
		Statement state = null;
		state = connection.createStatement();
		ResultSet rs = state.executeQuery(sqlQuery);
		connection.close();
		this.connection = null;
		return rs;
	}
	
	public void insert (String sqlQuery) throws SQLException {
		this.connect();
		Statement state = null;
		state = connection.createStatement();
		state.executeUpdate(sqlQuery);
		connection.close();
		this.connection = null;
	}

}