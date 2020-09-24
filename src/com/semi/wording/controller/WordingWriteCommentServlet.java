package com.semi.wording.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.semi.wording.model.service.WordingService;
import com.semi.wording.model.vo.WordingComment;

/**
 * Servlet implementation class WordingWriteCommentServlet
 */
@WebServlet("/wording/writeComent")
public class WordingWriteCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WordingWriteCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		WordingComment com = new WordingComment();
		com.setComLevel(Integer.parseInt(request.getParameter("comLevel")));
		com.setComContent(request.getParameter("comContent"));
		com.setWriter(request.getParameter("writer"));
		com.setMemberNo(Integer.parseInt(request.getParameter("memberNo")));
		com.setWordingNo(Integer.parseInt(request.getParameter("wordingNo")));
		
		com = new WordingService().insertWordingComment(com);
		
		response.setContentType("application/json;charset=utf-8");
		new Gson().toJson(com, response.getWriter());

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
