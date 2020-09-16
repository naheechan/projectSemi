package com.semi.member.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.member.model.service.MemberService;
import com.semi.member.model.vo.Member;

/**
 * Servlet implementation class EnrollMemberEndServlet
 */
@WebServlet(name="enrollMember",urlPatterns="/enrollMemberEnd")
public class EnrollMemberEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollMemberEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("가입 버튼눌림");
		Member m=new Member();
		m.setMemberId(request.getParameter("userId"));
		m.setMemberPwd(request.getParameter("password"));
		m.setMemberName(request.getParameter("username"));
		Date btemp=Date.valueOf(request.getParameter("birth"));//문자열로 받은 값을 java.sql.date타입으로 형변환
		m.setBirth(btemp);
		m.setPostCode(Integer.parseInt(request.getParameter("postcode")));
		m.setAddress(request.getParameter("address"));
		m.setExtraAddress(request.getParameter("extraAddress"));
		m.setDetailaddress(request.getParameter("detailAddress"));
		m.setGender(request.getParameter("gender"));
		m.setEmail(request.getParameter("email"));
		m.setAgency(request.getParameter("telecom"));
		m.setPhone(request.getParameter("phone"));
	
		System.out.println(m);
		int result=new MemberService().insertMember(m);
		
		String msg="";
		String loc="/";
		if(result>0) {
			msg="회원가입 성공";
		}
		else {
			msg="회원가입 실패";
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
