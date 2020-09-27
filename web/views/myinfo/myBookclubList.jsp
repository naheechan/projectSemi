<%@page import="com.semi.myinfo.model.vo.MyBookclub"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.semi.member.model.vo.Member" %>
<%@ page import="java.util.List" %>
<%@ page import="com.semi.wording.model.vo.*, java.util.Map" %>    
<%@ page import="com.semi.myinfo.model.vo.*" %>  
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/wordingBoard.css">
<script src="<%=request.getContextPath()%>/js/wordingBoard.js"></script>
<%@ include file="/views/common/header.jsp" %>
<%
		//서버에서 보낸 데이터 받기
		List<MyBookclub> MyBookclubList=(List)request.getAttribute("MyBookclubList");
		List<MyBookclub> MyBookclubListParti=(List)request.getAttribute("MyBookclubListParti");
		System.out.println("jsp 조장 : "+MyBookclubList);
		System.out.println("jsp 조원 : "+MyBookclubListParti);
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
        height: 30px;
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

    #mypages7{
    		background-color: rgb(40, 123, 98);
    }

    #buylist{
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
                <label><p class="p1">BOOKCLUB LIST</p></label>
            </div>
            <div class="memberInfo">
            	<p class="p2">북클럽 활동 내역</p>
                <form id="memberForm" action="" method="post">
                    <div id="buylist">
						<table>
							<p class="p2">북클럽 관리</p>
							<tr>
								<th><p class="p2">북클럽명</p></th>
								<th><p class="p2">북클럽이미지</p></th>
								<th><p class="p2">도서명</p></th>
								<th><p class="p2">지은이</p></th>
								<th><p class="p2">조장</p></th>
								<th><p class="p2">조원</p></th>
								<th><p class="p2">개설일자</p></th>
							</tr>

							<%for(MyBookclub mbc:MyBookclubList){ %>
							<tr>
								<td><%=mbc.getBookclubTitle()%></td>
								<td><img height=150px src="<%=request.getContextPath()%>/image/book/<%=mbc.getBookclubImg()%>"></td>
								<td><%=mbc.getBookTitle()%></td>
								<td><%=mbc.getBookAuthor()%></td>
								<td><%=mbc.getWriter()%></td>
								<td><%=mbc.getPartiId()%></td>
								<td><%=mbc.getBookclubDate()%></td>
							</tr>
							<%} %>
						</table>
								<div class="pageBar-div">
								<div id="pageBar">
									<%=request.getAttribute("pageBar")%>
								</div>
						</div>
						<table>
							<p class="p2">북클럽 참여</p>
							<tr>
								<th><p class="p2">북클럽명</p></th>
								<th><p class="p2">북클럽이미지</p></th>
								<th><p class="p2">도서명</p></th>
								<th><p class="p2">지은이</p></th>
								<th><p class="p2">조장</p></th>
								<th><p class="p2">조원</p></th>
								<th><p class="p2">개설일자</p></th>
							</tr>

							<%for(MyBookclub parti:MyBookclubListParti){ %>
							<tr>
								<td><%=parti.getBookclubTitle()%></td>
								<td><img height=150px src="<%=request.getContextPath()%>/image/book/<%=parti.getBookclubImg()%>"></td>
								<td><%=parti.getBookTitle()%></td>
								<td><%=parti.getBookAuthor()%></td>
								<td><%=parti.getWriter()%></td>
								<td><%=parti.getPartiId()%></td>
								<td><%=parti.getBookclubDate()%></td>
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