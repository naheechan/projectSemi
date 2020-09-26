package com.semi.bookclub.model.service;

import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.semi.bookclub.model.dao.BookclubDao;
import com.semi.bookclub.model.vo.Bookclub;
import com.semi.bookclub.model.vo.BookclubParti;
import com.semi.bookclub.model.vo.BookclubPartiView;
import com.semi.bookclub.model.vo.BookclubView;

public class BookclubService {
	
	private BookclubDao dao = new BookclubDao();
	
	public Map<String,String> selectSearchBook(String key) {
		Connection conn = getConnection();
		Map<String,String> mapBook = dao.selectSearchBook(conn, key);
		close(conn);
		return mapBook;
	}
	
	public Map<Integer,String> selectSearchBookImg(String key) {
		Connection conn = getConnection();
		Map<Integer,String> mapBook = dao.selectSearchBookImg(conn, key);
		close(conn);
		return mapBook;
	}

	
	public int insertBookclub(Bookclub bc) {
		Connection conn = getConnection();
		int result = dao.insertBookclub(conn, bc);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public int selectBookclubCount() {
		Connection conn = getConnection();
		int totalData = dao.selectBookclubCount(conn);
		close(conn);
		return totalData;
	}
	
	public List<BookclubView> selectBookclubList(int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<BookclubView> list = dao.selectBookclubList(conn, cPage, numPerPage);
		close(conn);
		return list;
	}
	
	
	public int insertBookclubJoin(BookclubParti bp) {
		Connection conn = getConnection();
		int result = dao.insertBookclubJoin(conn, bp);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	

	
	public List<BookclubPartiView> selectBookclubPartiViewList() {
		Connection conn = getConnection();
		List<BookclubPartiView> list = dao.selectBookclubPartiViewList(conn);
		close(conn);
		return list;
	}
	
	
	public Map<Integer,Integer> selectPartiCnt() {
		Connection conn = getConnection();
		Map<Integer,Integer> mapPartiCnt = dao.selectPartiCnt(conn);
		close(conn);
		return mapPartiCnt;
	}
	
	public int deleteBookclubJoin(BookclubParti bp) {
		Connection conn = getConnection();
		int result = dao.deleteBookclubJoin(conn, bp);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	
	public int deleteBookclub(int no) {
		Connection conn = getConnection();
		int result = dao.deleteBookclub(conn, no);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	
	
	
	
}
