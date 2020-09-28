package com.semi.notice.model.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.notice.model.service.NoticeService;
import com.semi.notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeUpdeteServlet
 */
@WebServlet("/notice/noticeUpdete")
public class NoticeUpdeteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdeteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Notice n= new Notice();
		n.setNoticeTitle(request.getParameter("noticeTitle"));
		n.setNoticeWriter(request.getParameter("noticeWriter"));
		n.setFilepath(request.getParameter("filepath"));
		n.setNoticeContent(request.getParameter("noticeContent"));
		int result=new NoticeService().noticeUpdate(n);
		String msg="";
		String loc="/";
		if(result>0) {
			msg="성공적으로 수정되었습니다.";
			loc="/notice/noticeList=";
		}else{
			msg="수정에 실패하였습니다";
			
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
