package com.semi.wording.model.vo;

public class WordingPic {
	private int wordingNo;
	private String wordingPicName;
	private int wordingPicBright;
	
	public WordingPic() {
		// TODO Auto-generated constructor stub
	}

	public WordingPic(int wordingNo, String wordingPicName, int wordingPicBright) {
		super();
		this.wordingNo = wordingNo;
		this.wordingPicName = wordingPicName;
		this.wordingPicBright = wordingPicBright;
	}

	public int getWordingNo() {
		return wordingNo;
	}

	public void setWordingNo(int wordingNo) {
		this.wordingNo = wordingNo;
	}

	public String getWordingPicName() {
		return wordingPicName;
	}

	public void setWordingPicName(String wordingPicName) {
		this.wordingPicName = wordingPicName;
	}

	public int getWordingPicBright() {
		return wordingPicBright;
	}

	public void setWordingPicBright(int wordingPicBright) {
		this.wordingPicBright = wordingPicBright;
	}

	@Override
	public String toString() {
		return "WordingPic [wordingNo=" + wordingNo + ", wordingPicName=" + wordingPicName + ", wordingPicBright="
				+ wordingPicBright + "]";
	}

	

}
