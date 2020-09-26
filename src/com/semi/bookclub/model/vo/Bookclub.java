package com.semi.bookclub.model.vo;

import java.sql.Date;

public class Bookclub {
	private int bookclubNo;
	private String bookclubTitle;
	private String bookclubImg;
	private int maxPerson;
	private Date bookclubDate;
	private int deleteBookclub;
	private String writer;
	private int memberNo;
	private int bookNo;
	
	public Bookclub() {
		// TODO Auto-generated constructor stub
	}

	public Bookclub(int bookclubNo, String bookclubTitle, String bookclubImg, int maxPerson, Date bookclubDate,
			int deleteBookclub, String writer, int memberNo, int bookNo) {
		super();
		this.bookclubNo = bookclubNo;
		this.bookclubTitle = bookclubTitle;
		this.bookclubImg = bookclubImg;
		this.maxPerson = maxPerson;
		this.bookclubDate = bookclubDate;
		this.deleteBookclub = deleteBookclub;
		this.writer = writer;
		this.memberNo = memberNo;
		this.bookNo = bookNo;
	}

	public int getBookclubNo() {
		return bookclubNo;
	}

	public void setBookclubNo(int bookclubNo) {
		this.bookclubNo = bookclubNo;
	}

	public String getBookclubTitle() {
		return bookclubTitle;
	}

	public void setBookclubTitle(String bookclubTitle) {
		this.bookclubTitle = bookclubTitle;
	}

	public String getBookclubImg() {
		return bookclubImg;
	}

	public void setBookclubImg(String bookclubImg) {
		this.bookclubImg = bookclubImg;
	}

	public int getMaxPerson() {
		return maxPerson;
	}

	public void setMaxPerson(int maxPerson) {
		this.maxPerson = maxPerson;
	}

	public Date getBookclubDate() {
		return bookclubDate;
	}

	public void setBookclubDate(Date bookclubDate) {
		this.bookclubDate = bookclubDate;
	}

	public int getDeleteBookclub() {
		return deleteBookclub;
	}

	public void setDeleteBookclub(int deleteBookclub) {
		this.deleteBookclub = deleteBookclub;
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

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	@Override
	public String toString() {
		return "Bookclub [bookclubNo=" + bookclubNo + ", bookclubTitle=" + bookclubTitle + ", bookclubImg="
				+ bookclubImg + ", maxPerson=" + maxPerson + ", bookclubDate=" + bookclubDate + ", deleteBookclub="
				+ deleteBookclub + ", writer=" + writer + ", memberNo=" + memberNo + ", bookNo=" + bookNo + "]";
	}
	
}
