package com.semi.wording.model.service;

import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.semi.wording.model.dao.WordingDao;
import com.semi.wording.model.vo.Wording;
import com.semi.wording.model.vo.WordingComment;
import com.semi.wording.model.vo.WordingPic;
import com.semi.wording.model.vo.WordingText;

public class WordingService {
	
	private WordingDao dao = new WordingDao();
	
	
	public int insertWording(Wording w, WordingPic pic, WordingText text) {
		Connection conn = getConnection();
		int result3 = 0;
		int result = dao.insertWording(conn, w);
		int no = dao.selectWordingNo(conn);
		if(result>0 && no>0) {
			int result2 = dao.insertWordingPic(conn, pic, no);
			if(result2>0) {
				result3 = dao.insertWordingText(conn, text, no);
				if(result3>0) {
					commit(conn);
					
				}else rollback(conn);
			}else rollback(conn);
		}else rollback(conn);
		
		close(conn);
		return result3;
	}
	
	
	public List<Wording> selectWordingBoardList(int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Wording> list = dao.selectWordingBoardList(conn, cPage, numPerPage);
		close(conn);
		return list;
	}
	
	public List<WordingPic> selectWordingPicList() {
		Connection conn = getConnection();
		List<WordingPic> list = dao.selectWordingPicList(conn);
		close(conn);
		return list;
	}
	
	public List<WordingText> selectWordingTextList() {
		Connection conn = getConnection();
		List<WordingText> list = dao.selectWordingTextList(conn);
		close(conn);
		return list;
	}
	
	public int selectWordingCount() {
		Connection conn = getConnection();
		int totalData = dao.selectWordingCount(conn);
		close(conn);
		return totalData;
	}
	
	public Wording selectWordingOne(int no) {
		Connection conn = getConnection();
		Wording w = dao.selectWordingOne(conn, no);
		
		close(conn);
		return w;
	}
	
	public Wording selectWordingOne(int no, boolean hasRead) {
		Connection conn = getConnection();
		Wording w = dao.selectWordingOne(conn, no);
		//조회수 증가
		if(w!=null && !hasRead) {
			int result = dao.updateReadCount(conn, no);
			if(result>0) commit(conn);
			else rollback(conn);
		}
		close(conn);
		return w;
	}
	
	public WordingPic selectWordingPicOne(int no) {
		Connection conn = getConnection();
		WordingPic pic = dao.selectWordingPicOne(conn, no);
		close(conn);
		return pic;
	}
	
	public WordingText selectWordingTextOne(int no) {
		Connection conn = getConnection();
		WordingText te = dao.selectWordingTextOne(conn, no);
		close(conn);
		return te;
	}
	
	public int updateWording(Wording w, WordingPic pic, WordingText text, int no) {
		Connection conn = getConnection();
		int result3 = 0;
		int result = dao.updateWording(conn, w, no);
		if(result>0) {
			int result2 = dao.updateWordingPic(conn, pic, no);
			if(result2>0) {
				result3 = dao.updateWordingText(conn, text, no);
				if(result3>0) {
					commit(conn);
					
				}else rollback(conn);
			}else rollback(conn);
		}else rollback(conn);
		
		close(conn);
		return result3;
	}
	
	public int selectWordingLikeCnt(int no) {
		Connection conn = getConnection();
		int likeCount = dao.selectWordingLikeCnt(conn, no);
		close(conn);
		return likeCount;
	}
	
	public int selectLikeCheck(int wordingNo, int memberNo) {
		Connection conn = getConnection();
		int likeChk = dao.selectLikeCheck(conn, wordingNo, memberNo);
		close(conn);
		return likeChk;
	}
	
	
	public int insertWordingLike(int wordingNo, int memberNo) {
		Connection conn = getConnection();
		int result = dao.insertWordingLike(conn, wordingNo, memberNo);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public int deleteWordingLike(int wordingNo, int memberNo) {
		Connection conn = getConnection();
		int result = dao.deleteWordingLike(conn, wordingNo, memberNo);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public Map<Integer,Integer> selectLikeCountList(List<Integer> listNo) {
		Connection conn = getConnection();
		Map<Integer,Integer> mapLike = dao.selectLikeCountList(conn, listNo);
		close(conn);
		return mapLike;
	}
	
	public List<Wording> selectWordingRanking() {
		Connection conn = getConnection();
		List<Wording> listRanking = null;
		List<Integer> listNo = dao.selectWordingNoRanking(conn);
		if(listNo.size()>0) {
			listRanking = dao.selectWordingRanking(conn, listNo);
		}
		close(conn);
		return listRanking;
	}
	
	public WordingComment insertWordingComment(WordingComment com) {
		Connection conn = getConnection();
		WordingComment resultCom = null;
		int result = dao.insertWordingComment(conn, com);
		if(result>0) {
			commit(conn);
			int no = dao.selectWordingCommentNo(conn);
			resultCom = dao.selectWordingCommentOne(conn, no);
		}
		else rollback(conn);
		close(conn);
		return resultCom;
	}
	
	public List<WordingComment> selectWordingCommentList(int no) {
		Connection conn = getConnection();
		List<WordingComment> listCom = dao.selectWordingCommentList(conn, no);
		close(conn);
		return listCom;
	}
	

	public int deleteWording(int no) {
		Connection conn = getConnection();
		int result = dao.deleteManyWordingLike(conn, no);
		result = dao.deleteWordingCom(conn, no);
		result = dao.deleteWordingPic(conn, no);
		if(result>0) {
			result = dao.deleteWordingText(conn, no);
			if(result>0) {
				result = dao.deleteWording(conn, no);
				if(result>0) {
					commit(conn);
				}else rollback(conn);
			}else rollback(conn);
		}else rollback(conn);


		close(conn);
		return result;
	}
	
	public int deleteWordingCom(int no) {
		Connection conn = getConnection();
		int result = dao.deleteWordingComLevTwo(conn, no);
		result = dao.deleteWordingComLevOne(conn, no);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	//마이페이지용
	public List<Wording> selectWordingBoardList(int cPage, int numPerPage, String userId) {
		Connection conn = getConnection();
		List<Wording> list = dao.selectWordingBoardList(conn, cPage, numPerPage, userId);
		close(conn);
		return list;
	}
	//마이페이지용
	public List<WordingPic> selectWordingPicList(String userId) {
		Connection conn = getConnection();
		List<WordingPic> list = dao.selectWordingPicList(conn, userId);
		close(conn);
		return list;
	}
	//마이페이지용
	public List<WordingText> selectWordingTextList(String userId) {
		Connection conn = getConnection();
		List<WordingText> list = dao.selectWordingTextList(conn, userId);
		close(conn);
		return list;

	}
	
	//마이페이지용
	public int selectWordingCount(String userId) {
		Connection conn = getConnection();
		int totalData = dao.selectWordingCount(conn, userId);
		close(conn);
		return totalData;
	}
	
	
	

}
