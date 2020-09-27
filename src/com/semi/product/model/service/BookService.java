package com.semi.product.model.service;

import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.semi.product.model.dao.BookDao;
import com.semi.product.model.vo.BookComView;
import com.semi.product.model.vo.BookDetailView;
import com.semi.product.model.vo.Books;
import com.semi.product.model.vo.BuyerView;
import com.semi.product.model.vo.Category;
import com.semi.product.model.vo.StarView;

public class BookService {
	private BookDao dao=new BookDao();

	public List<Books> selectBook(int cPage, int numPerPage) {
		Connection conn=getConnection();
		List<Books>list=dao.selectBook(conn,cPage,numPerPage);
		close(conn);
		return list;
	}

	/*public Books addcartselect(int no) {
		Connection conn=getConnection();
		Books bk=dao.addcartselect(conn,no);
		close(conn);
		return bk;
		
		
	}*/

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

	public BookDetailView selectBookDetail(int no) {
		Connection conn = getConnection();
		BookDetailView bv = dao.selectBookDetail(conn, no);
		close(conn);
		return bv;
	}
	
	public StarView selectStarView(int no) {
		Connection conn = getConnection();
		StarView star = dao.selectStarView(conn, no);
		close(conn);
		return star;
	}
	
	public List<BuyerView> selectBuyerView(int no) {
		Connection conn = getConnection();
		List<BuyerView> buyerList = dao.selectBuyerView(conn, no);
		close(conn);
		return buyerList;
	}

	
	public List<BookComView> selectBookComment(int no) {
		Connection conn = getConnection();
		List<BookComView> comList = dao.selectBookComment(conn, no);
		close(conn);
		return comList;
	}
	
	public int insertStarAndCom(int mNo, int bNo, int score, String com) {
		Connection conn = getConnection();
		int result = dao.insertStar(conn, mNo, bNo, score);
		if(result>0) {
			result = dao.insertBookCom(conn, mNo, bNo, com);
			if(result>0) commit(conn);
			else rollback(conn);
		}else rollback(conn);
		close(conn);
		return result;
	}
	
	public int updateStarAndCom(int mNo, int bNo, int score, String com) {
		Connection conn = getConnection();
		int result = dao.updateStar(conn, mNo, bNo, score);
		if(result>0) {
			result = dao.updateBookCom(conn, mNo, bNo, com);
			if(result>0) commit(conn);
			else rollback(conn);
		}else rollback(conn);
		close(conn);
		return result;
	}
	
	
	
	public int deleteStarAndCom(int mNo, int bNo) {
		Connection conn = getConnection();
		int result = dao.deleteStar(conn, mNo, bNo);
		if(result>0) {
			result = dao.deleteBookCom(conn, mNo, bNo);
			if(result>0) commit(conn);
			else rollback(conn);
		}else rollback(conn);
		close(conn);
		return result;
	}
	
	
	
	
	
	

}
