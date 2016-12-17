package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import bean.User;
import database.Account;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DataSource ds;
       
    public Controller() {
    }
    
    public void init(ServletConfig config) throws ServletException {
		try {
			InitialContext initContext = new InitialContext();
			Context env = (Context) initContext.lookup("java:comp/env");
			ds = (DataSource) env.lookup("jdbc/webshop");
		} catch (NamingException e) {
			throw new ServletException();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// use connection
		PrintWriter out = response.getWriter();
		
		String action = request.getParameter("action");

		if (action == null) {
			out.println("Unrecognized action");
			return;
		}

		Connection conn = null;

		try {
			conn = ds.getConnection();
		} catch (Exception e) {
			throw new ServletException();
		}

		if (action.equals("dologin")) {
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			User user = new User(email, password);

			request.setAttribute("email", email);
			request.setAttribute("password", "");

			Account account = new Account(conn);
			if (account.login(email, password)) {
				request.getRequestDispatcher("/loginsuccess.jsp").forward(request, response);
			} else {
				request.setAttribute("message", "Email address or password not recognized.");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}

		} else {
			out.println("Unrecognized action");
			return;
		}
	}

}
