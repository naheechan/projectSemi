package com.semi.notice.model.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.semi.notice.model.service.NoticeService;
import com.semi.notice.model.vo.Notice;


/**
 * Servlet implementation class NoticeWriterEndServlet
 */
@WebServlet("/notice/noticeWriteEnd")
public class NoticeWriterEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeWriterEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "공지사항 작성오류 [form:enctype] 관리자에게 문의하세요.");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		
		System.out.println(getServletContext().getRealPath("/"));
		String path=getServletContext().getRealPath("/")+"upload/notice";
		int maxSize=1024*1024*10;
		String encode="UTF-8";
		MultipartRequest mr=new MultipartRequest(request, path, maxSize
				,encode,new DefaultFileRenamePolicy());
		

		String title=mr.getParameter("title");
		String content=mr.getParameter("content");
		String writer=mr.getParameter("writer");
		String filepath=mr.getFilesystemName("upfile");

		Notice n=new Notice(0, title, writer, content, null, 0, filepath, 0, false);
		
		int result=new NoticeService().insertNotice(n);
		
		String msg="";
		String loc="";
		if(result>0) {
			msg="공지사항 등록 성공!";
			loc="/notice/noticeList";
		}else {
			msg="공지사항 등록 실패!";
			loc="/notice/noticeWrite";
		}
		request.setAttribute("msg",msg);
		request.setAttribute("loc",loc);
		request.getRequestDispatcher("/views/common/msg.jsp")
		.forward(request, response);
	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
