package com.semi.notice.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.semi.notice.model.vo.Notice;
import com.semi.notice.model.vo.NoticeComment;

import static com.semi.common.JDBCTemplate.close;

public class NoticeDao {
	private Properties prop = new Properties();

	public NoticeDao() {
		try {
			String path = NoticeDao.class.getResource("/sql/notice/notice_sql.properties").getPath();
			prop.load(new FileReader(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Notice> selectNoticeList(Connection conn, int cPage, int numPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Notice> list = new ArrayList();
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectNoticeList"));
			pstmt.setInt(1, (cPage - 1) * numPerPage + 1);
			pstmt.setInt(2, cPage * numPerPage);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Notice n = new Notice();
				n.setNoticeNo(rs.getInt("notice_No"));
				n.setNoticeTitle(rs.getString("notice_Title"));
				n.setNoticeWriter(rs.getString("notice_writer"));
				n.setNoticeContent(rs.getString("notice_content"));
				n.setNoticeDate(rs.getDate("notice_Date"));
				n.setNoticeViews(rs.getInt("notice_Views"));
				n.setFilepath(rs.getString("filepath"));
				n.setMemberNo(rs.getInt("member_No"));
				n.setNotice_Delete(rs.getNString("notice_Del") == "Y" ? true : false);
				list.add(n);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	public int selectNoticeCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectNoticeCount"));
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

	public Notice selectNoticeOne(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Notice n = null;
		NoticeComment nc=null;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectNoticeOne"));
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				n = new Notice();
				n.setNoticeNo(rs.getInt("notice_no"));
				n.setNoticeTitle(rs.getString("notice_title"));
				n.setNoticeWriter(rs.getNString("notice_writer"));
				n.setNoticeContent(rs.getString("notice_content"));
				n.setNoticeDate(rs.getDate("notice_date"));
				n.setFilepath(rs.getString("filepath"));
				n.setMemberNo(rs.getInt("member_no"));
				/*
				 * n.setNoticeViews(rs.getInt("notice_views"));
				 */
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return n;
	}

	public int insertNotice(Connection conn, Notice n) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("insertNotice"));
			pstmt.setString(1, n.getNoticeTitle());
			pstmt.setString(2, n.getNoticeWriter());
			pstmt.setString(3, n.getNoticeContent());
			pstmt.setString(4, n.getFilepath());
		
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int updateNotice(Connection conn, Notice n) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("updateNotice"));
			pstmt.setString(1, n.getNoticeTitle());
			pstmt.setString(2, n.getNoticeContent());
			pstmt.setString(3, n.getFilepath());
			pstmt.setInt(4, n.getNoticeNo());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteNotice(Connection conn, int noticeNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("deleteNotice"));
			pstmt.setInt(1, noticeNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;

	}
	/*
	 * public int insertNoticeComment(Connection conn, NoticeComment nc) {
	 * PreparedStatement pstmt= null; int result=0; try {
	 * pstmt=conn.prepareStatement(prop.getProperty("insertNoticeComment"));
	 * pstmt.setString(1, nc.getCommentLevle()); pstmt.setString(2,
	 * nc.getCommentContent()); pstmt.setInt(3, nc.getMemberNo()); pstmt.setInt(4,
	 * nc.getNoitcNo()); result=pstmt.executeUpdate(); }catch (SQLException e) {
	 * e.printStackTrace(); }finally { close(pstmt); } return result; }
	 */
	/*
	 * public int updateReadCount(Connection conn, int no) { PreparedStatement
	 * pstmt=null; int result=0; try {
	 * pstmt=conn.prepareStatement(prop.getProperty("updateReadCount"));
	 * pstmt.setInt(1, no); result=pstmt.executeUpdate(); }catch (SQLException e) {
	 * e.printStackTrace(); }finally { close(pstmt); }return result; }
	 */
	/*
	 * public List<NoticeComment> selectNoticeCommentList(Connection conn, int no){
	 * PreparedStatement pstmt=null; ResultSet rs=null; List<NoticeComment> list=new
	 * ArrayList(); try {
	 * pstmt=conn.prepareStatement(prop.getProperty("selectNoticeCommentList"));
	 * pstmt.setInt(1, no); rs=pstmt.executeQuery(); while(rs.next()) {
	 * NoticeComment nc= new NoticeComment(); nc.setNoticeCommentNo(rs.getInt(1));
	 * nc.setComentNo(rs.getInt(2)); nc.setCommentLevle(rs.getString(3));
	 * nc.setCommentContent(rs.getNString(4)); nc.setCommentDate(rs.getDate(5));
	 * nc.setMemberNo(rs.getInt(6)); nc.setNoitcNo(rs.getInt(7)); list.add(nc); }
	 * }catch (SQLException e) { e.printStackTrace(); }finally { close(rs);
	 * close(pstmt); }return list; }
	 */
}
