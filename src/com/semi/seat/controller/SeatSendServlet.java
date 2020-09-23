package com.semi.seat.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.seat.model.service.SeatService;
import com.semi.seat.model.vo.Seat;
/**
 * Servlet implementation class SeatSendServlet
 */
@WebServlet("/seatSend")
public class SeatSendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeatSendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Seat seat=new Seat();
		int useTime=Integer.parseInt(request.getParameter("useTime"));
		seat.setMemberNo(Integer.parseInt(request.getParameter("memberNo")));
		seat.setSeatDate(request.getParameter("seatDate"));
		seat.setSeatTime(Integer.parseInt(request.getParameter("seatTime")));
		seat.setUseTime(Integer.parseInt(request.getParameter("useTime")));
		seat.setMemberCount(Integer.parseInt(request.getParameter("memberCount")));
		seat.setSeatNo(request.getParameter("seatInfo"));
		
		System.out.println(seat);
		int result=0;
		
		//사용시간에 따라 데이터 입력
		if(useTime==1) {
			result=new SeatService().insertSeat(seat);
			System.out.println("servlet : "+result);
		}
		if(useTime==2) {
			for(int i=0; i<2; i++) {
				seat.setSeatTime((Integer.parseInt(request.getParameter("seatTime")))+i);
				result=new SeatService().insertSeat(seat);
			}
		}
		if(useTime==3) {
			for(int i=0; i<3; i++) {
				seat.setSeatTime((Integer.parseInt(request.getParameter("seatTime")))+i);
				result=new SeatService().insertSeat(seat);
			}
		}
		if(useTime==4) {
			for(int i=0; i<4; i++) {
				seat.setSeatTime((Integer.parseInt(request.getParameter("seatTime")))+i);
				result=new SeatService().insertSeat(seat);
			}
		}
		if(useTime==5) {
			for(int i=0; i<5; i++) {
				seat.setSeatTime((Integer.parseInt(request.getParameter("seatTime")))+i);
				result=new SeatService().insertSeat(seat);
			}
		}
		if(useTime==6) {
			for(int i=0; i<4; i++) {
				seat.setSeatTime((Integer.parseInt(request.getParameter("seatTime")))+i);
				result=new SeatService().insertSeat(seat);
			}
		}		
		if(useTime==7) {
			for(int i=0; i<4; i++) {
				seat.setSeatTime((Integer.parseInt(request.getParameter("seatTime")))+i);
				result=new SeatService().insertSeat(seat);
			}
		}
		if(useTime==8) {
			for(int i=0; i<4; i++) {
				seat.setSeatTime((Integer.parseInt(request.getParameter("seatTime")))+i);
				result=new SeatService().insertSeat(seat);
			}
		}
		if(useTime==9) {
			for(int i=0; i<4; i++) {
				seat.setSeatTime((Integer.parseInt(request.getParameter("seatTime")))+i);
				result=new SeatService().insertSeat(seat);
			}
		}
		String msg="";
		String loc="/";
		if(result>0&&result>0) {
			msg="좌석 예약 성공";
			loc="/seatMove";
		}else {
			msg="다시 선택해주세요.";
			loc="/seatMove";
		}
		
		request.setAttribute("msg",msg);
		request.setAttribute("loc", loc);
		
		request.getRequestDispatcher("/views/common/msg.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
