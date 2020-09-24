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
import com.semi.product.model.vo.BooksJoin;



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

	public int insertnumber(Connection conn, int no, int userno, int count) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("insertcart"));
			pstmt.setInt(1, no);
			pstmt.setInt(2, userno);
			pstmt.setInt(3, count);
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
				ca.setCount(rs.getInt("count"));
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

	public List<BooksJoin> selectbook(Connection conn, int userno) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BooksJoin> list = new ArrayList<BooksJoin>();
		BooksJoin bk = null;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectbooklist"));
			pstmt.setInt(1, userno);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				bk = new BooksJoin();
				bk.setBookNo(rs.getInt("book_no"));
				bk.setTitle(rs.getString("book_title"));
				bk.setAuthor(rs.getString("book_author"));
				bk.setPrice(rs.getInt("book_price"));
				bk.setBookimg(rs.getString("book_img"));
				bk.setPublisher(rs.getString("book_publisher"));
				bk.setPublicationdate(rs.getDate("book_Publicationdate"));
				bk.setCategoryno(rs.getInt("category_no"));
				bk.setCartno(rs.getInt("cart_no"));
				bk.setBookno(rs.getInt("book_no"));
				bk.setMemberno(rs.getInt("member_no"));
				bk.setCount(rs.getInt("count"));
				
				list.add(bk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	public int cartdelet(Connection conn, int[] check) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			for (int i = 0; i < check.length; i++) {
				pstmt = conn.prepareStatement(prop.getProperty("deletecart"));
				pstmt.setInt(1, check[i]);
				result = pstmt.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

}
