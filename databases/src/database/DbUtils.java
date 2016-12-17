package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtils {

	public static void populateDatabase() throws ClassNotFoundException, SQLException {
		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection("jdbc:h2:mem:webshop", "sa", "");

		String sql = "DROP TABLE IF EXISTS user;"
				+ "CREATE TABLE user (email VARCHAR(50) NOT NULL, password VARCHAR(25) NOT NULL);"
				+ "INSERT INTO user (email, password) VALUES ('user1', 'password1');"
				+ "INSERT INTO user (email, password) VALUES ('user2', 'password2');";
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
		conn.close();
	}
	
	public static void main(String[] args) {
		try {
			populateDatabase();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
