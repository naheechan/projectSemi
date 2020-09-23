package com.semi.seat.controller;

import java.io.IOException;



import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.seat.model.service.SeatService;
import com.semi.seat.model.vo.Seat;
/**
 * Servlet implementation class SeatGetServlet
 */
@WebServlet("/seatGet")
public class SeatGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeatGetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("좌석을 가져오라고 요청 받음");

		
		int memberNo=Integer.parseInt(request.getParameter("memberNo"));
		System.out.println("service : "+memberNo);
		String seatDate=request.getParameter("seatDate");
		System.out.println("service : "+seatDate);
		int seatTime=Integer.parseInt(request.getParameter("seatTime"));
		int useTime=Integer.parseInt(request.getParameter("useTime"));
		int memberCount=Integer.parseInt(request.getParameter("memberCount"));
		
		List<Seat> list=new SeatService().SelectSeat(seatDate, seatTime);
		System.out.println();
		System.out.println("servlet : "+list);
		
		if(list!=null) {
			//해당 날짜, 시간에 값이 있는 경우 (해당 날짜, 시간에 해당하는 좌석은 데이터를 옮겨 좌석 선택 불가하도록 해야함)
			request.setAttribute("list", list);
			request.setAttribute("seatDate", seatDate);
			request.setAttribute("seatTime", seatTime);
			request.setAttribute("useTime", useTime);
			request.setAttribute("memberCount", memberCount);
			request.getRequestDispatcher("/views/seat/studyroomMap.jsp")
			.forward(request,response);
		}
		if(list==null) {
			//해당 날짜, 시간에 값이 없는 경우 (모든 좌석 가져오기)
			request.setAttribute("seatDate", seatDate);
			request.setAttribute("seatTime", seatTime);
			request.setAttribute("useTime", useTime);
			request.setAttribute("memberCount", memberCount);
			request.getRequestDispatcher("/views/seat/studyroomMap.jsp")
			.forward(request,response);
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
