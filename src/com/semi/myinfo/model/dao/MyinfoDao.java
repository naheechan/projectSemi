package com.semi.myinfo.dao;

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
import com.semi.member.model.vo.Member;
import com.semi.myinfo.vo.BuylistDetail;

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
	
	public List<BuylistDetail> selectBuyList(Connection conn, int cPage, int numPerPage) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<BuylistDetail> list=new ArrayList();
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectBuyList"));
			pstmt.setInt(1, (cPage-1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BuylistDetail b=new BuylistDetail();
				b.setMemberNo(rs.getInt("MEMBER_NO"));
				b.setOrderNo(rs.getInt("ORDER_NO"));
				b.setTotalPrice(rs.getInt("TOTALPRICE"));
				b.setPostCode(rs.getInt("POSTCODE"));
				b.setAddress(rs.getString("ADDRESS"));
				b.setExtraAddress(rs.getString("EXTRAADDRESS"));
				b.setDetailAddress(rs.getString("DETAILADDRESS"));
				b.setDeliveryRequest(rs.getString("DELIVERY_REQUEST"));
				b.setOrderDate(rs.getDate("ORDER_DATE"));
				list.add(b);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return list;
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
	
}
	


