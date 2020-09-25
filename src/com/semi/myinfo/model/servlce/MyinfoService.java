package com.semi.myinfo.service;

import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.rollback;
import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.semi.member.model.vo.Member;
import com.semi.myinfo.dao.MyinfoDao;
import com.semi.myinfo.vo.Buylist;

public class MyinfoService {
	
	private MyinfoDao dao= new MyinfoDao();
	
	public int updateMember(Member m) {
		Connection conn=getConnection();
		int result=dao.updateMember(conn,m);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public int deleteMember(String Id) {
		Connection conn=getConnection();
		int result=dao.deleteMember(conn, Id);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public List<Buylist> selectBuyList(int cPage,int numPerPage) {
		Connection conn=getConnection();
		List<Buylist> list=dao.selectBuyList(conn,cPage,numPerPage);
		close(conn);
		return list;
	}

	public int selectBoardCount() {
		Connection conn=getConnection();
		int count=dao.selectBoardCount(conn);
		close(conn);
		return count;
	}
}
