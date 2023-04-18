package com.yedam;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddMemberFormControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		// 등록화면 호출
		String path = "WEB-INF/views/addForm.jsp";
		RequestDispatcher rd = req.getRequestDispatcher(path);
//		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/addForm.jsp");
		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
