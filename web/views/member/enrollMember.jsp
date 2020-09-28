<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 헤더 -->
<%@ include file="/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/enroll.css" type="text/css">
<style>
		/* 코드표 : RGB
        #E0ECE4 : 224,236,228 - 옅은 민트
        #F7F2E7 : 247,242,231 - 베이지
        #D8D3CD : 216,211,205 - 약간 짙은 베이지
        #797A7E : 121,122,126 - 짙은 그레이 
        */
        body{background-color:white}
        
        #signUp_text{
            font-size: 40px;
            font-weight: bold;
            color: rgb(79, 80, 82);
            text-align: center;
            margin-bottom: 20px;
            padding-top: 40px;
            }

        form{margin-left:36% ; 
            }
        
        h3{
            margin-top:10px; 
            margin-left:7%; 
            margin-bottom:0px;
            color: rgb(79, 80, 82);
        }

        input{
            margin-left:7%;
            margin-top:10px;
            background-color: rgb(235, 245, 238); 
            border: 2px;
            border-color: rgb(235, 245, 238);
            border-radius: 10px;
            width: 400px;
            height: 40px;
            font-size: 16px;
            font:bold;
            text-align:center;
            color: rgb(79, 80, 82);
        }
        #id{
            float: left;
            width: 295px;
            height: 40px;
        }

        #btnId{
            margin-left:10px;
            margin-top:-5px;
            background-color: rgb(245, 240, 223); 
            border: 2px;
            border-color: rgb(245, 240, 223); 
            border-radius: 10px;
            width: 100px;
            height: 40px;
            font-size: 15px;
            font:bold;
            color: rgb(79, 80, 82);
            text-align:center;
        }

        #resultid{
            margin-bottom: 10px;
            margin-right: 10px;
        }
        #result{
            margin-left: 20px;
        }
        #name{
            width: 400px;
            height: 40px;
            font-size: 16px;
        }
        #email, #address{
            width: 400px;
            height: 40px;
            font-size: 16px;
        }
        #gender{
            margin-left:7%;
            margin-top:10px;
            background-color: rgb(235, 245, 238);
            border: 2px;
            border-color: rgb(235, 245, 238); 
            border-radius: 10px;
            width: 400px;
            height: 40px;
            font-size: 16px;
            font:bold;
            color: rgb(79, 80, 82);
        }
        #telecom{
            margin-left:7%;
            margin-top:10px;
            background-color: rgb(235, 245, 238);
            border: 2px;
            border-color: rgb(235, 245, 238); 
            border-radius: 10px;
            width: 100px;
            height: 40px;
            font-size: 16px;
            font:bold;
            color: rgb(79, 80, 82);
        }

        #phone{
            margin-left:10px;
            margin-top:10px;
            background-color: rgb(235, 245, 238);
            border: 2px;
            border-color: rgb(235, 245, 238); 
            border-radius: 10px;
            width: 285px;
            height: 40px;
            font-size: 16px;
            font:bold;
            color: rgb(79, 80, 82);
        }
        
        #sample4_postcode{
            width: 285px;
            height: 40px;
            font-size: 16px;
        }
        
        #btn_postcode{
            margin-left:10px;
            margin-top:-5px;
            background-color: rgb(245, 240, 223); 
            border: 2px;
            border-color: rgb(245, 240, 223); 
            border-radius: 10px;
            width: 100px;
            height: 40px;
            font-size: 15px;
            font:bold;
            color: rgb(79, 80, 82);
            text-align:center;
        }
        #sample4_roadAddress, #sample4_detailAddress, #sample4_extraAddress{
         	width: 400px;
            height: 40px;
            font-size: 16px;
        }
        #sample4_jibunAddress{
        	display : none;
        }
           		
        #submit{
            margin-top:30px;
            background-color:rgb(121,122,126); 
            color:white; 
            font-size: 15px;
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
        
        select { width: 400px; text-align-last:center; }
       	.interest {
			width: 20px;
        	height: 20px;
        }
     
     	label { 
     		color: rgb(79, 80, 82);
     		font-size: 15px;
     	}
        	
</style>
	<section>
        <div>
            <article id="signUp_text">Sign Up</article>
            <br>
            <hr>
            <br>
            <form name="enrollMemberForm" action="<%=request.getContextPath()%>/memberEnrollEnd" method="post">
                <h3 class="join_title" id="id_text">아이디</h3>
                <input id="id" name="id" type="text" maxlength="10" placeholder="3글자 이상 작성해주세요"><br>
                <button id="btnId" type="button" onclick="checkId();">중복확인</button>
    
                <h3 class="join_title">비밀번호</h3>
                <input id="pw" name="pw" type="password" maxlength="20" placeholder="6글자 이상"><br>
                
                <h3 class="join_title">비밀번호 재확인</h3>
                <input id="pwck" name="pwck" type="password" maxlength="20"><span id="result"></span><br>
                
                <h3 class="join_title">이름</h3>
                <input id="name" name="name" type="text" maxlength="6"><br>
                
                <h3 class="join_title">생년월일</h3>
                <input id="birth" type="date" name="birth"><br>
                
                <h3 class="join_title">성별</h3>
                <select id="gender" name="gender">
	                <option value="X" selected>성별</option>
	                <option value="M">남자</option>
	                <option value="F">여자</option>
                </select>
    
                <h3 class="join_title">주소</h3>
                <input type="text" id="sample4_postcode" name="postcode" placeholder="우편번호">
				<input type="button" id="btn_postcode" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
				<input type="text" id="sample4_roadAddress" name="address" placeholder="도로명주소">
				<input type="text" id="sample4_jibunAddress" name="address1" placeholder="지번주소"><br>
				<span id="guide" style="color:#999;display:none"></span>
				<input type="text" id="sample4_detailAddress" name="extraAddress" placeholder="상세주소"><br>
				<input type="text" id="sample4_extraAddress" name="detailAddress" placeholder="동/구">

                <h3 class="join_title">이메일</h3>
                <input id="email" name="email" type="text" maxlength="25"><br>
    
                <h3 class="join_title">핸드폰번호</h3>
                <select id="telecom" name="telecom">
                <option value="SKT" selected>SKT</option>
                <option value="KT">KT</option>
                <option value="LGU+">LGU+</option>
                </select>
                <input type="text" id="phone" name="phone" placeholder="010-0000-0000" maxlength="13">
                <br>
                
                	<!-- 관심사 넣기 (인문사회, 자연과학 정보통신, 문학, 자기계발) -->
                <h3 class="join_title">관심분야</h3>
                	<input type="checkbox" name="interest" class="interest" id="interest0" value="100">
                    <label for="interest0">인문사회</label>
                    <input type="checkbox" name="interest" class="interest" id="interest1" value="200">
                    <label for="interest1">자연과학</label>
                    <input type="checkbox" name="interest" class="interest" id="interest2" value="300">
                    <label for="interest2">정보통신</label>
                    <br>
                    <input type="checkbox" name="interest" class="interest" id="interest3" value="400">
                    <label for="interest3">자기계발</label>
                    <input type="checkbox" name="interest" class="interest" id="interest4" value="500">
                    <label for="interest4">문학</label>
    			<br>
    			
                <input id="submit" type="submit" onclick="return checkData();" value="가입하기">
            </form>
            
            
            <!-- 중복아이디 검사를 위한 보이지 않는 아이디창 -->
            <form action="" name="checkIdDuplicate">
			<input type="hidden" name="id">
			</form>
			
			<!-- 중복검사를 실행했는지 체크하기 위해 보이지 않는 창 -->
			<input type="hidden" id="idCheckResult" name="idCheckResult" value="0">
			
        </div>  
        <br>
        <br>
        <br>
        
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
		
		<!-- 유효성 검사 자바스크립트 -->
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

        function checkId(){

    		//입력된 아이디값이 4글자 이상인지 확인
    		let id=$("#id").val().trim();
    		if(id.length<4){
    			alert("아이디는 4글자 이상입력하세요!");
    			return;
        	}
    		//중복확인할 새창을 띄우기
    		const url="<%=request.getContextPath()%>/checkIdDuplicate";
    		const title="chekcIdDuplicate";
    		const status="left=500px,top=100px,width=500px,height=200px";
    		open("",title,status);
    		
    		//form에 데이터를 채우고 open된 윈도우에서 결과를 받는 로직을 구성
    		//자바스크립트에서 form은 name속성으로 요소를 가져올 수 있음
    		console.log(checkIdDuplicate);
    		checkIdDuplicate.target=title;//form을 전송하는 윈도우를 선정
    		checkIdDuplicate.action=url;
    		checkIdDuplicate.method="post";
    		//input에 id값 넣기 formname속성값에서 inputname속성값으로 가져올 수 있음
    		console.log(checkIdDuplicate.id);
    		checkIdDuplicate.id.value=id;
    		//form 전송하기
    		checkIdDuplicate.submit();

        }

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

      </section>
      

<%@ include file="/views/common/footer.jsp" %>