package com.yedam;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/removeTodo.json")
public class RemoveTodo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RemoveTodo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TodoService service = new TodoServiceImpl();
		String json = "Fail";
		if(service.removeTodo(Integer.parseInt(request.getParameter("no")))) {
			json = "Success";
		};
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
