package com.semi.bookclub.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.bookclub.model.service.BookclubService;
import com.semi.bookclub.model.vo.BookclubPartiView;
import com.semi.bookclub.model.vo.BookclubView;

/**
 * Servlet implementation class bookClubList
 */
@WebServlet("/bookclub/bookclubList")
public class BookclubListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookclubListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int cPage = 1;
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		}catch(Exception e) {
			cPage = 1;
		}
		int numPerPage = 12;
		
		int pageBarSize = 5;
		int totalData = new BookclubService().selectBookclubCount();
		int totalPage = (int)(Math.ceil((double)totalData/numPerPage));
		int pageNo = ((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd = pageNo+pageBarSize-1;
		String pageBar = "";
		if(pageNo==1) {
			pageBar = "<span>&nbsp&nbsp이전&nbsp&nbsp</span>";
		}else {
			pageBar = "<a href='"+request.getContextPath()+"/bookclub/bookclubList?cPage="+(pageNo-1)+"'>&nbsp&nbsp이전&nbsp&nbsp</a>";
		}
		
		while(!(pageNo>pageEnd || pageNo>totalPage)) {
			if(pageNo==cPage) {
				pageBar += "<span class='clickPage'>&nbsp"+pageNo+"&nbsp</span>";
			}else {
				pageBar += "<a href='"+request.getContextPath()+"/bookclub/bookclubList?cPage="+pageNo+"'>&nbsp"+pageNo+"&nbsp</a>";
			}
			pageNo++;
		}
		
		if(pageNo>totalPage) {
			pageBar += "<span>&nbsp&nbsp다음&nbsp&nbsp</span>";
		}else {
			pageBar += "<a href='"+request.getContextPath()+"/bookclub/bookclubList?cPage="+pageNo+"'>&nbsp&nbsp다음&nbsp&nbsp</a>";
		}
		
		request.setAttribute("pageBar", pageBar);
		
		List<BookclubView> list = new BookclubService().selectBookclubList(cPage, numPerPage);
		List<BookclubPartiView> listParti = new BookclubService().selectBookclubPartiViewList();
		//Map<북클럽no,count(*)>
		Map<Integer,Integer> mapPartiCnt = new BookclubService().selectPartiCnt();

		if(list.size()>0) {
			request.setAttribute("list", list);
			request.setAttribute("listParti", listParti);
			request.setAttribute("mapPartiCnt", mapPartiCnt);
		}else {
			request.setAttribute("msg", "목록을 불러오는데 오류가 발생했습니다");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/views/bookclubBoard/bookclubBoard.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
