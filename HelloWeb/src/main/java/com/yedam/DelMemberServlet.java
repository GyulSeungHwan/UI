package com.yedam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.domain.Employee;
import com.yedam.persistence.EmpDAO;

@WebServlet("/delMemberServlet")
public class DelMemberServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
		
		String employeeId = req.getParameter("empid");
		
		EmpDAO dao = new EmpDAO();
		boolean result = dao.deleteEmployee(Integer.parseInt(employeeId));
		
		if(result) {
			resp.sendRedirect("empList");
		} else {
			resp.sendRedirect("../delForm.html");
		}
		
//		try {
//			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
//			String sql = "DELETE FROM employees WHERE employee_id = ?";
//			PreparedStatement psmt = conn.prepareStatement(sql);
//			psmt.setString(1, employeeId);
//			
//			int r = psmt.executeUpdate();
//			System.out.println("처리된 건수: " + r);
//			
//			resp.sendRedirect("empList");
//		} catch (Exception e) {
//			
//		}
	}
}
