package com.semi.wording.model.vo;

public class WordingLike {
	private int wordingLikeNo;
	private int wordingNo;
	private int memberNo;
	
	public WordingLike() {
		// TODO Auto-generated constructor stub
	}

	public WordingLike(int wordingLikeNo, int wordingNo, int memberNo) {
		super();
		this.wordingLikeNo = wordingLikeNo;
		this.wordingNo = wordingNo;
		this.memberNo = memberNo;
	}

	public int getWordingLikeNo() {
		return wordingLikeNo;
	}

	public void setWordingLikeNo(int wordingLikeNo) {
		this.wordingLikeNo = wordingLikeNo;
	}

	public int getWordingNo() {
		return wordingNo;
	}

	public void setWordingNo(int wordingNo) {
		this.wordingNo = wordingNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	@Override
	public String toString() {
		return "WordingLike [wordingLikeNo=" + wordingLikeNo + ", wordingNo=" + wordingNo + ", memberNo=" + memberNo
				+ "]";
	}
	
	

}
