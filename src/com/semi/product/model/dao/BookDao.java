package com.semi.product.model.dao;


import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static com.semi.common.JDBCTemplate.close;


import com.semi.product.model.vo.Books;
import com.semi.product.model.vo.Category;



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
				for(Books bs:list) {
					System.out.println(bs);
				}
				
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
				System.out.println("값이 왜 리스트에 안들어가지");
				for(Books bs:list) {
					System.out.println(bs);
				}
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
	

}
