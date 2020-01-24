package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.AdminDao;
import com.demo.Admin;

import javax.servlet.annotation.WebServlet;

@WebServlet("/adminUpdateStudent.do")
public class AdminUpdateStudent extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AdminDao dao = new AdminDao();
		Admin admin = new Admin();
		String message = null;
		PrintWriter out = response.getWriter();

		try {
			admin.setYql_Sno14(new String(request.getParameter("yql_Sno14").getBytes("iso-8859-1"), "UTF-8"));
			admin.setYql_Saddress14(new String(request.getParameter("yql_Saddress14").getBytes("iso-8859-1"), "UTF-8"));
			admin.setYql_Sage14(Integer.parseInt(request.getParameter("yql_Sage14")));

			boolean success = dao.updateStudent(admin);
			out.print("<script>alert('�޸�ѧ����Ϣ�ɹ���');" + "window.location.href='login.jsp'</script>");


			if (success) {
				message = "�ɹ��޸�һ��ѧ����Ϣ!";
			} else {
				message = "SQLException�쳣����!";
			}
		} catch (Exception e) {
			message = "����!";
		}

		request.setAttribute("message", message);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/adminDisplayAddStudent.jsp");
		rd.forward(request, response);

	}
}
