package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.AdminDao;
import com.demo.Admin;

import javax.servlet.annotation.WebServlet;

@WebServlet("/adminDeleteTeacher.do")
public class AdminDeleteTeacher extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AdminDao dao = new AdminDao();
		String message = null;

		try {
			String yql_Tno14 = new String(request.getParameter("yql_Tno14").getBytes("iso-8859-1"), "UTF-8");
			String yql_Tname14 = new String(request.getParameter("yql_Tname14").getBytes("iso-8859-1"), "UTF-8");

			boolean success = dao.deleteTeacher(yql_Tno14,yql_Tname14);

			if (success) {
				message = "�ɹ�ɾ��һ����ʦ��Ϣ!";
			} else {
				message = "SQLException�쳣����!";
			}
		} catch (Exception e) {
			message = "ɾ������!";
		}

		request.setAttribute("message", message);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/adminDisplayAddTeacher.jsp");
		rd.forward(request, response);

	}
}
