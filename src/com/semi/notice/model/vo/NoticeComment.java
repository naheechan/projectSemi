package com.semi.notice.model.vo;

import java.sql.Date;

public class NoticeComment {
	private int noticeCommentNo;
	private int ComentNo;
	private String CommentLevle;
	private String CommentContent;
	private Date CommentDate;
	private int noitcNo;
	private int MemberNo;

	public NoticeComment() {
	}

	public NoticeComment(int noticeCommentNo, int comentNo, String commentLevle, String commentContent,
			Date commentDate, int noitcNo, int memberNo) {
		super();
		this.noticeCommentNo = noticeCommentNo;
		ComentNo = comentNo;
		CommentLevle = commentLevle;
		CommentContent = commentContent;
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

	public String getCommentLevle() {
		return CommentLevle;
	}

	public void setCommentLevle(String commentLevle) {
		CommentLevle = commentLevle;
	}

	public String getCommentContent() {
		return CommentContent;
	}

	public void setCommentContent(String commentContent) {
		CommentContent = commentContent;
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
		return "NoticeComment [noticeCommentNo=" + noticeCommentNo + ", ComentNo=" + ComentNo + ", CommentLevle="
				+ CommentLevle + ", CommentContent=" + CommentContent + ", CommentDate=" + CommentDate + ", noitcNo="
				+ noitcNo + ", MemberNo=" + MemberNo + "]";
	}


}