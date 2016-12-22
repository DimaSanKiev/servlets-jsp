package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		
		// Using Map in EL
		Map<String, String> map = new HashMap<>();
		map.put("fruit", "apple");
		request.setAttribute("map1", map);
		
		// <c:out> tag vs direct using of EL
		request.setAttribute("link", "<a href='something.com'>Click here</a>");
		
		// forEach iterating through List
		List<Case> list = new ArrayList<>();
		list.add(new Case("test1", 1));
		list.add(new Case("test2", 2));
		list.add(new Case("test3", 3));
		session.setAttribute("list1", list);
		
		request.getRequestDispatcher("/receiveObjects.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
