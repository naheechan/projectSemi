package com.semi.myinfo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.buy.model.vo.Buylist;
import com.semi.buy.model.vo.BuylistJoin;
import com.semi.myinfo.model.servlce.MyinfoService;





/**
 * Servlet implementation class BuyListServlet
 */
@WebServlet("/myinfo/buylist")
public class BuyListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//주문내역 클릭시 주문한 내역을 출력해준다
		//주문내역도 페이징처리
		int userno=Integer.parseInt(request.getParameter("userno"));
		int cPage;
		try {
			cPage=Integer.parseInt(request.getParameter("cPage"));
		}catch (NumberFormatException e) {
			cPage=1;
		}
		int numPerPage;
		try {
			numPerPage=Integer.parseInt(request.getParameter("numPerPage"));
		
		}catch (NumberFormatException e) {
			numPerPage=3;
		}
		int pageBarSize=5;
		int totalData=new MyinfoService().selectcount(userno);
		int totalPage=(int)(Math.ceil((double)totalData/numPerPage));
		System.out.println(totalData);
		System.out.println(numPerPage);
		System.out.println(totalPage);
		int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd=pageNo+pageBarSize-1;
		String pageBar="";
		if(pageNo==1) {
			pageBar="<span class='page-btn'>이전</span>";
		}else {
			pageBar="<a href='"+request.getContextPath()
			+"/myinfo/buylist?cPage="+(pageNo-1)+"&numPerPage="+numPerPage+"&userno="+userno+"'>이전</a>";
		}
		
		while(!(pageNo>pageEnd||pageNo>totalPage)) {
			if(cPage==pageNo) {
				pageBar+="<span class='pageno'>"+pageNo+"</span>";
			}else {
				pageBar+="<a href='"+request.getContextPath()
				+"/myinfo/buylist?cPage="+(pageNo)+"&numPerPage="+numPerPage+"&userno="+userno+"'>"+pageNo+"</a>";
			}
			pageNo++;
		}
		if(pageNo>totalPage) {
				pageBar+="<span class='page-btn'>다음</span>";
		}else {
			pageBar+="<a href='"+request.getContextPath()
			+"/myinfo/buylist?cPage="+(pageNo)+"&numPerPage="+numPerPage+"&userno="+userno+"'>다음</a>";
		}
		System.out.println(cPage+":"+numPerPage);
		List<BuylistJoin>list=new MyinfoService().selectbuylist(userno,cPage,numPerPage);
		request.setAttribute("buylist", list);
		request.setAttribute("pageBar", pageBar);
		request.getRequestDispatcher("/views/myinfo/orderlist.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
