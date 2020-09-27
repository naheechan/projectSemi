package com.semi.myinfo.controller;

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
import com.semi.myinfo.model.vo.MyBookclub;

/**
 * Servlet implementation class MyBookclubListServlet
 */
@WebServlet("/myinfo/myBookclubList")
public class MyBookclubListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyBookclubListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId=request.getParameter("userId");
		
		int cPage = 1;
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		}catch(Exception e) {
			cPage = 1;
		}
		int numPerPage = 6;
		
		int pageBarSize = 5;
		int totalData = new BookclubService().selectBookclubCount(memberId);
		
		int totalPage = (int)(Math.ceil((double)totalData/numPerPage));
		int pageNo = ((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd = pageNo+pageBarSize-1;
		String pageBar = "";
		if(pageNo==1) {
			pageBar = "<span>&nbsp&nbsp이전&nbsp&nbsp</span>";
		}else {
			pageBar = "<a href='"+request.getContextPath()+"/myinfo/myBookclubList?cPage="+(pageNo-1)+"'>&nbsp&nbsp이전&nbsp&nbsp</a>";
		}
		
		while(!(pageNo>pageEnd || pageNo>totalPage)) {
			if(pageNo==cPage) {
				pageBar += "<span class='clickPage'>&nbsp"+pageNo+"&nbsp</span>";
			}else {
				pageBar += "<a href='"+request.getContextPath()+"/myinfo/myBookclubList?cPage="+pageNo+"'>&nbsp"+pageNo+"&nbsp</a>";
			}
			pageNo++;
		}
		
		if(pageNo>totalPage) {
			pageBar += "<span>&nbsp&nbsp다음&nbsp&nbsp</span>";
		}else {
			pageBar += "<a href='"+request.getContextPath()+"/myinfo/myBookclubList?cPage="+pageNo+"'>&nbsp&nbsp다음&nbsp&nbsp</a>";
		}
		
		request.setAttribute("pageBar", pageBar);
		
		//작성자 sort data
		List<MyBookclub> MyBookclubList = new BookclubService().MyBookclubList(cPage, numPerPage, memberId);
		System.out.println("servlet: "+MyBookclubList);
		
		//참여자 sort data
		List<MyBookclub> MyBookclubListParti=new BookclubService().MyBookclubListParti(cPage, numPerPage, memberId);

		if(MyBookclubList.size()>0&&MyBookclubListParti.size()>0) {
			request.setAttribute("MyBookclubList", MyBookclubList);
			request.setAttribute("MyBookclubListParti", MyBookclubListParti);

		}else {
			request.setAttribute("msg", "목록을 불러오는데 오류가 발생했습니다");
			request.setAttribute("loc", "/infoMove?userId="+memberId);
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/views/myinfo/myBookclubList.jsp").forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
