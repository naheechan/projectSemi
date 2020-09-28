<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>

<%@ page import="java.util.List,com.semi.seat.model.vo.SeatOrder" %>

<%
	List<SeatOrder> studyroomOrderlist=(List)request.getAttribute("studyroomOrderlist");
	String numPerPage = request.getParameter("numPerPage");
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

    }
    #memberForm{
    	margin-top: 20px;	
    }
    th{
    	flex-basis: 250px;
        height: 40px;
        border: 1px solid rgb(216,211,205);
        vertical-align: middle;
        background-color : rgb(239, 241, 243); 
    }
    td{
    	flex-basis: 250px;
    	height: 40px;
        border: 1px solid rgb(216,211,205);
        text-align: center;
        vertical-align: middle;
        
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
    #mypages4{
    		background-color: rgb(40, 123, 98);
    }
    .id_tr{
    	display: none;
    }
    #studyroomlist{
    	display : flex;
        justify-content: center;
        flex-direction: column;
        flex-wrap: nowrap;
    }

    .pageBar-div{
    	display : flex;
        justify-content: center;
        margin-top: 20px;
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
            <div class="mypages" id="mypages4" onclick="choiceBtn(event)"><a class="a" href="<%=request.getContextPath()%>/myinfo/studyroomOrderlist?userNo=<%=logginedMember.getMemberNo()%>">스터디룸</a></div>
            <div class="mypages" id="mypages5" onclick="choiceBtn(event)"><a class="a" href="<%=request.getContextPath()%>/myinfo/myWordingList?userId=<%=logginedMember.getMemberId()%>">도서글귀</a></div>
            <div class="mypages" id="mypages7" onclick="choiceBtn(event)"><a class="a" href="<%=request.getContextPath()%>/myinfo/myBookclubList?userId=<%=logginedMember.getMemberId()%>">북클럽</a></div>
            <div class="mypages" id="mypages8" onclick="choiceBtn(event)"><a class="a" href="<%=request.getContextPath()%>/cart/cartmove?userno=<%=logginedMember.getMemberNo()%>">장바구니</a></div>
            <div class="mypages" id="mypages9" onclick="choiceBtn(event)"><a class="a" href="<%=request.getContextPath()%>/myinfo/point?userId=<%=logginedMember.getMemberId()%>">포인트</a></div>
        </div>
        <div class="info-content">
            <div class="myinfo-title">
                <label><p class="p1">STUDYROOM RESERVATION LIST</p></label>
            </div>
            <div class="memberInfo">
            	<p class="p2">스터디룸 예약 및 결제 정보는 아래와 같습니다.</p>
                <form id="memberForm" action="" method="post">
                    <div id="studyroomlist">
						<table>
							<tr>
								<th><p class="p2">예약날짜</p></th>
								<th><p class="p2">예약시간</p></th>
								<th><p class="p2">사용시간</p></th>
								<th><p class="p2">좌석이름</p></th>
								<th><p class="p2">예약인원</p></th>
								<th><p class="p2">결제금액</p></th>
								<th><p class="p2">결제일자</p></th>
							</tr>

							<%for(SeatOrder so: studyroomOrderlist){ %>
							<tr>
								<td><%=so.getSeatDate()%></td>
								<td><%=so.getSeatTime()%>시</td>
								<td><%=so.getUseTime()%>시간</td>
								<td><%=so.getSeatNo()%></td>
								<td><%=so.getMemberCount()%>인</td>
								<td><%=so.getSeatPrice()%>원</td>
								<td><%=so.getSeatOrderDate()%></td>
							</tr>
							<%} %>
						</table>
						<div class="pageBar-div">
							<div id="pageBar">
								<%=request.getAttribute("pageBar")%>
							</div>
						</div>
					</div>
                     <!-- 
                     <input type="reset" class="infobtn1" value="취소">
                     <input type="submit" class="infobtn2" onclick="checkData();'" value="확인"> 
                     -->
                </form>
            </div>
        </div>
    </div>
</div>
</section>

<%@ include file="/views/common/footer.jsp" %>