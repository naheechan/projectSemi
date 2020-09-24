package com.semi.wording.model.vo;

import java.sql.Date;

public class WordingComment {
	private int wordingComNo;
	private int comLevel;
	private String comContent;
	private Date comDate;
	private String writer;
	private int memberNo;
	private int wordingNo;
	private int refComNo;
	
	public WordingComment() {
		// TODO Auto-generated constructor stub
	}

	public WordingComment(int wordingComNo, int comLevel, String comContent, Date comDate, String writer, int memberNo,
			int wordingNo, int refComNo) {
		super();
		this.wordingComNo = wordingComNo;
		this.comLevel = comLevel;
		this.comContent = comContent;
		this.comDate = comDate;
		this.writer = writer;
		this.memberNo = memberNo;
		this.wordingNo = wordingNo;
		this.refComNo = refComNo;
	}

	public int getWordingComNo() {
		return wordingComNo;
	}

	public void setWordingComNo(int wordingComNo) {
		this.wordingComNo = wordingComNo;
	}

	public int getComLevel() {
		return comLevel;
	}

	public void setComLevel(int comLevel) {
		this.comLevel = comLevel;
	}

	public String getComContent() {
		return comContent;
	}

	public void setComContent(String comContent) {
		this.comContent = comContent;
	}

	public Date getComDate() {
		return comDate;
	}

	public void setComDate(Date comDate) {
		this.comDate = comDate;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getWordingNo() {
		return wordingNo;
	}

	public void setWordingNo(int wordingNo) {
		this.wordingNo = wordingNo;
	}

	public int getRefComNo() {
		return refComNo;
	}

	public void setRefComNo(int refComNo) {
		this.refComNo = refComNo;
	}

	@Override
	public String toString() {
		return "WordingComment [wordingComNo=" + wordingComNo + ", comLevel=" + comLevel + ", comContent=" + comContent
				+ ", comDate=" + comDate + ", writer=" + writer + ", memberNo=" + memberNo + ", wordingNo=" + wordingNo
				+ ", refComNo=" + refComNo + "]";
	}
	
	
	
}
