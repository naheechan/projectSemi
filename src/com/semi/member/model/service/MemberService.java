package com.semi.member.model.service;


import static com.semi.common.JDBCTemplate.close;

import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import com.semi.member.model.dao.MemberDao;
import com.semi.member.model.vo.Member;
import com.semi.member.model.vo.Interest;


public class MemberService {

	private MemberDao dao=new MemberDao();
	
	public Member loginMember(String id, String password) {
		Connection conn=getConnection();
		Member m=dao.loginMember(conn,id, password);
		close(conn);
		return m;
	}
	
	public int insertMember(Member m) {
		Connection conn=getConnection();
		int result=dao.insertMember(conn,m);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public Member selectMember(String MemberId) {
		Connection conn=getConnection();
		Member m=dao.selectMember(conn,MemberId);
		close(conn);
		return m;
	}

	public Member findId(String MemberName, String birth, String phone) {
		Connection conn=getConnection();
		Member m=dao.findId(conn,MemberName,birth,phone);
		close(conn);
		return m; 
	}
	
	public Member findPw(String memberId, String memberName, String phone) {
		Connection conn=getConnection();
		Member m=dao.findPw(conn,memberId,memberName,phone);
		close(conn);
		return m; 
	}
	
	public int updatePw(String memberPw, String memberId, String memberName) {
		Connection conn=getConnection();
		int result=dao.updatePw(conn,memberPw,memberId,memberName);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result; 
	}
	
	
	public int updatePassword(String memberId, String Password) {
		Connection conn=getConnection();
		int result=dao.updatePassword(conn,memberId,Password);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result; 
	}
	
	public Member getseq(String memberId) {
		Connection conn=getConnection();
		Member m=dao.getseq(conn,memberId);
		close(conn);
		return m; 
	}
	
	public int insertInterest(int memberSeq, String interested) {
		Connection conn=getConnection();
		int result=dao.insertInterest(conn,memberSeq,interested);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	

	public List<Interest> getinterest(int memberNo) {
	      Connection conn=getConnection();
	      List<Interest> list=dao.getinterest(conn,memberNo);
	      close(conn);
	      return list; 
	   }
	
	public int DeleteMember(String memberId) {
		Connection conn=getConnection();
		int result=dao.DeleteMember(conn,memberId);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public int updateMember(Member m) {
		Connection conn=getConnection();
		int result=dao.updateMember(conn,m);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	
	public int deleteInterst(int memberSeq) {
		Connection conn=getConnection();
		int result=dao.deleteInterest(conn,memberSeq);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	
}
