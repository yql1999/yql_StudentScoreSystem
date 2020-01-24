package com.servlet;
import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.StudentDao;
import com.demo.Student;
import javax.servlet.annotation.WebServlet;
@WebServlet("/findByCSname.do")
public class findByCSname extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		StudentDao dao=new StudentDao();
		Student student=new Student();
		String message=null;           
		String CSname=request.getParameter("yql_CSname14");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		try{
			ArrayList<Student> success=dao.findByCSname(CSname);//调用函数
			
			if(success!= null){
				message="查询成功!";		
				request.getSession().setAttribute("student",success);  
		
			}else{
				message="查询错误!";
			}
			
		}
		catch(Exception e){
				message="查询错误!";
		}
		
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/displayFindByCSname.jsp");      
		rd.forward(request,response);
				
	}
}

