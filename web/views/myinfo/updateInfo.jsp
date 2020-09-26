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
		String[] checks=new String[5];
		String[] gcheck=new String[2];
		for(Interest inter : list){
			System.out.println(inter.getCategoryNo());
			if(inter.getCategoryNo().equals("100")){checks[0]="checked";}
			if(inter.getCategoryNo().equals("200")){checks[1]="checked";}
			if(inter.getCategoryNo().equals("300")){checks[2]="checked";}
			if(inter.getCategoryNo().equals("400")){checks[3]="checked";}
			if(inter.getCategoryNo().equals("500")){checks[4]="checked";}
		}
		
		if(m.getGender().equals("M")){
			gcheck[0]="selected";
		}else{
			gcheck[1]="selected";
		}
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
    }
    #sample4_jibunAddress{
    	display : none;
    }
    .interest {
			width: 15px;
        	height: 20px;
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
    .gender{
        width: 360px;
        text-align: center;
        font-size: 15px;
		height: 30px;
		border: 1px solid rgb(216,211,205);
		margin-top:4px;
		margin-bottom:4px;
		border-radius: 5px;
    }
	input[type="text"]{
		font-size: 15px;
		height: 30px;
		margin-top:4px;
		margin-bottom:4px;
	}
	select { text-align-last:center; }
	
	.active{
        	background-color: rgb(40, 123, 98);
        }
    #mypages1{
    		background-color: rgb(40, 123, 98);
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
                <form id="memberForm" action="" method="post">
                    <table>
                        <tr>
                            <th>아이디</th>
                            <td>
                                <input id="id" name="id" type="text" maxlength="10" readonly value="<%=m.getMemberId()%>">
                            </td>
                        </tr>
                        <tr>
                            <th>이름</th>
                            <td>
                                <input id="name" name="name" type="text" maxlength="6" readonly value="<%=m.getMemberName()%>">
                            </td>
                        </tr>
                        <tr>
                            <th>생년월일</th>
                            <td>
                                <input id="birth" name="birth" type="date" readonly value="<%=m.getBirth()%>">
                            </td>
                        </tr>
                        <tr>
                            <th>성별</th>
                            <td>
                                <select id="gender" name="gender" class="gender">
                                    <option value="M" <%=gcheck[0]%>>남자</option>
                                    <option value="F" <%=gcheck[1]%>>여자</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th>주소</th>
                            <td>
                                <input type="button" id="btn_postcode" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
                                <input type="text" id="sample4_postcode" name="postcode" placeholder="우편번호" value="<%=m.getPostcode() %>">
                                <input type="text" id="sample4_roadAddress" name="address" placeholder="도로명주소" value="<%=m.getAddress() %>">
                                <input type="text" id="sample4_jibunAddress" name="address1" placeholder="지번주소">
                                <span id="guide" style="color:#999;display:none"></span>
                                <input type="text" id="sample4_detailAddress" name="extraAddress" placeholder="상세주소" value="<%=m.getExtraAddress()%>"><br>
                                <input type="text" id="sample4_extraAddress" name="detailAddress" placeholder="동/구" value="<%=m.getDetailAddress() %>">
                            </td>
                        </tr>
                        <tr>
                            <th>이메일</th>
                            <td>
                                <input id="email" name="email" type="text" maxlength="25" value="<%=m.getEmail()%>">
                            </td>
                        </tr>
                        <tr>
                            <th>휴대폰</th>
                            <td>
                                <input type="text" id="phone" name="phone" maxlength="13" value="<%=m.getPhone()%>"><br>
                            </td>
                        </tr>
                        <tr>
                            <th>관심분야</th>
                            <td>
                                <input type="checkbox" name="interest" id="interest0" value="100" class="interest" 
                                <%=checks[0]%>>
                                <label for="interest0">인문사회</label>
                                <input type="checkbox" name="interest" id="interest1" value="200" class="interest" 
                                <%=checks[1]%>>
                                <label for="interest1">자연과학</label>
                                <input type="checkbox" name="interest" id="interest2" value="300" class="interest" 
                                <%=checks[2]%>>
                                <label for="interest2">정보통신</label>
                                <br>
                                <input type="checkbox" name="interest" id="interest3" value="400" class="interest" 
                                <%=checks[3]%>>
                                <label for="interest3">자기개발</label>
                                <input type="checkbox" name="interest" id="interest4" value="500" class="interest" 
                                <%=checks[4]%>>
                                <label for="interest4">문학</label>
                            </td>
                        </tr>
            
                    </table>
                    
                     <input type="button" class="infobtn1" onclick="fn_update_submit();" value="정보수정">
                     <input type="button" class="infobtn2" onclick="fn_delete_member();" value="회원탈퇴">
                </form>
            </div>
            </div>
        </div>
    </div>
</div>

<!-- 우편번호 자바 스크립트 -->
			<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
			<script>
			    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
			    function sample4_execDaumPostcode() {
			        new daum.Postcode({
			            oncomplete: function(data) {
			                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
			
			                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
			                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
			                var roadAddr = data.roadAddress; // 도로명 주소 변수
			                var extraRoadAddr = ''; // 참고 항목 변수
			
			                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
			                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
			                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
			                    extraRoadAddr += data.bname;
			                }
			                // 건물명이 있고, 공동주택일 경우 추가한다.
			                if(data.buildingName !== '' && data.apartment === 'Y'){
			                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
			                }
			                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
			                if(extraRoadAddr !== ''){
			                    extraRoadAddr = ' (' + extraRoadAddr + ')';
			                }
			
			                // 우편번호와 주소 정보를 해당 필드에 넣는다.
			                document.getElementById('sample4_postcode').value = data.zonecode;
			                document.getElementById("sample4_roadAddress").value = roadAddr;
			                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
			                
			                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
			                if(roadAddr !== ''){
			                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
			                } else {
			                    document.getElementById("sample4_extraAddress").value = '';
			                }
			
			                var guideTextBox = document.getElementById("guide");
			                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
			                if(data.autoRoadAddress) {
			                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
			                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
			                    guideTextBox.style.display = 'block';
			
			                } else if(data.autoJibunAddress) {
			                    var expJibunAddr = data.autoJibunAddress;
			                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
			                    guideTextBox.style.display = 'block';
			                } else {
			                    guideTextBox.innerHTML = '';
			                    guideTextBox.style.display = 'none';
			                }
			            }
			        }).open();
			    }
			</script>
            <script>

function checkData(){
            let id=document.getElementById("id");
            let pw=document.getElementById("pw");
            let name=document.getElementById("name");
            let idCheckResult=document.getElementById("idCheckResult");
			let birth=document.getElementById("birth").value;
			console.log("생년월일:"+birth);
			let gender=document.getElementById("gender").value;
			console.log("성별:"+gender+"/");
			let sample4Postcode=document.getElementById("sample4_postcode");
			let sample4RoadAddress=document.getElementById("sample4_roadAddress");
			let sample4DetailAddress=document.getElementById("sample4_detailAddress");
			let email=document.getElementById("email");
			let phone=document.getElementById("phone");
			
            if(id.value.length<3){
                alert("아이디를 4글자 이상으로 입력하세요");
                return false;
            }
            var re1=/^[A-za-z]/g;
            if(!re1.test(id.value)){
                 alert("대소문자, 숫자만 가능합니다.");
                 return false;
            }
            if(idCheckResult.value=="0"){
            	alert("아이디 중복확인을 해주세요.");
            	return false;
            }

            if(pw.value.length<5){
                alert("비밀번호를 6글자 이상로 입력하세요.");
                return false;
            }

        	var re2= /^[A-za-z0-9]{6,15}/g;
            if(!re2.test(pw.value)){
                 alert("6~15자리 이내 숫자, 문자만 가능합니다.");
                 return false;
            }
        	
            if(name.value.length<2){
                alert("이름을 2글자 이상로 입력하세요.");
                return false;
            }
        	var re3= /^[가-힣a-zA-Z]/g;
            if(!re3.test(name.value)){
                 alert("대소문자, 한글만 가능합니다.");
                 return false;
            }
            if(birth==""){
                alert("생년월일을 선택하세요.");
                return false;
            }
            if(gender=="X"){
                alert("성별을 선택하세요.");
                return false;
            }
             if(sample4Postcode.value.length<1){
                alert("우편번호를 입력하세요");
                return false;
            }
            if(sample4RoadAddress.value.length<1){
                alert("주소를 입력하세요.");
                return false;
            }
            if(sample4DetailAddress.value.length<1){
                alert("상세주소를 입력하세요.");
                return false;
            }
            if(email.value.length<1){
                alert("이메일을 입력하세요.");
                return false;
            }
            /* 대소문자, @,.를 써야함. */
        	var re4=/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
            if(!re4.test(email.value)){
                 alert("이메일을 다시 입력하세요.");
                 return false;
            }
            if(phone.value.length<1){
                alert("전화번호를 입력하세요.");
                return false;
            }

        	var re5=/^\d{3}-\d{3,4}-\d{4}$/;
            if(!re4.test(email.value)){
                 alert("000-0000-0000 방식으로 입력하세요.");
                 return false;
            }
            if(interest=="X"){
                alert("관심분야를 선택하세요.");
                return false;
            }
            alert("회원가입이 완료되었습니다.");
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