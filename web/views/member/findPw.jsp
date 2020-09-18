<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>비밀번호 찾기</title>
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
            text-align: center;
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
            width: 80px;
            display: inline-block;
        }
        .inputdata{
            margin-left: 10px;
            margin-right: 10px;
            margin-bottom: 10px;
            background-color: white; 
            border: 2px;
            border-color: rgb(247,242,231); 
            border-radius: 10px;
            width: 180px;
            height: 30px;}

        #submit{
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
    
    </style>

</head>
<body>
    <div>
    <header>
        <article id="id_text"><h1>Find Password</h1></article>
        <hr>
    </header>
    <section>
      <form action="<%=request.getContextPath()%>/findPwEnd" method="post">
        <fieldset>
            <legend>회원정보로 비밀번호 찾기</legend>
              <ul>
                    <li>
                        <label>아이디</label>
                        <input id="id" class="inputdata" name="id" type="text" maxlength="10"><br>
                    </li>
                    <li>
                        <label>이름</label>
                        <input id="name" class="inputdata" name="name" type="text" maxlength="10"><br>
                    </li>
                    <li>
                        <label>핸드폰번호</label>
                        <input type="text" id="phone" name="phone" class="inputdata" placeholder="010-0000-0000" maxlength="13">
                    </li>
                </ul>
        </fieldset>
        <br>
        <input id="submit" name="submit" type="submit" value="다음" onclick="clicksubmit();">
      </form>

    </section>
    <footer>
    </footer>
    </div>
    <script>
        function clicksubmit(){
            window.open("","_self","width=400, height=400");
        }

    </script>
    </body>
</html>