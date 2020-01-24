package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.AdminDao;
import com.demo.Admin;

import javax.servlet.annotation.WebServlet;

@WebServlet("/adminDeleteStudent.do")
public class AdminDeleteStudent extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AdminDao dao = new AdminDao();
		String message = null;
		PrintWriter out = response.getWriter();

		try {
			String yql_Sno14 = new String(request.getParameter("yql_Sno14").getBytes("iso-8859-1"), "UTF-8");
			String yql_Sname14 = new String(request.getParameter("yql_Sname14").getBytes("iso-8859-1"), "UTF-8");

			boolean success = dao.deleteStudent(yql_Sname14);
			out.print("<script>alert('删除学生信息成功！');" + "window.location.href='login.jsp'</script>");

			if (success) {
				message = "成功删除一条学生信息!";
			} else {
				message = "SQLException异常错误!";
			}
		} catch (Exception e) {
			message = "删除错误!";
		}

		request.setAttribute("message", message);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/adminDisplayAddStudent.jsp");
		rd.forward(request, response);

	}
}
