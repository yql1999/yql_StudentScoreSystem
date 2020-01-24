package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.AdminDao;
import com.demo.Admin;

import javax.servlet.annotation.WebServlet;

@WebServlet("/adminUpdateClass.do")
public class AdminUpdateClass extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AdminDao dao = new AdminDao();
		Admin admin = new Admin();
		String message = null;
		PrintWriter out = response.getWriter();

		try {
			admin.setYql_Cno14(new String(request.getParameter("yql_Cno14").getBytes("iso-8859-1"), "UTF-8"));
			admin.setYql_Tname14(new String(request.getParameter("yql_Tname14").getBytes("iso-8859-1"), "UTF-8"));
			admin.setYql_Classhour14(Integer.parseInt(request.getParameter("yql_Testway14")));
			admin.setYql_Testway14(new String(request.getParameter("yql_Testway14").getBytes("iso-8859-1"), "UTF-8"));

			boolean success = dao.updateClass(admin);
			out.print("<script>alert('修改课程信息成功！');");


			if (success) {
				message = "成功修改一条课程信息!";
			} else {
				message = "SQLException异常错误!";
			}
		} catch (Exception e) {
			message = "错误!";
		}

		request.setAttribute("message", message);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/adminDisplayAddClass.jsp");
		rd.forward(request, response);

	}
}
