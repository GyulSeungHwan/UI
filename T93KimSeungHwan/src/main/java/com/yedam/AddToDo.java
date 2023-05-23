package com.yedam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/addTodo.json")
public class AddToDo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddToDo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String no = request.getParameter("no");
		String title = request.getParameter("title");
		String status = request.getParameter("status");
		
		ToDoVO vo = new ToDoVO();
		vo.setTodoNo(Integer.parseInt(no));
		vo.setTodoTitle(title);
		vo.setTodoStatus(status);
		
		TodoService service = new TodoServiceImpl();
		boolean result = service.addTodo(vo);
		
		String json = "";
		
		Map<String, Object> map = new HashMap<>();
		
		if(result) {
			map.put("retCode", "Success");
			map.put("data", vo);
		} else {
			map.put("retCode", "Fail");
		}
		
		Gson gson = new GsonBuilder().create();
		json = gson.toJson(map);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
