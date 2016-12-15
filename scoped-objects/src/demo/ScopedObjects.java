package demo;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ScopedObjects")
public class ScopedObjects extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ScopedObjects() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Request scope - A user’s interaction with a web application in a single HTTP request.
		request.setAttribute("test", "Hello");
		String test1 = (String) request.getAttribute("test");
		
		// Session scope - A user’s interaction with a web application across multiple HTTP requests.
		HttpSession session = request.getSession();
		session.setAttribute("test", "Hello");
		String test2 = (String) session.getAttribute("test");
		
		// Application scope - Shared state across all users’ interactions with a web application.
		ServletContext context = getServletContext();
		context.setAttribute("test", "Hello");
		String test3 = (String) context.getAttribute("test");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
