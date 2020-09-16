package com.semi.product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.product.model.service.BookService;
import com.semi.product.model.vo.Books;

/**
 * Servlet implementation class ProductMainServlet
 */
@WebServlet("/product/productmain")
public class ProductMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductMainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Books> list=new BookService().selectBook();
		if(!list.isEmpty()) {
			System.out.println("값이 있음");
			request.setAttribute("list", list);
			request.getRequestDispatcher("/views/product/product.jsp").forward(request, response);
		}else{
			System.out.println("값이 없음");
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
