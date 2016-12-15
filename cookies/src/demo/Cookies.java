package demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Cookies")
public class Cookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Cookies() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		
		// all cookies set by this site for this browser corresponding to this request 
		Cookie[] cookies = request.getCookies();
		
		if (cookies == null) {
			out.println("No cookies found.<br/>");
		} else {
			for (Cookie retrievedCookie : cookies) {
				String name = retrievedCookie.getName();
				String value = retrievedCookie.getValue();

				out.println(name + " = " + value + "<br/>");
			}
		}
		
		Cookie cookie = new Cookie("user", "Dima");
		cookie.setMaxAge(300);		// 5 minutes
		response.addCookie(cookie);
		
		out.println("Cookie set.<br/>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
