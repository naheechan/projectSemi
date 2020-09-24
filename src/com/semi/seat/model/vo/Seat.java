package com.semi.seat.model.vo;

import java.sql.Date;

public class Seat {

	private int seatBookingNo; 	//시퀀스 예약 번호
	private int memberNo;		//시퀀스 회원 번호
	private String seatDate;	//예약 날짜
	private int seatTime;		//예약 시간
	private int useTime;		//사용 시간
	private int memberCount;	//예약 인원
	private String seatNo;		//좌석 번호
	private int seatPrice;		//결제 금액
	
	
	public Seat() {
		// TODO Auto-generated constructor stub
	}


	Seat(int seatBookingNo, int memberNo, String seatDate, int seatTime, int useTime, int memberCount, String seatNo,
			int seatPrice) {
		super();
		this.seatBookingNo = seatBookingNo;
		this.memberNo = memberNo;
		this.seatDate = seatDate;
		this.seatTime = seatTime;
		this.useTime = useTime;
		this.memberCount = memberCount;
		this.seatNo = seatNo;
		this.seatPrice = seatPrice;
	}


	public int getSeatBookingNo() {
		return seatBookingNo;
	}


	public void setSeatBookingNo(int seatBookingNo) {
		this.seatBookingNo = seatBookingNo;
	}


	public int getMemberNo() {
		return memberNo;
	}


	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}


	public String getSeatDate() {
		return seatDate;
	}


	public void setSeatDate(String seatDate) {
		this.seatDate = seatDate;
	}


	public int getSeatTime() {
		return seatTime;
	}


	public void setSeatTime(int seatTime) {
		this.seatTime = seatTime;
	}


	public int getUseTime() {
		return useTime;
	}


	public void setUseTime(int useTime) {
		this.useTime = useTime;
	}


	public int getMemberCount() {
		return memberCount;
	}


	public void setMemberCount(int memberCount) {
		this.memberCount = memberCount;
	}


	public String getSeatNo() {
		return seatNo;
	}


	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}


	public int getSeatPrice() {
		return seatPrice;
	}


	public void setSeatPrice(int seatPrice) {
		this.seatPrice = seatPrice;
	}


	@Override
	public String toString() {
		return "Seat [seatBookingNo=" + seatBookingNo + ", memberNo=" + memberNo + ", seatDate=" + seatDate
				+ ", seatTime=" + seatTime + ", useTime=" + useTime + ", memberCount=" + memberCount + ", seatNo="
				+ seatNo + ", seatPrice=" + seatPrice + "]";
	}

	
	
}