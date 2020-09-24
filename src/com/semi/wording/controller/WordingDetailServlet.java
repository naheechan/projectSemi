package com.semi.wording.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.member.model.vo.Member;
import com.semi.wording.model.service.WordingService;
import com.semi.wording.model.vo.Wording;
import com.semi.wording.model.vo.WordingComment;
import com.semi.wording.model.vo.WordingPic;
import com.semi.wording.model.vo.WordingText;

/**
 * Servlet implementation class WordingDetailServlet
 */
@WebServlet("/wording/wordingDetail")
public class WordingDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WordingDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("wordingNo"));
		
		//조회했었는지 확인
		Cookie[] cookies = request.getCookies();
		String boardHistory = ""; 
		boolean hasRead = false; 
		
		if(cookies!=null) {
			for(Cookie c : cookies) {
				String name = c.getName();
				String value = c.getValue();
				//boardHistory인 쿠키값을 찾기
				if("boardHistory".equals(name)) {
					boardHistory = value; //현재 저장된 값 대입
					if(value.contains("|"+no+"|")) {
						//이미 읽은 게시글임
						hasRead = true;
						break;
					}
				}
			}
		}
		if(!hasRead) { 
			Cookie c = new Cookie("boardHistory", boardHistory+"|"+no+"|");
			c.setMaxAge(-1); //브라우저 종료시 삭제
			response.addCookie(c);
		}
		
		Wording w = new WordingService().selectWordingOne(no, hasRead);
		WordingPic pic = new WordingService().selectWordingPicOne(no);
		WordingText te = new WordingService().selectWordingTextOne(no);
		int likeCount = new WordingService().selectWordingLikeCnt(no);
		int likeChk = new WordingService().selectLikeCheck(no, ((Member)request.getSession(false).getAttribute("logginedMember")).getMemberNo());
		List<WordingComment> listCom = new WordingService().selectWordingCommentList(no);
		
		if(w!=null && pic!=null && te!=null) {
			request.setAttribute("w", w);
			request.setAttribute("pic", pic);
			request.setAttribute("te", te);
			request.setAttribute("likeCount", likeCount);
			request.setAttribute("likeChk", likeChk);
			request.setAttribute("listCom", listCom);
			request.getRequestDispatcher("/views/wordingBoard/wordingBoardDetail.jsp").forward(request, response);
			return;
		}else {
			String msg = "잘못된 접근입니다.";
			String loc = "/";
			request.setAttribute("msg", msg);
			request.setAttribute("loc", loc);
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
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
