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
 * Servlet implementation class UpdatePasswordEndServelt
 */
@WebServlet(name="updatePasswordEnd", urlPatterns = "/updatePasswordEnd")
public class UpdatePasswordEndServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePasswordEndServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//패스워드찾기 정보 받아옴 (아이디, 핸드폰번호)
		
				String memberId=request.getParameter("id");
				System.out.println("servlet parameter id: "+memberId);
				String password=request.getParameter("pw");
				System.out.println("servlet parameter pw: "+password);
					
				int result=new MemberService().updatePassword(memberId,password);
				
				System.out.println("servlet : "+result);
				
				String msg="";
				String loc="/";
				
				if(result>0) {
					msg="비밀번호 변경 성공! 로그인하세요";
					loc="/logout";
					request.setAttribute("msg",msg);
					request.setAttribute("loc", loc);
					request.getRequestDispatcher("/views/common/msg.jsp")
					.forward(request, response);
				}else {
					msg="비밀번호 변경 실패";
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
