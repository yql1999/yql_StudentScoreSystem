package com.demo;
import java.io.Serializable;
public class Teacher implements Serializable{	
	
	private String yql_Sno14;
	private String yql_Sname14;
	private String yql_Cname14;
	private String yql_CSname14;
	
	private String yql_Tname14;
	private String yql_Tno14;
	private String yql_Tage14;
	private String yql_Tsex14;
	private String yql_Tphone14;
	private String yql_Trank14;
	
	private int Yql_Credit14;
	private String yql_Startterm14;
	private float yql_Score14;
	
	private String yql_CSno14;
	private String yql_Cno14;
	private int yql_Classhour14;
	
	private float yql_LessonAVG14;		
	
	private String password;
	
	
	public Teacher(){}
	public Teacher(String yql_Sno14,String yql_Sname14,String yql_Cname14,String yql_CSname14,
			String yql_Tname14,int Yql_Credit14,String yql_Startterm14,float yql_Score14,String password,
			String yql_CSno14,String yql_Cno14,int yql_Classhour14,float lessonAVG,String yql_Ssex14)
	{
		this.yql_Sno14=yql_Sno14;
		this.yql_Sname14=yql_Sname14;
		this.yql_Cname14=yql_Cname14;
		this.yql_CSname14=yql_CSname14;
		this.yql_Tname14=yql_Tname14;
		this.Yql_Credit14=Yql_Credit14;
		this.yql_Startterm14=yql_Startterm14;
		this.yql_Score14=yql_Score14;
		this.yql_CSno14=yql_CSno14;
		this.yql_Cno14=yql_Cno14;
		this.yql_Classhour14=yql_Classhour14;
		this.yql_LessonAVG14=lessonAVG;
		this.yql_Tsex14=yql_Ssex14;
		this.password=password;
	}
	
	
	public String getYql_Sno14() {
		return yql_Sno14;
	}
	public void setYql_Sno14(String yql_Sno14) {
		this.yql_Sno14 = yql_Sno14;
	}
	public String getYql_Sname14() {
		return yql_Sname14;
	}
	public void setYql_Sname14(String yql_Sname14) {
		this.yql_Sname14 = yql_Sname14;
	}
	public String getYql_Cname14() {
		return yql_Cname14;
	}
	public void setYql_Cname14(String yql_Cname14) {
		this.yql_Cname14 = yql_Cname14;
	}
	public String getYql_CSname14() {
		return yql_CSname14;
	}
	public void setYql_CSname14(String yql_CSname14) {
		this.yql_CSname14 = yql_CSname14;
	}
	public String getYql_Tname14() {
		return yql_Tname14;
	}
	public void setYql_Tname14(String yql_Tname14) {
		this.yql_Tname14 = yql_Tname14;
	}
	public String getYql_Tno14() {
		return yql_Tno14;
	}
	public void setYql_Tno14(String yql_Tno14) {
		this.yql_Tno14 = yql_Tno14;
	}
	public String getYql_Tage14() {
		return yql_Tage14;
	}
	public void setYql_Tage14(String yql_Tage14) {
		this.yql_Tage14 = yql_Tage14;
	}
	public String getYql_Tsex14() {
		return yql_Tsex14;
	}
	public void setYql_Tsex14(String yql_Tsex14) {
		this.yql_Tsex14 = yql_Tsex14;
	}
	public String getYql_Tphone14() {
		return yql_Tphone14;
	}
	public void setYql_Tphone14(String yql_Tphone14) {
		this.yql_Tphone14 = yql_Tphone14;
	}
	public String getYql_Trank14() {
		return yql_Trank14;
	}
	public void setYql_Trank14(String yql_Trank14) {
		this.yql_Trank14 = yql_Trank14;
	}
	public int getYql_Credit14() {
		return Yql_Credit14;
	}
	public void setYql_Credit14(int yql_Credit14) {
		Yql_Credit14 = yql_Credit14;
	}
	public String getYql_Startterm14() {
		return yql_Startterm14;
	}
	public void setYql_Startterm14(String yql_Startterm14) {
		this.yql_Startterm14 = yql_Startterm14;
	}
	public float getYql_Score14() {
		return yql_Score14;
	}
	public void setYql_Score14(float yql_Score14) {
		this.yql_Score14 = yql_Score14;
	}
	public String getYql_CSno14() {
		return yql_CSno14;
	}
	public void setYql_CSno14(String yql_CSno14) {
		this.yql_CSno14 = yql_CSno14;
	}
	public String getYql_Cno14() {
		return yql_Cno14;
	}
	public void setYql_Cno14(String yql_Cno14) {
		this.yql_Cno14 = yql_Cno14;
	}
	public int getYql_Classhour14() {
		return yql_Classhour14;
	}
	public void setYql_Classhour14(int yql_classhour14) {
		this.yql_Classhour14 = yql_classhour14;
	}
	public float getYql_LessonAVG14() {
		return yql_LessonAVG14;
	}
	public void setYql_LessonAVG14(float lessonAVG) {
		this.yql_LessonAVG14 = lessonAVG;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
