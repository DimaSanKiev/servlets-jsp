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
	}
	
	public boolean login(String email, String password) throws SQLException {
		
		/*String sql1 = "DROP TABLE IF EXISTS user;"
				+ "CREATE TABLE user (email VARCHAR(50) NOT NULL, password VARCHAR(25) NOT NULL);"
				+ "INSERT INTO user (email, password) VALUES ('user1', 'password1');"
				+ "INSERT INTO user (email, password) VALUES ('user2', 'password2');";
		Statement stmt1 = conn.createStatement();
		stmt1.executeUpdate(sql1);*/

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
	
}
