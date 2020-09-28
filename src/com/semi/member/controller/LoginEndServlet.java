package com.semi.member.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.member.model.service.MemberService;
import com.semi.member.model.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name="login",urlPatterns = "/loginEnd")
public class LoginEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//클라이언트가 보낸 데이터를 받아오기
				String id=request.getParameter("id");
				String pw=request.getParameter("pw");
				System.out.println("id : "+id+" password : "+pw);
			
				Member m=new MemberService().loginMember(id, pw);
	
				if(m!=null) {
					if(m.getLeave().equals("Y")) {
						request.setAttribute("msg", "탈퇴한 회원입니다.");
						request.setAttribute("loc", "/");
						RequestDispatcher rd=request.getRequestDispatcher("/views/common/msg.jsp");
						rd.forward(request,response);
					}
					else {
					HttpSession session=request.getSession();
					session.setAttribute("logginedMember",m);//유지할 값을 session에 넣기!
					response.sendRedirect(request.getContextPath());
					}
				}else {
					request.setAttribute("msg", "아이디나 비밀번호가 일치하지 않습니다!");
					request.setAttribute("loc", "/");
					
					RequestDispatcher rd=request.getRequestDispatcher("/views/common/msg.jsp");
					rd.forward(request,response);
					
					
				}
//				RequestDispatcher rd=request.getRequestDispatcher("/");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
