package com.semi.wording.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.semi.wording.model.service.WordingService;
import com.semi.wording.model.vo.Wording;
import com.semi.wording.model.vo.WordingPic;
import com.semi.wording.model.vo.WordingText;

/**
 * Servlet implementation class WordingWriteEndServlet
 */
@WebServlet("/wording/wordingWriteEnd")
public class WordingWriteEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WordingWriteEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		if (!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "공지사항 작성오류[form:enctype] 관리자에게 문의하세요");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		String path = getServletContext().getRealPath("/") + "image/wordingBoard";
		//System.out.println(path);
		int maxSize = 1024 * 1024 * 10;
		String encode = "UTF-8";
		MultipartRequest mr = new MultipartRequest(request, path, maxSize, encode, new DefaultFileRenamePolicy());
		
	
				
		Wording w =  new Wording();
	
		w.setWordingTitle(mr.getParameter("wordingTitle"));
		w.setWordingContent(mr.getParameter("wordingText"));
		w.setMemberNo(Integer.parseInt(mr.getParameter("writerNo")));
		w.setWriter(mr.getParameter("writerId"));
		
		//글귀 배경파일
		WordingPic pic = new WordingPic();
		pic.setWordingPicName(mr.getFilesystemName("wordingPic"));
		//배경 밝기
		pic.setWordingPicBright(Integer.parseInt(mr.getParameter("picDarkness")));
		
		//글자설정
		WordingText text = new WordingText();
		text.setWordingTextSize(Integer.parseInt(mr.getParameter("textSize")));
		text.setWordingTextColor(mr.getParameter("textColor"));
		text.setWordingTextX(Integer.parseInt(mr.getParameter("textX")));
		text.setWordingTextY(Integer.parseInt(mr.getParameter("textY")));
	
		int result = new WordingService().insertWording(w, pic, text);
		//System.out.println(w);
		String msg = "";
		String loc = "/wording/wordingList";
		if(result>0) {
			msg = "글귀가 등록되었습니다";
		}else {
			msg = "글귀 등록실패";
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
