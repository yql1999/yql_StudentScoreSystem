package com.servlet;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.StudentDao;
import com.demo.Student;

import javax.servlet.annotation.WebServlet;

@WebServlet("/findBySnoServlet.do")

//按学号查找学生成绩
public class FindBySnoServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StudentDao dao = new StudentDao();
		ArrayList<Student> studentList = new ArrayList<Student>();
		String message = null;
		response.setContentType("text/html;charset=UTF-8");
		String productid = request.getParameter("yql_Sno14");
		PrintWriter out = response.getWriter();

		try {

			studentList = dao.findBySno(productid);	// 调用函数

			if (studentList != null) {
				message = "学生成绩查询成功!";
				request.getSession().setAttribute("student", studentList);

			} else {
				message = "学生成绩查询错误1!";
			}

		} catch (Exception e) {
			e.printStackTrace();
			message = "学生成绩查询错误2!";
		}

		request.getSession().setAttribute("message", message);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/displayFindBySno.jsp");
		rd.forward(request, response);

	}
}
