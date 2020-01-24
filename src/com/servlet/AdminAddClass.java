package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.AdminDao;
import com.demo.Admin;

import javax.servlet.annotation.WebServlet;

@WebServlet("/adminAddClass.do")
public class AdminAddClass extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AdminDao dao = new AdminDao();
		Admin admin = new Admin();
		String message = null;

		try {
			admin.setYql_Cno14(new String(request.getParameter("yql_Cno14").getBytes("iso-8859-1"), "UTF-8"));
			admin.setYql_Cname14(new String(request.getParameter("yql_Cname14").getBytes("iso-8859-1"), "UTF-8"));
			admin.setYql_Tname14(new String(request.getParameter("yql_Tname14").getBytes("iso-8859-1"), "UTF-8"));
			admin.setYql_Startterm14(new String(request.getParameter("yql_Startterm14").getBytes("iso-8859-1"), "UTF-8"));
			admin.setYql_Classhour14(Integer.parseInt(request.getParameter("yql_Classhour14")));
			admin.setYql_Testway14(new String(request.getParameter("yql_Testway14").getBytes("iso-8859-1"), "UTF-8"));
			admin.setYql_Credit14(Integer.parseInt(request.getParameter("yql_Credit14")));

			boolean success = dao.addClass(admin);

			if (success) {
				message = "成功插入一条课程信息!";
			} else {
				message = "SQLException异常错误!";
			}
		} catch (Exception e) {
			message = "插入记录错误!";
		}

		request.setAttribute("message", message);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/adminDisplayAddClass.jsp");
		rd.forward(request, response);

	}
}
