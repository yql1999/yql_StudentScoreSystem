package com.servlet;
import java.io.*;

import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.AdminDao;
import com.demo.Admin;
import javax.servlet.annotation.WebServlet;

@WebServlet("/adminDisplayAddTeacher.do")

//�鿴ѧ���γ̳ɼ��������
public class AdminDisplayAddTeacher extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		
		AdminDao dao=new AdminDao();
		Admin admin=new Admin();
		String message=null; 
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		try{
			ArrayList<Admin> success=dao.displayTeacher();
			if(success!=null){
				message="��ʦ��Ϣ�����ѯ�ɹ�!";
				request.getSession().setAttribute("admin",success); 
		}else{
				message="��ʦ��Ϣ�����ѯ����1!";
			}
		}
		catch(Exception e){
				message="��ʦ��Ϣ�����ѯ����2!";
		}
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/adminDisplayAddTeacher.jsp");      
		rd.forward(request,response);
	}
}


