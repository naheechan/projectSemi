package com.semi.product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.product.model.service.BookService;
import com.semi.product.model.vo.Books;

/**
 * Servlet implementation class SearchTypeServlet
 */
@WebServlet("/product/searchtype")
public class SearchTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type=request.getParameter("searchType");
		String keyword = (request.getParameter("searchkey") == null) ? "" : request.getParameter("searchkey");
		int cPage;//페이징처리하기 초기값을 설정
		try {
			cPage=Integer.parseInt(request.getParameter("cPage"));
			System.out.println(cPage);
		}catch(NumberFormatException e) {
			cPage=1;
		}
		//페이지당 데이터 수:numPerPage->한개 페이지당 보여주는 데이터 수
		int numPerPage;
		try {
			numPerPage=Integer.parseInt(request.getParameter("numPerPage"));
			System.out.println(numPerPage);
		}catch(NumberFormatException e) {
			numPerPage=4;
		}
		List<Books> list =new BookService().searchkey(cPage,numPerPage,type,keyword);
		int pageBarSize=4;
		int totlaData=new BookService().selectBooksearchCount(type,keyword);
		System.out.println(totlaData);
		int totalPage=(int)(Math.ceil((double)totlaData/numPerPage));
		int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd=pageNo+pageBarSize-1;
		String pageBar=""; //페이지바를 구성한 html구문을 누적하는 변수
		if(pageNo==1) {
			pageBar="<span class='page-btn'>이전</span>";
		}else {
			pageBar="<a href='"+request.getContextPath()
			+"/product/searchtype?cPage="+(pageNo-1)+"&searchType="+type+"&searchkeyword="+keyword+"&numPerPage="+numPerPage+"'>이전</a>";
		}
		
		while(!(pageNo>pageEnd||pageNo>totalPage)) {
			if(cPage==pageNo) {
				pageBar+="<span class='pageno'>"+pageNo+"</span>";
			}else {
				pageBar+="<a href='"+request.getContextPath()
				+"/product/searchtype?cPage="+pageNo+"&searchType="+type+"&searchkeyword="+keyword+"&numPerPage="+numPerPage+"'>"+pageNo+"</a>";
			}
			pageNo++;
		}
		
		if(pageNo>totalPage) {
				pageBar+="<span class='page-btn'>다음</span>";
		}else {
			pageBar+="<a href='"+request.getContextPath()
			+"/product/searchtype?cPage="+pageNo+"&searchType="+type+"&searchkeyword="+keyword+"&numPerPage="+numPerPage+"'>다음</a>";
		}
		
//		검색한 결과를 가져오는 부분
		
		request.setAttribute("list", list);
		request.setAttribute("pageBar", pageBar);
		request.getRequestDispatcher("/views/product/product.jsp").forward(request, response);
		
	}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
