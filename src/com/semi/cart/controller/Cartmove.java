package com.semi.cart.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.semi.cartmodel.service.CartService;
import com.semi.cartmodel.vo.Cart;
import com.semi.product.model.vo.Books;

import oracle.net.aso.s;

/**
 * Servlet implementation class Cartmove
 */
@WebServlet("/cart/cartmove")
public class Cartmove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cartmove() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//여기서 장바구니에 있는 데이터를 뽑아서 리스트에 넣고 jsp에 보낸다 보낼때 세션으로 보낸다
		//1.db에서 회원아이디와 책번호를 뽑는다
		System.out.println("장바구니로이동하기");
		int userno=Integer.parseInt(request.getParameter("userno"));
		List<Cart>cartlist=new CartService().selectno(userno);
		List<Books>booklist=new CartService().selectbook(userno);
	
		//로그인한 아이디번호로 장바구니에 담은 책 번호를 가져온다
		//가져온 책번호 분기문 처리 만약 책 번호가 동일 하다가면 수량을 1증가시켜라
		//데이터를 불러왔을 때 세션으로 담아서 전송
		HttpSession session=request.getSession();
	/*	if(session.getAttribute("productList")==null) {
			booklist=new ArrayList<Books>();
			session.setAttribute("booklist", booklist);
		}else {
			session.setAttribute("booklist", booklist);
		}*/
		session.setAttribute("booklist", booklist);
	
		request.getRequestDispatcher("/views/cart/cart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
