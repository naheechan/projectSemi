package com.semi.myinfo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.member.model.service.MemberService;
import com.semi.member.model.vo.Member;

/**
 * Servlet implementation class UpdatePasswordServlet
 */
@WebServlet(name="updatePasswordMove", urlPatterns = "/updatePasswordMove")
public class UpdatePasswordMoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePasswordMoveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId=request.getParameter("id");
		String password=request.getParameter("pw");
		
		Member m=new MemberService().loginMember(memberId, password);

		String msg="";
		String loc="/";
		
		if(m!=null) {
			String id=m.getMemberId();
			request.setAttribute("userId", memberId);
			request.getRequestDispatcher("/views/myinfo/updatePasswordEnd.jsp")
			.forward(request, response);
			
		}else {
			msg="비밀번호를 다시 입력해주세요.";
			loc="/myinfo/passwordUpdate?userId="+memberId;
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
