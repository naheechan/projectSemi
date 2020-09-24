package com.semi.product.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.member.model.vo.interest;
import com.semi.product.model.service.BookService;
import com.semi.product.model.vo.Books;

/**
 * Servlet implementation class ProductMainServlet
 */
@WebServlet("/product/productmain")
public class ProductMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductMainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
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
		int pageBarSize=5;
		int totlaData=new BookService().selectBookCount();
		int totalPage=(int)(Math.ceil((double)totlaData/numPerPage));
		int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd=pageNo+pageBarSize-1;
		String pageBar=""; //페이지바를 구성한 html구문을 누적하는 변수
		if(pageNo==1) {
			pageBar="<span class='page-btn'>이전</span>";
		}else {
			pageBar="<a href='"+request.getContextPath()
			+"/product/productmain?cPage="+(pageNo-1)+"&numPerPage="+numPerPage+"'>이전</a>";
		}
		
		while(!(pageNo>pageEnd||pageNo>totalPage)) {
			if(cPage==pageNo) {
				pageBar+="<span class='pageno'>"+pageNo+"</span>";
			}else {
				pageBar+="<a href='"+request.getContextPath()
				+"/product/productmain?cPage="+(pageNo)+"&numPerPage="+numPerPage+"'>"+pageNo+"</a>";
			}
			pageNo++;
		}
		
		if(pageNo>totalPage) {
				pageBar+="<span class='page-btn'>다음</span>";
		}else {
			pageBar+="<a href='"+request.getContextPath()
			+"/product/productmain?cPage="+(pageNo)+"&numPerPage="+numPerPage+"'>다음</a>";
		}
		List<Books> list=new BookService().selectBook(cPage,numPerPage);
		if(!list.isEmpty()) {
			System.out.println("값이 있음");
			request.setAttribute("list", list);
			request.setAttribute("pageBar", pageBar);
			request.getRequestDispatcher("/views/product/product.jsp").forward(request, response);
		}else{
			System.out.println("값이 없음");
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
