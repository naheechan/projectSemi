package com.semi.cartmodel.service;

import java.sql.Connection;

import com.semi.cartmodel.dao.CartDao;

import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.rollback;

public class CartService {
	private CartDao dao=new CartDao();

	public int insertnumber(int no, int userno) {
		Connection conn=getConnection();
		int result=dao.insertnumber(conn,no,userno);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
		
		
	}
	

}
