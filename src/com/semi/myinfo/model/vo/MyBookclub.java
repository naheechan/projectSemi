package com.semi.myinfo.model.vo;

import java.sql.Date;

public class MyBookclub {
	
	private String partiId;
	private int bookclubNo;
	private String bookclubTitle;
	private String bookclubImg;
	private int maxPerson;
	private Date bookclubDate;
	private int deleteBookclub;
	private String writer;
	private int memberNo;
	private int bookNo;
	private String bookTitle;
	private String bookAuthor;
	
	public MyBookclub() {
		// TODO Auto-generated constructor stub
	}

	MyBookclub(String partiId, int bookclubNo, String bookclubTitle, String bookclubImg, int maxPerson,
			Date bookclubDate, int deleteBookclub, String writer, int memberNo, int bookNo, String bookTitle,
			String bookAuthor) {
		super();
		this.partiId = partiId;
		this.bookclubNo = bookclubNo;
		this.bookclubTitle = bookclubTitle;
		this.bookclubImg = bookclubImg;
		this.maxPerson = maxPerson;
		this.bookclubDate = bookclubDate;
		this.deleteBookclub = deleteBookclub;
		this.writer = writer;
		this.memberNo = memberNo;
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
	}

	public String getPartiId() {
		return partiId;
	}

	public void setPartiId(String partiId) {
		this.partiId = partiId;
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

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	@Override
	public String toString() {
		return "MyBookclub [partiId=" + partiId + ", bookclubNo=" + bookclubNo + ", bookclubTitle=" + bookclubTitle
				+ ", bookclubImg=" + bookclubImg + ", maxPerson=" + maxPerson + ", bookclubDate=" + bookclubDate
				+ ", deleteBookclub=" + deleteBookclub + ", writer=" + writer + ", memberNo=" + memberNo + ", bookNo="
				+ bookNo + ", bookTitle=" + bookTitle + ", bookAuthor=" + bookAuthor + "]";
	}
	
	
}
