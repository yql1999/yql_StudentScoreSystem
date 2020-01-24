package com.servlet;
import java.io.*;

import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.TeacherDao;
import com.demo.Teacher;

import javax.servlet.annotation.WebServlet;

@WebServlet("/findAvg.do")

//ÿ�ſε�ƽ���ɼ�
public class FindAvgServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		
		TeacherDao dao=new TeacherDao();
		String message=null; 
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		try{
			ArrayList<Teacher> teacher = dao.findAvgTeacher();
			if(teacher!=null){
				message="ÿ�ſε�ƽ���ɼ���ѯ�ɹ�!";
				request.getSession().setAttribute("teacher",teacher); 
				//response.sendRedirect("/displayAvg.jsp");
		}else{
				message="ÿ�ſε�ƽ���ɼ���ѯ����1!";
			}
		}
		catch(Exception e){
				message="ÿ�ſε�ƽ���ɼ���ѯ����2!";
		}
		
		request.getSession().setAttribute("message",message);
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/displayAvg.jsp");      
		rd.forward(request,response);
	}
}

