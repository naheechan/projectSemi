package com.semi.product.model.service;

import java.sql.Connection;
import java.util.List;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.close;

import com.semi.product.model.dao.BookDao;
import com.semi.product.model.vo.Books;
import com.semi.product.model.vo.Category;

public class BookService {
	private BookDao dao=new BookDao();

	public List<Books> selectBook(int cPage, int numPerPage) {
		Connection conn=getConnection();
		List<Books>list=dao.selectBook(conn,cPage,numPerPage);
		close(conn);
		return list;
	}

	public Books addcartselect(int no) {
		Connection conn=getConnection();
		Books bk=dao.addcartselect(conn,no);
		close(conn);
		return bk;
		
		
	}

	public int selectBookCount() {
		Connection conn=getConnection();
		int count=dao.selectBookCount(conn);
		close(conn);
		return count;
	}

	public List<Books> searchkey(int cPage, int numPerPage, String type, String keyword) {
		Connection conn=getConnection();
		List<Books> list=dao.searchbook(conn,cPage,numPerPage,type,keyword);
		close(conn);
		return list;
	}

	public int selectBooksearchCount(String type, String keyword) {
		Connection conn=getConnection();
		int result=dao.selectsearchbook(conn,type,keyword);
		close(conn);
		return result;
	}

	public List<Books> categorylist(int cPage,int numPerPage,Category ca) {
		Connection conn=getConnection();
		System.out.println(ca+":"+numPerPage+":"+cPage);
		List<Books> list =dao.categorylist(conn,cPage,numPerPage,ca);
		close(conn);
		System.out.println("실행테스트");
		return list;
	}

	public List<Books> categoryAlllist(int cPage, int numPerPage) {
		Connection conn=getConnection();
		List<Books> list =dao.categoryAlllist(conn,cPage,numPerPage);
		close(conn);
		return list;
	}

	public int selectcateBookCount(Category ca) {
		Connection conn=getConnection();
		int count=dao.selectcateBookCount(conn,ca);
		close(conn);
		return count;
	}

	
	

	

}
