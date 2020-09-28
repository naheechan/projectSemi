package com.semi.order.model.service;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.close;

import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.rollback;

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

	public int insertorder(List<Buylist> blist) {
		Connection conn=getConnection();
		int result=dao.insertorder(conn, blist);
		if(result>0)commit(conn);
		else rollback(conn);
		close(conn);
		return result;
		
	}

	public int insertborder(Buylist bu) {
		// TODO Auto-generated method stub
		Connection conn=getConnection();
		int result=dao.insertorder(conn, bu);
		if(result>0)commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	

}
