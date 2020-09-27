package com.semi.notice.model.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.semi.notice.model.service.NoticeService;
import com.semi.notice.model.vo.Notice;
import com.semi.notice.model.vo.NoticeComment;

/**
 * Servlet implementation class NoticeViewServlet
 */
@WebServlet("/notice/noticeView")
public class NoticeViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NoticeViewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		// 새로고침시 조회수가 증가하는 것 방지하기
		// 쿠키에 조회한 내용을 기록(저장)관리하여 한번 조회하면 그뒤에는 조회수가 올라가지 않게 설정
		// 1. 쿠키에 조회한 이력이 있는지 조회
		Cookie[] cookies = request.getCookies();
		String noticeHistory ="";// 이력을 저장하는 변수
		boolean hasRead = false;// 읽은 글이면 true, 안읽었으면 false표현 기준!
		if (cookies != null) {
			for (Cookie c : cookies) {
				String name = c.getName();
				String value = c.getValue();
				// boardHistory인 쿠키값을 찾기
				if ("noticeHistory".equals(name)) {
					noticeHistory = value;// 현재저장된 값 대입
					if (value.contains("|" + no + "|")) {
						// 읽은 게시글
						hasRead = true;
						break;
					}

				}
			}
		}
		// 읽지않은 게시글이면 cookie에 기록을 해야함.
		if (!hasRead) {
			Cookie c = new Cookie("noticeHistory", noticeHistory + "|" + no + "|");
			c.setMaxAge(-1);// 브라우저 종료시 삭제
			response.addCookie(c);
		}

		Notice n = new NoticeService().selectNoticeOne(no, hasRead);

		request.setAttribute("n", n);

		// 댓글리스트 추가
		List<NoticeComment> list = new NoticeService().selectBoardCommentList(no);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/views/notice/noticeView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
