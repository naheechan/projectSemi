package com.semi.wording.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.wording.model.service.WordingService;
import com.semi.wording.model.vo.Wording;
import com.semi.wording.model.vo.WordingPic;
import com.semi.wording.model.vo.WordingText;

/**
 * Servlet implementation class WordingList
 */
@WebServlet("/wording/wordingList")
public class WordingListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WordingListServlet() {
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
		int totalData = new WordingService().selectWordingCount();
		int totalPage = (int)(Math.ceil((double)totalData/numPerPage));
		System.out.println("totalData : "+totalData);
		System.out.println("totalPage : "+totalPage);
		int pageNo = ((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd = pageNo+pageBarSize-1;
		String pageBar = "";
		if(pageNo==1) {
			pageBar = "<span>&nbsp&nbsp이전&nbsp&nbsp</span>";
		}else {
			pageBar = "<a href='"+request.getContextPath()+"/wording/wordingList?cPage="+(pageNo-1)+"'>&nbsp&nbsp이전&nbsp&nbsp</a>";
		}
		
		while(!(pageNo>pageEnd || pageNo>totalPage)) {
			if(pageNo==cPage) {
				pageBar += "<span class='clickPage'>&nbsp"+pageNo+"&nbsp</span>";
			}else {
				pageBar += "<a href='"+request.getContextPath()+"/wording/wordingList?cPage="+pageNo+"'>&nbsp"+pageNo+"&nbsp</a>";
			}
			pageNo++;
		}
		
		if(pageNo>totalPage) {
			pageBar += "<span>&nbsp&nbsp다음&nbsp&nbsp</span>";
		}else {
			pageBar += "<a href='"+request.getContextPath()+"/wording/wordingList?cPage="+pageNo+"'>&nbsp&nbsp다음&nbsp&nbsp</a>";
		}
		
		request.setAttribute("pageBar", pageBar);
		
		
		List<Wording> list = new WordingService().selectWordingBoardList(cPage, numPerPage);
		List<WordingPic> listPic = new WordingService().selectWordingPicList();
		List<WordingText> listText = new WordingService().selectWordingTextList();
		
		//wording_no의 리스트
		List<Integer> listNo = new ArrayList<>();
		for(Wording word : list) {
			listNo.add(word.getWordingNo());
		}
		//Map<wording_no, 해당글귀의 좋아요 count(*)>
		Map<Integer,Integer> mapLike = new WordingService().selectLikeCountList(listNo);

//		for(Integer i : mapLike.keySet()){ //저장된 key값 확인
//		    System.out.println("[Key]:" + i + " [Value]:" + mapLike.get(i));
//		}
		
		//좋아요순위 1~3위
		List<Wording> listRanking = new WordingService().selectWordingRanking();
		
		if(list.size()>0 && listPic.size()>0 && listText.size()>0 && mapLike.size()>0 && listRanking.size()>0) {
			
			request.setAttribute("list", list);
			request.setAttribute("listPic", listPic);
			request.setAttribute("listText", listText);
			request.setAttribute("mapLike", mapLike);
			request.setAttribute("listRanking", listRanking);
		}
		request.getRequestDispatcher("/views/wordingBoard/wordingBoard.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
