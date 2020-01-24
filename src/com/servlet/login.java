package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.dao.StudentDao;
import com.dao.TeacherDao;
//import DAO.UserDAO;
import com.demo.Student;
import com.demo.Teacher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import beans.Admin;
//import beans.Student;

@WebServlet("/login.do")
public class login extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String userid = request.getParameter("userid"); // 获取账号
		String password = request.getParameter("password"); // 获取密码
		String user = request.getParameter("user"); // 判断用户身份
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		if (user == null || password == null) { // 未输入密码
			out.print("<script>alert('登录失败，用户名和密码不能为空！');" + "window.location.href='login.jsp'</script>");
		} else {
			// 学生登录时
			if (user.equals("student")) {
				// System.out.println("student");
				try {
					// 检索是否有该学号的学生
					ArrayList<Student> student = new StudentDao().findBySno(userid);
					if (student != null && password.equals("123456")) {
						HttpSession session = request.getSession();
						session.setAttribute("student", student);
						out.print("<script>alert('学生登录成功!');");
						RequestDispatcher rd = getServletContext().getRequestDispatcher("/findBySno.jsp");
						rd.forward(request, response);
					} else {
						out.print("<script>alert('学生登录失败！请确认账号和密码！');" + "window.location.href='login.jsp'</script>");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			//管理员登录时
			else if(user.equals("admin")){
				// System.out.println("admin");
				try {
					// 检索
					if (userid.equals("admin") && password.equals("admin")) {
						out.print("<script>alert('管理员登录成功!');");
						RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin.jsp");
						rd.forward(request, response);
					} else {
						out.print("<script>alert('管理员登录失败！请确认账号和密码！');" + "window.location.href='login.jsp'</script>");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			// 教师登录时
			else {
				// System.out.println("teacher");
				try {
					Teacher teacher = new TeacherDao().findByTno(userid);
					// 检索是否有该教师号的教师
					if (teacher != null && password.equals("123456")) {
						HttpSession session = request.getSession();
						session.setAttribute("teacher", teacher);
						out.print("<script>alert('教师登录成功!');");
						RequestDispatcher rd = getServletContext().getRequestDispatcher("/findAvg.jsp");
						rd.forward(request, response);
					} else {
						out.print("<script>alert('教师登录失败!请确认账号和密码！');" + "window.location.href='login.jsp'</script>");
					}
				} catch (Exception e) {

					e.printStackTrace();
				}
			}
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

}
