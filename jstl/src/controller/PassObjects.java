package controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Case;

@WebServlet("/PassObjects")
public class PassObjects extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PassObjects() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Case case1 = new Case("Request Scope", 1);
		Case case2 = new Case("Session Scope", 2);
		Case case3 = new Case("Application Scope", 3);
		
		// Request scope
		request.setAttribute("case1", case1);
		
		// Session scope
		HttpSession session = request.getSession();
		session.setAttribute("case2", case2);
		
		// Application scope
		ServletContext context = getServletContext();
		context.setAttribute("case3", case3);
		
		request.getRequestDispatcher("/receiveObjects.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
