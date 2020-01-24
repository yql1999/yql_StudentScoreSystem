package com.servlet;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.StudentDao;
import com.demo.Student;
import javax.servlet.annotation.WebServlet;

@WebServlet("/findAll.do")

//�༶�γ̿����ѯ
public class findAllClassLesson extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		StudentDao dao = new StudentDao();
		String message = null;
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		try {
			ArrayList<Student> stuList = dao.findAllStudent();
			if (stuList != null) {
				message = "�༶�γ̿����ѯ��ѯ�ɹ�!";

				request.getSession().setAttribute("student", stuList);
			} else {
				message = "�༶�γ̿����ѯ��ѯ����!";
			}

		} catch (Exception e) {
			message = "�༶�γ̿����ѯ��ѯ����!";
		}

		request.getSession().setAttribute("message", message);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/displayAllClassLesson.jsp");
		rd.forward(request, response);

	}
}
