package com.semi.member.model.service;

import java.sql.Connection;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.rollback;
import com.semi.member.model.dao.MemberDao;
import com.semi.member.model.vo.Member;

public class MemberService {
	private MemberDao dao=new MemberDao();

	public Member selectMember(String userId) {
		Connection conn=getConnection();
		Member m=dao.selectMember(conn,userId);
		close(conn);
		return m;
	}

	public int insertMember(Member m) {
		Connection conn=getConnection();
		int result=dao.insertMember(conn,m);
		if(result>0) commit(conn);
		else rollback(conn);
		return result;
		
		
	}

	public Member loginMember(String id, String pw) {
		Connection conn=getConnection();
		Member m=dao.loginMember(conn,id,pw);
		close(conn);
		return m;
	}

}
