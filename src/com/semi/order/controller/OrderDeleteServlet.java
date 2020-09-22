package com.semi.order.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.cartmodel.service.CartService;

/**
 * Servlet implementation class OrderDeleteServlet
 */
@WebServlet("/cart/orderdel")
public class OrderDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("주문삭제 눌림");
		String msg="";
		String loc="";
		String[]scheck=request.getParameterValues("dele");
		
		int check[]=new int[scheck.length];
		for(int i=0;i<check.length;i++) {
			check[i]=Integer.parseInt(scheck[i]);
			System.out.println(check[i]);
		}
		int result=new CartService().deletecart(check);
		if(result>0) {
			msg="정상적으로 삭제 되었습니다";
			loc="/";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
