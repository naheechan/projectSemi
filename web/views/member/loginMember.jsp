<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 헤더 -->
<%@ include file="/views/common/header.jsp" %>
    <style>
        /* 코드표 : RGB
        #E0ECE4 : 224,236,228 - 옅은 민트
        #F7F2E7 : 247,242,231 - 베이지
        #D8D3CD : 216,211,205 - 약간 짙은 베이지
        #797A7E : 121,122,126 - 짙은 그레이 
        */
        body{background-color: rgb(247,242,231)}

        #login_text{
            font-size: 40px;
            font-weight: bold;
            color: rgb(79, 80, 82);
            text-align: center;
            margin-bottom: 20px;
            padding-top: 40px;
            }
        #id{margin-left: 40%;
            margin-top:10px;
            background-color: white; 
            border: 2px;
            border-color: rgb(247,242,231); 
            border-radius: 10px;
            width: 400px;
            height: 50px;}

        #pw{margin-left:40%;
            margin-top:30px;
            border: 2px;
            background-color: white; 
            border-color: rgb(247,242,231); 
            border-radius: 10px;
            width: 400px;
            height: 50px;}


        #submit{margin-left:40%;
            margin-top:30px;
            background-color:rgb(121,122,126); 
            color:white; 
            font :bolder;
            border: 2px;
            border-color: rgb(247,242,231); 
            border-radius: 10px;
            width: 400px;
            height: 50px;
            text-align:center;
            font-size: 20px;
            font:bold;
            }
            .find { color: rgb(79, 80, 82); text-decoration: none;}

            #find{margin-left: 42%; 
                  margin-top: 30px;}
            
            label{margin:10px;}

    </style>

      <section>
        <div>
            <article id="login_text">Customer Login</article>
            <br>
            <hr>
            <br>
             <form action="<%=request.getContextPath()%>/loginEnd" method="post">
                <input id="id" name="id" type="text" placeholder="아이디" maxlength="10"><br>
                <input id="pw" name="pw" type="password" placeholder="비밀번호" maxlength="20"><br>
                <input id="submit" name="submit" type="submit" value="로그인" onclick="submitclick();">
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
    
    
      <script>
        function submitclick(){
        	let id=$("#id").val();
			let password=$("#pw").val()
			//아이디가 4글자 미만이면 안됨.
			if(id.trim().length<4){
				alert("아이디는 4글자 이상입력하세요!");
				$("#id").focus();
				return false;
			}
			//패스워드를 입력하지 않으면 안됨.
			if(password.trim().length==0){
				alert("비밀번호를 입력하세요!");
				$("#password").focus();
				return false;
			}
        }
        
        function findId(){
         	const url="<%=request.getContextPath()%>/findId";
  			const name="_blank";
  			const status="left=500px,top=100px,width=500px,height=400px";
  			open(url,name,status);
        }

        function findPw(){
         	const url="<%=request.getContextPath()%>/findPw";
         	const name="_blank";
  			const status="left=500px,top=100px,width=500px,height=400px";
  			open(url,name,status);
        }

        function join(){
          window.open("<%=request.getContextPath()%>/enrollMember","_self");
        }
        </script>
        </section>
<%@ include file="/views/common/footer.jsp" %>