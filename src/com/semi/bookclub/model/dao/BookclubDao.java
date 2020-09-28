package com.semi.bookclub.model.dao;

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

import com.semi.bookclub.model.vo.Bookclub;
import com.semi.bookclub.model.vo.BookclubParti;
import com.semi.bookclub.model.vo.BookclubPartiView;
import com.semi.bookclub.model.vo.BookclubView;
import com.semi.wording.model.dao.WordingDao;
import com.semi.myinfo.model.vo.MyBookclub;

public class BookclubDao {
	
	private Properties prop = new Properties();
	
	public BookclubDao() {
		try {
			String fileName = WordingDao.class.getResource("/sql/bookclub/bookclub_sql.properties").getPath();
			prop.load(new FileReader(fileName));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public Map<String,String> selectSearchBook(Connection conn, String key) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String,String> mapBook = new HashMap<>();
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectSearchBook"));
			pstmt.setString(1, "%"+key+"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				mapBook.put(rs.getString("book_title"), rs.getString("book_img"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}	
		return mapBook;
		
	}
	
	
	public Map<Integer,String> selectSearchBookImg(Connection conn, String key) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<Integer,String> mapBook = new HashMap<>();
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectSearchBookImg"));
			pstmt.setString(1, key);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				mapBook.put(rs.getInt("book_no"), rs.getString("book_img"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}	
		return mapBook;
		
	}
	
	public int insertBookclub(Connection conn, Bookclub bc) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("insertBookclub"));
			pstmt.setString(1, bc.getBookclubTitle());
			pstmt.setString(2, bc.getBookclubImg());
			pstmt.setInt(3, bc.getMaxPerson());
			pstmt.setString(4, bc.getWriter());
			pstmt.setInt(5, bc.getMemberNo());
			pstmt.setInt(6, bc.getBookNo());
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}	
		return result;
	}
	
	
	public int selectBookclubCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int totalData = 0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectBookclubCount"));
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
	
	
	public List<BookclubView> selectBookclubList(Connection conn, int cPage, int numPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BookclubView> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectBookclubList"));
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
	
	private BookclubView inputData(ResultSet rs) throws SQLException {
		BookclubView bc = new BookclubView();
		bc.setBookclubNo(rs.getInt("bookclub_no"));
		bc.setBookclubTitle(rs.getString("bookclub_title"));
		bc.setBookclubImg(rs.getString("bookclub_img"));
		bc.setMaxPerson(rs.getInt("max_person"));
		bc.setBookclubDate(rs.getDate("bookclub_date"));
		bc.setDeleteBookclub(rs.getInt("delete_bookclub"));
		bc.setWriter(rs.getString("writer"));
		bc.setMemberNo(rs.getInt("member_no"));
		bc.setBookNo(rs.getInt("book_no"));
		bc.setGender(rs.getString("gender"));
		
		return bc;
	}
	
	
	
	public int insertBookclubJoin(Connection conn, BookclubParti bp) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("insertBookclubJoin"));
			pstmt.setString(1, bp.getPartiId());
			pstmt.setInt(2, bp.getMemberNo());
			pstmt.setInt(3, bp.getBookclubNo());
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}	
		return result;
	}
	
	
	public List<BookclubPartiView> selectBookclubPartiViewList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BookclubPartiView> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectBookclubPartiViewList"));
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BookclubPartiView pv = new BookclubPartiView();
				pv.setBookclubNo(rs.getInt("bookclub_no"));
				pv.setMemberId(rs.getString("member_id"));
				pv.setGender(rs.getString("gender"));
				list.add(pv);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}	
		return list;
	}
	
	
	
	public Map<Integer,Integer> selectPartiCnt(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<Integer,Integer> mapPartiCnt = new HashMap<>();
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectPartiCnt"));
			rs = pstmt.executeQuery();
			while(rs.next()) {
				mapPartiCnt.put(rs.getInt(1), rs.getInt(2));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}	
		return mapPartiCnt;
	}
	
	
	public int deleteBookclubJoin(Connection conn, BookclubParti bp) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("deleteBookclubJoin"));
			pstmt.setInt(1, bp.getMemberNo());
			pstmt.setInt(2, bp.getBookclubNo());
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}	
		return result;
	}
	
	
	
	public int deleteBookclub(Connection conn, int no) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("deleteBookclub"));
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}	
		return result;
	}
	//마이페이지
	public int selectBookclubCount(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int totalData = 0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("myselectBookclubCount"));
			pstmt.setString(1, memberId);
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
	
	//마이페이지
	
	public List<MyBookclub> MyBookclubList(Connection conn, int cPage, int numPerPage, String memberId){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MyBookclub> list = new ArrayList();
		try {
			pstmt = conn.prepareStatement(prop.getProperty("myBookclubList"));
			pstmt.setString(1, memberId);
			pstmt.setInt(2, (cPage-1)*numPerPage+1);
			pstmt.setInt(3, cPage*numPerPage);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MyBookclub mbc=new MyBookclub();
				mbc.setPartiId(rs.getString("parti_id"));
				mbc.setBookclubNo(rs.getInt("bookclub_no"));
				mbc.setBookclubTitle(rs.getNString("bookclub_title"));
				mbc.setBookclubImg(rs.getString("bookclub_img"));
				mbc.setMaxPerson(rs.getInt("max_person"));
				mbc.setBookclubDate(rs.getDate("bookclub_date"));
				mbc.setDeleteBookclub(rs.getInt("delete_bookclub"));
				mbc.setWriter(rs.getString("writer"));
				mbc.setMemberNo(rs.getInt("member_no"));
				mbc.setBookNo(rs.getInt("book_no"));
				mbc.setBookTitle(rs.getString("book_title"));
				mbc.setBookAuthor(rs.getNString("book_author"));
				list.add(mbc);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}	
		System.out.println(list);
		return list;
	}
	
	//마이페이지
	public List<MyBookclub> MyBookclubListParti(Connection conn, int cPage, int numPerPage, String memberId){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MyBookclub> list = new ArrayList();
		try {
			pstmt = conn.prepareStatement(prop.getProperty("MyBookclubListParti"));
			pstmt.setString(1, memberId);
			pstmt.setInt(2, (cPage-1)*numPerPage+1);
			pstmt.setInt(3, cPage*numPerPage);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MyBookclub mbc=new MyBookclub();
				mbc.setPartiId(rs.getString("parti_id"));
				mbc.setBookclubNo(rs.getInt("bookclub_no"));
				mbc.setBookclubTitle(rs.getNString("bookclub_title"));
				mbc.setBookclubImg(rs.getString("bookclub_img"));
				mbc.setMaxPerson(rs.getInt("max_person"));
				mbc.setBookclubDate(rs.getDate("bookclub_date"));
				mbc.setDeleteBookclub(rs.getInt("delete_bookclub"));
				mbc.setWriter(rs.getString("writer"));
				mbc.setMemberNo(rs.getInt("member_no"));
				mbc.setBookNo(rs.getInt("book_no"));
				mbc.setBookTitle(rs.getString("book_title"));
				mbc.setBookAuthor(rs.getNString("book_author"));
				list.add(mbc);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}	
		System.out.println(list);
		return list;
	}
}
