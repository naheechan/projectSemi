<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<%@ page import="com.semi.member.model.vo.Member" %>
<%@ page import="com.semi.member.model.vo.Interest" %>
<%@ page import="java.util.List" %>
<%
		//서버에서 보낸 데이터 받기
		Member m=(Member)request.getAttribute("member");
		List<Interest> list=(List)request.getAttribute("list");
		System.out.println("jsp m : "+m);
		System.out.println("jsp list : "+list);
/* 		String[] interest=inter.getCategoryNo().split(",");
		String[] checks=new String[5];
		if(interest!=null){
		   for(String v : interest){
		      switch(v){
		         case "100" : checks[0]="checked";break; 
		         case "200" : checks[1]="checked";break;
		         case "300" : checks[2]="checked";break;
		         case "400" : checks[3]="checked";break;
		         case "500" : checks[4]="checked";break;
		      }
		   }
		} */


%>

<section>
<div>
	<h2>회원정보수정</h2>
	<form id="memberFrm" action="" method="post">
		
		<h3 class="update_title" id="id_text">아이디</h3>
                <input id="id" name="id" type="text" maxlength="10" readonly value="<%=m.getMemberId()%>"><br>

		<h3 class="update_title">이름</h3>
	            <input id="name" name="name" type="text" maxlength="6" readonly value="<%=m.getMemberName()%>"><br>
	   
	    <h3 class="update_title">생일</h3>
	 		    <input id="name" name="birth" type="date" readonly value="<%=m.getBirth()%>"><br>
	    
	    <h3 class="update_title">이메일</h3>
                <input id="email" name="email" type="text" maxlength="25" value="<%=m.getEmail()%>"><br>	 
		 
		<h3 class="update_title">핸드폰번호</h3>
		 		<input type="text" id="phone" name="phone" maxlength="13" value="<%=m.getPhone()%>"><br>
	    
	    <h3 class="update_title">주소</h3>
	            <input type="text" id="sample4_postcode" name="postcode" placeholder="우편번호" value="<%=m.getPostcode() %>">
				<input type="text" id="sample4_roadAddress" name="address" placeholder="도로명주소" value="<%=m.getAddress() %>">
				<input type="text" id="sample4_detailAddress" name="extraAddress" placeholder="상세주소" value="<%=m.getExtraAddress()%>"><br>
				<input type="text" id="sample4_extraAddress" name="detailAddress" placeholder="동/구" value="<%=m.getDetailAddress() %>">
		 
		 <input type="button" onclick="fn_update_submit();" value="정보수정">
		 <input type="button" onclick="fn_delete_member();" value="탈퇴">
	</form>
</div>

<script>
<%--         //탈퇴
        function fn_delete_member(){
 			if(confirm("정말로 탈퇴하시겠습니까?")){
 				location.replace('<%=request.getContextPath()%>/myinfo/deleteMember?Member_Id=<%=logginedMember.getMemberId()%>');
 			}
 				
 		}
        
        //업데이트
 		function fn_update_submit(){
 			const frm=$("#memberFrm");
 			const url="<%=request.getContextPath()%>/myinfo/updateInfo";
 			frm.attr({
 				"action":url,
 				"method":"post",
 			});
 			frm.submit();
 		} --%>
        
        </script>
</section>
    
<%@ include file="/views/common/footer.jsp" %>