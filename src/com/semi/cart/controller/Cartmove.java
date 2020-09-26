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
import com.semi.product.model.vo.BooksJoin;

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

		//분기처리 해야할듯 세션을 한번만 실행해야 하도록
		if(request.getParameter("userno")!=null) {
			//회원이 로그인을 한다면 그회원이 가지고있는 장바구니테이블을 보여준다
			int userno=Integer.parseInt(request.getParameter("userno"));
			HttpSession session=request.getSession();
			List<BooksJoin>booklist=new CartService().selectbook(userno);
			session.setAttribute("booklist",booklist );
			request.getRequestDispatcher("/views/cart/cart.jsp").forward(request, response);
		}
		else {
			//아니면 설정한 세션을 그대로 출력해주는 로직
			request.getRequestDispatcher("/views/cart/cart.jsp").forward(request, response);
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
