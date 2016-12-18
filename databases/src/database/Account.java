package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Account {
	private Connection conn;

	public Account(Connection conn) {
		this.conn = conn;
		try {
			populateDatabase();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean login(String email, String password) throws SQLException {

		String sql = "SELECT COUNT(*) AS count FROM user WHERE email=? AND password=?";

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, email);
		stmt.setString(2, password);

		ResultSet rs = stmt.executeQuery();

		int count = 0;
		if (rs.next()) {
			count = rs.getInt("count");
		}
		
		rs.close();
		
		if (count == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public void create(String email, String password) throws SQLException {
		String sql = "INSERT INTO user (email, password) VALUES (?,?);";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, email);
		stmt.setString(2, password);
		
		stmt.executeUpdate();
		
		stmt.close();
	}
	
	public boolean exists(String email) throws SQLException {
		String sql = "SELECT COUNT(*) AS count FROM user WHERE email=?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, email);
		
		ResultSet rs = stmt.executeQuery();
		
		int count = 0;
		if (rs.next()) {
			count = rs.getInt("count");
		}
		
		rs.close();
		
		if (count == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public void populateDatabase() throws SQLException {
		String sql = "DROP TABLE IF EXISTS user;"
				+ "CREATE TABLE user (email VARCHAR(50) NOT NULL, password VARCHAR(25) NOT NULL);"
				+ "INSERT INTO user (email, password) VALUES ('user1@email.com', 'password1');"
				+ "INSERT INTO user (email, password) VALUES ('user2@email.com', 'password2');";
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
	}
}
