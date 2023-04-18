package com.yedam;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.domain.Employee;
import com.yedam.persistence.EmpDAO;

@WebServlet("/empList")
public class EmpListServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
//		// jdbc 연결 접속 조회
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
		
		EmpDAO dao = new EmpDAO();
		List<Employee> list = dao.getEmpList();
		
//		try {
//			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
//			// 쿼리조회 -> 처리결과 : PreparedStatement
//			String sql = "SELECT employee_id, first_name, last_name, email, phone_number FROM employees";
//			PreparedStatement psmt = conn.prepareStatement(sql);
//			ResultSet rs = psmt.executeQuery();
			
			out.print("<table border = '1'>");
			out.print("<thead><tr><td>사원번호</td><td>FirstName</td><td>LastName</td><td>Email</td><td>PhoneNumber</td></tr></thead>");
			out.print("<tbody>");
//			while(rs.next()) {
			for (Employee emp : list) {
//				System.out.println("eid: " + rs.getInt("employee_id") + "fName: " + rs.getString("first_name") + "lName: " + rs.getString("last_name") + "email: " + rs.getString("email") + "phone: " + rs.getString("phone_number"));
				// 사원번호, fName, lname, email, phone...
				out.print("<tr><td><a href = 'searchMember?empid="+ emp.getEmployeeId() + "'>"
						+ emp.getEmployeeId() + "</a></td> <td>"
						+ emp.getFirstName()
						+ "</td> <td>" + emp.getLastName()
						+ "</td> <td>" + emp.getEmail()
						+ "</td> <td>" + emp.getJobId()
						+ "</td></tr>");
			}
//				System.out.println("eid: " + rs.getInt("employee_id") + "fName: " + rs.getString("first_name") + "lName: " + rs.getString("last_name") + "email: " + rs.getString("email") + "phone: " + rs.getString("phone_number"));
//				// 사원번호, fName, lname, email, phone...
//				out.print("<tr><td>" + rs.getInt("employee_id") + "</td> <td>" + rs.getString("first_name") + "</td> <td>" + rs.getString("last_name") + "</td> <td>" + rs.getString("email") + "</td> <td>" + rs.getString("phone_number") + "</td>");
//			}
			out.print("</tbody>");
			out.print("</table>");
//			conn.close();
//			psmt.close();
//			rs.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}
	
//	public static void main(String[] args) {
//		// jdbc 연결 접속 조회
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		
//		try {
//			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
//			// 쿼리조회 -> 처리결과 : PreparedStatement
//			String sql = "SELECT employee_id, first_name, last_name, email, phone_number FROM employees";
//			PreparedStatement psmt = conn.prepareStatement(sql);
//			ResultSet rs = psmt.executeQuery();
//			
//			while(rs.next()) {
//				System.out.println("eid: " + rs.getInt("employee_id") + "fName: " + rs.getString("first_name"));
//			}
//			conn.close();
//			psmt.close();
//			rs.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
}
