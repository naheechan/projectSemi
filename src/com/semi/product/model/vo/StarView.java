package com.semi.product.model.vo;

public class StarView {
	private int oneStar;
	private int twoStar;
	private int threeStar;
	private int fourStar;
	private int fiveStar;
	
	public StarView() {
		// TODO Auto-generated constructor stub
	}

	public StarView(int oneStar, int twoStar, int threeStar, int fourStar, int fiveStar) {
		super();
		this.oneStar = oneStar;
		this.twoStar = twoStar;
		this.threeStar = threeStar;
		this.fourStar = fourStar;
		this.fiveStar = fiveStar;
	}

	public int getOneStar() {
		return oneStar;
	}

	public void setOneStar(int oneStar) {
		this.oneStar = oneStar;
	}

	public int getTwoStar() {
		return twoStar;
	}

	public void setTwoStar(int twoStar) {
		this.twoStar = twoStar;
	}

	public int getThreeStar() {
		return threeStar;
	}

	public void setThreeStar(int threeStar) {
		this.threeStar = threeStar;
	}

	public int getFourStar() {
		return fourStar;
	}

	public void setFourStar(int fourStar) {
		this.fourStar = fourStar;
	}

	public int getFiveStar() {
		return fiveStar;
	}

	public void setFiveStar(int fiveStar) {
		this.fiveStar = fiveStar;
	}

	@Override
	public String toString() {
		return "StarView [oneStar=" + oneStar + ", twoStar=" + twoStar + ", threeStar=" + threeStar + ", fourStar="
				+ fourStar + ", fiveStar=" + fiveStar + "]";
	}
	
}
