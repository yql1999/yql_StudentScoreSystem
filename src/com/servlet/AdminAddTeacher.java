package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.AdminDao;
import com.demo.Admin;

import javax.servlet.annotation.WebServlet;

@WebServlet("/adminAddTeacher.do")
public class AdminAddTeacher extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AdminDao dao = new AdminDao();
		Admin admin = new Admin();
		String message = null;

		try {
			admin.setYql_Tno14(new String(request.getParameter("yql_Tno14").getBytes("iso-8859-1"), "UTF-8"));
			admin.setYql_Tname14(new String(request.getParameter("yql_Tname14").getBytes("iso-8859-1"), "UTF-8"));
			admin.setYql_Tsex14(new String(request.getParameter("yql_Tsex14").getBytes("iso-8859-1"), "UTF-8"));
			admin.setYql_Tage14(Integer.parseInt(request.getParameter("yql_Tage14")));
			admin.setYql_Trank14(new String(request.getParameter("yql_Trank14").getBytes("iso-8859-1"), "UTF-8"));
			admin.setYql_Tphone14(new String(request.getParameter("yql_Tphone14")));

			boolean success = dao.addTeacher(admin);

			if (success) {
				message = "成功插入一条教师信息!";
			} else {
				message = "SQLException异常错误!";
			}
		} catch (Exception e) {
			message = "插入记录错误!";
		}

		request.setAttribute("message", message);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/adminDisplayAddTeacher.jsp");
		rd.forward(request, response);

	}
}
