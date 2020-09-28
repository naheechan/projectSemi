package com.semi.product.model.dao;


import static com.semi.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.semi.product.model.vo.BookComView;
import com.semi.product.model.vo.BookDetailView;
import com.semi.product.model.vo.Books;
import com.semi.product.model.vo.BuyerView;
import com.semi.product.model.vo.Category;
import com.semi.product.model.vo.StarView;



public class BookDao {
	public BookDao() {
		//기본생성자로 프로퍼티스 설정하기
		try {
			String path=BookDao.class.getResource("/sql/product/product_sql.properties").getPath();
			prop.load(new FileReader(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private Properties prop=new Properties();
	public List<Books> selectBook(Connection conn, int cPage, int numPerPage) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Books> list=new ArrayList<Books>();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectbook"));
			pstmt.setInt(1, (cPage-1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Books bk=new Books();
				bk.setBookNo(rs.getInt("book_no"));
				bk.setTitle(rs.getString("book_title"));
				bk.setAuthor(rs.getString("book_author"));
				bk.setPrice(rs.getInt("book_price"));
				bk.setBookimg(rs.getString("book_img"));
				bk.setPublisher(rs.getString("book_publisher"));
				bk.setPublicationdate(rs.getDate("book_publicationdate"));
				bk.setCategoryno(rs.getInt("category_no"));
				list.add(bk);		
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	/*public Books addcartselect(Connection conn, int no) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Books bk=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("addcartselect"));
			pstmt.setInt(1,no);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				bk=new Books();
				bk.setBookNo(rs.getInt("book_no"));
				bk.setTitle(rs.getString("book_title"));
				bk.setAuthor(rs.getString("book_author"));
				bk.setPrice(rs.getInt("book_price"));
				bk.setBookimg(rs.getString("book_img"));
				bk.setPublisher(rs.getString("book_publisher"));
				bk.setPublicationdate(rs.getDate("book_publicationdate"));
				bk.setCategoryno(rs.getInt("category_no"));
				
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return bk;
	}*/
	public int selectBookCount(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectcount"));
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result=rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return result;
	}
	public List<Books> searchbook(Connection conn, int cPage, int numPerPage, String type, String keyword) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Books>list =new ArrayList<Books>();
		Books bk=null;
		try {
			String sql=prop.getProperty("searchkeypage");
			pstmt=conn.prepareStatement(sql.replace("$type",type ));
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, (cPage-1)*numPerPage+1);
			pstmt.setInt(3, cPage*numPerPage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				bk=new Books();
				bk.setBookNo(rs.getInt("book_no"));
				bk.setTitle(rs.getString("book_title"));
				bk.setAuthor(rs.getString("book_author"));
				bk.setPrice(rs.getInt("book_price"));
				bk.setBookimg(rs.getString("book_img"));
				bk.setPublisher(rs.getString("book_publisher"));
				bk.setPublicationdate(rs.getDate("book_publicationdate"));
				bk.setCategoryno(rs.getInt("category_no"));
				list.add(bk);
				
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	public int selectsearchbook(Connection conn, String type, String keyword) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int countpage=0;
		try {
			String sql=prop.getProperty("searchbookcount");
			pstmt=conn.prepareStatement(sql.replace("$type", type));
			pstmt.setString(1, "%"+keyword+"%");
			rs=pstmt.executeQuery();
			if(rs.next()) {
				countpage=rs.getInt(1);
			}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return countpage;
	}
	public List<Books> categorylist(Connection conn,int cPage,int numPerPage, Category ca) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Books>list=new ArrayList<Books>();
		System.out.println("실행테스트");
		Books bk=null;
		System.out.println(ca+":"+cPage+":"+numPerPage);
		try {
			pstmt=conn.prepareStatement(prop.getProperty("categoryList"));
			pstmt.setInt(1, ca.getCategoryno());
			pstmt.setInt(2, (cPage-1)*numPerPage+1);
			pstmt.setInt(3, cPage*numPerPage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				bk=new Books();
				bk.setBookNo(rs.getInt("book_no"));
				bk.setTitle(rs.getString("book_title"));
				bk.setAuthor(rs.getString("book_author"));
				bk.setPrice(rs.getInt("book_price"));
				bk.setBookimg(rs.getString("book_img"));
				bk.setPublisher(rs.getString("book_publisher"));
				bk.setPublicationdate(rs.getDate("book_publicationdate"));
				bk.setCategoryno(rs.getInt("category_no"));
				list.add(bk);
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	public List<Books> categoryAlllist(Connection conn, int cPage, int numPerPage) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Books>list=new ArrayList<Books>();
		Books bk=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("categorylistAll"));
			pstmt.setInt(1, (cPage-1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				bk=new Books();
				bk.setBookNo(rs.getInt("book_no"));
				bk.setTitle(rs.getString("book_title"));
				bk.setAuthor(rs.getString("book_author"));
				bk.setPrice(rs.getInt("book_price"));
				bk.setBookimg(rs.getString("book_img"));
				bk.setPublisher(rs.getString("book_publisher"));
				bk.setPublicationdate(rs.getDate("book_publicationdate"));
				bk.setCategoryno(rs.getInt("category_no"));
				list.add(bk);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public int selectcateBookCount(Connection conn, Category ca) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectcatecount"));
			pstmt.setInt(1, ca.getCategoryno());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result=rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return result;
	}
	
	
	public BookDetailView selectBookDetail(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BookDetailView bv = null;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectBookDetail"));
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bv = new BookDetailView();
				bv.setBookNo(rs.getInt("book_no"));
				bv.setBookTitle(rs.getString("book_title"));
				bv.setBookAuthor(rs.getString("book_author"));
				bv.setBookPrice(rs.getInt("book_price"));
				bv.setBookImg(rs.getString("book_img"));
				bv.setBookPublisher(rs.getString("book_publisher"));
				bv.setBookPublicationdate(rs.getDate("book_publicationdate"));
				bv.setCategoryNo(rs.getInt("category_no"));
				bv.setBookintro(rs.getString("bookintro"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return bv;
	}
	
	public StarView selectStarView(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StarView star = null;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectStarView"));
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				star = new StarView();
				star.setOneStar(rs.getInt("one_star"));
				star.setTwoStar(rs.getInt("two_star"));
				star.setThreeStar(rs.getInt("three_star"));
				star.setFourStar(rs.getInt("four_star"));
				star.setFiveStar(rs.getInt("five_star"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return star;
	}
	
	
	public List<BuyerView> selectBuyerView(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BuyerView> buyerList = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectBuyerView"));
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BuyerView b = new BuyerView();
				b.setGender(rs.getString("gender"));
				b.setAge(rs.getInt("age"));
				buyerList.add(b);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return buyerList;
	}
	
	
	public List<BookComView> selectBookComment(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BookComView> comList = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectBookComment"));
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BookComView com = new BookComView();
				com.setBookNo(rs.getInt("book_no"));
				com.setMemberNo(rs.getInt("member_no"));
				com.setCom(rs.getString("com"));
				com.setComDate(rs.getDate("com_date"));
				com.setMemberId(rs.getString("member_id"));
				com.setScore(rs.getInt("score"));
				comList.add(com);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return comList;
	}
	
	public int insertStar(Connection conn, int mNo, int bNo, int score) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("insertStar"));
			pstmt.setInt(1, bNo);
			pstmt.setInt(2, mNo);
			pstmt.setInt(3, score);
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int insertBookCom(Connection conn, int mNo, int bNo, String com) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("insertBookCom"));
			pstmt.setInt(1, bNo);
			pstmt.setInt(2, mNo);
			pstmt.setString(3, com);
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int updateStar(Connection conn, int mNo, int bNo, int score) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("updateStar"));
			pstmt.setInt(1, score);
			pstmt.setInt(2, bNo);
			pstmt.setInt(3, mNo);
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int updateBookCom(Connection conn, int mNo, int bNo, String com) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("updateBookCom"));
			pstmt.setString(1, com);
			pstmt.setInt(2, bNo);
			pstmt.setInt(3, mNo);
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	
	
	public int deleteStar(Connection conn, int mNo, int bNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("deleteStar"));
			pstmt.setInt(1, bNo);
			pstmt.setInt(2, mNo);
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	
	public int deleteBookCom(Connection conn, int mNo, int bNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("deleteBookCom"));
			pstmt.setInt(1, bNo);
			pstmt.setInt(2, mNo);
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	public Books selectBookbuy(Connection conn, int no) {
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	Books bk=null;
	try {
		pstmt=conn.prepareStatement(prop.getProperty("selectbuynow"));
		pstmt.setInt(1, no);
		rs=pstmt.executeQuery();
		if(rs.next()) {
			bk=new Books();
			bk.setBookNo(rs.getInt("book_no"));
			bk.setTitle(rs.getString("book_title"));
			bk.setAuthor(rs.getString("book_author"));
			bk.setPrice(rs.getInt("book_price"));
			bk.setBookimg(rs.getString("book_img"));
			bk.setPublisher(rs.getString("book_publisher"));
			bk.setPublicationdate(rs.getDate("book_publicationdate"));
			bk.setCategoryno(rs.getInt("category_no"));
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		close(pstmt);
		close(rs);
	}
		return bk;
	}
	
	
	
	
	
	
	

}
