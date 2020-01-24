package com.servlet;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.StudentDao;
import com.demo.Student;
import javax.servlet.annotation.WebServlet;

@WebServlet("/findBySaddress.do")

public class findBySaddress extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDao dao = new StudentDao();
		Student student = new Student();
		String message = null;

		String sno = (new String(request.getParameter("yql_Saddress14").getBytes("iso-8859-1"), "UTF-8"));
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		try {
			ArrayList<Student> success = dao.findBySaddress(sno);// ���ú���

			if (success != null) {
				message = "��ѯ�ɹ�!";
				request.getSession().setAttribute("student", success);

			} else {
				message = "��ѯ����!";
			}

		} catch (Exception e) {
			message = "��ѯ����!";
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/displayFindBySaddress.jsp");
		rd.forward(request, response);

	}
}
