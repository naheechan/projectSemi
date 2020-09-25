package com.semi.myinfo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.member.model.vo.Member;
import com.semi.member.model.vo.Interest;
import com.semi.member.model.service.MemberService;

/**
 * Servlet implementation class InfoMoveServlet
 */
@WebServlet("/infoMove")
public class InfoMoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoMoveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId=request.getParameter("userId");
		System.out.println("myinfoService getparameter id: " + userId);
		
		Member m=new MemberService().selectMember(userId);
		System.out.println(m);
		 
		int memberNo = m.getMemberNo();
		System.out.println("myinfoService memberno: " + memberNo);

		List<Interest> list = new MemberService().getinterest(memberNo);
	    System.out.println("myinfoService inter: " + list);
	      
	    request.setAttribute("list",list);
		request.setAttribute("member", m);
		
		RequestDispatcher rd=request.getRequestDispatcher("/views/myinfo/updateInfo.jsp");
		rd.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
