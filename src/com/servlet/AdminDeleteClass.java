package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.AdminDao;
import com.demo.Admin;

import javax.servlet.annotation.WebServlet;

@WebServlet("/adminDeleteClass.do")
public class AdminDeleteClass extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AdminDao dao = new AdminDao();
		String message = null;
		PrintWriter out = response.getWriter();

		try {
			String yql_Cno14 = new String(request.getParameter("yql_Cno14").getBytes("iso-8859-1"), "UTF-8");
			String yql_Cname14 = new String(request.getParameter("yql_Cname14").getBytes("iso-8859-1"), "UTF-8");

			boolean success = dao.deleteClass(yql_Cno14,yql_Cname14);
			out.print("<script>alert('ɾ���γ���Ϣ�ɹ���');" + "window.location.href='login.jsp'</script>");

			if (success) {
				message = "�ɹ�ɾ��һ���γ���Ϣ!";
			} else {
				message = "SQLException�쳣����!";
			}
		} catch (Exception e) {
			message = "ɾ������!";
		}

		request.setAttribute("message", message);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/adminDisplayAddClass.jsp");
		rd.forward(request, response);

	}
}
