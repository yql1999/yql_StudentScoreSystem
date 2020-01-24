package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.TeacherDao;
import com.demo.Teacher;

import javax.servlet.annotation.WebServlet;

@WebServlet("/addStudentReport.do")

//����ѧ���ɼ�
public class AddStudentReportServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		TeacherDao dao = new TeacherDao();
		Teacher teacher = new Teacher();
		String message = null;
		
		try {
			teacher.setYql_Sno14(new String(request.getParameter("yql_Sno14").getBytes("iso-8859-1"), "UTF-8"));
			teacher.setYql_Cno14(new String(request.getParameter("yql_Cno14").getBytes("iso-8859-1"), "UTF-8"));
			teacher.setYql_Startterm14(
					new String(request.getParameter("yql_Startterm14").getBytes("iso-8859-1"), "UTF-8"));
			teacher.setYql_Score14((float) Double.parseDouble(request.getParameter("yql_Score14")));
			teacher.setYql_Tname14(new String(request.getParameter("yql_Tname14").getBytes("iso-8859-1"), "UTF-8"));
			
			boolean success = dao.addStudentReport(teacher);
			
			//System.out.println(success);
			
			if (success) {
				message = "�ɹ�����һ���ɼ���¼!";
			} else {
				message = "SQLException�쳣����!";
			}
		} catch (Exception e) {
			message = "�����¼����!";
		}

		request.setAttribute("message", message);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/addStudentReport.jsp");
		rd.forward(request, response);

	}
}
