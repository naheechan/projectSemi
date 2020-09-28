<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.semi.seat.model.vo.Seat"%>
<%@ page import="com.semi.member.model.vo.Member"%>

<% 
	List<Seat> list=(List)request.getAttribute("list");
	String seatDate=(String)request.getAttribute("seatDate");
	System.out.println(seatDate);
	int seatTime=Integer.parseInt(request.getAttribute("seatTime").toString());
	System.out.println(seatTime);
	int useTime=Integer.parseInt(request.getAttribute("useTime").toString());
	int memberCount=Integer.parseInt(request.getAttribute("memberCount").toString());
	Member logginedMember=(Member)session.getAttribute("logginedMember");
%>
<style>

		<%for(Seat s : list) {%>
		
		#<%=s.getSeatNo() %>{
			opacity: 0.4;
  			cursor: not-allowed; 
		}
		<%} %>
		
		.p2{
            text-align: center;
            margin-bottom: 10px;
            font-size: 20px;
            font-weight: bold;
            color: rgb(79, 80, 82); 
        }

        .p3{
            text-align: center;
            margin-bottom: 20px;
            font-size: 18px;
            font-weight: bold;
            color: rgb(79, 80, 82); 
        }
        .seat-wrap{
          width:49%;
          margin:20px auto 0 auto;
          padding: 30px 0;
        }
		.seat-container{
          width:100%;
          text-align: center;
        }
        .R1{
            width:25%;float:left; overflow:hidden;

        }
        .R2{
            width:25%;float:left; overflow:hidden;
        }
        #Room1, #Room3{
        	margin-bottom:5px;
        }
        .seat:hover, .seat:focus {
          background-color: rgb(203, 230, 212); 
        }
        .room:hover, .room:focus {
          background-color: rgb(203, 230, 212); 
        }
        .room{
          border-radius: 10px;
   		  
        }
        #room2, #room4{margin-top:15px}
		.seats{
			position : relative;
            width:50%; float:left; overflow:hidden;
            padding: 58px 2% 0 2%;
            box-sizing: border-box;
		}
        .seats > div{
          width:100%;    
          font-size:0;
        }
        .seats > div:after{
           content:'';
           display:block;
           clear:both;
       }
       .seats > div + div{}
        .seat-a{
          margin-top:4px;
          text-align: center
        }
        .seat-a > div:nth-child(3){
          margin-left:20px
        }
        .seat-b{
          margin-top:4px;
        }
        .seat-b > div:nth-child(3){
          margin-left:20px
        }
        
        .seat-c{
          margin-top:20px
        }
        .seat-d{
          margin-top:4px
        }
        .seat-e{
          margin-top:20px
        }
        .seats > div > div{
          display: inline-block;
          width: calc(20% - 3.2px);
          height:48px;
        }
        .seats > div > div + div{margin-left:4px}
        .seats > div > div > input{
            width:100%;
            height:100%;
            border-radius: 5px
        }
        
        .reserve-button-wrap{
          text-align: center;
           margin-bottom:50px;
        }
        
        #cancel{
          border-radius: 5px;
          position: none;
          display: inline-block;
          margin-top:50px;
        }

        #reserve{
          
          border-radius: 5px;
          display: inline-block;
          margin-left:50px;
         
        }

        #cancel:hover, #seat:focus, #reserve:hover, #reserve:focus{
          background-color:rgb(121,122,126);
        }
        .next{width:100%}
        
        .seat-info-hidden{
        	display:none
        }
        
        @media all and (max-width:1200px){
        .seat-wrap{width:80%}
        }

        </style>
    <!-- 좌석 안내 -->
		<div class="seatText-container">
	        <p class="p2">STUDYROOM MAP</p>
	        <p class="p3">원하시는 좌석을 선택하여 예약하기 버튼을 누르세요.</p>
	        <br>
	        <p class="p3">일반좌석 : 1시간 1000원   | ROOM : 1시간 5000원 (1인 기준)</p>
        </div>
        <div class="seat-wrap">
            <div class="seat-container">
                <!-- room1,2 -->
                <div class="R1">
                  <div><input type="button" value="Room1" id="Room1" class="seat" style="width:90%; height:200px; border-radius:5px" onclick="seatInfoFunction(event)"></div>
                  <div><input type="button" value="Room2" id="Room2" class="seat" style="width:90%; height:150px; border-radius:5px" onclick="seatInfoFunction(event)"></div>
                </div>

                <!-- 좌석 -->
                <div class="seats">
                    <div class="seat-a">
                        <div><input type="button" class="seat" id="A1" value="A1" onclick="seatInfoFunction(event)"></div>
                        <div><input type="button" class="seat" id="A2" value="A2" onclick="seatInfoFunction(event)"></div>
                        <div><input type="button" class="seat" id="A3" value="A3" onclick="seatInfoFunction(event)"></div>
                        <div><input type="button" class="seat" id="A4" value="A4" onclick="seatInfoFunction(event)"></div>
                    </div>

                    <div class="seat-b">
                            <div><input type="button" class="seat" id="B1" value="B1" onclick="seatInfoFunction(event)"></div>
                            <div><input type="button" class="seat" id="B2" value="B2" onclick="seatInfoFunction(event)"></div>
                            <div><input type="button" class="seat" id="B3" value="B3" onclick="seatInfoFunction(event)"></div>
                            <div><input type="button" class="seat" id="B4" value="B4" onclick="seatInfoFunction(event)"></div>
                    </div>

                    <div class="seat-c">
                        <div><input type="button" class="seat" id="C1" value="C1" onclick="seatInfoFunction(event)"></div>
                        <div><input type="button" class="seat" id="C2" value="C2" onclick="seatInfoFunction(event)"></div>
                        <div><input type="button" class="seat" id="C3" value="C3" onclick="seatInfoFunction(event)"></div>
                        <div><input type="button" class="seat" id="C4" value="C4" onclick="seatInfoFunction(event)"></div>
                        <div><input type="button" class="seat" id="C5" value="C5" onclick="seatInfoFunction(event)"></div>
                    </div>

                    <div class="seat-d">
                        <div><input type="button" class="seat" id="D1" value="D1" onclick="seatInfoFunction(event)"></div>
                        <div><input type="button" class="seat" id="D2" value="D2" onclick="seatInfoFunction(event)"></div>
                        <div><input type="button" class="seat" id="D3" value="D3" onclick="seatInfoFunction(event)"></div>
                        <div><input type="button" class="seat" id="D4" value="D4" onclick="seatInfoFunction(event)"></div>
                        <div><input type="button" class="seat" id="D5" value="D5" onclick="seatInfoFunction(event)"></div>
                    </div>

                    <div class="seat-e">
                        <div><input type="button" class="seat" id="E1" value="E1" onclick="seatInfoFunction(event)"></div>
                        <div><input type="button" class="seat" id="E2" value="E2" onclick="seatInfoFunction(event)"></div>
                        <div><input type="button" class="seat" id="E3" value="E3" onclick="seatInfoFunction(event)"></div>
                        <div><input type="button" class="seat" id="E4" value="E4" onclick="seatInfoFunction(event)"></div>
                        <div><input type="button" class="seat" id="E5" value="E5" onclick="seatInfoFunction(event)"></div>
                    </div>


            </div>
            
                <!-- room3,4 -->
                <div class="R2">
                  <div><input type="button" value="Room3" id="Room3"class="seat" style="width:90%; height:200px; border-radius:5px" onclick="seatInfoFunction(event)"></div>
                  <div><input type="button" value="Room4" id="Room4" class="seat" style="width:90%; height:150px; border-radius:5px" onclick="seatInfoFunction(event)"></div>
                </div>
        </div>
     
      	<!-- 좌석 정보 가져오는 텍스트 (히든) -->
        <div class="next">
          <form action="<%=request.getContextPath() %>/seatOrderMove" method="post">
            <div class="seat-info-hidden"><!--개발 후 숨김처리-->
            	<input type="text" name="memberName" id="memberName" class="seatInfo" value="<%=logginedMember.getMemberName()%>">
      			<input type="text" name="email" id="email" class="seatInfo" value="<%=logginedMember.getEmail()%>">	
                <input type="text" name="memberNo" id="memberNo" class="seatInfo" value="<%=logginedMember.getMemberNo()%>">
                <input type="text" name="seatDate" id="seatDate" class="seatInfo" value="<%=seatDate%>">
                <input type="text" name="seatTime" id="seatTime" class="seatInfo" value="<%=seatTime%>">
                <input type="text" name="useTime" id="useTime" class="seatInfo" value="<%=useTime%>">
                <input type="text" name="memberCount" id="memberCount" class="seatInfo" value="<%=memberCount%>">
                <input type="text" name="seatInfo" id="seatInfo" value="A1">
                <input type="text" name="seatPrice" id="seatPrice" value="1000">
            </div>
            <div class="reserve-button-wrap">
                <input id="cancel" type="button" value="취소" onclick="goindex();" style="width:100px;height:50px">
                <input id="reserve" type="submit" value="예약하기" style="width:100px;height:50px" onclick="return seatOrder();">
            </div>
          </form>
        </div>
    </div>
</body>
</html>
        
        <script>
        
        	function seatInfoFunction(event){
        	
        	
	        	document.getElementById('seatInfo').value=event.target.value;
	        	if(event.target.id=="Room1"||event.target.id=="Room2"||event.target.id=="Room3"||event.target.id=="Room4"){
	        		let UseTime=document.getElementById('useTime').value
	        		let memberCount=document.getElementById('memberCount').value
	        		document.getElementById('seatPrice').value=5000*memberCount*UseTime;
	        	}else{
	        		let UseTime=document.getElementById('useTime').value
	        		let memberCount=document.getElementById('memberCount').value
	        		document.getElementById('seatPrice').value=1000*UseTime;
	        	}

        	}
        
          	function goindex(){
            	alert("취소되었습니다.");
            	location.reload();
        	 }
			
          	function seatOrder(){
        		let result=document.getElementById('result').value;
        		console.log("seatOrder함수 :"+result);
          		const url="<%=request.getContextPath()%>/seatOrderMove";
        		const title="seatOrder1";
        		const status="left=500px,top=100px,width=850px,height=650px";
        		window.open("",title,status);
        		
         		seatOrder1.target=title;
        		seatOrder1.action=url;
        		seatOrder1.method="post";
        		seatOrder1.submit();
        		
        		

        		
          	}
        </script>
        
