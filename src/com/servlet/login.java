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
		String userid = request.getParameter("userid"); // ��ȡ�˺�
		String password = request.getParameter("password"); // ��ȡ����
		String user = request.getParameter("user"); // �ж��û����
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		if (user == null || password == null) { // δ��������
			out.print("<script>alert('��¼ʧ�ܣ��û��������벻��Ϊ�գ�');" + "window.location.href='login.jsp'</script>");
		} else {
			// ѧ����¼ʱ
			if (user.equals("student")) {
				// System.out.println("student");
				try {
					// �����Ƿ��и�ѧ�ŵ�ѧ��
					ArrayList<Student> student = new StudentDao().findBySno(userid);
					if (student != null && password.equals("123456")) {
						HttpSession session = request.getSession();
						session.setAttribute("student", student);
						out.print("<script>alert('ѧ����¼�ɹ�!');");
						RequestDispatcher rd = getServletContext().getRequestDispatcher("/findBySno.jsp");
						rd.forward(request, response);
					} else {
						out.print("<script>alert('ѧ����¼ʧ�ܣ���ȷ���˺ź����룡');" + "window.location.href='login.jsp'</script>");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			//����Ա��¼ʱ
			else if(user.equals("admin")){
				// System.out.println("admin");
				try {
					// ����
					if (userid.equals("admin") && password.equals("admin")) {
						out.print("<script>alert('����Ա��¼�ɹ�!');");
						RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin.jsp");
						rd.forward(request, response);
					} else {
						out.print("<script>alert('����Ա��¼ʧ�ܣ���ȷ���˺ź����룡');" + "window.location.href='login.jsp'</script>");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			// ��ʦ��¼ʱ
			else {
				// System.out.println("teacher");
				try {
					Teacher teacher = new TeacherDao().findByTno(userid);
					// �����Ƿ��иý�ʦ�ŵĽ�ʦ
					if (teacher != null && password.equals("123456")) {
						HttpSession session = request.getSession();
						session.setAttribute("teacher", teacher);
						out.print("<script>alert('��ʦ��¼�ɹ�!');");
						RequestDispatcher rd = getServletContext().getRequestDispatcher("/findAvg.jsp");
						rd.forward(request, response);
					} else {
						out.print("<script>alert('��ʦ��¼ʧ��!��ȷ���˺ź����룡');" + "window.location.href='login.jsp'</script>");
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
