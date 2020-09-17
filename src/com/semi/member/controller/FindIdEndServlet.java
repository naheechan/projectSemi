package com.semi.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.member.model.service.MemberService;
import com.semi.member.model.vo.Member;

/**
 * Servlet implementation class FindIdEndServlet
 */
@WebServlet("/findIdEnd")
public class FindIdEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindIdEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//아이디찾기 정보 받아옴 (이름,생년월일,이메일)
		String MemberName=request.getParameter("name");
		String birth=request.getParameter("birth");
		/* Date birth=Date.valueOf(request.getParameter("date")); */
		String phone=request.getParameter("phone");
		System.out.println("받아온 birth 파라미터 : "+birth);
		
		Member m=new MemberService().findId(MemberName,birth,phone);

		String msg="";
		String loc="/";
		
		
		if(m!=null) {
			String id=m.getMemberId();
			String name=m.getMemberName();
			msg="ID 찾기 성공";
			request.setAttribute("msg",msg);
			request.setAttribute("loc", loc);
			request.setAttribute("memberId", id);
			request.setAttribute("memberName", name);
			request.getRequestDispatcher("/views/member/findIdResult.jsp")
			.forward(request, response);
		}else {
			msg="해당 정보에 맞는 아이디가 존재하지 않습니다.";
			loc="/findId";
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
