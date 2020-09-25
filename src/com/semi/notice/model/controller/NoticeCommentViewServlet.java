package com.semi.notice.model.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.member.model.vo.Interest;

/**
 * Servlet implementation class NoticeCommentViewServlet
 */
@WebServlet("/notice/noticeCommentView")
public class NoticeCommentViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NoticeCommentViewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int no = Integer.parseInt(request.getParameter("no"));
		Cookie[] cookies = request.getCookies();
		String noticeHistory = "";
		boolean hasRead = false;

		if (cookies != null) {
			for (Cookie c : cookies) {
				String name = c.getName();
				String value = c.getValue();
				if ("noticeHistory".equals(name)) {
					noticeHistory = value;
					if (value.contains("|" + no + "|")) {
						hasRead = true;
						break;
					}

				}
			}
		}
		if(!hasRead) {
			Cookie c=new Cookie("noticeHistory", noticeHistory+"|"+no+"|");
			c.setMaxAge(-1);
			response.addCookie(c);
		}

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
