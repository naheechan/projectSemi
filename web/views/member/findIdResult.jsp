<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.semi.member.model.vo.Member"%>
<% 

		String msg=(String)request.getAttribute("msg");
		String loc=(String)request.getAttribute("loc");
		String memberId=(String)request.getAttribute("memberId");
		String memberName=(String)request.getAttribute("memberName");
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
        }
        #id_text{
            font-size: 20px;
            font-weight: bold;
            color: rgb(79, 80, 82);
            text-align: center;
        }
        ul{  
            list-style: none;
            margin-left: 15%;
        }
        label{
            position: relative;
            margin-left: -20px;
            text-align: center;
            width: 300px;
            display: inline-block;
            color: rgb(79, 80, 82);
        }
		span{
			font-size : 18px;
			font-weight: bold;
			color: green;
		}

        #submit{
            margin-left:45%;
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
    
    </style>
	<script>

		//알람메세지띄우기
		alert("<%=msg%>");
	
	</script>
</head>
<body>
    <div>
    <header>
        <article id="id_text"><h1>Find ID</h1></article>
        <hr>
    </header>
    <section>
      <form action="" method="post">
        <fieldset>
            <legend>아이디 찾기 결과</legend>
                <ul>
                    <li>
                        <label><%=memberName%>님의 아이디는</label>
                        <br>
                        <label><span><%=memberId%></span> 입니다.</label><br>
                    </li>
                </ul>
       	</fieldset>
       	<br>
       	<input id="submit" name="close" type="button" value="닫기" onclick="window.open('','_self').close();">
      </form>
    </section>
    </div>
</body>
</html>