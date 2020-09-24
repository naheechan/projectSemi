package com.semi.wording.model.dao;

import static com.semi.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.semi.wording.model.vo.Wording;
import com.semi.wording.model.vo.WordingComment;
import com.semi.wording.model.vo.WordingPic;
import com.semi.wording.model.vo.WordingText;

public class WordingDao {
	
	private Properties prop = new Properties();
	
	public WordingDao() {
		try {
			String fileName = WordingDao.class.getResource("/sql/wording/wording_sql.properties").getPath();
			prop.load(new FileReader(fileName));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public int insertWording(Connection conn, Wording w) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("insertWording"));
			pstmt.setString(1, w.getWordingTitle());
			pstmt.setString(2, w.getWordingContent());
			pstmt.setInt(3, w.getMemberNo());
			pstmt.setString(4, w.getWriter());
			result = pstmt.executeUpdate();
			System.out.println("insertWording result : "+result);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int selectWordingNo(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int no = 0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectWordingNoCurrval"));
			rs = pstmt.executeQuery();
			if(rs.next()) {
				no = rs.getInt(1);
			}
			System.out.println("selectWordingNo no : "+no);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return no;
	}
	
	public int insertWordingPic(Connection conn, WordingPic pic, int no) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("insertWordingPic"));
			pstmt.setInt(1, no);
			pstmt.setString(2, pic.getWordingPicName());
			pstmt.setInt(3, pic.getWordingPicBright());
			result = pstmt.executeUpdate();
			System.out.println("insertWordingPic result : "+result);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int insertWordingText(Connection conn, WordingText text, int no) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("insertWordingText"));
			pstmt.setInt(1, no);
			pstmt.setInt(2, text.getWordingTextSize());
			pstmt.setString(3, text.getWordingTextColor());
			pstmt.setInt(4, text.getWordingTextX());
			pstmt.setInt(5, text.getWordingTextY());
			
			result = pstmt.executeUpdate();
			System.out.println("insertWordingText result : "+result);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	
	public List<Wording> selectWordingBoardList(Connection conn, int cPage, int numPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Wording> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectWordingBoardList"));
			pstmt.setInt(1, (cPage-1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(inputData(rs));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	private Wording inputData(ResultSet rs) throws SQLException {
		Wording w = new Wording();
		w.setWordingNo(rs.getInt("wording_no"));
		w.setWordingTitle(rs.getString("wording_title"));
		w.setWordingContent(rs.getString("wording_content"));
		w.setWordingDate(rs.getDate("wording_date"));
		w.setWordingViewCount(rs.getInt("wording_view_count"));
		w.setMemberNo(rs.getInt("member_no"));
		w.setWriter(rs.getString("writer"));
		return w;
	}
	
	public List<WordingPic> selectWordingPicList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<WordingPic> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectWordingPicList"));
			rs = pstmt.executeQuery();
			while(rs.next()) {
				WordingPic pic = new WordingPic();
				pic.setWordingNo(rs.getInt("wording_no"));
				pic.setWordingPicName(rs.getString("wording_pic_name"));
				pic.setWordingPicBright(rs.getInt("wording_pic_bright"));
				list.add(pic);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	
	public List<WordingText> selectWordingTextList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<WordingText> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectWordingTextList"));
			rs = pstmt.executeQuery();
			while(rs.next()) {
				WordingText t = new WordingText();
				t.setWordingNo(rs.getInt("wording_no"));
				t.setWordingTextSize(rs.getInt("wording_text_size"));
				t.setWordingTextColor(rs.getString("wording_text_color"));
				t.setWordingTextX(rs.getInt("wording_text_x"));
				t.setWordingTextY(rs.getInt("wording_text_y"));
				list.add(t);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	
	public int selectWordingCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int totalData = 0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectWordingCount"));
			rs = pstmt.executeQuery();
			if(rs.next()) {
				totalData = rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return totalData;
		
	}
	
	public Wording selectWordingOne(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Wording w = null;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectWordingOne"));
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				w = inputData(rs);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return w;
	}
	
	public WordingPic selectWordingPicOne(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		WordingPic pic = null;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectWordingPicOne"));
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				pic = new WordingPic();
				pic.setWordingNo(rs.getInt("wording_no"));
				pic.setWordingPicName(rs.getString("wording_pic_name"));
				pic.setWordingPicBright(rs.getInt("wording_pic_bright"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return pic;
	}
	
	public WordingText selectWordingTextOne(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		WordingText te = null;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectWordingTextOne"));
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				te = new WordingText();
				te.setWordingNo(rs.getInt("wording_no"));
				te.setWordingTextSize(rs.getInt("wording_text_size"));
				te.setWordingTextColor(rs.getString("wording_text_color"));
				te.setWordingTextX(rs.getInt("wording_text_x"));
				te.setWordingTextY(rs.getInt("wording_text_y"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return te;
	}
	
	public int updateWording(Connection conn, Wording w, int no) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("updateWording"));
			pstmt.setString(1, w.getWordingTitle());
			pstmt.setString(2, w.getWordingContent());
			pstmt.setInt(3, no);
			result = pstmt.executeUpdate();
			System.out.println("updateWording result : "+result);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int updateWordingPic(Connection conn, WordingPic pic, int no) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			if(pic.getWordingPicName()==null) {
				pstmt = conn.prepareStatement(prop.getProperty("updateWordingPicWithNull"));
				pstmt.setInt(2, no);
			}else {
				pstmt = conn.prepareStatement(prop.getProperty("updateWordingPic"));
				pstmt.setString(2, pic.getWordingPicName());
				pstmt.setInt(3, no);
			}
			pstmt.setInt(1, pic.getWordingPicBright());
			
			result = pstmt.executeUpdate();
			System.out.println("updateWordingPic result : "+result);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	
	
	public int updateWordingText(Connection conn, WordingText te, int no) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("updateWordingText"));
			
			pstmt.setInt(1, te.getWordingTextSize());
			pstmt.setString(2, te.getWordingTextColor());
			pstmt.setInt(3, te.getWordingTextX());
			pstmt.setInt(4, te.getWordingTextY());
			pstmt.setInt(5, no);
			
			result = pstmt.executeUpdate();
			System.out.println("updateWordingText result : "+result);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	
	public int selectWordingLikeCnt(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int likeCount = 0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectWordingLikeCnt"));
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				likeCount = rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return likeCount;
	}
	
	
	public int selectLikeCheck(Connection conn, int wordingNo, int memberNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int likeChk = 0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectLikeCheck"));
			pstmt.setInt(1, wordingNo);
			pstmt.setInt(2, memberNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				likeChk = rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return likeChk;
	}
	
	
	public int insertWordingLike(Connection conn, int wordingNo, int memberNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("insertWordingLike"));
			pstmt.setInt(1, wordingNo);
			pstmt.setInt(2, memberNo);
			result = pstmt.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int deleteWordingLike(Connection conn, int wordingNo, int memberNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("deleteWordingLike"));
			pstmt.setInt(1, wordingNo);
			pstmt.setInt(2, memberNo);
			result = pstmt.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	
	public Map<Integer,Integer> selectLikeCountList(Connection conn, List<Integer> listNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<Integer,Integer> mapLike = new HashMap<>();
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectWordingLikeCnt"));
			for(int no : listNo) {
				pstmt.setInt(1, no);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					mapLike.put(no,rs.getInt(1));
				}
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return mapLike;
	}
	
	public int updateReadCount(Connection conn, int no) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("updateReadCount"));
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public List<Integer> selectWordingNoRanking(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Integer> listNo = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectWordingNoRanking"));
			rs = pstmt.executeQuery();
			while(rs.next()) {
				listNo.add(rs.getInt("wording_no"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return listNo;
	}
	
	
	public List<Wording> selectWordingRanking(Connection conn, List<Integer> listNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Wording> listRanking = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectWordingOne"));
			for(int no : listNo) {
				pstmt.setInt(1, no);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					listRanking.add(inputData(rs));
				}
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return listRanking;
	}
	
	public int insertWordingComment(Connection conn, WordingComment com) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("insertWordingComment"));
			pstmt.setInt(1, com.getComLevel());
			pstmt.setString(2, com.getComContent());
			pstmt.setString(3, com.getWriter());
			pstmt.setInt(4, com.getMemberNo());
			pstmt.setInt(5, com.getWordingNo());
			pstmt.setString(6, com.getRefComNo()==0?null:String.valueOf(com.getRefComNo()));
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int selectWordingCommentNo(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int no = 0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectWordingCommentNoCurrval"));
			rs = pstmt.executeQuery();
			if(rs.next()) {
				no = rs.getInt(1);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return no;
	}
	
	public WordingComment selectWordingCommentOne(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		WordingComment resultCom = null;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectWordingCommentOne"));
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				resultCom = new WordingComment();
				resultCom.setWordingComNo(rs.getInt("wording_com_no"));
				resultCom.setComLevel(rs.getInt("com_level"));
				resultCom.setComContent(rs.getString("com_content"));
				resultCom.setComDate(rs.getDate("com_date"));
				resultCom.setWriter(rs.getString("writer"));
				resultCom.setMemberNo(rs.getInt("member_no"));
				resultCom.setWordingNo(rs.getInt("wording_no"));
				resultCom.setRefComNo(rs.getInt("ref_com_no"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return resultCom;
	}
	
	
	public List<WordingComment> selectWordingCommentList(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<WordingComment> listCom = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectWordingCommentList"));
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				WordingComment wo = new WordingComment();
				wo.setWordingComNo(rs.getInt("wording_com_no"));
				wo.setComLevel(rs.getInt("com_level"));
				wo.setComContent(rs.getString("com_content"));
				wo.setComDate(rs.getDate("com_date"));
				wo.setWriter(rs.getString("writer"));
				wo.setMemberNo(rs.getInt("member_no"));
				wo.setWordingNo(rs.getInt("wording_no"));
				wo.setRefComNo(rs.getInt("ref_com_no"));
				listCom.add(wo);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return listCom;
	}
	
	
}
