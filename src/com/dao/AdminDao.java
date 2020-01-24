package com.dao;

import java.sql.*;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.Admin;
import com.demo.Student;
import com.demo.Teacher;

public class AdminDao extends BaseDao {
	private Admin admin;

	// 增加学生信息
	public boolean addStudent(Admin admin) {
		
		String SQL = "execute pro_yql_学生表插入信息  @yql_Sno14 = ?,@yql_Sname14 = ?,@yql_Ssex14 = ?,"
				+ "@yql_Sage14 = ?,@yql_Saddress14 = ?,@yql_Screditsum14 = ?,@yql_CSno14 = ?";
		
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {
			
			pstmt.setString(1, admin.getYql_Sno14());
			pstmt.setString(2, admin.getYql_Sname14());
			pstmt.setString(3, admin.getYql_Ssex14());
			pstmt.setInt(4, admin.getYql_Sage14());
			pstmt.setString(5, admin.getYql_Saddress14());
			pstmt.setInt(6, admin.getYql_Screditsum14());
			pstmt.setString(7, admin.getYql_CSno14());
			
			pstmt.executeUpdate();
			return true;
		}catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}

	// 删除学生信息
	public boolean deleteStudent(String yql_Sname14) {
		String sql = "DELETE FROM yeql_Students14 WHERE yql_Sname14 = ?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, yql_Sname14);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}

	}

	// 修改学生信息
	public boolean updateStudent(Admin admin) {
		String sql = "UPDATE yeql_Students14 SET yql_Sage14=?,yql_Saddress14=? WHERE yql_Sno14=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, admin.getYql_Sage14());
			pstmt.setString(2, admin.getYql_Saddress14());
			pstmt.setString(3, admin.getYql_Sno14());
			pstmt.executeUpdate();

			return true;

		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}

	}

	// 查看学生信息
	public ArrayList<Admin> displayStudent() {

		ArrayList<Admin> adminList = new ArrayList<Admin>();

		String sql = "SELECT * FROM  yeql_Students14";
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rst = pstmt.executeQuery()) {
			while (rst.next()) {
				Admin admin = new Admin();
				admin.setYql_Sno14(rst.getString("yql_Sno14"));
				admin.setYql_Sname14(rst.getString("yql_Sname14"));
				admin.setYql_Ssex14(rst.getString("yql_Ssex14"));
				admin.setYql_Sage14(rst.getInt("yql_Sage14"));
				admin.setYql_Saddress14(rst.getString("yql_Saddress14"));
				admin.setYql_Screditsum14(rst.getInt("yql_Screditsum14"));
				admin.setYql_CSno14(rst.getString("yql_CSno14"));
				adminList.add(admin);
			}
		} catch (SQLException se) {
			// System.out.println("数据库连接失败");
			se.printStackTrace();
			return null;
		}

		// System.out.println("yes");
		return adminList;

	}

	// 查看按学号学生信息
	public ArrayList<Student> findBySno(String sno) {
		ArrayList<Student> studentList = new ArrayList<Student>();
		boolean flag = false;
		String sql = "SELECT * FROM  yeql_Reports_View14 WHERE yql_Sno14=?";

		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			// System.out.println("数据库连接成功");
			pstmt.setString(1, sno);
			try (ResultSet rst = pstmt.executeQuery()) {
				while (rst.next()) {
					Student student = new Student();
					student.setYql_Sno14(rst.getString("yql_Sno14"));
					student.setYql_Sname14(rst.getString("yql_Sname14"));
					student.setYql_Cname14(rst.getString("yql_Cname14"));
					student.setYql_CSname14(rst.getString("yql_CSname14"));
					student.setYql_Tname14(rst.getString("yql_Tname14"));
					student.setYql_Credit14(rst.getInt("yql_Credit14"));
					student.setYql_Startterm14(rst.getString("yql_Startterm14"));
					student.setYql_Score14(rst.getFloat("yql_Score14"));
					studentList.add(student);
					flag = true;
				}
			}
		} catch (SQLException se) {
			// System.out.println("数据库连接失败");
			se.printStackTrace();
			return null;
		}
		if (!flag) {
			// System.out.println("null");
			return null;
		}

		// System.out.println("yes");
		return studentList;

	}

	// 插入教师信息
	public boolean addTeacher(Admin admin) {
		String sql = "INSERT INTO yeql_Teachers14"
				+ "(yql_Tno14,yql_Tname14,yql_Tsex14,yql_Tage14,yql_Trank14,yql_Tphone14)VALUES(?,?,?,?,?,?)";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, admin.getYql_Tno14());
			pstmt.setString(2, admin.getYql_Tname14());
			pstmt.setString(3, admin.getYql_Tsex14());
			pstmt.setInt(4, admin.getYql_Tage14());
			pstmt.setString(5, admin.getYql_Trank14());
			pstmt.setString(6, admin.getYql_Tphone14());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}

	// 修改教师信息
	public boolean updateTeacher(Admin admin) {
		String sql = "UPDATE yeql_Teachers14 SET yql_Tage14=?,yql_Tphone14=? WHERE yql_Tno14=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, admin.getYql_Tage14());
			pstmt.setString(2, admin.getYql_Tphone14());
			pstmt.setString(3, admin.getYql_Tno14());
			pstmt.executeUpdate();

			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}

	}

	// 删除教师信息
	public boolean deleteTeacher(String yql_Tno14, String yql_Tname14) {
		String sql = "DELETE FROM yeql_Teachers14 WHERE yql_Tno14=? AND yql_Tname14=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, yql_Tno14);
			pstmt.setString(2, yql_Tname14);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}

	}

	// 查看教师信息
	public ArrayList<Admin> displayTeacher() {

		ArrayList<Admin> adminList = new ArrayList<Admin>();

		String sql = "SELECT * FROM  yeql_Teachers14";
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rst = pstmt.executeQuery()) {
			while (rst.next()) {
				Admin admin = new Admin();
				admin.setYql_Tno14(rst.getString("yql_Tno14"));
				admin.setYql_Tname14(rst.getString("yql_Tname14"));
				admin.setYql_Tsex14(rst.getString("yql_Tsex14"));
				admin.setYql_Tage14(rst.getInt("yql_Tage14"));
				admin.setYql_Trank14(rst.getString("yql_Trank14"));
				admin.setYql_Tphone14(rst.getString("yql_Tphone14"));
				adminList.add(admin);
			}
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		}
		return adminList;
	}

	// 插入课程信息
	public boolean addClass(Admin admin) {
		String sql = "INSERT INTO yeql_Courses14"
				+ "(yql_Cno14,yql_Cname14,yql_Tname14,yql_Startterm14,yql_Classhour14,yql_Testway14,yql_Credit14)VALUES(?,?,?,?,?,?,?)";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, admin.getYql_Cno14());
			pstmt.setString(2, admin.getYql_Cname14());
			pstmt.setString(3, admin.getYql_Tname14());
			pstmt.setString(4, admin.getYql_Startterm14());
			pstmt.setInt(5, admin.getYql_Classhour14());
			pstmt.setString(6, admin.getYql_Testway14());
			pstmt.setInt(7, admin.getYql_Credit14());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}

	// 修改课程信息
	public boolean updateClass(Admin admin) {
		String sql = "UPDATE yeql_Courses14 SET yql_Tname14=?,yql_Classhour14=?,yql_Testway14=? WHERE yql_Cno14=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, admin.getYql_Tname14());
			pstmt.setInt(2, admin.getYql_Classhour14());
			pstmt.setString(3, admin.getYql_Testway14());
			pstmt.setString(4, admin.getYql_Cno14());
			pstmt.executeUpdate();

			return true;

		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}

	}

	// 删除课程信息
	public boolean deleteClass(String yql_Cno14, String yql_Cname14) {
		String sql = "DELETE FROM yeql_Courses14 WHERE yql_Cno14=? AND yql_Cname14 = ?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, yql_Cno14);
			pstmt.setString(2, yql_Cname14);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}

	}

	// 查看课程信息
	public ArrayList<Admin> displayClass() {

		ArrayList<Admin> adminList = new ArrayList<Admin>();

		String sql = "SELECT * FROM  yeql_Courses14";
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rst = pstmt.executeQuery()) {
			while (rst.next()) {
				Admin admin = new Admin();
				admin.setYql_Cno14(rst.getString("yql_Cno14"));
				admin.setYql_Cname14(rst.getString("yql_Cname14"));
				admin.setYql_Tname14(rst.getString("yql_Tname14"));
				admin.setYql_Startterm14(rst.getString("yql_Startterm14"));
				admin.setYql_Classhour14(rst.getInt("yql_Classhour14"));
				admin.setYql_Testway14(rst.getString("yql_Testway14"));
				admin.setYql_Credit14(rst.getInt("yql_Credit14"));
				adminList.add(admin);
			}
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		}
		return adminList;
	}

}
