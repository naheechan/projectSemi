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
	private String agency;
	private String phone;
	private int postcode;
	private String address;
	private String extraAddress;
	private String detailAddress;
	private Date enrollDate;
	private int point;
	private String leave;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	Member(int memberNo, String memberId, String memberPwd, String memberName, String gender, Date birth, String email,
			String agency, String phone, int postcode, String address, String extraAddress, String detailAddress,
			Date enrollDate, int point, String leave) {
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
		this.postcode = postcode;
		this.address = address;
		this.extraAddress = extraAddress;
		this.detailAddress = detailAddress;
		this.enrollDate = enrollDate;
		this.point = point;
		this.leave = leave;
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

	public int getPostcode() {
		return postcode;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
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

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getLeave() {
		return leave;
	}

	public void setLeave(String leave) {
		this.leave = leave;
	}

	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberName="
				+ memberName + ", gender=" + gender + ", birth=" + birth + ", email=" + email + ", agency=" + agency
				+ ", phone=" + phone + ", postcode=" + postcode + ", address=" + address + ", extraAddress="
				+ extraAddress + ", detailAddress=" + detailAddress + ", enrollDate=" + enrollDate + ", point=" + point
				+ ", leave=" + leave + "]";
	}

	
	
}