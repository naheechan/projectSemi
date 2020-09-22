package com.semi.member.model.dao;

import static com.semi.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.semi.member.model.vo.Member;

public class MemberDao {
	
	private Properties prop=new Properties();
	
	public MemberDao() {
		
		try {
			String fileName=MemberDao.class.getResource("/sql/member/member_sql.properties").getPath();
			prop.load(new FileReader(fileName));		
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public Member loginMember(Connection conn, String id, String pw) {
		System.out.println("dao :"+id);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Member m=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectMember"));
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				m=new Member();
				m.setMemberNo(rs.getInt("member_no"));
				m.setMemberId(rs.getString("member_id"));
				m.setMemberPwd(rs.getString("member_pwd"));
				m.setMemberName(rs.getString("member_name"));
				m.setGender(rs.getString("gender"));
				m.setBirth(rs.getDate("birth"));
				m.setEmail(rs.getString("email"));
				m.setAgency(rs.getString("agency"));
				m.setPhone(rs.getString("phone"));
				m.setPostcode(rs.getInt("postcode"));
				m.setAddress(rs.getString("address"));
				m.setExtraAddress(rs.getString("extraaddress"));
				m.setDetailAddress(rs.getString("detailaddress"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("dao :"+m);
		return m;
	}
	
	public int insertMember(Connection conn, Member m) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			System.out.println("dao m:"+m);
			pstmt=conn.prepareStatement(prop.getProperty("insertMember"));
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPwd());
			pstmt.setString(3, m.getMemberName());
			pstmt.setString(4, m.getGender());
			pstmt.setDate(5, m.getBirth());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getAgency());
			pstmt.setString(8, m.getPhone());
			pstmt.setInt(9, m.getPostcode());
			pstmt.setString(10, m.getAddress());
			pstmt.setString(11, m.getExtraAddress());
			pstmt.setString(12, m.getDetailAddress());
			result=pstmt.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		System.out.println("dao result:"+result);
		return result;
	}
	
	public Member selectMember(Connection conn, String MemberId) {
		System.out.println(MemberId);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Member m=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectMemberOne"));
			pstmt.setString(1, MemberId);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				m=new Member();
				m.setMemberId(rs.getString("member_id"));
				m.setMemberPwd(rs.getString("member_pwd"));
				m.setMemberName(rs.getString("member_name"));
				m.setGender(rs.getString("gender"));
				m.setBirth(rs.getDate("birth"));
				m.setEmail(rs.getString("email"));
				m.setAgency(rs.getString("agency"));
				m.setPhone(rs.getString("phone"));
				m.setPostcode(rs.getInt("postcode"));
				m.setAddress(rs.getString("address"));
				m.setExtraAddress(rs.getString("extraaddress"));
				m.setDetailAddress(rs.getString("detailaddress"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return m;	
	}
	
	public Member findId(Connection conn,String MemberName,String birth,String phone) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Member m=null;
		/* Date birth1=Date.valueOf(birth); */
		System.out.println("dao : "+MemberName);
		System.out.println("dao : "+birth);
		System.out.println("dao : "+phone);
		try {
			pstmt=conn.prepareStatement(prop.getProperty("findId"));
			pstmt.setString(1, MemberName);
			pstmt.setString(2, birth);
			pstmt.setString(3, phone);
			
			rs=pstmt.executeQuery();
			if(rs.next()) {	
				m=new Member();
				m.setMemberId(rs.getString("member_id"));
				m.setMemberPwd(rs.getString("member_pwd"));
				m.setMemberName(rs.getString("member_name"));
				m.setGender(rs.getString("gender"));
				m.setBirth(rs.getDate("birth"));
				m.setEmail(rs.getString("email"));
				m.setAgency(rs.getString("agency"));
				m.setPhone(rs.getString("phone"));
				m.setPostcode(rs.getInt("postcode"));
				m.setAddress(rs.getString("address"));
				m.setExtraAddress(rs.getString("extraaddress"));
				m.setDetailAddress(rs.getString("detailaddress"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		System.out.println("dao : "+m);
		return m;
	}
	
	public Member findPw(Connection conn,String memberId, String memberName, String phone) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Member m=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("findPw"));
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberName);
			pstmt.setString(3, phone);
			
			rs=pstmt.executeQuery();
			if(rs.next()) {	
				m=new Member();
				m.setMemberId(rs.getString("member_id"));
				m.setMemberPwd(rs.getString("member_pwd"));
				m.setMemberName(rs.getString("member_name"));
				m.setGender(rs.getString("gender"));
				m.setBirth(rs.getDate("birth"));
				m.setEmail(rs.getString("email"));
				m.setAgency(rs.getString("agency"));
				m.setPhone(rs.getString("phone"));
				m.setPostcode(rs.getInt("postcode"));
				m.setAddress(rs.getString("address"));
				m.setExtraAddress(rs.getString("extraaddress"));
				m.setDetailAddress(rs.getString("detailaddress"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return m;
	}
	
	public int updatePw(Connection conn,String memberPw,String memberId,String memberName) {
		PreparedStatement pstmt=null;
		int result=0;
		System.out.println("dao : "+memberPw);
		System.out.println("dao : "+memberId);
		System.out.println("dao : "+memberName);
		try {
			pstmt=conn.prepareStatement(prop.getProperty("updatePw"));
			pstmt.setString(1, memberPw);
			pstmt.setString(2, memberId);
			pstmt.setString(3, memberName);

			result=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	public Member getseq(Connection conn,String memberId) {
		System.out.println(memberId);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Member m=null;
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectMemberOne"));
			pstmt.setString(1, memberId);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				m=new Member();
				m.setMemberNo(rs.getInt("member_no"));
				m.setMemberId(rs.getString("member_id"));
				m.setMemberPwd(rs.getString("member_pwd"));
				m.setMemberName(rs.getString("member_name"));
				m.setGender(rs.getString("gender"));
				m.setBirth(rs.getDate("birth"));
				m.setEmail(rs.getString("email"));
				m.setAgency(rs.getString("agency"));
				m.setPhone(rs.getString("phone"));
				m.setPostcode(rs.getInt("postcode"));
				m.setAddress(rs.getString("address"));
				m.setExtraAddress(rs.getString("extraaddress"));
				m.setDetailAddress(rs.getString("detailaddress"));
				m.setPoint(rs.getInt("point"));
				m.setLeave(rs.getNString("leave"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return m;	
	}
	
	public int insertInterest(Connection conn,int memberSeq,String interested) {
		System.out.println("Dao : "+memberSeq);
		System.out.println("Dao : "+interested);
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("insertInterest"));
			pstmt.setInt(1, memberSeq);
			pstmt.setString(2, interested);
			System.out.println(pstmt);
			result=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		System.out.println("Dao insert 결과 :"+result);
		return result;
	}
}

