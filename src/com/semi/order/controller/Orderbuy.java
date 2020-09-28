package com.semi.order.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.buy.model.vo.Buylist;
import com.semi.cartmodel.vo.Cart;
import com.semi.order.model.service.OrderSerivce;

/**
 * Servlet implementation class Orderbuy
 */
@WebServlet("/cart/orderbuy")
public class Orderbuy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Orderbuy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int bookno=Integer.parseInt(request.getParameter("bookno"));
		Buylist bu = bu=new Buylist();
			bu.setTotalprice(Integer.parseInt(request.getParameter("totalprice")));
			bu.setMemberno(Integer.parseInt(request.getParameter("userno")));
			bu.setRecipient(request.getParameter("Recipient"));
			bu.setPostcode(Integer.parseInt(request.getParameter("postcode")));
			bu.setAddress(request.getParameter("address"));
			bu.setExtraaddress(request.getParameter("extraaddress"));
			bu.setRequest(request.getParameter("request"));
			bu.setDetailaddress(request.getParameter("detailaddress"));
			bu.setPhone(request.getParameter("tel"));
			bu.setCount(Integer.parseInt(request.getParameter("count")));
			bu.setBookno(bookno);
			
			int result=new OrderSerivce().insertborder(bu);
			if(result>0) {
				
				request.getRequestDispatcher("/views/order/orderend.jsp").forward(request, response);
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
