package com.semi.product.model.vo;

import java.sql.Date;

public class BookComView {
	private int bookNo;
	private int memberNo;
	private String com;
	private Date comDate;
	private String memberId;
	private int score; //별점점수
	
	public BookComView() {
		// TODO Auto-generated constructor stub
	}

	public BookComView(int bookNo, int memberNo, String com, Date comDate, String memberId, int score) {
		super();
		this.bookNo = bookNo;
		this.memberNo = memberNo;
		this.com = com;
		this.comDate = comDate;
		this.memberId = memberId;
		this.score = score;
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getCom() {
		return com;
	}

	public void setCom(String com) {
		this.com = com;
	}

	public Date getComDate() {
		return comDate;
	}

	public void setComDate(Date comDate) {
		this.comDate = comDate;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "BookComView [bookNo=" + bookNo + ", memberNo=" + memberNo + ", com=" + com + ", comDate=" + comDate
				+ ", memberId=" + memberId + ", score=" + score + "]";
	}
	
	

}
