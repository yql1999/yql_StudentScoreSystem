package com.servlet;
import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.TeacherDao;
import com.demo.Teacher;

import javax.servlet.annotation.WebServlet;
@WebServlet("/findOrderYear.do")
public class FindOrderYearServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		TeacherDao dao=new TeacherDao();
		Teacher teacher=new Teacher();
		String message=null; 
		response.setContentType("text/html;charset=UTF-8");
		String sno=request.getParameter("yql_Startterm14");
		PrintWriter out=response.getWriter();
		try{
			ArrayList<Teacher> success=dao.findOrderYearTeacher(sno);
			if(success!=null){
				message="��ѯ�ɹ�!";
				request.getSession().setAttribute("teacher",success); 
		}else{
				message="��ѯ����!";
			}
		}
		catch(Exception e){
				message="��ѯ����!";
		}
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/displayOrderYear.jsp");      
		rd.forward(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}
}




