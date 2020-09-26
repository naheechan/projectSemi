package com.semi.bookclub.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.bookclub.model.service.BookclubService;
import com.semi.bookclub.model.vo.Bookclub;

/**
 * Servlet implementation class BookclubWriteEndServlet
 */
@WebServlet("/bookclub/bookclubWriteEnd")
public class BookclubWriteEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookclubWriteEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Bookclub bc = new Bookclub();
		bc.setBookclubTitle(request.getParameter("title"));
		bc.setBookclubImg(request.getParameter("searchBookImgName"));
		bc.setMaxPerson(Integer.parseInt(request.getParameter("maxPerson")));
		bc.setWriter(request.getParameter("writer"));
		bc.setMemberNo(Integer.parseInt(request.getParameter("memberNo")));
		bc.setBookNo(Integer.parseInt(request.getParameter("searchBookNo")));
		
		int result = new BookclubService().insertBookclub(bc);
		String msg = "";
		String loc = "/";
		if(result>0) {
			msg = "북클럽이 새로 등록되었습니다.";
		}else {
			msg = "북클럽 등록에 실패하였습니다.";
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
