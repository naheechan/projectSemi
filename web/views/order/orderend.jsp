<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<style>
body{
height:80vh;
}
#orderend{
width:960px;
margin:0 auto;
}
#endtitle{
font-size:30px;
margin:0 auto;
width:960px;
margin-top:25px;
}
.maintext{
text-shadow: 0px 1px #ffffff, 4px 4px 0px #dad7d7;

margin-top:25px;
margin-bottom:25px;
height:500px;
border:1px solid black;
display:flex;
justify-content: center;
flex-flow: column nowrap;
   align-items: center;
}
.maintext>p{
font-size:15px;
}
.maintext>h2{
font-size:30px;
padding-bottom:100px;
}
#indexbtn{
margin-top:20px;
}

button {
	background: #8fa3ad;
	color: #fff;
	border: none;
	position: relative;
	height: 50px;
	font-size: 15px;
	padding: 0 2em;
	cursor: pointer;
	transition: 800ms ease all;
	outline: none;
	border-radius:5px;
}

button:hover {
	background: #fff;
	color: #8fa3ad;
}



button:before, button:after {
	content: '';
	position: absolute;
	top: 0;
	right: 0;
	height: 2px;
	width: 0;
	background: #8fa3ad;
	transition: 400ms ease all;
}

button:after {
	right: inherit;
	top: inherit;
	left: 0;
	bottom: 0;
}

button:hover:before, button:hover:after {
	width: 100%;
	transition: 800ms ease all;
}
</style>
<section>
<h2 id="endtitle">주문완료</h2>
<hr>
<div id="orderend">
<div class="maintext">
<h2>결제가 성공적으로 완료되었습니다!</h2>
<p>주문하신 내역은 마이페이지>주문내역에서 확인 하실수 있습니다</p>
<button id="indexbtn" onclick="location.replace('<%=request.getContextPath()%>/index.jsp')">홈으로</button>
</div>

</div>

</section>
<%@ include file="/views/common/footer.jsp"%>