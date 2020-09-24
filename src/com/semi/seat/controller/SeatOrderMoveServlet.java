package com.semi.seat.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.seat.model.vo.Seat;

/**
 * Servlet implementation class SeatOrderServlet
 */
@WebServlet("/seatOrderMove")
public class SeatOrderMoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeatOrderMoveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 결제 페이지로 이동
		String MemberName=request.getParameter("memberName1");
		String Email=request.getParameter("email");
		Seat seat=new Seat();
		seat.setMemberNo(Integer.parseInt(request.getParameter("memberNo1")));
		seat.setSeatDate(request.getParameter("seatDate1"));
		seat.setSeatTime(Integer.parseInt(request.getParameter("seatTime1")));
		seat.setUseTime(Integer.parseInt(request.getParameter("useTime1")));
		seat.setMemberCount(Integer.parseInt(request.getParameter("memberCount1")));
		seat.setSeatNo(request.getParameter("seatInfo1"));
		seat.setSeatPrice(Integer.parseInt(request.getParameter("seatPrice1")));
		
		request.setAttribute("seat",seat);
		request.setAttribute("MemberName",MemberName);
		request.setAttribute("Email",Email);
		System.out.println(seat);
		System.out.println(MemberName);
		RequestDispatcher rd=request.getRequestDispatcher("/views/order/seatPay.jsp");
		rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
