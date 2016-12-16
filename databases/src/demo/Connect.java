package demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Connect")
public class Connect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Connect() {
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			out.println("Can't load database driver");
		}
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:h2:mem:webshop", "sa", "");
		} catch (SQLException e) {
			out.println("Can't connect to database");
		}
		out.println("Connected to database");
		try {
			conn.close();
		} catch (SQLException e) {
			out.println("Can't close the connection");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
