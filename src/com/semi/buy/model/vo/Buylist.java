package com.semi.buy.model.vo;

import java.sql.Date;

public class Buylist {
	private int orderno;
	private int totalprice;
	private String address;
	private int postcode;
	private String extraaddress;
	private String detailaddress;
	private Date orderdate;
	private String request;
	private int memberno;
	private String recipient;
	private int bookno;	
	private String phone;
	private int count;
	public Buylist() {
		// TODO Auto-generated constructor stub
	}
	public int getOrderno() {
		return orderno;
	}
	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPostcode() {
		return postcode;
	}
	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}
	public String getExtraaddress() {
		return extraaddress;
	}
	public void setExtraaddress(String extraaddress) {
		this.extraaddress = extraaddress;
	}
	public String getDetailaddress() {
		return detailaddress;
	}
	public void setDetailaddress(String detailaddress) {
		this.detailaddress = detailaddress;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public int getMemberno() {
		return memberno;
	}
	public void setMemberno(int memberno) {
		this.memberno = memberno;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public int getBookno() {
		return bookno;
	}
	public void setBookno(int bookno) {
		this.bookno = bookno;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Buylist(int orderno, int totalprice, String address, int postcode, String extraaddress, String detailaddress,
			Date orderdate, String request, int memberno, String recipient, int bookno, String phone, int count) {
		super();
		this.orderno = orderno;
		this.totalprice = totalprice;
		this.address = address;
		this.postcode = postcode;
		this.extraaddress = extraaddress;
		this.detailaddress = detailaddress;
		this.orderdate = orderdate;
		this.request = request;
		this.memberno = memberno;
		this.recipient = recipient;
		this.bookno = bookno;
		this.phone = phone;
		this.count = count;
	}
	@Override
	public String toString() {
		return "Buylist [orderno=" + orderno + ", totalprice=" + totalprice + ", address=" + address + ", postcode="
				+ postcode + ", extraaddress=" + extraaddress + ", detailaddress=" + detailaddress + ", orderdate="
				+ orderdate + ", request=" + request + ", memberno=" + memberno + ", recipient=" + recipient
				+ ", bookno=" + bookno + ", phone=" + phone + ", count=" + count + "]";
	}
	

}
