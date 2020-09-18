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
		System.out.println("장바구니 담기 테스트");
		//제품번호화 사용자 번호를 가져와서 장바구니 테이블에 담기
		int no=Integer.parseInt(request.getParameter("cproductno"));
		int userno=Integer.parseInt(request.getParameter("memberno"));
		Books bk=new BookService().addcartselect(no);
		System.out.println(userno);
		System.out.println(bk);
		int result=new CartService().insertnumber(no,userno);
		if(result>0) {
			System.out.println("장바구니에 값이 추가");
		}
		HttpSession session=request.getSession();
		List<Books> clist=null;
		if(session.getAttribute("productList")==null) {
			 clist=new ArrayList<Books>();
		}
		clist.add(bk);
		session.setAttribute("clist", clist);
		request.getRequestDispatcher("/views/cart/cartck.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
