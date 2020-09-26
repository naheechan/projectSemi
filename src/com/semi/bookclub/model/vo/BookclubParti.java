package com.semi.bookclub.model.vo;

public class BookclubParti {
	private int bpNo;
	private String partiId;
	private int memberNo;
	private int bookclubNo;
	
	public BookclubParti() {
		// TODO Auto-generated constructor stub
	}

	public BookclubParti(int bpNo, String partiId, int memberNo, int bookclubNo) {
		super();
		this.bpNo = bpNo;
		this.partiId = partiId;
		this.memberNo = memberNo;
		this.bookclubNo = bookclubNo;
	}

	public int getBpNo() {
		return bpNo;
	}

	public void setBpNo(int bpNo) {
		this.bpNo = bpNo;
	}

	public String getPartiId() {
		return partiId;
	}

	public void setPartiId(String partiId) {
		this.partiId = partiId;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getBookclubNo() {
		return bookclubNo;
	}

	public void setBookclubNo(int bookclubNo) {
		this.bookclubNo = bookclubNo;
	}

	@Override
	public String toString() {
		return "BookclubParti [bpNo=" + bpNo + ", partiId=" + partiId + ", memberNo=" + memberNo + ", bookclubNo="
				+ bookclubNo + "]";
	}
	
}
