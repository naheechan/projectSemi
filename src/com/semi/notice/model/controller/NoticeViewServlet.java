package com.semi.notice.model.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.notice.model.service.NoticeService;
import com.semi.notice.model.vo.Notice;
import com.semi.notice.model.vo.NoticeComment;

/**
 * Servlet implementation class NoticeViewServlet
 */
@WebServlet("/notice/noticeView")
public class NoticeViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
       
        int no=Integer.parseInt(request.getParameter("no"));
		/*
		 * Cookie [] cookies=request.getCookies(); String noticeHistrory=""; boolean
		 * hasRead=false; if(cookies!=null) { for(Cookie c: cookies) { String
		 * name=c.getName(); String value=c.getValue(); if("noticeHistory".equals(name))
		 * { noticeHistrory=value; if(value.contains("|"+no+"|")) { hasRead=true; break;
		 * } } } } if(!hasRead) { Cookie c= new
		 * Cookie("noticeHistory",noticeHistrory+"|"+no+"|"); c.setMaxAge(-1);
		 * response.addCookie(c);
		 * 
		 * }
		 */
		/*
		 * Notice n= new NoticeService().selectNoticeOne(no,hasRead);
		 * request.setAttribute("n", n);
		 * request.getRequestDispatcher("/views/notice/noticeList.jsp").forward(request,
		 * response);
		 */
		/*
		 * List<NoticeComment> list=new NoticeService().selectNoticeCommentList(no);
		 * request.setAttribute("list", list);
		 * request.getRequestDispatcher("/views/noitc/noticeView.jsp").forward(request,
		 * response);
		 */
		Notice n=new NoticeService().selectNoticeOne(no);
		String view="";
		if(n==null) {
			//선택한 자료가 없을때
			//자료가 없다는 메세지출력 후 리스트 화면으로 이동
			request.setAttribute("msg", "조회된 공지사항이 없습니다.");
			request.setAttribute("loc", "/notice/noticeList");
			view="/views/common/msg.jsp";
		}else {
			//선택된 공지사항으로 이동
			request.setAttribute("notice",n);
			view="/views/notice/noticeView.jsp";
		}
		request.getRequestDispatcher(view).forward(request,response);
	}	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
