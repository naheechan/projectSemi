package com.semi.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.member.model.service.MemberService;
import com.semi.member.model.vo.Member;

/**
 * Servlet implementation class MemberLogin
 */
@WebServlet(name="login",urlPatterns="/login")
public class MemberLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("로그인 버튼 누름");
		String id=request.getParameter("userId");
		String pw=request.getParameter("password");
		System.out.println(id+pw);
		Member m=new MemberService().loginMember(id,pw);
		System.out.println(m);//가져온 데이터 출력
		
		if(m!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("logginedMember", m);//유지한 값을 session에 넣기 내가 session을 지우기 전에 살아있음
			response.sendRedirect(request.getContextPath());
			}
		else {
			request.setAttribute("msg", "아이디나 비밀번호가 일치하지 않습니다!");
			request.setAttribute("loc", "/views/member/login.jsp");
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
