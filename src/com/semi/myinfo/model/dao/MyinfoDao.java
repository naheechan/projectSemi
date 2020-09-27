package com.semi.myinfo.model.dao;

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
import com.semi.buy.model.vo.BuylistJoin;
import com.semi.seat.model.vo.Seat;
import com.semi.seat.model.vo.SeatOrder;
import com.semi.member.model.vo.Member;

import oracle.net.aso.p;


public class MyinfoDao {
	
private Properties prop=new Properties();
	
	
	public MyinfoDao() {
		try {
			String path=MyinfoDao.class.getResource("/sql/myinfo/myinfo_sql.properties").getPath();
			prop.load(new FileReader(path));
		}catch(IOException e) {
			e.printStackTrace();	
		}
	}

	
	public int selectBoardCount(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectBoardCount"));
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result=rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return result;
	}

	public List<BuylistJoin> selectbuylist(Connection conn, int userno, int cPage, int numPerPage) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		BuylistJoin by=null;
		List<BuylistJoin>list=new ArrayList<BuylistJoin>();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectbuylist"));
			pstmt.setInt(1, userno);
			pstmt.setInt(2, (cPage-1)*numPerPage+1);
			pstmt.setInt(3, cPage*numPerPage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				by=new BuylistJoin();
				by.setOrderno(rs.getInt("order_no"));
				by.setTotalprice(rs.getInt("totalprice"));
				by.setAddress(rs.getString("address"));
				by.setPostcode(rs.getInt("postcode"));
				by.setExtraaddress(rs.getString("extraaddress"));
				by.setDetailaddress(rs.getString("detailaddress"));
				by.setRequest(rs.getString("deliveryrequest"));
				by.setOrderdate(rs.getDate("order_date"));
				by.setRecipient(rs.getString("recipient"));
				by.setMemberno(rs.getInt("member_no"));
				by.setBookno(rs.getInt("book_no"));
				by.setCount(rs.getInt("count"));
				by.setTitle(rs.getString("book_title"));
				by.setBookimg(rs.getString("book_img"));
				by.setPrice(rs.getInt("book_price"));
				list.add(by);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return list;
	}

	public int selectbuycount(Connection conn, int userno) {
		PreparedStatement pstmt=null;
		int result=0;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectbuycount"));
			pstmt.setInt(1, userno);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result=rs.getInt(1);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int selectStudyroomCount(Connection conn,int memberNo) {
		PreparedStatement pstmt=null;
		int result=0;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectStudyroomCount"));
			pstmt.setInt(1, memberNo);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result=rs.getInt(1);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public List<SeatOrder> selectStudyroomlist(Connection conn, int memberNo, int cPage, int numPerPage){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		SeatOrder so=null;
		List<SeatOrder> list=new ArrayList<SeatOrder>();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectStudyroomlist"));
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, (cPage-1)*numPerPage+1);
			pstmt.setInt(3, cPage*numPerPage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				so=new SeatOrder();
				so.setSeatOrderNo(rs.getInt("seat_order_no"));
				so.setMemberNo(rs.getInt("member_no"));
				so.setSeatDate(rs.getString("seat_date"));
				so.setSeatTime(rs.getInt("seat_time"));
				so.setUseTime(rs.getInt("use_time"));
				so.setMemberCount(rs.getInt("member_count"));
				so.setSeatNo(rs.getString("seat_no"));
				so.setSeatPrice(rs.getInt("seat_price"));
				so.setSeatOrderDate(rs.getDate("seat_order_date"));

				list.add(so);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return list;
	}
}
	


