package com.semi.myinfo.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.member.model.service.MemberService;
import com.semi.member.model.vo.Member;
/**
 * Servlet implementation class UpdatePwServlet
 */
@WebServlet("/myinfo/updateInfo")
public class UpdateInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Member m = new Member();
		m.setMemberId(request.getParameter("id"));
		m.setMemberPwd(request.getParameter("pw"));
		m.setMemberName(request.getParameter("name"));
//		m.setGender(request.getParameter("gender"));
		
		//날짜
		String birthParameter=request.getParameter("birth"); // 형식을 지켜야 함
		Date date = Date.valueOf(birthParameter);
		m.setBirth(date);
		m.setEmail(request.getParameter("email"));
		m.setAgency(request.getParameter("agency"));
		m.setPhone(request.getParameter("phone"));
		m.setPostcode(Integer.parseInt(request.getParameter("postcode")));
		m.setAddress(request.getParameter("address"));
		m.setExtraAddress(request.getParameter("extraAddress"));
		m.setDetailAddress(request.getParameter("detailAddress"));

//		m.setPoint(Integer.parseInt(request.getParameter("point")));
		
		int result = new MemberService().memberUpdate(m);
//		Member seq=new MemberService().getseq(memberId);
//		
//		
//		int memberSeq=seq.getMemberNo();
//			
//		int interestResult=new MemberService().insertInterest(memberSeq, interested);

		String msg="";
		String loc="/";
		if(result>0) {
			msg="회원정보 수정 완료되었습니다.";
		}else {
			msg="회원정보 수정 실패하였습니다.";
		}

		request.setAttribute("msg", msg);
		request.setAttribute("loc",loc);
		request.getRequestDispatcher("/views/common/msg/jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
