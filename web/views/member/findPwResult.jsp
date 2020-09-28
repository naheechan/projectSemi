<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.semi.member.model.vo.Member"%>
<% 

		String msg=(String)request.getAttribute("msg");
		String loc=(String)request.getAttribute("loc");
		String memberId=(String)request.getAttribute("memberId");
		String memberName=(String)request.getAttribute("memberName");
		int result=(int)request.getAttribute("result");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ID 결과 확인</title>
    <style>
        /* 코드표 : RGB
        #E0ECE4 : 224,236,228 - 옅은 민트
        #F7F2E7 : 247,242,231 - 베이지
        #D8D3CD : 216,211,205 - 약간 짙은 베이지
        #797A7E : 121,122,126 - 짙은 그레이 
        */
        html{
            background-color: rgb(224,236,228);
        }
        legend{
            font-size: 15px;
            text-align: center;
            color: rgb(79, 80, 82);
            font-weight: bold;
        }
        #id_text{
            font-size: 20px;
            font-weight: bold;
            color: rgb(79, 80, 82);
            text-align: center;
        }


        #close{
            margin-left:43%;
            margin-top:10px;
            background-color:rgb(121,122,126); 
            color:white; 
            font-size: 15px;
            font:bold;
            border: 2px;
            border-color: rgb(247,242,231); 
            border-radius: 10px;
            width: 60px;
            height: 30px;
            text-align:center;
            }
        
    	table{margin-left: 17%;
    		  text-align: center;}
    		  
    	td{	font-size: 15px;
            text-align: center;
            color: rgb(79, 80, 82);
            }
    	
    </style>
</head>
<body>
    <div>
    <header>
        <article id="id_text"><h1>Find Password</h1></article>
        <hr>
    </header>
    <section>
          <script>
		function checkData(){

            let pw=document.getElementById("pw");

            if(pw.value.length<5){
                alert("비밀번호를 6글자 이상로 입력하세요.");
                return false;
            }

        	var re2= /^.*(?=^.{6,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
            if(!re2.test(pw.value)){
                 alert("6~15자리 이내 숫자,문자,특수문자를 포함해야합니다.");
                 return false;
            }

            return true;
        }
            </script>
      <%  if(result==0){%>
      <form action="<%=request.getContextPath()%>/updatePw" method="post">
        <fieldset>
            <legend>비밀번호 재입력</legend>
                <table>
                    <tr>
                        <td colspan="2"><br><%=memberId%>의 비밀번호를 입력하세요.</td>
                    </tr>
                    <tr>
                    <td><br></td>
                    <td><br></td>
                    </tr>
					<tr>
                       <td>비밀번호</td>
               		   <td><input id="pw" name="pw" type="password" maxlength="20" placeholder="6글자 이상"></td>
               		</tr>
               		<tr>
               			<td>비밀번호 확인</td>
               		    <td><input id="pwck" name="pwck" type="password" maxlength="20"><span id="result"></td>
                    </tr>
                    <tr>
                    	<td><input type="hidden" id="id" name="id" value="<%=memberId%>"></td>
                    	<td><input type="hidden" id="name" name="name" value="<%=memberName%>"></td>
                    </tr>
                </table>
       	</fieldset>
       	<br>
       	<div>
       	<input id="close" name="close" type="submit" onclick="return checkData();" value="변경" >
       	</div>
      </form>
      <%} else{%>
      <script>
    	//알람메세지띄우기
		alert("<%=msg%>");
      	window.open('','_self').close();
      </script>
      <%} %>
    </section>
    </div>
</body>
</html>