package com.semi.seat.model.dao;

import static com.semi.common.JDBCTemplate.close;


import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.semi.seat.model.dao.SeatDao;
import com.semi.seat.model.vo.Seat;

public class SeatDao {
	private Properties prop=new Properties();
	
	public SeatDao() {
		try {
			String fileName=SeatDao.class.getResource("/sql/seat/seat_sql.properties").getPath();
			prop.load(new FileReader(fileName));		
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
		
		public List<Seat> SelectSeat(Connection conn, String seatDate, int seatTime) {
			System.out.println("dao :"+seatDate);
			System.out.println("dao :"+seatTime);
			
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			List<Seat> list=new ArrayList();
			try {
				pstmt=conn.prepareStatement(prop.getProperty("selectSeat"));
				pstmt.setString(1, seatDate);
				pstmt.setInt(2, seatTime);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					Seat seat=new Seat();
					seat.setSeatBookingNo(rs.getInt("seat_booking_no"));
					seat.setMemberNo(rs.getInt("member_no"));
					seat.setSeatDate(rs.getString("seat_date"));
					seat.setSeatTime(rs.getInt("seat_time"));
					seat.setUseTime(rs.getInt("use_time"));
					seat.setMemberCount(rs.getInt("member_count"));
					seat.setSeatNo(rs.getString("seat_no"));
					seat.setSeatPrice(rs.getInt("seat_price"));
					list.add(seat);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
			}
			System.out.println("return dao :"+list);
			return list;
		}
		
		public int insertSeat(Connection conn, Seat seat) {
			PreparedStatement pstmt=null;
			int result=0;
			try {
				System.out.println("dao s :"+seat);
				pstmt=conn.prepareStatement(prop.getProperty("insertSeat"));
				
				pstmt.setInt(1, seat.getMemberNo());
				pstmt.setString(2, seat.getSeatDate());
				pstmt.setInt(3, seat.getSeatTime());
				pstmt.setInt(4, seat.getUseTime());
				pstmt.setInt(5, seat.getMemberCount());
				pstmt.setString(6, seat.getSeatNo());
				pstmt.setInt(7,seat.getSeatPrice());
				
				result=pstmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			System.out.println("dao result:"+result);
			return result;
		}
		
		public int insertSeatOrder(Connection conn, Seat seat) {
			PreparedStatement pstmt=null;
			int resultOrder=0;
			try {
				System.out.println("dao s :"+seat);
				pstmt=conn.prepareStatement(prop.getProperty("insertSeatOrder"));
				
				pstmt.setInt(1, seat.getMemberNo());
				pstmt.setString(2, seat.getSeatDate());
				pstmt.setInt(3, seat.getSeatTime());
				pstmt.setInt(4, seat.getUseTime());
				pstmt.setInt(5, seat.getMemberCount());
				pstmt.setString(6, seat.getSeatNo());
				pstmt.setInt(7,seat.getSeatPrice());
				
				resultOrder=pstmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			System.out.println("dao result:"+resultOrder);
			return resultOrder;
		}
}
