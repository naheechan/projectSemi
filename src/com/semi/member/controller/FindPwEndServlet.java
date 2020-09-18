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
 * Servlet implementation class FindPwEndServlet
 */
@WebServlet("/findPwEnd")
public class FindPwEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindPwEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("UTF-8");
		
		//패스워드찾기 정보 받아옴 (아이디, 이름, 핸드폰번호)
		
		String memberId=request.getParameter("id");
		String memberName=request.getParameter("name");
		String phone=request.getParameter("phone");
	
		Member m=new MemberService().findPw(memberId, memberName,phone);

		String msg="";
		String loc="/";
		int result=0;
		
		if(m!=null) {
			String id=m.getMemberId();
			String name=m.getMemberName();
			System.out.println("servlet :"+m);
			msg="비밀번호를 재입력하세요.";
			request.setAttribute("msg",msg);
			request.setAttribute("memberId", id);
			request.setAttribute("memberName", name);
			request.setAttribute("result", result);
			request.getRequestDispatcher("/views/member/findPwResult.jsp")
			.forward(request, response);
		}else {
			msg="비밀번호를 변경할 수 없습니다.";
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
