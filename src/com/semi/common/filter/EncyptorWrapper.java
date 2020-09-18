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
	}
	
	//재정의하고 싶은 매소드를 작성 -> @Override
	@Override
	public String getParameter(String name) {
		//client가 전달한 값중 비빌번호(password) name값만 
		//암호화처리하고 나머지 name은 정상적으로 처리
		String returnValue="";
		if(name.equals("pw")) {
			//암호화처리 후 반환
			String pw=super.getParameter(name);
			System.out.println(pw);
			String encPw=getSha512(pw);
			System.out.println(encPw);
			returnValue=encPw;
		}else {
			//정상적으로 반환 -> 원래대로 반환
			returnValue=super.getParameter(name);
		}
		
		return returnValue;
	}
	
	
	private String getSha512(String value) {
		String encPwd=null;//암호화한 값 보관
		//암호화처리객체
		MessageDigest md=null;
		//1. 암호화알고리즘을 불러옴 
		try {
			md=MessageDigest.getInstance("SHA-512");
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		//2. 알고리즘을 이용해서 Byte단위로 암호화처리를 함
		byte[] bytes=value.getBytes(Charset.forName("UTF-8"));//패스워드값을 byte로 변경
		//byte값을 MessageDigest를 이용해서 암호화함.
		//md.update()매소드를 이용
		md.update(bytes);//md에 지정된 암호화 알고리즘에 의해 매개변수의 값을 암호화함.
		
		//3. byte로 쪼개서 암호화한 내용을 String값으로 변환
		encPwd=Base64.getEncoder().encodeToString(md.digest());
		//4. 변환값 리턴!
		return encPwd;		
	}
}
