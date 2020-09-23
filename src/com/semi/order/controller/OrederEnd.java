package com.semi.order.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.buy.model.vo.Buylist;
import com.semi.cartmodel.vo.Cart;
import com.semi.order.model.service.OrderSerivce;
import com.semi.product.model.vo.BooksJoin;



/**
 * Servlet implementation class OrederEnd
 */
@WebServlet("/cart/orderend")
public class OrederEnd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrederEnd() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Buylist bu = new Buylist();
		bu.setTotalprice(Integer.parseInt(request.getParameter("totalprice")));
		bu.setMemberno(Integer.parseInt(request.getParameter("userno")));
		bu.setRecipient(request.getParameter("Recipient"));
		bu.setPostcode(Integer.parseInt(request.getParameter("postcode")));
		bu.setAddress(request.getParameter("address"));
		bu.setExtraaddress(request.getParameter("extraaddress"));
		bu.setDetailaddress(request.getParameter("detailaddress"));
		bu.setPhone(request.getParameter("tel"));
		System.out.println(bu);
		List<Cart>list=new OrderSerivce().selectproduct(bu);
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
