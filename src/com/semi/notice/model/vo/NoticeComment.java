package com.semi.notice.model.vo;

import java.sql.Date;

public class NoticeComment {
	private int CCommentNo;
	private int CcommentLevel;
	private String boardCommentContent;
	private Date boardCommentDate;
  public NoticeComment() {

}
public NoticeComment(int cCommentNo, int ccommentLevel, String boardCommentContent, Date boardCommentDate) {
	super();
	CCommentNo = cCommentNo;
	CcommentLevel = ccommentLevel;
	this.boardCommentContent = boardCommentContent;
	this.boardCommentDate = boardCommentDate;
}
public int getCCommentNo() {
	return CCommentNo;
}
public void setCCommentNo(int cCommentNo) {
	CCommentNo = cCommentNo;
}
public int getCcommentLevel() {
	return CcommentLevel;
}
public void setCcommentLevel(int ccommentLevel) {
	CcommentLevel = ccommentLevel;
}
public String getBoardCommentContent() {
	return boardCommentContent;
}
public void setBoardCommentContent(String boardCommentContent) {
	this.boardCommentContent = boardCommentContent;
}
public Date getBoardCommentDate() {
	return boardCommentDate;
}
public void setBoardCommentDate(Date boardCommentDate) {
	this.boardCommentDate = boardCommentDate;
}
@Override
public String toString() {
	return "NoticeComment [CCommentNo=" + CCommentNo + ", CcommentLevel=" + CcommentLevel + ", boardCommentContent="
			+ boardCommentContent + ", boardCommentDate=" + boardCommentDate + "]";
}	
  
}
 
