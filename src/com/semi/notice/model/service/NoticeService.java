package com.semi.notice.model.service;

import java.sql.Connection;
import java.util.List;

import com.semi.notice.model.dao.NoticeDao;
import com.semi.notice.model.vo.Notice;
import com.semi.notice.model.vo.NoticeComment;

import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.rollback;

import oracle.jdbc.OracleConnection.CommitOption;

public class NoticeService {
	private NoticeDao dao = new NoticeDao();

	public List<Notice> selectNoticeList(int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Notice> list = dao.selectNoticeList(conn, cPage, numPerPage);
		close(conn);
		return list;
	}

	public int selectNoticeCount() {
		Connection conn = getConnection();
		int count = dao.selectNoticeCount(conn);
		close(conn);
		return count;
	}

	public Notice selectNoticeOne(int no) {
		Connection conn = getConnection();
		Notice n = dao.selectNoticeOne(conn, no);
		close(conn);
		return n;
	}

	public int insertNotice(Notice n) {
		Connection conn = getConnection();
		int result = dao.insertNotice(conn, n);
		if (result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int noticeUpdate(Notice n) {
		Connection conn = getConnection();
		int result = dao.updateNotice(conn, n);
		if (result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int deleteNotice(int NoticeNo) {
		Connection conn = getConnection();
		int result = dao.deleteNotice(conn, NoticeNo);
		if (result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public Notice selectNoticeOne(int no, boolean hasRead) {
		Connection conn = getConnection();
		Notice n = dao.selectNoticeOne(conn, no);
		if (n != null && !hasRead) {
			int result = dao.updateReadCount(conn, no);
			if (result > 0)
				commit(conn);
			else
				rollback(conn);
		}
		close(conn);
		return n;
	}

	public int insertNoticeComment(NoticeComment nc) {
		Connection conn = getConnection();
		int result = dao.insertNoticeComment(conn, nc);
		if (result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	
	  public List<NoticeComment> selectBoardCommentList(int no) { Connection conn =
	  getConnection(); List<NoticeComment> list = dao.selectNoticeCommentList(conn,
	  no); close(conn); return list; }
	 

}
