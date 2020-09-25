package com.semi.myinfo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.buy.model.vo.Buylist;
import com.semi.buy.model.vo.BuylistJoin;
import com.semi.myinfo.model.servlce.MyinfoService;





/**
 * Servlet implementation class BuyListServlet
 */
@WebServlet("/myinfo/buylist")
public class BuyListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//주문내역 클릭시 주문한 내역을 출력해준다
		int userno=Integer.parseInt(request.getParameter("userno"));
		List<BuylistJoin>list=new MyinfoService().selectbuylist(userno);
		request.setAttribute("buylist", list);
		request.getRequestDispatcher("/views/myinfo/orderlist.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
