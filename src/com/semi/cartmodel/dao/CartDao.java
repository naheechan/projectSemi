package com.semi.cartmodel.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.semi.cartmodel.vo.Cart;
import com.semi.product.model.vo.Books;

import static com.semi.common.JDBCTemplate.close;

public class CartDao {
	private Properties prop = new Properties();

	public CartDao() {
		try {
			String fileName = CartDao.class.getResource("/sql/cart/cart_sql.properties").getPath();
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public int insertnumber(Connection conn, int no, int userno) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("insertcart"));
			pstmt.setInt(1, no);
			pstmt.setInt(2, userno);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public List<Cart> selectcartno(Connection conn, int userno) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Cart> list = new ArrayList<Cart>();
		Cart ca = null;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectcartno"));
			pstmt.setInt(1, userno);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ca = new Cart();
				ca.setBookno(rs.getInt("book_no"));
				ca.setCartno(rs.getInt("cart_no"));
				ca.setMemberno(rs.getInt("member_no"));
				list.add(ca);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	public List<Books> selectbook(Connection conn, int userno) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Books>list=new ArrayList<Books>();
		Books bk=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectbooklist"));
			pstmt.setInt(1, userno);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				bk=new Books();
				bk.setBookNo(rs.getInt("book_no"));
				bk.setTitle(rs.getString("book_title"));
				bk.setAuthor(rs.getString("book_author"));
				bk.setPrice(rs.getInt("book_price"));
				bk.setBookimg(rs.getString("book_img"));
				bk.setPublisher(rs.getString("book_publisher"));
				bk.setPublicationdate(rs.getDate("book_Publicationdate"));
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

}
