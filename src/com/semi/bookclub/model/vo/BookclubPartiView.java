package com.semi.bookclub.model.vo;

public class BookclubPartiView {
	private int bookclubNo;
	private String memberId;
	private String gender;
	
	public BookclubPartiView() {
		// TODO Auto-generated constructor stub
	}

	public BookclubPartiView(int bookclubNo, String memberId, String gender) {
		super();
		this.bookclubNo = bookclubNo;
		this.memberId = memberId;
		this.gender = gender;
	}

	public int getBookclubNo() {
		return bookclubNo;
	}

	public void setBookclubNo(int bookclubNo) {
		this.bookclubNo = bookclubNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "BookclubPartiView [bookclubNo=" + bookclubNo + ", memberId=" + memberId + ", gender=" + gender + "]";
	}
	

}
