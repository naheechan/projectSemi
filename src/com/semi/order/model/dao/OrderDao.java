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
	public List<Cart> selectproduct(Connection conn, Buylist bu) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Cart>list=new ArrayList<Cart>();
		Cart ck=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectproduct"));
			pstmt.setInt(1, bu.getMemberno());
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
	

}
