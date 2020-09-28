package com.semi.order.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.buy.model.vo.Buylist;
import com.semi.cartmodel.service.CartService;
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
		int userno=Integer.parseInt(request.getParameter("userno"));
		//어떤 책을 구매했는지 cart테이블을 조회해서 가져온다
		List<Cart>list=new OrderSerivce().selectproduct(userno);
		List<Buylist>blist=new ArrayList<Buylist>();
		Buylist bu = null;
		for(Cart ck:list) {
			bu=new Buylist();
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
			bu.setBookno(ck.getBookno());
			blist.add(bu);
		}
		//가져왔으면 그책번호랑 주문정보를 주문테이블에 데이터를 넣는다
		int result=new OrderSerivce().insertorder(blist);
		HttpSession session=request.getSession();
		if(result>0) {
			//여기서 장바구니 비우기를 해줘?
			//장바구니에 담은 책 세션을 주문을 완료하면 지워준다
			//해당회원이 주문을 완료하면 장바구니를 비워주는 로직
			int cleancart=new CartService().cleancart(userno);
			if(cleancart>0) {
				session.removeAttribute("booklist");
				request.getRequestDispatcher("/views/order/orderend.jsp").forward(request, response);
			}
			
		}
		
		

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
