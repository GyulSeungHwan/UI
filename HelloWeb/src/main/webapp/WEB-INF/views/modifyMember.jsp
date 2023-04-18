<%@page import="com.yedam.domain.Employee"%>
<%@page import="com.yedam.persistence.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modifyMember.jsp</title>
<style>
 input[type = "button"]{
 	background-color: yellow;
 }
</style>
</head>
<body>
 <%
  // 사원번호 조회 => Employee
  /*String empId = request.getParameter("empid");
  EmpDAO dao = new EmpDAO();
  Employee result = dao.getEmp(Integer.parseInt(empId));*/
  Employee emp = (Employee) request.getAttribute("empInfo");
 %>
 
 <form action = "modifyMember.do" method = "POST">
  <table border = "1">
   <tr>
    <th>사원번호</th>
     <td><input type = "text" name = "empid" value = "<%=emp.getEmployeeId()%>" readonly></td>
   </tr>
   <tr>
    <th>FirstName</th>
     <td><input type = "text" name = "fname" value = "<%=emp.getFirstName()%>"></td>
   </tr>
   <tr>
    <th>LastName</th>
     <td><input type = "text" name = "lname" value = "<%=emp.getLastName()%>"></td>
   </tr>
   <tr>
    <th>Email</th>
     <td><input type = "text" name = "email" value = "<%=emp.getEmail()%>"></td>
   </tr>
   <tr>
    <td colspan = "2">
     <input type = "submit" value = "수정">
     <input type = "button" value = "삭제"> <!-- == $0 -->
    </td>
   </tr>
  </table>
 </form>
 
 <script>
 // Document Object Model
  let btn = document.querySelector('input[type="button"]');
  console.log(btn);
  btn.onclick = function(){
	  //alert("클릭됨");
	  let frm = document.querySelector('form');
	  frm.action = "deleteMember.do";
	  frm.submit(); // 
  }
 </script>
</body>
</html>