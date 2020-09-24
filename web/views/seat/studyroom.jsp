<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ include file="/views/common/header.jsp" %>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
<style> 
        /* 코드표 : RGB
        #E0ECE4 : 224,236,228 - 옅은 민트
        #F7F2E7 : 247,242,231 - 베이지
        #D8D3CD : 216,211,205 - 약간 짙은 베이지
        #797A7E : 121,122,126 - 짙은 그레이 
        */

        #section_text{
            text-align: center;
            font-size: 25px;
            font-weight: bold;
            color: rgb(79, 80, 82);
            height: 30px;
        }
        .p1{
            text-align: center;
            font-size: 18px;
            font-weight: bold;
            color: rgb(79, 80, 82); 
            margin-top: 15px;
            margin-bottom: 15px;
        }
        
        .choicedate {
          display: inline-block;
          margin-left: 27%;
        }

        .datebtn {
          background-color: rgb(121,122,126);
          color: rgb(247,242,231);
          padding: 16px;
          font-size: 14px;
          border: none;
          cursor: pointer;
          border-radius:10px;
        }
        
        .datebtn:hover, .datebtn:active,.datebtn:focus {
          background-color: rgb(79, 80, 82); 
        }

        .choicetime {
          display: inline-block;
          margin-left: 31%;
        }
        
        .timebtn {
          background-color: rgb(121,122,126);
          color: rgb(247,242,231);
          padding: 16px;
          font-size: 14px;
          border: none;
          cursor: pointer;
          border-radius:10px;
        }
        .choicedate a{
            font-size: 14px;
            font-weight: bold;
            color: rgb(79, 80, 82); 
        }
        .timebtn:hover, .timebtn:focus {
          background-color: rgb(79, 80, 82);
        }
        
        
  		.choiceUseTime {
          display: inline-block;
          margin-left: 34.7%;
        }

        .useTime {
          background-color: rgb(121,122,126);
          color: rgb(247,242,231);
          padding: 16px;
          font-size: 14px;
          border: none;
          cursor: pointer;
          border-radius:10px;
        }
        
        .useTime:hover, .useTime:focus {
          background-color: rgb(79, 80, 82); 
        }
        
        .choiceMemberCount {
          display: inline-block;
          margin-left: 43.5%;
        }

        .memberCount {
          background-color: rgb(121,122,126);
          color: rgb(247,242,231);
          padding: 16px;
          font-size: 14px;
          border: none;
          cursor: pointer;
          border-radius:10px;
        }
        
        .memberCount:hover, .memberCount:focus {
          background-color: rgb(79, 80, 82); 
        }
        
        
        #btn_SeatList{
          background-color: rgb(203, 230, 212);
          margin-left: 47.4%;
          color: rgb(79, 80, 82);
          padding: 16px;
          font-size: 14px;
          border: none;
          cursor: pointer;
          border-radius:10px;
        }
        
        #btn_SeatList:hover, #btn_SeatList:focus {
          background-color: rgb(143, 187, 158); 
        }
        .seatInfo{
        	witdh: 50px;
        	heigh: 30px;
        }
		
		.seat-info-hidden{
		
        	display:none
        }
        .active{
        	background-color: rgb(79, 80, 82);
        }
</style>
	<!-- 날짜 선택 --> 
<section id="msection">
<div id="studyroom_container">

    <div>
        <article id="section_text">STUDY ROOM RESERVATION</article>
        <br>
        <p class="p1">원하시는 날짜와 시간을 선택하세요.</p>
   
	</div>
    
    <div class="choicedate">
    	
    	<button type="button" id="datebtn1" value="1" class="datebtn" onclick="dateFunction(event)">1</button>
    	<button type="button" id="datebtn2" value="1" class="datebtn" onclick="dateFunction(event)">2</button>
    	<button type="button" id="datebtn3" value="1" class="datebtn" onclick="dateFunction(event)">3</button>
    	<button type="button" id="datebtn4" value="1" class="datebtn" onclick="dateFunction(event)">4</button>
    	<button type="button" id="datebtn5" value="1" class="datebtn" onclick="dateFunction(event)">5</button>
    	<button type="button" id="datebtn6" value="1" class="datebtn" onclick="dateFunction(event)">6</button>
    	<button type="button" id="datebtn7" value="1" class="datebtn" onclick="dateFunction(event)">7</button>

    </div>
    <br>
    <br>
    <div class="choicetime">
    	<button type="button" id="timebtn1" onclick="timeFunction(event)" class="timebtn" value="09">09:00</button>
    	<button type="button" id="timebtn2" onclick="timeFunction(event)" class="timebtn" value="10">10:00</button>
    	<button type="button" id="timebtn3" onclick="timeFunction(event)" class="timebtn" value="11">11:00</button>
    	<button type="button" id="timebtn4" onclick="timeFunction(event)" class="timebtn" value="12">12:00</button>
    	<button type="button" id="timebtn5" onclick="timeFunction(event)" class="timebtn" value="13">13:00</button>
    	<button type="button" id="timebtn6" onclick="timeFunction(event)" class="timebtn" value="14">14:00</button>
    	<button type="button" id="timebtn7" onclick="timeFunction(event)" class="timebtn" value="15">15:00</button>
    	<button type="button" id="timebtn8" onclick="timeFunction(event)" class="timebtn" value="16">16:00</button>
    	<button type="button" id="timebtn9" onclick="timeFunction(event)" class="timebtn" value="17">17:00</button>
    	<button type="button" id="timebtn10" onclick="timeFunction(event)" class="timebtn" value="18">18:00</button>

    </div>
    
    <p class="p1">이용 시간</p>
    <div class="choiceUseTime">
    	<button type="button" id="useTime1" onclick="useTimeFunction(event)" class="useTime" value="1">1시간</button>
    	<button type="button" id="useTime2" onclick="useTimeFunction(event)" class="useTime" value="2">2시간</button>
    	<button type="button" id="useTime3" onclick="useTimeFunction(event)" class="useTime" value="3">3시간</button>
    	<button type="button" id="useTime4" onclick="useTimeFunction(event)" class="useTime" value="4">4시간</button>
    	<button type="button" id="useTime5" onclick="useTimeFunction(event)" class="useTime" value="5">5시간</button>
    	<button type="button" id="useTime6" onclick="useTimeFunction(event)" class="useTime" value="6">6시간</button>
    	<button type="button" id="useTime7" onclick="useTimeFunction(event)" class="useTime" value="7">7시간</button>
    	<button type="button" id="useTime8" onclick="useTimeFunction(event)" class="useTime" value="8">8시간</button>
    </div>
    
    <p class="p1">인원</p>
    <div class="choiceMemberCount">
    	<button type="button" id="memberCount1" onclick="memberCountFunction(event)" class="memberCount" value="1">1명</button>
    	<button type="button" id="memberCount2" onclick="memberCountFunction(event)" class="memberCount" value="2">2명</button>
    	<button type="button" id="memberCount3" onclick="memberCountFunction(event)" class="memberCount" value="3">3명</button>
    	<button type="button" id="memberCount4" onclick="memberCountFunction(event)" class="memberCount" value="4">4명</button>

    </div>
        
        <!-- (보이지 않음) seatServlet으로 데이터를 보내주기 위한 좌석 예약 정보 -->
        <div class="seat-info-hidden">
			<input type="text" name="memberNo" id="memberNo" class="seatInfo" value="<%=logginedMember.getMemberNo()%>">
			<input type="text" name="seatDate" id="seatDate" class="seatInfo" value="yyyy-MM-dd">
			<input type="text" name="seatTime" id="seatTime" class="seatInfo" value="0">
			<input type="text" name="useTime" id="useTime" class="seatInfo" value="0">
			<input type="text" name="memberCount" id="memberCount" class="seatInfo" value="0">
	 	</div>
		<br>
		<br>
		<button id="btn_SeatList">좌석 조회</button>
		<br>
		<br>
			
		<!-- 좌석 보기 Ajax -->	
		<div id="seatMap"></div>
		<br>
		<br>
		
		

		<script> 		
		let date =new Date();
        let week = new Array('일','월','화','수','목','금','토');
        let today=new Date();

        var btns=document.getElementsByClassName("datebtn");
     	
        for(let i=0;i<btns.length;i++){
        	btns[i].value=(today.getFullYear())+"/"+(today.getMonth()+1)+"/"+(today.getDate());
        	today.setDate(today.getDate()+1);
        }
        today.setDate(today.getDate()-7);
        
        for(let i=0;i<btns.length;i++){
            btns[i].innerHTML=(today.getMonth()+1)+"월 "+(today.getDate())+"일 ("+week[(today.getDay())]+")";
            today.setDate(today.getDate()+1);
        }

		</script>
		
		<script>
			function removeClass(className){
				$("."+className).removeClass('active');
          	}
			
			function dateFunction(event){
				document.getElementById('seatDate').value=event.target.value;	
				removeClass('datebtn');
				let addTarget=event.target.id;
				$("#"+addTarget).addClass("active");
				
			}
		
			function timeFunction(event){
				document.getElementById('seatTime').value=event.target.value;
				removeClass('timebtn');
				let addTarget=event.target.id;
				$("#"+addTarget).addClass("active");
			}
			
			function useTimeFunction(event){
				document.getElementById('useTime').value=event.target.value;
				removeClass('useTime');
				let addTarget=event.target.id;
				$("#"+addTarget).addClass("active");
			}
			
			function memberCountFunction(event){
				document.getElementById('memberCount').value=event.target.value;
				removeClass('memberCount');
				let addTarget=event.target.id;
				$("#"+addTarget).addClass("active");
			}
			
			
		</script>
		<!-- 좌석 MAP 요청하고 받아오는 ajax -->
		<script>		
			$("#btn_SeatList").click(e => {
				$.ajax({
					url : "<%=request.getContextPath()%>/seatGet",
					type : "get",
					dataType : "html",
					data : {
						memberNo : $("#memberNo").val(),
						seatDate : $("#seatDate").val(),
						seatTime : $("#seatTime").val(),
						useTime : $("#useTime").val(),
						memberCount : $("#memberCount").val()
					},
					success : data => {
						console.log(data);
						$("#seatMap").html(data);
					}
				});
			});
		</script>
		
</div>			
</section>	
			
<%@ include file="/views/common/footer.jsp" %>