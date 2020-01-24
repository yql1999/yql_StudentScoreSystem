package com.servlet;
import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.TeacherDao;
import com.demo.Teacher;

import javax.servlet.annotation.WebServlet;
@WebServlet("/findOrderCreditSum.do")
public class FindOrderCreditSumServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		TeacherDao dao=new TeacherDao();
		Teacher teacher=new Teacher();
		String message=null; 
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		try{
			ArrayList<Teacher> success=dao.findOrderCreditSumTeacher();
			if(!success.isEmpty()){
				message="��ѯ�ɹ�!";
				request.getSession().setAttribute("teacher",success); 
		}else{
				message="��ѯ����!";
			}
		}
		catch(Exception e){
				message="��ѯ����!";
		}
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/displayOrderCreditSum.jsp");      
		rd.forward(request,response);
	}
}

