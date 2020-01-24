package com.dao;

import java.sql.*;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.Student;
import com.demo.Teacher;

public class TeacherDao extends BaseDao {
	private Teacher teacher;

	// 登录时按老师编号查找
	public Teacher findByTno(String sno) {
		Teacher teacher = new Teacher();
		boolean flag = false;

		String sql = "SELECT * FROM  yeql_Reports_View14 WHERE yql_Tno14=?";

		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, sno);
			try (ResultSet rst = pstmt.executeQuery()) {
				if (rst.next()) {
					teacher.setYql_Tno14(rst.getString("yql_Tno14"));
					teacher.setYql_Tname14(rst.getString("yql_Tname14"));
					teacher.setYql_Cname14(rst.getString("yql_Cname14"));
					teacher.setYql_Sno14(rst.getString("yql_Sno14"));
					teacher.setYql_Sname14(rst.getString("yql_Sname14"));
					teacher.setYql_CSname14(rst.getString("yql_CSname14"));
					teacher.setYql_Credit14(rst.getInt("yql_Credit14"));
					teacher.setYql_Startterm14(rst.getString("yql_Startterm14"));
					teacher.setYql_Score14(rst.getFloat("yql_Score14"));
					flag = true;
				} else
					return null;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		if (!flag)
			return null;

		return teacher;
	}

	// 按学生编号查找老师
	public Teacher findBySno(String sno) {
		Student student = new Student();
		try (Connection conn = dataSource.getConnection()) {
			String sql = "SELECT * FROM  yeql_Reports_View14 WHERE yql_Sno14=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sno);
			try (ResultSet rst = pstmt.executeQuery()) {
				if (rst.next()) {
					student.setYql_Sno14(rst.getString("yql_Sno14"));
					student.setYql_Sname14(rst.getString("yql_Sname14"));
					student.setYql_Cname14(rst.getString("yql_Cname14"));
					student.setYql_CSname14(rst.getString("yql_CSname14"));
					student.setYql_Tname14(rst.getString("yql_Tname14"));
					student.setYql_Credit14(rst.getInt("yql_Credit14"));
					student.setYql_Startterm14(rst.getString("yql_Startterm14"));
					student.setYql_Score14(rst.getFloat("yql_Score14"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return teacher;
	}

	// 查询每门课程平均成绩
	public ArrayList<Teacher> findAvgTeacher() {
		
		ArrayList<Teacher> custList = null;
		custList = new ArrayList<Teacher>();
		String sql = "SELECT * FROM yeql_LessonAVG_View14";

		boolean flag=false;
		
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rst = pstmt.executeQuery()) {
			while (rst.next()) {
				Teacher teacher = new Teacher();
				teacher.setYql_Cno14(rst.getString("yql_Cno14"));
				teacher.setYql_Cname14(rst.getString("yql_Cname14"));
				teacher.setYql_LessonAVG14(rst.getFloat("yql_LessonAVG14"));
				flag=true;
				custList.add(teacher);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		if(!flag) {
			System.out.println("null");
			return null;
		}
		return custList;
	}

	// 所学课程及学分统计
	public ArrayList<Teacher> findCreditTeacher() {
		ArrayList<Teacher> custList = null;
		custList = new ArrayList<Teacher>();
		String sql = "SELECT * FROM yeql_CnameCredit_View14";
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rst = pstmt.executeQuery()) {
			while (rst.next()) {
				Teacher teacher = new Teacher();
				teacher.setYql_Sno14(rst.getString("yql_Sno14"));
				teacher.setYql_Cname14(rst.getString("yql_Cname14"));
				teacher.setYql_Credit14(rst.getInt("yql_Credit14"));
				custList.add(teacher);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return custList;
	}

	// 学生名次排定（按学期）
	public ArrayList<Teacher> findOrderYearTeacher(String sno) {
		ArrayList<Teacher> custList = null;
		custList = new ArrayList<Teacher>();
		boolean flag=false;
		String sql = "SELECT * FROM yeql_StarttermCredit_View14 where yql_Startterm14=? order by yql_Score14 DESC";
		
		
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			// System.out.println("数据库连接成功");
			pstmt.setString(1, sno);
			try (ResultSet rst = pstmt.executeQuery()) {
			while (rst.next()) {
				Teacher teacher = new Teacher();
				teacher.setYql_Score14(rst.getFloat("yql_Score14"));
				teacher.setYql_Sno14(rst.getString("yql_Sno14"));
				teacher.setYql_Sname14(rst.getString("yql_Sname14"));
				teacher.setYql_CSname14(rst.getString("yql_CSname14"));
				teacher.setYql_Cname14(rst.getString("yql_Cname14"));
				teacher.setYql_Startterm14(rst.getString("yql_Startterm14"));
				flag=true;
				custList.add(teacher);
			}
		}
	} catch (SQLException se) {
		// System.out.println("数据库连接失败");
		se.printStackTrace();
		return null;
	}
	if (!flag) {
		//System.out.println("null");
		return null;
	}

	//System.out.println("yes");
	return custList;

}

	// 学生成绩按学年统计（按总学分）
	public ArrayList<Teacher> findOrderCreditSumTeacher() {
		ArrayList<Teacher> custList = null;
		custList = new ArrayList<Teacher>();
		String sql = "select yql_SCreditsum14,yql_Sname14,yql_Ssex14,yql_CSno14 from yeql_Students14 order by yql_SCreditsum14 DESC ";
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rst = pstmt.executeQuery()) {
			while (rst.next()) {
				Teacher teacher = new Teacher();
				teacher.setYql_Credit14(rst.getInt("yql_SCreditsum14"));
				teacher.setYql_Sname14(rst.getString("yql_Sname14"));
				teacher.setYql_Tsex14(rst.getString("yql_Ssex14"));
				teacher.setYql_CSno14(rst.getString("yql_CSno14"));
				custList.add(teacher);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return custList;
	}

	// 插入一条学生成绩
	public boolean addStudentReport(Teacher teacher) {
		String sql = "INSERT INTO yeql_Reports14"
				+ "(yql_Sno14,yql_Cno14,yql_Startterm14,yql_Score14,yql_Tname14)VALUES(?,?,?,?,?)";
		String SQL="declare @yql_Sno14 String = ? declare @yql_Cno14 String = ? declare @yql_Startterm14 String = ? "
				+ "declare @yql_Score14 int = ? declare @yql_Tname14 String = ? "
				+ " exec dbo.pro_yql_输入成绩  @yql_Sno14,@yql_Cno14,@yql_Startterm14,"
				+ "@yql_Score14,@yql_Tname14";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, teacher.getYql_Sno14());
			pstmt.setString(2, teacher.getYql_Cno14());
			pstmt.setString(3, teacher.getYql_Startterm14());
			pstmt.setFloat(4, teacher.getYql_Score14());
			pstmt.setString(5, teacher.getYql_Tname14());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}

	// 查询表
	public ArrayList<Teacher> addStudentTeacher() {
		ArrayList<Teacher> custList = null;
		custList = new ArrayList<Teacher>();
		String sql = "SELECT * FROM yeql_Reports14";
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rst = pstmt.executeQuery()) {
			while (rst.next()) {
				Teacher teacher = new Teacher();
				teacher.setYql_Sno14(rst.getString("yql_Sno14"));
				teacher.setYql_Cno14(rst.getString("yql_Cno14"));
				teacher.setYql_Startterm14(rst.getString("yql_Startterm14"));
				teacher.setYql_Score14(rst.getFloat("yql_Score14"));
				teacher.setYql_Tname14(rst.getString("yql_Tname14"));
				custList.add(teacher);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return custList;
	}

}