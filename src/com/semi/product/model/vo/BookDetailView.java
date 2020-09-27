package com.semi.product.model.vo;

import java.sql.Date;

public class BookDetailView {
	private int bookNo;
	private String bookTitle;
	private String bookAuthor;
	private int bookPrice;
	private String bookImg;
	private String bookPublisher;
	private Date bookPublicationdate;
	private int categoryNo;
	private String bookintro;
	
	public BookDetailView() {
		// TODO Auto-generated constructor stub
	}

	public BookDetailView(int bookNo, String bookTitle, String bookAuthor, int bookPrice, String bookImg,
			String bookPublisher, Date bookPublicationdate, int categoryNo, String bookintro) {
		super();
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookPrice = bookPrice;
		this.bookImg = bookImg;
		this.bookPublisher = bookPublisher;
		this.bookPublicationdate = bookPublicationdate;
		this.categoryNo = categoryNo;
		this.bookintro = bookintro;
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

	public int getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getBookImg() {
		return bookImg;
	}

	public void setBookImg(String bookImg) {
		this.bookImg = bookImg;
	}

	public String getBookPublisher() {
		return bookPublisher;
	}

	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}

	public Date getBookPublicationdate() {
		return bookPublicationdate;
	}

	public void setBookPublicationdate(Date bookPublicationdate) {
		this.bookPublicationdate = bookPublicationdate;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getBookintro() {
		return bookintro;
	}

	public void setBookintro(String bookintro) {
		this.bookintro = bookintro;
	}

	@Override
	public String toString() {
		return "BookDetailView [bookNo=" + bookNo + ", bookTitle=" + bookTitle + ", bookAuthor=" + bookAuthor
				+ ", bookPrice=" + bookPrice + ", bookImg=" + bookImg + ", bookPublisher=" + bookPublisher
				+ ", bookPublicationdate=" + bookPublicationdate + ", categoryNo=" + categoryNo + ", bookintro="
				+ bookintro + "]";
	}
	

}
