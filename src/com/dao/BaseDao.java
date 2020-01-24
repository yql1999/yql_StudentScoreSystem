package com.dao;
import java.sql.*;
import javax.sql.DataSource;
import javax.naming.*;
public class BaseDao {
	DataSource dataSource;
	public BaseDao(){
		try{
			Context context=new InitialContext();
			dataSource=(DataSource)context.lookup("java:comp/env/jdbc/sampleDS");
		} 
		catch(NamingException ne){
			System.out.println("Exception:"+ne);
		}
	}
	// 返回一个连接对象
	public Connection getConnection()throws Exception{
		return dataSource.getConnection();
	}
}
