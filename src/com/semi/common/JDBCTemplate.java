package com.semi.common;

import java.io.FileReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;





public class JDBCTemplate {
	public static Connection getConnection() {
		//jdbc를 이용하기위해 getconnection메소드를 선언
		Connection conn=null;
		Properties prop=new Properties();//프로퍼티스 파일로  처리하기위해 프로퍼티를 생성
		try {
			String fileName=JDBCTemplate.class.getResource("/driver/driver.properties").getPath();
			prop.load(new FileReader(fileName));
			Class.forName(prop.getProperty("driver"));
			conn=DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("id"),prop.getProperty("pw"));
			conn.setAutoCommit(false); //자동으로 커밋 방지
		}catch(Exception e) {
			e.printStackTrace();//에러나는 구문을 확인하기위해 사용
		}
		return conn;
	}
	public static void close(Connection conn) {
		try {
			if(conn!=null&&conn.isClosed()) {
				conn.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(Statement stmt) {
		try {
			if(stmt!=null&&stmt.isClosed()) {
				stmt.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rs) {
		try {
			if(rs!=null&&rs.isClosed()) {
				rs.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void commit(Connection conn) {
		try {
			if(conn!=null&&!conn.isClosed()) {
			conn.commit();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void rollback(Connection conn) {
		try {
			if(conn!=null&&!conn.isClosed()) {
			conn.rollback();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	

}
