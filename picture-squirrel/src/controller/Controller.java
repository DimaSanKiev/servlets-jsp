package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gallery")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Controller() {
    }

	public void init(ServletConfig config) throws ServletException {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get the action parameter
		String action = request.getParameter("action");
		
		// Build the Map of action parameter to page
		Map<String, String> actionMap = new HashMap<>();
		actionMap.put("image", "/image.jsp");
		actionMap.put("home", "/home.jsp");
		
		// If the action parameter is null or the map doesn't contain
		// a page for this action, set the action to the home page
		if (action == null || !actionMap.containsKey(action)) {
			action = "home";
		}
		
		// Forward to the requested page
		request.getRequestDispatcher(actionMap.get(action)).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
