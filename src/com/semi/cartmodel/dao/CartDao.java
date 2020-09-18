package com.semi.cartmodel.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import static com.semi.common.JDBCTemplate.close;

public class CartDao {
	private Properties prop=new Properties();
	public CartDao() {
		try {
			String fileName=CartDao.class.getResource("/sql/cart/cart_sql.properties").getPath();
			prop.load(new FileReader(fileName));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	public int insertnumber(Connection conn, int no, int userno) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("insertcart"));
			pstmt.setInt(1, no);
			pstmt.setInt(2, userno);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;	
	}

}
