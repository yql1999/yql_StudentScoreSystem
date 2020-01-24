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
			out.print("<script>alert('ɾ��ѧ����Ϣ�ɹ���');" + "window.location.href='login.jsp'</script>");

			if (success) {
				message = "�ɹ�ɾ��һ��ѧ����Ϣ!";
			} else {
				message = "SQLException�쳣����!";
			}
		} catch (Exception e) {
			message = "ɾ������!";
		}

		request.setAttribute("message", message);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/adminDisplayAddStudent.jsp");
		rd.forward(request, response);

	}
}
