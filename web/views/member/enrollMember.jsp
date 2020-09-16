<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
  <div>
            <article id="signUp_text">Sign Up</article>
            <br>
            <hr>
            <br>
            <form id="memberEnrollFrm"name="memberEnrollFrm"action="<%=request.getContextPath()%>/enrollMemberEnd" method="post">
                <h3 class="join_title" id="id_text">아이디</h3>
                <input id="userId" name="userId" type="text" maxlength="10" placeholder="3글자 이상 작성해주세요" required ><br>
                <input id="btnId" type="button"onclick="checkId();" value="중복확인"></input>

                <h3 class="join_title">비밀번호</h3>
                <input id="password" name="password" type="password" maxlength="20" placeholder="8글자 이상" required><br>

                <h3 class="join_title">비밀번호 재확인</h3>
                <input id="password" name="password_2" type="password" maxlength="20"><span id="result" required></span><br>

                <h3 class="join_title">이름</h3>
                <input id="username" name="username" type="text" maxlength="6" required><br>

                <h3 class="join_title">생년월일</h3>
                <input id="birth" type="date" name="birth" required><br>
                <h3 class="join_title">주소</h3>
                <input type="text" id="postcode" name="postcode"placeholder="우편번호" />
                <input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기" /><br />
                <input type="text" id="address" name="address" placeholder="주소" /><br />
                <input type="text" id="extraAddress" name="extraAddress"placeholder="참고항목" />
                <input type="text" id="detailAddress" name="detailAddress" placeholder="상세주소" />

                <h3 class="join_title">성별</h3>
                <select id="gender" name="gender">
                    <option value="gender" selected>성별</option>
                    <option value="M">남자</option>
                    <option value="W">여자</option>
                </select>
                <h3 class="join_title">이메일</h3>
                <input id="email" name="email" type="text" maxlength="25"><br>
                <h3 class="join_title">핸드폰번호</h3>
                <select id="telecom" name="telecom">
                    <option value="SKT" selected>SKT</option>
                    <option value="KT">KT</option>
                    <option value="LGU+">LGU+</option>
                    <label><input type="tel" id="phone" name="phone"placeholder="010-0000-0000" maxlength="13"></label><br>
                    <input id="button" type="button" value="가입하기" onclick="return checkData();"></input>
                    </select>
            </form>
            <form action="" name="checkIdDuplicate">
  			<input type="hidden" name="userId">
  			</form>
        </div>
        <br>
        <br>
        <br>
    </section>
    <script>
    function checkId() {
    	  console.log(document.querySelector("#userId").value);
    	  let userid = document.querySelector("#userId").value;
    	  console.log(userid.length);
    	 if (userid.trim().length < 4) {
    	    alert("아이디를 4글자이상 입력해주세요");
    	    return;
    	  }
    	  const url = "<%=request.getContextPath()%>/checkIdDuplicate";
    	  const title = "checkIdDuplicate";
    	  const status = "left=500px,top=200px,width=400px,height=400px";
    	  open("", title, status);
    	  checkIdDuplicate.target = title; //form을 전송하는 윈도우를 선정
    	  checkIdDuplicate.action = url;
    	  checkIdDuplicate.method = "post";
    	  checkIdDuplicate.userId.value = userid;
    	  checkIdDuplicate.submit();
    	}
    </script>
<%@ include file="/views/common/footer.jsp"%>