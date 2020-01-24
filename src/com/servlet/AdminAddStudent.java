package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.AdminDao;
import com.demo.Admin;

import javax.servlet.annotation.WebServlet;

@WebServlet("/adminAddStudent.do")
public class AdminAddStudent extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AdminDao dao = new AdminDao();
		Admin admin = new Admin();
		String message = null;
		PrintWriter out = response.getWriter();

		try {
			admin.setYql_Sno14(new String(request.getParameter("yql_Sno14").getBytes("iso-8859-1"), "UTF-8"));
			admin.setYql_Sname14(new String(request.getParameter("yql_Sname14").getBytes("iso-8859-1"), "UTF-8"));
			admin.setYql_Ssex14(new String(request.getParameter("yql_Ssex14").getBytes("iso-8859-1"), "UTF-8"));
			admin.setYql_Sage14(Integer.parseInt(request.getParameter("yql_Sage14")));
			admin.setYql_Saddress14(new String(request.getParameter("yql_Saddress14").getBytes("iso-8859-1"), "UTF-8"));
			admin.setYql_Screditsum14(Integer.parseInt(request.getParameter("yql_Screditsum14")));
			admin.setYql_CSno14(new String(request.getParameter("yql_CSno14").getBytes("iso-8859-1"), "UTF-8"));

			boolean success = dao.addStudent(admin);

			if (success) {
				message = "成功插入一条学生信息!";			
				out.print("<script>alert('插入学生信息成功！');" + "window.location.href='login.jsp'</script>");

			} else {
				message = "SQLException异常错误!";
			}
		} catch (Exception e) {
			message = "插入记录错误!";
		}

		request.setAttribute("message", message);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/adminDisplayAddStudent.jsp");
		rd.forward(request, response);

	}
}
