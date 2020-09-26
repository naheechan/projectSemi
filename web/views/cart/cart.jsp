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
	border: 2px solid black;
	width: 960px;
}

#button-box {
	display: flex;
	justify-content: space-between;
	padding-bottom:3rem;
}
.btn{
background-color: rgb(121, 122, 126);
}

#headerfont {
	font-size: 25px;
	width: 960px;
	margin: 0 auto;
}

#carttable th {
	border: 1px solid black;
}

#carttable td {
	border: 1px solid black;
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
	width: 960px;
	margin: 0 auto;
}

#totaltxt {
	margin-bottom: 100px;
}
</style>
<section>
	<p id="headerfont">Cart</p>
	<hr>
	<div id="cartcontainer">
		<form action="<%=request.getContextPath()%>/cart/orderdel" id="delfrm">
			<table id="carttable">
				<%
					for (BooksJoin bk : list) {
				%>
				<tr>
					<th colspan="2">상품명</th>
					<th class="price">가격</th>
					<th class="count">수량</th>
					<th class="del">삭제</th>
				</tr>
				<tr>
				<!--이미지와  책제목 flex로 묶어주기-->
					<td colspan="2"><img
						src="<%=request.getContextPath()%>/image/book/<%=bk.getBookimg()%>"><div><%=bk.getTitle()%></div></td>
					
					<td><%=bk.getPrice()%>원</td>
					<td><input id="quantity" type="text" size="1"
						value="<%=bk.getCount()%>">
					<td><input type="checkbox" name="dele" id="dele"
						value="<%=bk.getCartno()%>" /></td>
					<input type="hidden" name="cartno" value="<%=bk.getCartno()%>">
				</tr>
				<%
					}
				%>
			</table>
			<hr>
			<div id="price-box">
				<div id="totaltxt">
					총금액 :<%=totalprice%>원
				</div>
				<div id="button-box">
					<button type="button" class="btn del"onclick="check()">선택상품삭제하기</button>
					<button type="button" class="btn order"onclick="order()">주문하기</button>
		</form>
	</div>
	</div>
	</div>
	<script>

	function check() {
		let frm=document.querySelector("#delfrm");
		console.log(frm);
		let check1=document.querySelector("#carttable>tbody");
		
		if(check1==null){
			alert("장바구니가 이미 비여있습니다. ");
			frm.action="<%=request.getContextPath()%>/views/cart/cart.jsp?userno=<%=logginedMember.getMemberNo()%>"
		}
		frm.submit();
		
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
