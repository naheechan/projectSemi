package com.semi.wording.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.wording.model.vo.Wording;

/**
 * Servlet implementation class WordingWriteEndServlet
 */
@WebServlet("/wording/wordingWriteEnd")
public class WordingWriteEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WordingWriteEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Wording w =  new Wording();
		
		w.setWordingTitle(request.getParameter("wordingTitle"));
		w.setWordingContent(request.getParameter("wordingText"));
		
		
		//작성자 회원번호
		int writerNo = Integer.parseInt(request.getParameter("writerNo"));
		
		//글귀 배경파일
		String wordingPic = request.getParameter(request.getParameter("wordingPic"));
		//배경 밝기
		int picDarkness = Integer.parseInt(request.getParameter("picDarkness"));
		//위 2개로 int 배경NO = new service().~~; 해서 pk받아오셈
		
		//글자설정
		int textSize = Integer.parseInt(request.getParameter("textSize"));
		String textColor = request.getParameter("textColor");
		int textX = Integer.parseInt(request.getParameter("textX"));
		int textY = Integer.parseInt(request.getParameter("textY"));
		//위에 것들로 int 글자설정NO = new service().~~; 해서 pk받아오셈
		
		
		//파일저장 처리 완료하고 w완성해서 insert시키셈
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
