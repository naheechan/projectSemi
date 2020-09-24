package com.semi.order.model.service;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.close;

import java.sql.Connection;
import java.util.List;

import com.semi.buy.model.vo.Buylist;
import com.semi.cartmodel.vo.Cart;
import com.semi.order.model.dao.OrderDao;
import com.semi.product.model.vo.BooksJoin;
public class OrderSerivce {
	private OrderDao dao=new OrderDao();

	public List<Cart> selectproduct(int userno) {
		Connection conn=getConnection();
		List<Cart>list =dao.selectproduct(conn,userno);
		close(conn);
		return list;
	}

	public void insertorder(Buylist bu, List<Cart> list) {
		Connection conn=getConnection();
		int result=dao.insertorder(conn,bu,list);
		
	}

}
