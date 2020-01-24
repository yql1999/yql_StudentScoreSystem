package com.servlet;
import java.io.*;

import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.TeacherDao;
import com.demo.Teacher;
import javax.servlet.annotation.WebServlet;

@WebServlet("/addStudentTeacher.do")

//�鿴ѧ���γ̳ɼ��������
public class AddStudentTeacher extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		
		TeacherDao dao=new TeacherDao();
		Teacher teacher=new Teacher();
		String message=null; 
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		try{
			ArrayList<Teacher> success=dao.addStudentTeacher();
			if(!success.isEmpty()){
				message="ѧ���γ̳ɼ������ѯ�ɹ�!";
				request.getSession().setAttribute("teacher",success); 
		}else{
				message="ѧ���γ̳ɼ������ѯ����1!";
			}
		}
		catch(Exception e){
				message="ѧ���γ̳ɼ������ѯ����2!";
		}
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/displayAddStudent.jsp");      
		rd.forward(request,response);
	}
}


