package com.semi.bookclub.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.bookclub.model.service.BookclubService;
import com.semi.bookclub.model.vo.BookclubParti;

/**
 * Servlet implementation class BookclubJoinServlet
 */
@WebServlet("/bookclub/bookclubJoin")
public class BookclubJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookclubJoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BookclubParti bp = new BookclubParti();
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		bp.setMemberNo(memberNo);
		bp.setPartiId(request.getParameter("memberId"));
		bp.setBookclubNo(Integer.parseInt(request.getParameter("bookclubNo")));
		
		
		int result = new BookclubService().insertBookclubJoin(bp);
		
		if(result>0) {
			response.sendRedirect(request.getContextPath()+"/bookclub/bookclubList");
		}else {
			request.setAttribute("msg", "북클럽 참여가 제한되었습니다.");
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
