package com.dao;

import java.sql.*;
import java.util.ArrayList;
import com.demo.Student;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.Student;

public class StudentDao extends BaseDao {

	// ��ѧ�ż���ѧ���ɼ���Ϣ
	public ArrayList<Student> findBySno(String sno) {
		ArrayList<Student> studentList = new ArrayList<Student>();
		boolean flag = false;
		String sql = "SELECT * FROM  yeql_Reports_View14 WHERE yql_Sno14=?";
		
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			// System.out.println("���ݿ����ӳɹ�");
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
			se.printStackTrace();
			return null;
		}
		if (!flag) {
			return null;
		}

		return studentList;

	}
	
	//������Դ�ز���ѧ���ɼ�
		public ArrayList<Student> findBySaddress(String sno) {
			ArrayList<Student> custList = null;
			custList = new ArrayList<Student>();

				try (Connection conn = dataSource.getConnection()) {
					String sql = "SELECT * FROM  yeql_ResouceGrade_View14 WHERE yql_Saddress14=?";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, sno);
					try (ResultSet rst = pstmt.executeQuery()) {
						while (rst.next()) {
						Student student = new Student();
						student.setYql_Saddress14(rst.getString("yql_Saddress14"));
						student.setYql_ResouceGradeAVG14(rst.getFloat("yql_ResouceGradeAVG14"));

						custList.add(student);
						}
					} catch (SQLException e) {
						e.printStackTrace();
						return null;
					}
				} catch (SQLException se) {
					return null;
				}
				return custList;
			}
		

	// ���༶���Ƽ���ѧ���ɼ���Ϣ
	public ArrayList<Student> findByCSname(String CSname) {
		ArrayList<Student> custList = null;
		custList = new ArrayList<Student>();
		try (Connection conn = dataSource.getConnection()) {
			String sql = "SELECT * FROM  yeql_Reports_View14 WHERE yql_CSname14=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, CSname);
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
					custList.add(student);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		} catch (SQLException se) {
			return null;
		}
		return custList;
	}

	// ��ѯ���а༶�γ̿�����Ϣ
	public ArrayList<Student> findAllStudent() {
		ArrayList<Student> custList = null;
		custList = new ArrayList<Student>();
		String sql = "SELECT * FROM yeql_ClassLesson_View14";
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rst = pstmt.executeQuery()) {
			while (rst.next()) {
				Student student = new Student();
				student.setYql_CSno14(rst.getString("yql_CSno14"));
				student.setYql_CSname14(rst.getString("yql_CSname14"));
				student.setYql_Cno14(rst.getString("yql_Cno14"));
				student.setYql_Cname14(rst.getString("yql_Cname14"));
				student.setYql_Classhour14(rst.getInt("yql_Classhour14"));
				student.setYql_Credit14(rst.getInt("yql_Credit14"));
				custList.add(student);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return custList;
	}

	// ��ѯ���н�ʦ�ڿ���Ϣ
	public ArrayList<Student> findTeachCno() {
		
		ArrayList<Student> stuList = null;
		stuList = new ArrayList<Student>();
		String sql = "SELECT * FROM yeql_TecaherTeach_View14";
		boolean flag=false;
		
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rst = pstmt.executeQuery()) {
			while (rst.next()) {
				Student student = new Student();
				student.setYql_Tno14(rst.getString("yql_Tno14"));
				student.setYql_Cno14(rst.getString("yql_Cno14"));
				student.setYql_Cname14(rst.getString("yql_Cname14"));
				student.setYql_Tname14(rst.getString("yql_Tname14"));
				student.setYql_Credit14(rst.getInt("yql_Credit14"));
				student.setYql_Classhour14(rst.getInt("yql_Classhour14"));
				
				flag=true;
				stuList.add(student);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		if (!flag) {
			System.out.println("null");
			return null;
		}
		System.out.println("yes");
		return stuList;
	}

}
