package com.semi.product.model.service;

import java.sql.Connection;
import java.util.List;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.close;

import com.semi.product.model.dao.BookDao;
import com.semi.product.model.vo.Books;

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

}
