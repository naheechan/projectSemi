<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@page import="com.semi.member.model.vo.Member" %> <%
Member m=(Member)request.getAttribute("result"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Insert title here</title>
  </head>
  <style>
    div#checkId-container {
      text-align: center;
      padding-top: 50px;
    }
    span#duplicated {
      color: red;
      font-weight: bolder;
    }
  </style>
  <body>
    <div id="checkId-container">
      <%if(m==null) {%> [<span><%=request.getParameter("userId") %></span>]는
      사용가능합니다. <br /><br />
      <button type="button" onclick="setUserId();">닫기</button>
      <%} else{%> [<span id="duplicated"><%=m.getMemberId()%></span>]는
      사용중입니다. <br /><br />
      <!-- 아이디 재입력창 구성 -->
      <form
        action="<%=request.getContextPath() %>/checkIdDuplicate"
        method="post"
      >
        <input type="text" name="userId" id="userId" />
        <input type="submit" value="중복검사" onclick="return fn_validate();" />
      </form>
      <%} %>
    </div>
    <script>
      function fn_validate() {
        let id = document.getElementById("userId").value;
        if (id.trim().length < 4) {
          alert("아이디는 4글자 이상 입력하세요!");
          document.getElementById("userId").focus();
          return false;
        }
      }
      function setUserId() {
        //입력된 id를 부모창에 대입
        const id = '<%=request.getParameter("userId")%>';

        opener.memberEnrollFrm.userId.value = id;
        opener.document.getElementById("password").focus();
        console.log(opener.memberEnrollFrm.password); //이 조건에 오류가 발생해서 부모의 dom으로 가져와서 focus를 먹였다
        /* opener.memberEnrollFrm.password.focus(); */ //팝업창 닫아주기
        close();
      }
    </script>
  </body>
</html>
