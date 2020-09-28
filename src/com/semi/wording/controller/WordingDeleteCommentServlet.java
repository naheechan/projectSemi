package com.semi.wording.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.wording.model.service.WordingService;

/**
 * Servlet implementation class WordingDeleteCommentServlet
 */
@WebServlet("/wording/wordingComDelete")
public class WordingDeleteCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WordingDeleteCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("comNo"));
		int wordingNo = Integer.parseInt(request.getParameter("wordingNo"));
		
		int result = new WordingService().deleteWordingCom(no);
		if(result>0) {
			response.sendRedirect(request.getContextPath()+"/wording/wordingDetail?wordingNo="+wordingNo);
		}else {
			request.setAttribute("msg", "댓글삭제에 실패하였습니다");
			request.setAttribute("loc", "/wording/wordingDetail?wordingNo="+wordingNo);
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
