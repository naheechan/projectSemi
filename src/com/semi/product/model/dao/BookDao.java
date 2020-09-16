package com.semi.product.model.dao;

import java.awt.print.Book;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static com.semi.common.JDBCTemplate.close;


import com.semi.product.model.vo.Books;

public class BookDao {
	public BookDao() {
		//기본생성자로 프로퍼티스 설정하기
		try {
			String path=BookDao.class.getResource("/sql/product/product_sql.properties").getPath();
			prop.load(new FileReader(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private Properties prop=new Properties();
	public List<Books> selectBook(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Books> list=new ArrayList<Books>();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectbook"));
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Books bk=new Books();
				bk.setBookNo(rs.getInt("book_no"));
				bk.setTitle(rs.getString("book_title"));
				bk.setAuthor(rs.getString("book_author"));
				bk.setPrice(rs.getInt("book_price"));
				bk.setBookimg(rs.getString("book_img"));
				bk.setPublisher(rs.getString("book_publisher"));
				bk.setPublicationdate(rs.getDate("book_publicationdate"));
				list.add(bk);		
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	public Books addcartselect(Connection conn, int no) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Books bk=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("addcartselect"));
			pstmt.setInt(1,no);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				bk=new Books();
				bk.setBookNo(rs.getInt("book_no"));
				bk.setTitle(rs.getString("book_title"));
				bk.setAuthor(rs.getString("book_author"));
				bk.setPrice(rs.getInt("book_price"));
				bk.setBookimg(rs.getString("book_img"));
				bk.setPublisher(rs.getString("book_publisher"));
				bk.setPublicationdate(rs.getDate("book_publicationdate"));
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return bk;
	}

}
