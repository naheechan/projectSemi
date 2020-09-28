<%@page import="com.semi.product.model.vo.BooksJoin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List,com.semi.product.model.vo.Books"%>
<%
	List<BooksJoin> list = (List) session.getAttribute("booklist");
	int totalprice = 0;
	if (!list.isEmpty()) {
		for (BooksJoin bk : list) {

			totalprice += (bk.getPrice() * bk.getCount());
		}
	}
%>
<%@ include file="/views/common/header.jsp"%>
<style>
#carttable {
	height: auto;
	margin: 0 auto;
	width: 960px;
}

#button-box {
	display: flex;
	justify-content: space-around;
	padding-bottom: 3rem;
}

#headerfont {
	font-size: 25px;
	width: 960px;
	margin: 0 auto;
	padding-top: 50px;
}



#carttable>td>img{
border:1px solid black;
}



#carttable td {

	
	text-align:center;
}

hr {
	margin-bottom: 50px;
}

#cartcontainer {
	height: auto;
	padding-bottom: 2.5em;
}

td {
	width: auto;
	
}

#price-box {
	
	margin: 0 auto;
	margin-top:50px;
	margin-bottom:50px;
	width:960px;
	box-shadow:1px 1px 1px 1px
}

#totaltxt {
	margin-top:50px;
	margin-bottom: 50px;
	font-size:20px;
	display:flex;
	justify-content:flex-end;
	padding-right:20px;
	
}
th {
	flex-basis: 250px;
	height: 30px;
	border: 1px solid rgb(216, 211, 205);
	vertical-align: middle;
	background-color: rgb(239, 241, 243);
}

td {
	flex-basis: 250px;
	border: 1px solid rgb(216, 211, 205);
	text-align: center;
	vertical-align: middle;
}
#flextable{
display:flex;
flex-flow:column;

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
#zero{
width:960px;
font-size:20px;
margin:0 auto;
}
#tdimg{
float:left
}
#tdtitle{
padding-top:70px;
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

	<p id="headerfont"><i class="fas fa-cart-plus"></i>Cart</p>
	<hr>
	<div id="cartcontainer">
		<form action="<%=request.getContextPath()%>/cart/orderdel" id="delfrm">
		
		<%if(!list.isEmpty()){ %>
		<div id="flextable">
			<table id="carttable">

				<tr>
					<th colspan="2">상품명</th>
					<th class="price">가격</th>
					<th class="count">수량</th>
					<th class="del">삭제</th>
				</tr>
				<%
					for (BooksJoin bk : list) {
				%>
				<tr>
					<!--이미지와  책제목 flex로 묶어주기-->
					<td colspan="2" class="carttd"><img height=150px
						src="<%=request.getContextPath()%>/image/book/<%=bk.getBookimg()%>"id="tdimg"><div id="tdtitle"><%=bk.getTitle()%></div></td>
					<td><%=bk.getPrice()%>원</td>
					<td><%=bk.getCount()%> <input type="hidden" name="quantity"
						value="<%=bk.getCount()%>" /></td>
					<td><input type="checkbox" name="dele" id="dele"
						value="<%=bk.getCartno()%>" /></td>
					<input type="hidden" name="cartno" value="<%=bk.getCartno()%>" />
				</tr>
				<%
					}
				%>
			</table>
			<%} else{%>
			<div id="zero">장바구니가 비여있습니다</div>
			<%} %>
		
			<div id="price-box">
				<div id="totaltxt">
					총 상품금액 :<%=totalprice%>원
				</div>
				</div>
				</div>
				<div id="button-box">
					<button type="button" class="btn del" onclick="check()">선택상품삭제하기</button>
					<button type="button" class="btn order" onclick="order()">주문하기</button>
				</div>
			
		</form>

	</div>

	<script>

	function check() {
		let frm=document.querySelector("#delfrm");
		let check1=document.querySelector("#carttable>tbody");
		let delconfirm=confirm('정말로 삭제하시겠습니까?');
		if(check1==null){
			alert("장바구니가 이미 비여있습니다. ");
			frm.action="<%=request.getContextPath()%>/views/cart/cart.jsp?userno=<%=logginedMember.getMemberNo()%>"
		}
		if(delconfirm){
			frm.submit();
		}else{
			return;
		}
		
		
	}
	//나중에 ajax꼭 사용해보기
	 function order() {
		let check1=document.querySelector("#carttable>tbody");
		if(check1==null){
			alert("주문할 상품을 담아주세요. ");
			location.href='<%=request.getContextPath()%>/views/cart/cart.jsp'
			retrun;
		}
		location.href='<%=request.getContextPath()%>/cart/order'
	}
	<%-- $("#down").click(e=>{
		
	 $.ajax({
			type:"post",
			url:"<%=request.getContextPath()%>/cart/quantity",
			//data:{"quantity":$("#quantity").val()},
			dataType:'json',
			success:success2,
			error:error
		}); 
	})
	function success2() {
		alert(" ajax연결 성공");
		
	}
	function error() {
		alert(" ajax연결 실패");	
		
	} --%> 
	</script>
</section>
<%@ include file="/views/common/footer.jsp"%>
