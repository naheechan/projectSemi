<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<%@ page import="com.semi.member.model.vo.Member" %>
<%@ page import="java.util.List" %>
<%
		//서버에서 보낸 데이터 받기
		Member m=(Member)request.getAttribute("member");
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
        height: 40px;
        vertical-align: middle;
        width: 250px;
        border: 1px solid rgb(216,211,205);
        background-color : rgb(239, 241, 243); 
    }
    td{
    	width: 300px;
    	height: 40px;
        vertical-align: middle;
        border: 1px solid rgb(216,211,205);
        text-align: center;
        
    }
    input{
        border: none;
        text-align: center;
        font-size: 15px;
		height: 30px;
		margin-top:4px;
		margin-bottom:4px;
		margin-left: 5px;
		margin-right: 5px;
    }
	table{
		margin-top : 10px;
	}

    #mypages9{
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
            <div class="mypages" id="mypages4" onclick="choiceBtn(event)"><a class="a" href="<%=request.getContextPath()%>/myinfo/studyroomOrderlist?userNo=<%=logginedMember.getMemberNo()%>">스터디룸</a></div>
            <div class="mypages" id="mypages5" onclick="choiceBtn(event)"><a class="a" href="">도서글귀</a></div>
            <div class="mypages" id="mypages6" onclick="choiceBtn(event)"><a class="a" href="">좋아요</a></div>
            <div class="mypages" id="mypages7" onclick="choiceBtn(event)"><a class="a" href="">북클럽</a></div>
            <div class="mypages" id="mypages8" onclick="choiceBtn(event)"><a class="a" href="<%=request.getContextPath()%>/cart/cartmove?userno=<%=logginedMember.getMemberNo()%>">장바구니</a></div>
            <div class="mypages" id="mypages9" onclick="choiceBtn(event)"><a class="a" href="<%=request.getContextPath()%>/myinfo/point?userId=<%=logginedMember.getMemberId()%>">포인트</a></div>
        </div>
        <div class="info-content">
            <div class="myinfo-title">
                <label><p class="p1">POINT</p></label>
            </div>
            <div class="memberInfo">
            	<p class="p2"><%=m.getMemberName()%>님의 포인트 내역은 다음과 같습니다.</p>
                <form id="memberForm" action="" method="post">
                    <table id="table1">
                    	<tr>
                            <th>포인트</th>
                            <td>
                                <input id="point" name="point" type="text" maxlength="10" readonly value="<%=m.getPoint()%>">
                            </td>
                        </tr>
                    </table>
                    <table>
                        <tr>
                            <th>사용 내역</th>
                            <td>
                                <input id="point" name="point" type="text" maxlength="10" readonly value="사용 내역이 없습니다.">
                            </td>
                        </tr>
                        <tr>
                            <th>사용 포인트</th>
                            <td>
                                <input id="point" name="point" type="text" maxlength="10" readonly value="0">
                            </td>
                        </tr>
                    </table>
                    <table>
                        <tr>
                            <th>잔여 포인트</th>
                            <td>
                                <input id="point" name="point" type="text" maxlength="10" readonly value="<%=m.getPoint()%>">
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
</div>

<script>

</section>
    
<%@ include file="/views/common/footer.jsp" %>