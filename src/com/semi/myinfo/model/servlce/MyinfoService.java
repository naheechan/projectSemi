package com.semi.myinfo.model.servlce;

import static com.semi.common.JDBCTemplate.commit;

import static com.semi.common.JDBCTemplate.rollback;
import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.semi.buy.model.vo.Buylist;
import com.semi.buy.model.vo.BuylistJoin;
import com.semi.seat.model.vo.Seat;
import com.semi.seat.model.vo.SeatOrder;
import com.semi.member.model.vo.Member;
import com.semi.myinfo.model.dao.MyinfoDao;


public class MyinfoService {

	private MyinfoDao dao = new MyinfoDao();

	public int selectBoardCount() {
		Connection conn = getConnection();
		int count = dao.selectBoardCount(conn);
		close(conn);
		return count;
	}

	public List<BuylistJoin> selectbuylist(int userno, int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<BuylistJoin> list = dao.selectbuylist(conn, userno,cPage,numPerPage);
		close(conn);
		return list;

	}

	public int selectcount(int userno) {
		Connection conn = getConnection();
		int result=dao.selectbuycount(conn,userno);
		close(conn);
		return result;
	}
	
	public int selectStudyroomCount(int memberNo) {
		Connection conn = getConnection();
		int result=dao.selectStudyroomCount(conn,memberNo);
		close(conn);
		return result;
	}
	
	public List<SeatOrder> selectStudyroomlist(int memberNo,int cPage, int numPerPage){
		Connection conn = getConnection();
		List<SeatOrder> list = dao.selectStudyroomlist(conn, memberNo,cPage,numPerPage);
		close(conn);
		return list;
	}
}
