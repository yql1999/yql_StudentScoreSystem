package com.servlet;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.StudentDao;
import com.demo.Student;

import javax.servlet.annotation.WebServlet;

@WebServlet("/findTeachCno.do")

//教师任课查询
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

				message = "教师任课信息查询成功!";
				request.getSession().setAttribute("student", stuList);

			} else {
				message = "教师任课查询错误1!";
			}

		} catch (Exception e) {
			e.printStackTrace();
			message = "教师任课查询错误2!";
		}

		request.getSession().setAttribute("message", message);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/displayAllTeacherCno.jsp");
		rd.forward(request, response);

	}
}
