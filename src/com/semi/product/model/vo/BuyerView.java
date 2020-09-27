package com.semi.product.model.vo;

public class BuyerView {
	
	private String gender;
	private int age;
	
	
	public BuyerView() {
		// TODO Auto-generated constructor stub
	}


	public BuyerView(String gender, int age) {
		super();
		this.gender = gender;
		this.age = age;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "BuyerView [gender=" + gender + ", age=" + age + "]";
	}
	
	
	

}
