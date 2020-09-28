package com.semi.order.model.dao;

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
import com.semi.buy.model.vo.Buylist;
import com.semi.cartmodel.vo.Cart;
import com.semi.product.model.dao.BookDao;
import com.semi.product.model.vo.BooksJoin;


public class OrderDao {
	private Properties prop=new Properties();
	public OrderDao() {
		// TODO Auto-generated constructor stub
		try {
			String path=BookDao.class.getResource("/sql/product/product_sql.properties").getPath();
			prop.load(new FileReader(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public List<Cart> selectproduct(Connection conn, int userno) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Cart>list=new ArrayList<Cart>();
		Cart ck=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectproduct"));
			pstmt.setInt(1, userno);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				ck=new Cart();
				ck.setCartno(rs.getInt("cart_no"));
				ck.setBookno(rs.getInt("book_no"));
				ck.setMemberno(rs.getInt("member_no"));
				list.add(ck);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	public int insertorder(Connection conn, List<Buylist> blist) {
		PreparedStatement pstmt=null;
		int result=0;
		try{
			pstmt=conn.prepareStatement(prop.getProperty("insertorder"));
			for(Buylist bk:blist) {
				pstmt.setInt(1,bk.getTotalprice());
				pstmt.setString(2,bk.getAddress());
				pstmt.setInt(3,bk.getPostcode());
				pstmt.setString(4,bk.getExtraaddress());
				pstmt.setString(5, bk.getDetailaddress());
				pstmt.setString(6, bk.getRequest());
				pstmt.setString(7, bk.getRecipient());
				pstmt.setInt(8, bk.getMemberno());
				pstmt.setInt(9, bk.getBookno());
				pstmt.setInt(10, bk.getCount());
				result=pstmt.executeUpdate();
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			
		}
		
		return result;
	}
	public int insertorder(Connection conn, Buylist bu) {
		PreparedStatement pstmt=null;
		int result=0;
		try{
			pstmt=conn.prepareStatement(prop.getProperty("insertorder"));
				pstmt.setInt(1,bu.getTotalprice());
				pstmt.setString(2,bu.getAddress());
				pstmt.setInt(3,bu.getPostcode());
				pstmt.setString(4,bu.getExtraaddress());
				pstmt.setString(5, bu.getDetailaddress());
				pstmt.setString(6, bu.getRequest());
				pstmt.setString(7, bu.getRecipient());
				pstmt.setInt(8, bu.getMemberno());
				pstmt.setInt(9, bu.getBookno());
				pstmt.setInt(10, bu.getCount());
				result=pstmt.executeUpdate();
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			
		}
		
		return result;
	}
	

}
