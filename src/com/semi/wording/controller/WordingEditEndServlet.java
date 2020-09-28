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
 * Servlet implementation class WordingEditEndServlet
 */
@WebServlet("/wording/wordingEditEnd")
public class WordingEditEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WordingEditEndServlet() {
    	super();
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
		
		
		//글귀 배경파일
		WordingPic pic = new WordingPic();
		String wordingPic = mr.getFilesystemName("wordingPic");
		if(wordingPic!=null) {
			pic.setWordingPicName(wordingPic);
		}
		//배경 밝기
		pic.setWordingPicBright(Integer.parseInt(mr.getParameter("picDarkness")));
		
		//글자설정
		WordingText text = new WordingText();
		text.setWordingTextSize(Integer.parseInt(mr.getParameter("textSize")));
		text.setWordingTextColor(mr.getParameter("textColor"));
		text.setWordingTextX(Integer.parseInt(mr.getParameter("textX")));
		text.setWordingTextY(Integer.parseInt(mr.getParameter("textY")));
		
		int no = Integer.parseInt(mr.getParameter("wordingNo"));

//		System.out.println(w);
//		System.out.println(pic);
//		System.out.println(text);
//		System.out.println(no);
		
		int result = new WordingService().updateWording(w, pic, text, no);
		
		//System.out.println("update최종결과 : "+result);
		String msg = "";
		String loc = "/wording/wordingDetail?wordingNo="+no;
		if(result>0) {
			msg = "글귀가 수정되었습니다";
		}else {
			msg = "글귀 수정실패";
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
