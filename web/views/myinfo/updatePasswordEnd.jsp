<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<%@ page import="com.semi.member.model.vo.Member" %>
<%@ page import="com.semi.member.model.vo.Interest" %>
<%@ page import="java.util.List" %>
<%
		//서버에서 보낸 데이터 받기
		String userId=(String)request.getAttribute("userId");
%>


<style>

	.sectionInfo{
		display : flex;
        justify-content: center;
	}
	.divInfo{
		display: block;
	}
	.p1{
        font-size: 20px;
        font-weight: bold;
    }
    .p2{
    	font-size: 15px;
        font-weight: bold;
    }
    .myinfo{
    	margin-top: 20px;
        display : flex;
        justify-content: left;
        flex-flow: nowrap row;
    }
    .info-side-bar{
    	margin-top: 40px;
        display: inline-block;
        float: left;
        flex-direction: column;
        width: 200px;
        height: 500px;
    }
    .info-side-bar>div{
        width: 200px;
        height: 50px;
        margin-top:5px;
        background-color: rgb(121,122,126);
        color:white;
        text-align: center;
        line-height: 50px;

    }
    .info-side-bar>.mypage{
    	background-color: rgb(40, 123, 98);
    	color : white;
    	font-size: 18px;
    	font-weight: bold;
    
    }
    .a:link { color: white; text-decoration: none;}
    .a:visited { color:  white; text-decoration: none;}
    .a:hover { color:  white; text-decoration: none;}

    .info-side-bar>div:hover, .info-side-bar>div:active,.info-side-bar>div:focus {
          background-color: rgb(40, 123, 98); 
        }
    .info-content{
    	margin-top:10px;
        display: inline-block;
        float: left;
        margin-left: 50px;
        width: 650px;
        background-color: white;
    }
    .myinfo-title{
        display : flex;
        justify-content: center;
        margin-bottom:15px;
    }
    .memberInfo{
        width: 650px;
        height: 800px;
        background-color:

    }
    #memberForm{
    	margin-top: 20px;	
    }
    th{
        width: 250px;
        border: 1px solid rgb(216,211,205);
    }
    td{
        border: 1px solid rgb(216,211,205);
        text-align: center;
        
    }
    input{
        width: 360px;
        border: 1px solid rgb(216,211,205);
        border-radius: 5px;
        text-align: center;
        font-size: 15px;
		height: 30px;
		margin-top:4px;
		margin-bottom:4px;
		margin-left: 5px;
		margin-right: 5px;
    }
   
    .infobtn1, .infobtn2{
            margin-top: 15px;
            width: 100px;
        	height: 50px;
            background-color: rgb(121,122,126);
            color:white
    }
    .infobtn1{
        margin-left: 30%;
        margin-right: 50px;
    }

    .infobtn1:hover, .infobtn1:active,.infobtn1:focus {
          background-color: rgb(79, 80, 82); 
        }
    .infobtn2:hover, .infobtn2:active,.infobtn2:focus {
          background-color: rgb(79, 80, 82); 
        }

	input[type="text"]{
		font-size: 15px;
		height: 30px;
		margin-top:4px;
		margin-bottom:4px;
	}

	.active{
        	background-color: rgb(40, 123, 98);
        }
    #mypages2{
    		background-color: rgb(40, 123, 98);
    }
    .id_tr{
    	display: none;
    }

</style>

<section class="sectionInfo">
<div class="divInfo">
    <div class="myinfo">
        <div class="info-side-bar">
            <div class="mypage">마이페이지</div>
            <div class="mypages" id="mypages1" onclick="choiceBtn(event)"><a class="a" href="<%=request.getContextPath()%>/infoMove?userId=<%=logginedMember.getMemberId()%>">회원정보</a></div>
            <div class="mypages" id="mypages2" onclick="choiceBtn(event)"><a class="a" href="<%=request.getContextPath()%>/myinfo/passwordUpdate?userId=<%=logginedMember.getMemberId()%>">비밀번호 변경</a></div>
            <div class="mypages" id="mypages3" onclick="choiceBtn(event)"><a class="a" href="<%=request.getContextPath()%>/myinfo/buylist?userno=<%=logginedMember.getMemberNo()%>">주문내역</a></div>
            <div class="mypages" id="mypages4" onclick="choiceBtn(event)"><a class="a" href="">스터디룸</a></div>
            <div class="mypages" id="mypages5" onclick="choiceBtn(event)"><a class="a" href="">나의글귀</a></div>
            <div class="mypages" id="mypages6" onclick="choiceBtn(event)"><a class="a" href="">좋아요목록</a></div>
            <div class="mypages" id="mypages7" onclick="choiceBtn(event)"><a class="a" href="">포인트</a></div>
            <div class="mypages" id="mypages8" onclick="choiceBtn(event)"><a class="a" href="">장바구니</a></div>
        </div>
        <div class="info-content">
            <div class="myinfo-title">
                <label><p class="p1">회원정보</p></label>
            </div>
            <div class="memberInfo">
            	<p class="p2">비밀번호를 재입력하세요</p>
                <form id="memberForm" action="<%=request.getContextPath() %>/updatePasswordEnd" method="post">
                    <table>
                    	<tr class="id_tr">
                            <th>아이디</th>
                            <td>
                                <input id="id" name="id" type="text" maxlength="10" value="<%=userId%>">
                            </td>
                        </tr>
                        <tr>
                            <th>비밀번호</th>
                            <td>
                                <input id="pw" name="pw" type="password" maxlength="20" placeholder="6글자 이상">
                            </td>
                        </tr>
                        <tr>
                            <th>비밀번호 확인</th>
                            <td>
                                <input id="pwck" name="pwck" type="password" maxlength="20">
                            </td>
                        </tr>
                        <tr>
                            <th colspan="2"><label id="result"></label></th>
                        </tr>
                    </table>
                     <input type="reset" class="infobtn1" value="취소">
                     <input type="submit" class="infobtn2" onclick="checkData();'" value="확인">
                </form>
            </div>
        </div>
    </div>
</div>

	<script>
	
	let pwck=document.getElementById("pwck");
	let pass=document.getElementById("pw");
	function focusTest(e){
	    pass.removeEventListener("focus",focusTest);
	}
	
	pass.addEventListener("focus",focusTest);
	pwck.addEventListener("keyup",function(e){
	    const pw=document.getElementById("pw").value.trim();
	    const result=document.getElementById("result");
	    if(e.target.value.trim()==pw){
	        result.style.color="green";
	        result.innerHTML="비밀번호가 일치합니다";
	    }else{
	        result.style.color="red";
	        result.innerHTML="비밀번호가 일치하지 않습니다.";
	    }
	})
	
	</script>
	
	<script>
	function checkData(){

            let pw=document.getElementById("pw");

            if(pw.value.length<5){
                alert("비밀번호를 6글자 이상로 입력하세요.");
                return false;
            }

        	var re2= /^[A-za-z0-9]{6,15}/g;
            if(!re2.test(pw.value)){
                 alert("6~15자리 이내 숫자, 문자만 가능합니다.");
                 return false;
            }

            return true;
        }
            </script>
			<script>
         //탈퇴
        function fn_delete_member(){
 			if(confirm("정말로 탈퇴하시겠습니까?")){
 				location.replace('<%=request.getContextPath()%>/myinfo/deleteMember?id=<%=logginedMember.getMemberId()%>');
 			}
 				
 		}
        
        //업데이트
 		function fn_update_submit(){
 			const frm=$("#memberForm");
 			const url="<%=request.getContextPath()%>/updateInfo";
 			frm.attr({
 				"action":url,
 				"method":"post",
 			});
 			frm.submit();
 		}
        
        </script>
        
        <script>
		function removeClass(){
			$(".mypages").removeClass('active');
      	}
		
		function choiceBtn(event){
			removeClass();
			let addTarget=event.target.id;
			$("#"+addTarget).addClass("active");
		}
        </script>
</section>
    
<%@ include file="/views/common/footer.jsp" %>