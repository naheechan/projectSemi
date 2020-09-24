package com.semi.wording.model.vo;

public class WordingText {
	private int wordingNo;
	private int wordingTextSize;
	private String wordingTextColor;
	private int wordingTextX;
	private int wordingTextY;
	
	public WordingText() {
		// TODO Auto-generated constructor stub
	}

	public WordingText(int wordingNo, int wordingTextSize, String wordingTextColor, int wordingTextX,
			int wordingTextY) {
		super();
		this.wordingNo = wordingNo;
		this.wordingTextSize = wordingTextSize;
		this.wordingTextColor = wordingTextColor;
		this.wordingTextX = wordingTextX;
		this.wordingTextY = wordingTextY;
	}

	public int getWordingNo() {
		return wordingNo;
	}

	public void setWordingNo(int wordingNo) {
		this.wordingNo = wordingNo;
	}

	public int getWordingTextSize() {
		return wordingTextSize;
	}

	public void setWordingTextSize(int wordingTextSize) {
		this.wordingTextSize = wordingTextSize;
	}

	public String getWordingTextColor() {
		return wordingTextColor;
	}

	public void setWordingTextColor(String wordingTextColor) {
		this.wordingTextColor = wordingTextColor;
	}

	public int getWordingTextX() {
		return wordingTextX;
	}

	public void setWordingTextX(int wordingTextX) {
		this.wordingTextX = wordingTextX;
	}

	public int getWordingTextY() {
		return wordingTextY;
	}

	public void setWordingTextY(int wordingTextY) {
		this.wordingTextY = wordingTextY;
	}

	@Override
	public String toString() {
		return "WordingText [wordingNo=" + wordingNo + ", wordingTextSize=" + wordingTextSize + ", wordingTextColor="
				+ wordingTextColor + ", wordingTextX=" + wordingTextX + ", wordingTextY=" + wordingTextY + "]";
	}
	
	
	
}
