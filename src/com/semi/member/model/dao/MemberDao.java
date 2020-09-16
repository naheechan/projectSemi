package com.semi.member.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;



import static com.semi.common.JDBCTemplate.close;



import com.semi.member.model.vo.Member;




public class MemberDao {
	private Properties prop=new Properties();
 public MemberDao() {
	//프로퍼티 가져오기
	try {
		String fileName=MemberDao.class.getResource("/sql/member/member_sql.properties").getPath();
		prop.load(new FileReader(fileName));
	}catch(IOException e) {
		e.printStackTrace();
	}
 }
public Member selectMember(Connection conn, String userId) {
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	Member m=null;
	try {
		pstmt=conn.prepareStatement(prop.getProperty("selectMemberone"));
		pstmt.setString(1, userId);
		rs=pstmt.executeQuery();
		if(rs.next()){
			m=inputData(rs);
			
		}
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
	
	return m;
}
private Member inputData(ResultSet rs) {
	Member m=new Member();
	try {
		m.setMemberNo(rs.getInt("member_no"));
		m.setMemberId(rs.getString("member_id"));
		m.setMemberPwd(rs.getString("member_pwd"));
		m.setMemberName(rs.getString("member_name"));
		m.setGender(rs.getString("gender"));
		m.setBirth(rs.getDate("birth"));
		m.setEmail(rs.getString("email"));
		m.setAgency(rs.getString("agency"));
		m.setPhone(rs.getString("phone"));
		m.setPostCode(rs.getInt("postcode"));
		m.setAddress(rs.getString("address"));
		m.setExtraAddress(rs.getString("extraaddress"));
		m.setDetailaddress(rs.getString("detailaddress"));
		m.setEnrollDate(rs.getDate("enroll_date"));
		
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return m;
}
	public int insertMember(Connection conn, Member m) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("insertMember"));
			pstmt.setString(1,m.getMemberId());
			pstmt.setString(2, m.getMemberPwd());
			pstmt.setString(3,m.getMemberName());
			pstmt.setString(4,m.getGender());
			pstmt.setDate(5,m.getBirth());
			pstmt.setString(6,m.getEmail());
			pstmt.setString(7,m.getAgency());
			pstmt.setString(8,m.getPhone());
			pstmt.setInt(9,m.getPostCode());
			pstmt.setString(10, m.getAddress());
			pstmt.setString(11, m.getExtraAddress());
			pstmt.setString(12, m.getDetailaddress());
			result=pstmt.executeUpdate(); //sql쿼리에 대한 결과값을 반환
		
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;				
	}
	public Member loginMember(Connection conn, String id, String pw) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Member m=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("loginMember"));
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs=pstmt.executeQuery();
			if(rs.next()){
				m=inputData(rs);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);

		}
		System.out.println(m);
		return m;
	}

}
