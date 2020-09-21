package com.semi.cartmodel.vo;

public class Cart {
	private int cartno;
	private int memberno;
	private int bookno;
	public Cart() {
		// TODO Auto-generated constructor stub
	}
	public int getCartno() {
		return cartno;
	}
	public void setCartno(int cartno) {
		this.cartno = cartno;
	}
	public int getMemberno() {
		return memberno;
	}
	public void setMemberno(int memberno) {
		this.memberno = memberno;
	}
	public int getBookno() {
		return bookno;
	}
	public void setBookno(int bookno) {
		this.bookno = bookno;
	}
	public Cart(int cartno, int memberno, int bookno) {
		super();
		this.cartno = cartno;
		this.memberno = memberno;
		this.bookno = bookno;
	}
	@Override
	public String toString() {
		return "Cart [cartno=" + cartno + ", memberno=" + memberno + ", bookno=" + bookno + "]";
	}
	

}
