package com.semi.member.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
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
@WebServlet(name="enrollMember", urlPatterns = "/memberEnrollEnd")
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
		//인코딩 처리
		request.setCharacterEncoding("UTF-8");
		
		String memberId=request.getParameter("id");
		//회원가입정보(데이터)를 받아옴 (Member)
		Member m=new Member();
		m.setMemberId(request.getParameter("id"));
		m.setMemberPwd(request.getParameter("pw"));
		m.setMemberName(request.getParameter("name"));
		
		//날짜
		String birthParameter=request.getParameter("birth"); // 형식을 지켜야 함
		Date date = Date.valueOf(birthParameter);
		m.setBirth(date);
		m.setGender(request.getParameter("gender"));
		m.setPostcode(Integer.parseInt(request.getParameter("postcode")));
		m.setAddress(request.getParameter("address"));
		m.setExtraAddress(request.getParameter("extraAddress"));
		m.setDetailAddress(request.getParameter("detailAddress"));
		m.setEmail(request.getParameter("email"));
		m.setAgency(request.getParameter("telecom"));
		m.setPhone(request.getParameter("phone"));
		
		// 시퀀스 가져오기
		int result=new MemberService().insertMember(m);
		Member seq=new MemberService().getseq(memberId);
		
		System.out.println(seq);
		int memberSeq=seq.getMemberNo();
		System.out.println(memberSeq);
		
		//관심분야 다중값을 전달함
		/* 	인문사회 100
			자연과학 200
			정보통신 300
			자기계발 400
			문학 500 */
		
		String[] interest=request.getParameterValues("interest");

		System.out.println("interst : "+interest);
			if(interest.length==1) {
				System.out.println("interest index 갯수 1: "+interest[0]);
				String interested=interest[0];
				int interestResult=new MemberService().insertInterest(memberSeq, interested);
			}
			if(interest.length==2) {
				String interested=interest[0];
				int interestResult=new MemberService().insertInterest(memberSeq, interested);
				String interested1=interest[1];
				int interestResult1=new MemberService().insertInterest(memberSeq, interested1);
			}
			if(interest.length==3) {
				String interested=interest[0];
				int interestResult=new MemberService().insertInterest(memberSeq, interested);
				String interested1=interest[1];
				int interestResult1=new MemberService().insertInterest(memberSeq, interested1);
				String interested2=interest[2];
				int interestResult2=new MemberService().insertInterest(memberSeq, interested2);
			}
			if(interest.length==4) {
				String interested=interest[0];
				int interestResult=new MemberService().insertInterest(memberSeq, interested);
				String interested1=interest[1];
				int interestResult1=new MemberService().insertInterest(memberSeq, interested1);
				String interested2=interest[2];
				int interestResult2=new MemberService().insertInterest(memberSeq, interested2);
				String interested3=interest[3];
				int interestResult3=new MemberService().insertInterest(memberSeq, interested3);
			}
			if(interest.length==5) {
				String interested=interest[0];
				int interestResult=new MemberService().insertInterest(memberSeq, interested);
				String interested1=interest[1];
				int interestResult1=new MemberService().insertInterest(memberSeq, interested1);
				String interested2=interest[2];
				int interestResult2=new MemberService().insertInterest(memberSeq, interested2);
				String interested3=interest[3];
				int interestResult3=new MemberService().insertInterest(memberSeq, interested3);
				String interested4=interest[4];
				int interestResult4=new MemberService().insertInterest(memberSeq, interested4);
			}
			/*
			 * for(int i=0;i<interest.length;i++) { String interested=interest[i]; int
			 * interestResult=new MemberService().insertInterest(memberSeq, interested); }
			 */
			/*오라클 DB에는 배열자료형을 문자형으로 변환해줘야함.
			String interested=String.join(",",interest);*/
				
		
		
		String msg="";
		String loc="/";
		/*if(result>0&&interestResult>0) {*/
		if(result>0) {
			msg="회원가입성공";
		}else {
			msg="회원가입실패";
			loc="/enrollMember";
		}
		
		request.setAttribute("msg",msg);
		request.setAttribute("loc", loc);
		
		request.getRequestDispatcher("/views/common/msg.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
