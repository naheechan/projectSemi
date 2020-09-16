package com.semi.member.model.vo;

import java.sql.Date;

public class Member {
	private int memberNo;
	private String memberId;
	private String memberPwd;
	private String memberName;
	private String gender;
	private Date birth;
	private String email;
	private String agency; //통신사
	private String phone;
	private int postCode; //우편번호
	private String address;
	private String extraAddress; //참고주소
	private String detailaddress;//상세주소
	private Date enrollDate;
	public Member() {
		
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPwd() {
		return memberPwd;
	}
	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getPostCode() {
		return postCode;
	}
	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getExtraAddress() {
		return extraAddress;
	}
	public void setExtraAddress(String extraAddress) {
		this.extraAddress = extraAddress;
	}
	public String getDetailaddress() {
		return detailaddress;
	}
	public void setDetailaddress(String detailaddress) {
		this.detailaddress = detailaddress;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	public Member(int memberNo, String memberId, String memberPwd, String memberName, String gender, Date birth,
			String email, String agency, String phone, int postCode, String address, String extraAddress,
			String detailaddress, Date enrollDate) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.gender = gender;
		this.birth = birth;
		this.email = email;
		this.agency = agency;
		this.phone = phone;
		this.postCode = postCode;
		this.address = address;
		this.extraAddress = extraAddress;
		this.detailaddress = detailaddress;
		this.enrollDate = enrollDate;
	}
	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberName="
				+ memberName + ", gender=" + gender + ", birth=" + birth + ", email=" + email + ", agency=" + agency
				+ ", phone=" + phone + ", postCode=" + postCode + ", address=" + address + ", extraAddress="
				+ extraAddress + ", detailaddress=" + detailaddress + ", enrollDate=" + enrollDate + "]";
	}
	

	
	
	
	

}
