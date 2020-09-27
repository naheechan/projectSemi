<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ include file="/views/common/header.jsp"%>
<style>
  /* 코드표 : RGB
        #E0ECE4 : 224,236,228 - 옅은 민트
        #F7F2E7 : 247,242,231 - 베이지
        #D8D3CD : 216,211,205 - 약간 짙은 베이지
        #797A7E : 121,122,126 - 짙은 그레이 
        */
  body {
    background-color: rgb(247, 242, 231);
  }

  #login_text {
    font-size: 40px;
    font-weight: bold;
    color: rgb(79, 80, 82);
    text-align: center;
    margin-bottom: 20px;
    padding-top: 40px;
  }
  #id {
    margin-left: 40%;
    margin-top: 10px;
    background-color: white;
    border: 2px;
    border-color: rgb(247, 242, 231);
    border-radius: 10px;
    width: 400px;
    height: 50px;
  }

  #pw {
    margin-left: 40%;
    margin-top: 30px;
    border: 2px;
    background-color: white;
    border-color: rgb(247, 242, 231);
    border-radius: 10px;
    width: 400px;
    height: 50px;
  }

  #submit {
    margin-left: 40%;
    margin-top: 30px;
    background-color: rgb(121, 122, 126);
    color: white;
    font: bolder;
    border: 2px;
    border-color: rgb(247, 242, 231);
    border-radius: 10px;
    width: 400px;
    height: 50px;
    text-align: center;
    font-size: 20px;
    font: bold;
  }
  .find {
    color: rgb(79, 80, 82);
    text-decoration: none;
  }

  #find {
    margin-left: 42%;
    margin-top: 30px;
  }

  label {
    margin: 10px;
  }
</style>
<section>
  <div>
    <article id="login_text">Customer Login</article>
    <br>
    <hr>
    <br>
    <form action="<%=request.getContextPath() %>/login" method="post" id="loginfrm">
      <input id="id" name="userId" type="text" placeholder="아이디" maxlength="10"><br>
      <input id="pw" name="password" type="password" placeholder="비밀번호" maxlength="20"><br>
      <input id="button" type="button" value="로그인" onclick="return logincheck();">
    </form>
    <form id="find">
      <label class="find" onclick="findId();">아이디 찾기</label>
      <label class="find" onclick="findPw();">비밀번호 찾기</label>
      <label class="find" onclick="join();">회원가입</label>
    </form>
    <br>
    <br>
    <br>
  </div>
</section>
<script>
	function logincheck() {
		let frm=document.querySelector("#loginfrm");
		frm.submit();	
	}
 
    
    
</script>

<%@ include file="/views/common/footer.jsp"%>
