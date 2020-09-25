package com.semi.notice.model.vo;

import java.sql.Date;

import javax.swing.text.StyledEditorKit.BoldAction;

public class Notice {
	private int noticeNo;
	private String noticeTitle;
    private String noticeWriter;
	private String noticeContent;
	private Date noticeDate;
	private int noticeViews;
	private String filepath;
	private int memberNo;
	private boolean notice_Delete;
	
	public Notice() {
		
	}

	public Notice(int noticeNo, String noticeTitle, String noticeWriter, String noticeContent, Date noticeDate,
			int noticeViews, String filepath, int memberNo, boolean notice_Delete) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeWriter = noticeWriter;
		this.noticeContent = noticeContent;
		this.noticeDate = noticeDate;
		this.noticeViews = noticeViews;
		this.filepath = filepath;
		this.memberNo = memberNo;
		this.notice_Delete = notice_Delete;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeWriter() {
		return noticeWriter;
	}

	public void setNoticeWriter(String noticeWriter) {
		this.noticeWriter = noticeWriter;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public Date getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}

	public int getNoticeViews() {
		return noticeViews;
	}

	public void setNoticeViews(int noticeViews) {
		this.noticeViews = noticeViews;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public boolean isNotice_Delete() {
		return notice_Delete;
	}

	public void setNotice_Delete(boolean notice_Delete) {
		this.notice_Delete = notice_Delete;
	}

	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticeWriter=" + noticeWriter
				+ ", noticeContent=" + noticeContent + ", noticeDate=" + noticeDate + ", noticeViews=" + noticeViews
				+ ", filepath=" + filepath + ", memberNo=" + memberNo + ", notice_Delete=" + notice_Delete + "]";
	}
}