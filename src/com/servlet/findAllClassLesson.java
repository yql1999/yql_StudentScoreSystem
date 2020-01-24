package com.servlet;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.StudentDao;
import com.demo.Student;
import javax.servlet.annotation.WebServlet;

@WebServlet("/findAll.do")

//班级课程开设查询
public class findAllClassLesson extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		StudentDao dao = new StudentDao();
		String message = null;
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		try {
			ArrayList<Student> stuList = dao.findAllStudent();
			if (stuList != null) {
				message = "班级课程开设查询查询成功!";

				request.getSession().setAttribute("student", stuList);
			} else {
				message = "班级课程开设查询查询错误!";
			}

		} catch (Exception e) {
			message = "班级课程开设查询查询错误!";
		}

		request.getSession().setAttribute("message", message);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/displayAllClassLesson.jsp");
		rd.forward(request, response);

	}
}
