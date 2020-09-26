package com.semi.myinfo.controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.seat.model.vo.SeatOrder;
import com.semi.myinfo.model.servlce.MyinfoService;

/**
 * Servlet implementation class StudyroomOrderlistServlet
 */
@WebServlet("/myinfo/studyroomOrderlist")
public class StudyroomOrderlistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudyroomOrderlistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//주문내역 클릭시 주문한 내역을 출력해준다
				//주문내역도 페이징처리
				int memberNo=Integer.parseInt(request.getParameter("userNo"));
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
				int totalData=new MyinfoService().selectStudyroomCount(memberNo);
				
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
					+"/myinfo/studyroomOrderlist?cPage="+(pageNo-1)+"&numPerPage="+numPerPage+"&userNo="+memberNo+"'>이전</a>";
				}
				
				while(!(pageNo>pageEnd||pageNo>totalPage)) {
					if(cPage==pageNo) {
						pageBar+="<span class='pageno'>"+pageNo+"</span>";
					}else {
						pageBar+="<a href='"+request.getContextPath()
						+"/myinfo/studyroomOrderlist?cPage="+(pageNo)+"&numPerPage="+numPerPage+"&userNo="+memberNo+"'>"+pageNo+"</a>";
					}
					pageNo++;
				}
				if(pageNo>totalPage) {
						pageBar+="<span class='page-btn'>다음</span>";
				}else {
					pageBar+="<a href='"+request.getContextPath()
					+"/myinfo/studyroomOrderlist?cPage="+(pageNo)+"&numPerPage="+numPerPage+"&userNo="+memberNo+"'>다음</a>";
				}
				System.out.println(cPage+":"+numPerPage);
				
				
				List<SeatOrder> list=new MyinfoService().selectStudyroomlist(memberNo,cPage,numPerPage);
				request.setAttribute("studyroomOrderlist", list);
				request.setAttribute("pageBar", pageBar);
				request.getRequestDispatcher("/views/myinfo/studyroomOrderlist.jsp").forward(request, response);
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
