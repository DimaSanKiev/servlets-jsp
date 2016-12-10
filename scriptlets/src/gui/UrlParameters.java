package gui;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UrlParameters")
public class UrlParameters extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UrlParameters() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// http://localhost:8080/scriptlets/UrlParameters?id=1&user=dima
		String user = request.getParameter("user");
		String id = request.getParameter("id");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("The <b>'user'</b> parameter is: " + user);
		out.println("<br/>");
		out.println("The <b>'id'</b> parameter is: " + id);
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
