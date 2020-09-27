package com.semi.notice.model.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.member.model.vo.interest;
import com.semi.notice.model.service.NoticeService;
import com.semi.notice.model.vo.NoticeComment;

/**
 * Servlet implementation class NoticeCommentInsertServlet
 */
@WebServlet("/notice/noticeCommentInsert")
public class NoticeCommentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeCommentInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int noticeRef=Integer.parseInt(request.getParameter("noticeRef"));
		String noticeCommentWriter=request.getParameter("noticeCommentWriter");
		int noticeCommentLevel=Integer.parseInt(request.getParameter("noticeCommentLevel"));
		int noticeCommentRef=Integer.parseInt(request.getParameter("noticeCommentRef"));
		String noticeCommentContent=request.getParameter("noticeCommentContnet");
		NoticeComment nc=new NoticeComment(0, noticeCommentLevel, noticeCommentWriter, noticeCommentContent, null, noticeRef, noticeCommentRef,0, 0);
		int result=new NoticeService().insertNoticeComment(nc);
		String msg="";
		String loc="/notice/noticeView?no="+noticeRef;
		if(result>0) {
			msg="댓글 등록 성공";
		}else {
		   msg="댓글 등록 실패";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
