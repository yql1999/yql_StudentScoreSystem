package com.servlet;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.StudentDao;
import com.demo.Student;

import javax.servlet.annotation.WebServlet;

@WebServlet("/findBySnoServlet.do")

//��ѧ�Ų���ѧ���ɼ�
public class FindBySnoServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StudentDao dao = new StudentDao();
		ArrayList<Student> studentList = new ArrayList<Student>();
		String message = null;
		response.setContentType("text/html;charset=UTF-8");
		String productid = request.getParameter("yql_Sno14");
		PrintWriter out = response.getWriter();

		try {

			studentList = dao.findBySno(productid);	// ���ú���

			if (studentList != null) {
				message = "ѧ���ɼ���ѯ�ɹ�!";
				request.getSession().setAttribute("student", studentList);

			} else {
				message = "ѧ���ɼ���ѯ����1!";
			}

		} catch (Exception e) {
			e.printStackTrace();
			message = "ѧ���ɼ���ѯ����2!";
		}

		request.getSession().setAttribute("message", message);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/displayFindBySno.jsp");
		rd.forward(request, response);

	}
}
