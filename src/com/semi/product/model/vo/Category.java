package com.semi.product.model.vo;

public class Category {
	private int categoryno;
	private String categoryname;
	public Category() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Category [categoryno=" + categoryno + ", categoryname=" + categoryname + "]";
	}
	public Category(int categoryno, String categoryname) {
		super();
		this.categoryno = categoryno;
		this.categoryname = categoryname;
	}
	public int getCategoryno() {
		return categoryno;
	}
	public void setCategoryno(int categoryno) {
		this.categoryno = categoryno;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

}
