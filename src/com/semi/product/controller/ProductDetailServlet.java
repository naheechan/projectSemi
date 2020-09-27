package com.semi.product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.product.model.service.BookService;
import com.semi.product.model.vo.BookComView;
import com.semi.product.model.vo.BookDetailView;
import com.semi.product.model.vo.BuyerView;
import com.semi.product.model.vo.StarView;

/**
 * Servlet implementation class ProductDetailServlet
 */
@WebServlet("/product/productDetail")
public class ProductDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		BookDetailView bookdetail = new BookService().selectBookDetail(no);
		
		if(bookdetail!=null) {
			StarView star = new BookService().selectStarView(no); //null나와도 되는애임
			List<BuyerView> buyerList = new BookService().selectBuyerView(no); //.size() 0 나와도 되는애임
			List<BookComView> comList = new BookService().selectBookComment(no); //.size() 0 나와도 되는애임
			
			request.setAttribute("bookdetail", bookdetail);
			request.setAttribute("star", star);
			request.setAttribute("buyerList", buyerList);
			request.setAttribute("comList", comList);
			
			request.getRequestDispatcher("/views/product/productDetail.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "잘못된 접근입니다.");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
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
