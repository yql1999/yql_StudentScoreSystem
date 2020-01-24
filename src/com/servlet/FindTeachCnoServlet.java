package com.servlet;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.StudentDao;
import com.demo.Student;

import javax.servlet.annotation.WebServlet;

@WebServlet("/findTeachCno.do")

//��ʦ�οβ�ѯ
public class FindTeachCnoServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StudentDao dao = new StudentDao();
		String message = null;
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		ArrayList<Student> stuList = new ArrayList<Student>();
		
		try {
			stuList = dao.findTeachCno();
			
			if (stuList != null) {

				message = "��ʦ�ο���Ϣ��ѯ�ɹ�!";
				request.getSession().setAttribute("student", stuList);

			} else {
				message = "��ʦ�οβ�ѯ����1!";
			}

		} catch (Exception e) {
			e.printStackTrace();
			message = "��ʦ�οβ�ѯ����2!";
		}

		request.getSession().setAttribute("message", message);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/displayAllTeacherCno.jsp");
		rd.forward(request, response);

	}
}
