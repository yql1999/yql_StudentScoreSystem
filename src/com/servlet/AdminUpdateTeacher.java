package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.AdminDao;
import com.demo.Admin;

import javax.servlet.annotation.WebServlet;

@WebServlet("/adminUpdateTeacher.do")
public class AdminUpdateTeacher extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AdminDao dao = new AdminDao();
		Admin admin = new Admin();
		String message = null;
		PrintWriter out = response.getWriter();

		try {
			admin.setYql_Tno14(new String(request.getParameter("yql_Tno14").getBytes("iso-8859-1"), "UTF-8"));
			admin.setYql_Tphone14(new String(request.getParameter("yql_Tphone14").getBytes("iso-8859-1"), "UTF-8"));
			admin.setYql_Tage14(Integer.parseInt(request.getParameter("yql_Tage14")));

			boolean success = dao.updateTeacher(admin);
			out.print("<script>alert('�޸Ľ�ʦ��Ϣ�ɹ���');" + "window.location.href='login.jsp'</script>");

			if (success) {
				message = "�ɹ��޸�һ����ʦ��Ϣ!";
			} else {
				message = "SQLException�쳣����!";
			}
		} catch (Exception e) {
			message = "����!";
		}

		request.setAttribute("message", message);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/adminDisplayAddTeacher.jsp");
		rd.forward(request, response);

	}
}
