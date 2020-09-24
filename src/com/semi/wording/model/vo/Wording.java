package com.semi.wording.model.vo;

import java.sql.Date;

public class Wording {
	private int wordingNo;
	private String wordingTitle;
	private String wordingContent;
	private Date wordingDate;
	private int wordingViewCount;
	private int memberNo;
	private String writer;
	
	public Wording() {
		// TODO Auto-generated constructor stub
	}

	public Wording(int wordingNo, String wordingTitle, String wordingContent, Date wordingDate, int wordingViewCount,
			int memberNo, String writer) {
		super();
		this.wordingNo = wordingNo;
		this.wordingTitle = wordingTitle;
		this.wordingContent = wordingContent;
		this.wordingDate = wordingDate;
		this.wordingViewCount = wordingViewCount;
		this.memberNo = memberNo;
		this.writer = writer;
	}

	public int getWordingNo() {
		return wordingNo;
	}

	public void setWordingNo(int wordingNo) {
		this.wordingNo = wordingNo;
	}

	public String getWordingTitle() {
		return wordingTitle;
	}

	public void setWordingTitle(String wordingTitle) {
		this.wordingTitle = wordingTitle;
	}

	public String getWordingContent() {
		return wordingContent;
	}

	public void setWordingContent(String wordingContent) {
		this.wordingContent = wordingContent;
	}

	public Date getWordingDate() {
		return wordingDate;
	}

	public void setWordingDate(Date wordingDate) {
		this.wordingDate = wordingDate;
	}

	public int getWordingViewCount() {
		return wordingViewCount;
	}

	public void setWordingViewCount(int wordingViewCount) {
		this.wordingViewCount = wordingViewCount;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	@Override
	public String toString() {
		return "Wording [wordingNo=" + wordingNo + ", wordingTitle=" + wordingTitle + ", wordingContent="
				+ wordingContent + ", wordingDate=" + wordingDate + ", wordingViewCount=" + wordingViewCount
				+ ", memberNo=" + memberNo + ", writer=" + writer + "]";
	}

	
}
