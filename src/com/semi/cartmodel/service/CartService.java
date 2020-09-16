package com.semi.cartmodel.service;

import java.sql.Connection;

import com.semi.cartmodel.dao.CartDao;

import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.close;

public class CartService {
	private CartDao dao=new CartDao();

	public int insertnumber(int no, int userno) {
		Connection conn=getConnection();
		dao.insertnumber(conn,no,userno);
		
		
	}
	

}
