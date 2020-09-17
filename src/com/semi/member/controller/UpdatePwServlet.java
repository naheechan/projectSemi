package com.semi.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.member.model.service.MemberService;
/**
 * Servlet implementation class UpdatePwServlet
 */
@WebServlet(name="updatePw", urlPatterns = "/updatePw")
public class UpdatePwServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePwServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String memberId=request.getParameter("id");
		String memberName=request.getParameter("name");
		String memberPw=request.getParameter("pw");
		
		System.out.println("servlet :"+memberId);
		System.out.println("servlet :"+memberName);
		System.out.println("servlet :"+memberPw);
		int result=new MemberService().updatePw(memberPw,memberId,memberName);
		
		System.out.println("servlet : "+result);
		
		String msg="";
		String loc="/";
		
		if(result>0) {
			msg="비밀번호 변경 성공";
			request.setAttribute("msg",msg);
			request.setAttribute("loc", loc);
			request.setAttribute("result", result);
			request.getRequestDispatcher("/views/member/findPwResult.jsp")
			.forward(request, response);
		}else {
			msg="비밀번호 변경 실패";
			loc="/findPw";
			request.setAttribute("msg",msg);
			request.setAttribute("loc", loc);
			request.getRequestDispatcher("/views/common/msg.jsp")
			.forward(request, response);
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
