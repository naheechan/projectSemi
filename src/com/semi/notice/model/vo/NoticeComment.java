package com.semi.notice.model.vo;

import java.sql.Date;

public class NoticeComment {
	private int noticeCommentNo;
	private int ComentNo;
	private String Commentlevle;
	private String Comment;
	private Date CommentDate;
	private int noitcNo;
	private int MemberNo;

	public NoticeComment() {
	}

	public NoticeComment(int noticeCommentNo, int comentNo, String commentlevle, String comment, Date commentDate,
			int noitcNo, int memberNo) {
		super();
		this.noticeCommentNo = noticeCommentNo;
		ComentNo = comentNo;
		Commentlevle = commentlevle;
		Comment = comment;
		CommentDate = commentDate;
		this.noitcNo = noitcNo;
		MemberNo = memberNo;
	}

	public int getNoticeCommentNo() {
		return noticeCommentNo;
	}

	public void setNoticeCommentNo(int noticeCommentNo) {
		this.noticeCommentNo = noticeCommentNo;
	}

	public int getComentNo() {
		return ComentNo;
	}

	public void setComentNo(int comentNo) {
		ComentNo = comentNo;
	}

	public String getCommentlevle() {
		return Commentlevle;
	}

	public void setCommentlevle(String commentlevle) {
		Commentlevle = commentlevle;
	}

	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
	}

	public Date getCommentDate() {
		return CommentDate;
	}

	public void setCommentDate(Date commentDate) {
		CommentDate = commentDate;
	}

	public int getNoitcNo() {
		return noitcNo;
	}

	public void setNoitcNo(int noitcNo) {
		this.noitcNo = noitcNo;
	}

	public int getMemberNo() {
		return MemberNo;
	}

	public void setMemberNo(int memberNo) {
		MemberNo = memberNo;
	}

	@Override
	public String toString() {
		return "NoticeComment [noticeCommentNo=" + noticeCommentNo + ", ComentNo=" + ComentNo + ", Commentlevle="
				+ Commentlevle + ", Comment=" + Comment + ", CommentDate=" + CommentDate + ", noitcNo=" + noitcNo
				+ ", MemberNo=" + MemberNo + "]";
	}

}
