package com.semi.wording.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.wording.model.service.WordingService;
import com.semi.wording.model.vo.Wording;
import com.semi.wording.model.vo.WordingPic;
import com.semi.wording.model.vo.WordingText;

/**
 * Servlet implementation class WordingEditServlet
 */
@WebServlet("/wording/wordingEdit")
public class WordingEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WordingEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("wordingNo"));
		Wording w = new WordingService().selectWordingOne(no);
		WordingPic pic = new WordingService().selectWordingPicOne(no);
		WordingText te = new WordingService().selectWordingTextOne(no);
		
		if(w!=null && pic!=null && te!=null) {
			request.setAttribute("w", w);
			request.setAttribute("pic", pic);
			request.setAttribute("te", te);
			request.getRequestDispatcher("/views/wordingBoard/wordingBoardWrite.jsp").forward(request, response);
			return;
		}else {
			String msg = "잘못된 접근입니다.";
			String loc = "/";
			request.setAttribute("msg", msg);
			request.setAttribute("loc", loc);
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
