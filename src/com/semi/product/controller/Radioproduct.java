package com.semi.product.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.product.model.service.BookService;
import com.semi.product.model.vo.Books;
import com.semi.product.model.vo.Category;





/**
 * Servlet implementation class Radioproduct
 */
@WebServlet("/product/radioproduct")
public class Radioproduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Radioproduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String item =request.getParameter("item");
		Category ca=new Category(); //카테고리번호로 처리 라디오 버튼 클릭시에 해당 카테고리와 같은 책을 출력해주는 로직구성
		switch(item) {
		case "all": ca.setCategoryno(1); break;
		case "social": ca.setCategoryno(100); break;
		case "science":ca.setCategoryno(200); break;
		case "it": ca.setCategoryno(300);break;
		case "literature": ca.setCategoryno(400);break;
		case "development":ca.setCategoryno(500);break;
		}
		
		int cPage;//페이징처리하기 초기값을 설정
		try {
			cPage=Integer.parseInt(request.getParameter("cPage"));
			System.out.println(cPage);
		}catch(NumberFormatException e) {
			System.out.println("이거실행");
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
		int totlaData;
		if(ca.getCategoryno()==1) {
			totlaData=new BookService().selectBookCount();
		}else {
			totlaData=new BookService().selectcateBookCount(ca);
		}
		System.out.println(totlaData);
		int totalPage=(int)(Math.ceil((double)totlaData/numPerPage));
		int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd=pageNo+pageBarSize-1;
		String pageBar=""; //페이지바를 구성한 html구문을 누적하는 변수
		if(pageNo==1) {
			pageBar="<span class='page-btn'>이전</span>";
		}else {
			pageBar="<a href='"+request.getContextPath()
			+"/product/radioproduct?cPage="+(pageNo-1)+"&item="+item+"&numPerPage="+numPerPage+"'>이전</a>";
		}
		while(!(pageNo>pageEnd||pageNo>totalPage)) {
			if(cPage==pageNo) {
				pageBar+="<span class='pageno'>"+pageNo+"</span>";
			}else {
				pageBar+="<a href='"+request.getContextPath()
				+"/product/radioproduct?cPage="+pageNo+"&item="+item+"&numPerPage="+numPerPage+"'>"+pageNo+"</a>";
			}
			pageNo++;
		}
		
		if(pageNo>totalPage) {
				pageBar+="<span class='page-btn'>다음</span>";
		}else {
			pageBar+="<a href='"+request.getContextPath()
			+"/product/radioproduct?cPage="+pageNo+"&item="+item+"&numPerPage="+numPerPage+"'>다음</a>";
		}
		HttpSession session=request.getSession();
		//분기처리 all이 선택되면 모든 책 정보 출력해주기
		List<Books>list=new ArrayList<Books>();
		if(ca.getCategoryno()==1) {
			list=new BookService().categoryAlllist(cPage,numPerPage);
			for(Books bk:list) {
				System.out.println(bk);
			}
			System.out.println("값이 있음");
			request.setAttribute("list", list);
			request.setAttribute("pageBar", pageBar);
			session.setAttribute("item", item);
			request.getRequestDispatcher("/views/product/product.jsp").forward(request, response);
		}else {
			list=new BookService().categorylist(cPage,numPerPage,ca);
			if(list.isEmpty()) {
				System.out.println("값이없음");
			}
			request.setAttribute("list", list);
			request.setAttribute("pageBar", pageBar);
			session.setAttribute("item", item);
			request.getRequestDispatcher("/views/product/product.jsp").forward(request, response);	
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
