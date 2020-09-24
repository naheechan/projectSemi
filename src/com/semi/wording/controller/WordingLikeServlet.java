package com.semi.wording.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.wording.model.service.WordingService;

/**
 * Servlet implementation class WordingLikeServlet
 */
@WebServlet("/wording/wordingLike")
public class WordingLikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WordingLikeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int wordingNo = Integer.parseInt(request.getParameter("wordingNo"));
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		int likeChk = new WordingService().selectLikeCheck(wordingNo, memberNo);
		int result = 0;
		int redHeart = 0;
		if(likeChk==0) {
			//좋아요insert
			result = new WordingService().insertWordingLike(wordingNo, memberNo);
			if(result>0) redHeart = 1;
			else redHeart = 0;
		}else {
			//이미 좋아요 눌러서, 좋아요delete
			result = new WordingService().deleteWordingLike(wordingNo, memberNo);
			if(result>0) redHeart = 0;
			else redHeart = 1;
		}
		
		//좋아요 수 조회
		int lCnt = new WordingService().selectWordingLikeCnt(wordingNo);
		
		response.setContentType("text/csv;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.append(lCnt+","+redHeart); //redHeart가 1이면 빨간하트, 0이면 속빈하트
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
