<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="java.util.List,com.semi.buy.model.vo.BuylistJoin" %>
	<%
	List<BuylistJoin>buylist=(List)request.getAttribute("buylist");
	%>
<%@ include file="/views/common/header.jsp"%>
<style>
section{
height:100vh;
}
.myinfo{
	display:flex;
	justify-content: space-between;
	margin:0 auto;
	width:960px;
}
.info-side-bar {
	display: inline-block;
	float: left;
	flex-direction: column;
	width: 200px;
	height: 500px;
}

.info-side-bar>div {
	width: 200px;
	height: 50px;
	margin-top: 5px;
	background-color: rgb(121, 122, 126);
	color: white;
	text-align: center;
	line-height: 50px;
}


table{
border:1px solid black;
}
tr{
border:1px solid black;
}
th{
border:1px solid black;
}
td{
border:1px solid black;

}

a:link {
	color: white;
	text-decoration: none;
}

a:visited {
	color: white;
	text-decoration: none;
}

a:hover {
	color: white;
	text-decoration: none;
}

.info-side-bar>div:hover, .info-side-bar>div:active, .info-side-bar>div:focus
	{
	background-color: rgb(79, 80, 82);
}
</style>
<section>
	<div class="myinfo">
		<div class="info-side-bar">
			<div>마이페이지</div>
			<div>
				<a href="">회원정보</a>
			</div>
			<div>
				<a href="">비밀번호 변경</a>
			</div>
			<div>
				<a href="">주문내역</a>
			</div>
			<div>
				<a href="">스터디룸</a>
			</div>
			<div>
				<a href="">나의글귀</a>
			</div>
			<div>
				<a href="">좋아요목록</a>
			</div>
			<div>
				<a href="">포인트</a>
			</div>
			<div>
				<a href="">장바구니</a>
			</div>
			
		</div>
		
		<div id="buylist">
		<table>
			<tr>
				<th>주문일</th>
				<th>수령자</th>
				<th colspan="2">상품정보</th>
				<th>주문금액</th>
			</tr>
			<%for(BuylistJoin b:buylist){ %>
				<td><%=b.getOrderdate()%></td>
				<td><%=b.getRecipient()%></td>
				<td colspan="2"><%=b.getTitle()%>
				<img height=150px src="<%=request.getContextPath()%>/image/book/<%=b.getBookimg()%>">
				</td>
				
				<td><%=b.getTotalprice()%>원</td>
			<%} %>
		</table>
		</div>
	</div>
</section>
<%@ include file="/views/common/footer.jsp"%>