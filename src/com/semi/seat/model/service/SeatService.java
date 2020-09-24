package com.semi.seat.model.service;

import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import com.semi.seat.model.dao.SeatDao;
import com.semi.seat.model.vo.Seat;



public class SeatService {

	private SeatDao dao=new SeatDao();
	
	public List<Seat> SelectSeat(String seatDate, int seatTime) {
		Connection conn=getConnection();
		List<Seat> list=dao.SelectSeat(conn, seatDate, seatTime);		
		close(conn);
		return list;
	}
	
	public int insertSeat(Seat seat) {
		Connection conn=getConnection();
		int result=dao.insertSeat(conn, seat);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
		
	}
}