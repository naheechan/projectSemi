package com.semi.product.controller;

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
import com.semi.product.model.service.BookService;
import com.semi.product.model.vo.Books;
import com.semi.product.model.vo.BooksJoin;

/**
 * Servlet implementation class CheckcartServlet
 */
@WebServlet("/product/checkcart")
public class CheckcartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /** 
     * @see HttpServlet#HttpServlet()
     */
    public CheckcartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//세션으로 장바구니 처리계속 남아있어야해서
		//제품번호화 사용자 번호를 가져와서 장바구니 테이블에 담기
		//장바구니에 담는 서블릿
		int no=Integer.parseInt(request.getParameter("cproductno"));
		int userno=Integer.parseInt(request.getParameter("memberno"));
		int count=0;
		if(request.getParameter("count") != null) {
		 count=Integer.parseInt(request.getParameter("count"));
		}else {
			//없으면 오라클 기본값 1부여해서 넣기
			count=1;	
		}
		//해당책번호를 불러와서 그 책번호에 대한 정보를 books객체에 저장한다
		int result=new CartService().insertnumber(no,userno,count);
		//책번호 유저번호와 수량을 받아서 cart테이블에 값을 넣는다
		//값을 생성 유저번호를 통해서 어떤 책이 들어있는지 확인
		List<BooksJoin>booklist=new CartService().selectbook(userno);
		HttpSession session=request.getSession();
		if(result>0) {
			session.setAttribute("booklist", booklist);
			request.setAttribute("userno", userno);
			request.getRequestDispatcher("/views/cart/cartck.jsp").forward(request, response);
		}
		
	
//		session.setAttribute("productList", clist);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
