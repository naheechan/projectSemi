package com.semi.myinfo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.member.model.service.MemberService;
import com.semi.member.model.vo.Member;
import com.semi.wording.model.service.WordingService;
import com.semi.wording.model.vo.Wording;
import com.semi.wording.model.vo.WordingPic;
import com.semi.wording.model.vo.WordingText;

/**
 * Servlet implementation class MyWordingListServlet
 */
@WebServlet("/myinfo/myWordingList")
public class MyWordingListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyWordingListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId=request.getParameter("userId");
		Member m=new MemberService().selectMember(userId);
		
		
		int cPage = 1;
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
			System.out.println("servlet : "+cPage);
		}catch(Exception e) {
			cPage = 1;
		}
		int numPerPage = 6;
		
		int pageBarSize = 5;
		int totalData = new WordingService().selectWordingCount(userId);
		int totalPage = (int)(Math.ceil((double)totalData/numPerPage));
		System.out.println("totalData servlet : "+totalData);
		System.out.println("totalData servlet : "+totalPage);
		int pageNo = ((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd = pageNo+pageBarSize-1;
		String pageBar = "";
		if(pageNo==1) {
			pageBar = "<span>&nbsp&nbsp이전&nbsp&nbsp</span>";
		}else {
			pageBar = "<a href='"+request.getContextPath()+"/wording/myWordingList?cPage="+(pageNo-1)+"'>&nbsp&nbsp이전&nbsp&nbsp</a>";
		}
		
		while(!(pageNo>pageEnd || pageNo>totalPage)) {
			if(pageNo==cPage) {
				pageBar += "<span class='clickPage'>&nbsp"+pageNo+"&nbsp</span>";
			}else {
				pageBar += "<a href='"+request.getContextPath()+"/wording/myWordingList?cPage="+pageNo+"'>&nbsp"+pageNo+"&nbsp</a>";
			}
			pageNo++;
		}
		
		if(pageNo>totalPage) {
			pageBar += "<span>&nbsp&nbsp다음&nbsp&nbsp</span>";
		}else {
			pageBar += "<a href='"+request.getContextPath()+"/wording/myWordingList?cPage="+pageNo+"'>&nbsp&nbsp다음&nbsp&nbsp</a>";
		}
		request.setAttribute("pageBar", pageBar);
		
		
		
		List<Wording> list = new WordingService().selectWordingBoardList(cPage, numPerPage, userId);
		List<WordingPic> listPic = new WordingService().selectWordingPicList(userId);
		List<WordingText> listText = new WordingService().selectWordingTextList(userId);
		
		//wording_no의 리스트
		List<Integer> listNo = new ArrayList<>();
		for(Wording word : list) {
			listNo.add(word.getWordingNo());
		}
		//Map<wording_no, 해당글귀의 좋아요 count(*)>
		Map<Integer,Integer> mapLike = new WordingService().selectLikeCountList(listNo);
		
		if(list.size()>0 && listPic.size()>0 && listText.size()>0 && mapLike.size()>0) {
			
			request.setAttribute("member", m);
			request.setAttribute("list", list);
			request.setAttribute("listPic", listPic);
			request.setAttribute("listText", listText);
			request.setAttribute("mapLike", mapLike);
		}
		request.getRequestDispatcher("/views/myinfo/mywordingList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
