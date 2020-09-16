package com.semi.product.model.vo;

import java.sql.Date;

public class Books {
	private int bookNo;
	private String title;//책제목
	private String author;//저자
	private int price;//가격
	private String publisher;//출판사
	private String bookimg;
	private Date publicationdate;//출판일
	public Books() {
		// TODO Auto-generated constructor stub
	}
	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getBookimg() {
		return bookimg;
	}
	public void setBookimg(String bookimg) {
		this.bookimg = bookimg;
	}
	public Date getPublicationdate() {
		return publicationdate;
	}
	public void setPublicationdate(Date publicationdate) {
		this.publicationdate = publicationdate;
	}
	@Override
	public String toString() {
		return "Books [bookNo=" + bookNo + ", title=" + title + ", author=" + author + ", price=" + price
				+ ", publisher=" + publisher + ", bookimg=" + bookimg + ", publicationdate=" + publicationdate + "]";
	}
	public Books(int bookNo, String title, String author, int price, String publisher, String bookimg,
			Date publicationdate) {
		super();
		this.bookNo = bookNo;
		this.title = title;
		this.author = author;
		this.price = price;
		this.publisher = publisher;
		this.bookimg = bookimg;
		this.publicationdate = publicationdate;
	}
	
	
	
}
