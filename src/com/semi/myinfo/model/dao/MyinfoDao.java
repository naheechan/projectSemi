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
	
	public int updateMember(Connection conn, Member m) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("updateMember"));
			pstmt.setString(1, m.getMemberPwd());
			pstmt.setString(2, m.getMemberName());
//			pstmt.setString(4, m.getGender());
			pstmt.setDate(3, m.getBirth());
			pstmt.setString(4, m.getEmail());
			pstmt.setString(5, m.getAgency());
			pstmt.setString(6, m.getPhone());
			pstmt.setInt(7, m.getPostcode());
			pstmt.setString(8, m.getAddress());
			pstmt.setString(9, m.getExtraAddress());
			pstmt.setString(10, m.getDetailAddress());
			
			pstmt.setString(11, m.getMemberId());
			
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	public int deleteMember(Connection conn, String id) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("deleteMember"));
			pstmt.setString(1, id);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;	
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
	
}
	


