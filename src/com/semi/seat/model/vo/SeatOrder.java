package com.semi.seat.model.vo;

import java.sql.Date;

public class SeatOrder {

	private int seatOrderNo;
	private int memberNo;
	private String seatDate;
	private int seatTime;
	private int useTime;
	private int memberCount;
	private String seatNo;
	private int seatPrice;
	private Date seatOrderDate;
	
	public SeatOrder() {
		// TODO Auto-generated constructor stub
	}

	SeatOrder(int seatOrderNo, int memberNo, String seatDate, int seatTime, int useTime, int memberCount, String seatNo,
			int seatPrice, Date seatOrderDate) {
		super();
		this.seatOrderNo = seatOrderNo;
		this.memberNo = memberNo;
		this.seatDate = seatDate;
		this.seatTime = seatTime;
		this.useTime = useTime;
		this.memberCount = memberCount;
		this.seatNo = seatNo;
		this.seatPrice = seatPrice;
		this.seatOrderDate = seatOrderDate;
	}

	public int getSeatOrderNo() {
		return seatOrderNo;
	}

	public void setSeatOrderNo(int seatOrderNo) {
		this.seatOrderNo = seatOrderNo;
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

	public Date getSeatOrderDate() {
		return seatOrderDate;
	}

	public void setSeatOrderDate(Date seatOrderDate) {
		this.seatOrderDate = seatOrderDate;
	}

	@Override
	public String toString() {
		return "SeatOrder [seatOrderNo=" + seatOrderNo + ", memberNo=" + memberNo + ", seatDate=" + seatDate
				+ ", seatTime=" + seatTime + ", useTime=" + useTime + ", memberCount=" + memberCount + ", seatNo="
				+ seatNo + ", seatPrice=" + seatPrice + ", seatOrderDate=" + seatOrderDate + "]";
	}
	
	
	
}
