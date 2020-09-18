package com.semi.member.model.vo;

public class interest {

	int memberCategoryNo;
	int memberNo;
	String categoryNo;
	
	public interest() {
		// TODO Auto-generated constructor stub
	}

	interest(int memberCategoryNo, int memberNo, String categoryNo) {
		super();
		this.memberCategoryNo = memberCategoryNo;
		this.memberNo = memberNo;
		this.categoryNo = categoryNo;
	}

	public int getMemberCategoryNo() {
		return memberCategoryNo;
	}

	public void setMemberCategoryNo(int memberCategoryNo) {
		this.memberCategoryNo = memberCategoryNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}

	@Override
	public String toString() {
		return "interest [memberCategoryNo=" + memberCategoryNo + ", memberNo=" + memberNo + ", categoryNo="
				+ categoryNo + "]";
	}
	
	
}
