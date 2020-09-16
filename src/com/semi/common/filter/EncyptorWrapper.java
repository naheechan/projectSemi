package com.semi.common.filter;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;



public class EncyptorWrapper extends HttpServletRequestWrapper {

	public EncyptorWrapper(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String getParameter(String name) {
		String returnValue="";
		if(name.equals("password")) {
			//분기문 처리 만약에 getparameter로 받아온 값이 패스워라면
			//암호화 처리 
			String pw=super.getParameter(name);
			String ecnPw=getSha512(pw);
			returnValue=ecnPw;		
		}else {
			returnValue=super.getParameter(name);
		}
		return returnValue;
	}
	private String getSha512(String value) {
		String encPwd=null;//암호화한 값을 보관
		MessageDigest md=null;
		//암호화 알고리즘을 불러온다
		try {
			md=MessageDigest.getInstance("SHA-512");
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		//알고리즘을 이용해서 byte단위로 암호화처리를 함
		byte[] bytes=value.getBytes(Charset.forName("UTF-8"));//패스워드 값을 byte로 변경
		//byte값을 MessageDigest를 사용해서 암호화
		md.update(bytes);
		encPwd=Base64.getEncoder().encodeToString(md.digest());
		//변환값 리턴
		return encPwd;
	
	}
	

}
