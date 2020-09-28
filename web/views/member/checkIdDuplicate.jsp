<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.semi.member.model.vo.Member" %>
<%
	 Member m=(Member)request.getAttribute("result");
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복검사</title>
<style>
	div#checkId-container-text{font-size:25px; text-align:center; color:rgb(121,122,126)}
	div#checkId-container{text-align:center;padding-top:18px;}
	span#duplicated{color:red;font-weight:bolder;font-size:18px;}
	span#checkId{color:green;font-weight:bolder;font-size:18px;}
	html{
            background-color: rgb(224,236,228);
        }
    .button{
    		background-color:rgb(121,122,126); 
            color:white; 
            font-size: 15px;
            font:bold;
            border: 2px;
            border-color: rgb(247,242,231); 
            border-radius: 5px;
    }
</style>
</head>
<body>
	<div id="checkId-container-text">Check ID</div>
	<hr>
	<div id="checkId-container">
		<fieldset>
				<%if(m==null) {%>
					<span id="checkId"><%=request.getParameter("id") %></span>는 사용가능합니다.	
					<br><br>
					<button type="button" class="button" onclick="setMemberId();">닫기</button>
				<%} else{%>
					<span id="duplicated"><%=m.getMemberId() %></span>는 사용중입니다.
					<br><br>
					<!-- 아이디 재입력창 구성 -->
					<form action="<%=request.getContextPath() %>/checkIdDuplicate" method="post">
						<input type="text" name="id" id="id">
						<input type="submit" class="button" value="중복검사" onclick="return fn_validate();">
					</form>
				<%} %>
		</fieldset>
	</div>
	<script>
		function fn_validate(){
			let id=document.getElementById("id").value;
			if(id.trim().length<4){
				alert("아이디는 4글자 이상 입력하세요!");
				document.getElementById("id").focus();
				return false;
			}
		}
		function setMemberId(){
			//입력된 id를 부모창에 대입
			const id='<%=request.getParameter("id")%>';
			console.log(id);
			opener.enrollMemberForm.id.value=id;
			//중복확인을 했는지 확인해주기.
			opener.idCheckResult.value=1;

			//팝업창 닫아주기
			window.open('','_self').close(); 
			
		}
	</script>
</body>
</html>

