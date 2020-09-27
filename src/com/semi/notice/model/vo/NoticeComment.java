package com.semi.notice.model.vo;

import java.sql.Date;

public class NoticeComment {
	private int noticeCommentNo;
	private int noticeCommentLevel;
	private String noticeCommentWriter;
	private String noticeCommentContent;
	private Date noticeCommentDate;
	private int noticeRef;
	private int noticeCommentRef;
	private int memberNo;
	private int noticeNo;
	public NoticeComment() {
		
	}
	public NoticeComment(int noticeCommentNo, int noticeCommentLevel, String noticeCommentWriter,
			String noticeCommentContent, Date noticeCommentDate, int noticeRef, int noticeCommentRef, int memberNo,
			int noticeNo) {
		super();
		this.noticeCommentNo = noticeCommentNo;
		this.noticeCommentLevel = noticeCommentLevel;
		this.noticeCommentWriter = noticeCommentWriter;
		this.noticeCommentContent = noticeCommentContent;
		this.noticeCommentDate = noticeCommentDate;
		this.noticeRef = noticeRef;
		this.noticeCommentRef = noticeCommentRef;
		this.memberNo = memberNo;
		this.noticeNo = noticeNo;
	}
	public int getNoticeCommentNo() {
		return noticeCommentNo;
	}
	public void setNoticeCommentNo(int noticeCommentNo) {
		this.noticeCommentNo = noticeCommentNo;
	}
	public int getNoticeCommentLevel() {
		return noticeCommentLevel;
	}
	public void setNoticeCommentLevel(int noticeCommentLevel) {
		this.noticeCommentLevel = noticeCommentLevel;
	}
	public String getNoticeCommentWriter() {
		return noticeCommentWriter;
	}
	public void setNoticeCommentWriter(String noticeCommentWriter) {
		this.noticeCommentWriter = noticeCommentWriter;
	}
	public String getNoticeCommentContent() {
		return noticeCommentContent;
	}
	public void setNoticeCommentContent(String noticeCommentContent) {
		this.noticeCommentContent = noticeCommentContent;
	}
	public Date getNoticeCommentDate() {
		return noticeCommentDate;
	}
	public void setNoticeCommentDate(Date noticeCommentDate) {
		this.noticeCommentDate = noticeCommentDate;
	}
	public int getNoticeRef() {
		return noticeRef;
	}
	public void setNoticeRef(int noticeRef) {
		this.noticeRef = noticeRef;
	}
	public int getNoticeCommentRef() {
		return noticeCommentRef;
	}
	public void setNoticeCommentRef(int noticeCommentRef) {
		this.noticeCommentRef = noticeCommentRef;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	@Override
	public String toString() {
		return "NoticeComment [noticeCommentNo=" + noticeCommentNo + ", noticeCommentLevel=" + noticeCommentLevel
				+ ", noticeCommentWriter=" + noticeCommentWriter + ", noticeCommentContent=" + noticeCommentContent
				+ ", noticeCommentDate=" + noticeCommentDate + ", noticeRef=" + noticeRef + ", noticeCommentRef="
				+ noticeCommentRef + ", memberNo=" + memberNo + ", noticeNo=" + noticeNo + "]";
	}
	

}
