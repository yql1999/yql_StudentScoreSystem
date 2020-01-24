package com.servlet;
import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.TeacherDao;
import com.demo.Teacher;

import javax.servlet.annotation.WebServlet;
@WebServlet("/findCredit.do")
public class FindCreditServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		TeacherDao dao=new TeacherDao();
		Teacher teacher=new Teacher();
		String message=null; 
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		try{
			ArrayList<Teacher> success=dao.findCreditTeacher();
			if(!success.isEmpty()){
				message="查询成功!";
				request.getSession().setAttribute("teacher",success); 
		}else{
				message="查询错误!";
			}
		}
		catch(Exception e){
				message="查询错误!";
		}
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/displayCredit.jsp");      
		rd.forward(request,response);
	}
}

