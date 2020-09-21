<%@page import="oracle.net.aso.l"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List,com.semi.product.model.vo.Books"%>
<%
	List<Books> book = (List) request.getAttribute("list");
%>
<%@ include file="/views/common/header.jsp"%>

<style>
div>.product_list {
	display: flex;
	justify-content: space-between;
	flex-flow: wrap;
	width: 960px;
	margin: 0 auto;
	height: 100%;
	align-content: space-around;
}

#push {
	height: 100px;
}

.product_list>li {
	align-items: center;
}

hr {
	margin-bottom: 100px;
}

.content {
	overflow: scroll;
}

.product_list li {
	position: relative;
	/*  width: 374px; */
	width: 200px;
	height: 350px;
	/*   height: 501px;  */
	border: 1px solid #d9d9d9;
	/* float: left;
    margin: 0 20px 20px 0; */
	margin-bottom: 50px;
}

.product_list li:hover {
	border-color: black;
}

.product_list dl {
	padding: 150px 0 0 0;
}

.product_list dt {
	border-top: 1px solid #f0f0f0;
	padding: 11px 10px 14px;
}

.product_list a {
	font-size: 16px;
	color: #1a1a1a;
}

a {
	text-decoration: none;
}

.product_list .img {
	position: absolute;
	left: 0;
	top: 0;
}

.product_list .price {
	position: absolute;
	font-size: 21px;
	bottom: 80px;
	left: 90px;
	font-weight: bold;
	padding: 0 0 0 10px;
	color: #f06292;
}

.maincategory {
	display: flex;
	justify-content: space-around;
	margin: 0 auto;
	width: 960px;
}

.product_list .author {
	position: absolute;
	font-size: 14px;
	left: 80px;
	bottom: 60px;
	color: #1a1a1a;
	font-weight: bold;
	padding: 0 0 0 10px;
}

.product_list .btm {
	position: absolute;
	left: 0px;
	bottom: 0px;
	border-top: 1px solid #f0f0f0;
	background: #f0f0f0;
	width: 100%;
}

.product_list .btm div {
	float: left;
	width: 50%;
	text-align: center;
	height: 30px;
	line-height: 30px;
	font-size: 12px;
	color: #767676;
}

.content::-webkit-scrollbar {
	display: none;
}

.product_list .btm div a {
	font-size: 12px;
	color: #767676;
}

.product_list .title a {
	color: #2196f3;
}

.item {
	border: 1px solid black;
	border-radius: 10px;
	padding: 10px;
}

.item:hover {
	background-color: red;
}

.maincategory {
	border: 1px solid black;
	border-radius: 15px;
	padding: 10px;
}

#pageBar {
	width: 300px;
	margin-left: auto;
	margin-right: auto;
	text-align: center;
	display: flex;
	justify-content: space-between;
	
}
</style>
<section>
	<div class="content">
		<ul class="maincategory">
			<li class="item all"><input type="radio" name="item" value="all"
				id="all" checked /><label for="all">전체보기</label></li>
			<li class="item Social"><input type="radio" name="item"
				id="social" value="social" /><label for="social">인문사회</label></li>
			<li class="item Science"><input type="radio" name="item"
				id="science" value="science" /><label for="science">자연과학</label></li>
			<li class="item it"><input type="radio" name="item" id="it"
				value="it" /><label for="it">정보통신</label></li>
			<li class="item literature"><input type="radio" name="item"
				id="literature" value="literature" /><label for="literature">문학</label></li>
			<li class="item Self-development"><input type="radio"
				name="item" id="development" value="development" /><label
				for="development">자기계발</label></li>
		</ul>
		<hr>
		<ul class="product_list">
			<%
				for (Books bk : book) {
			%>
			<li>
				<dl>
					<dt class="title" id="title" name="title">
						<a href=""><%=bk.getTitle()%></a>
					</dt>
					<dd class="img" name="img">
						<a href=""><img id="img" width="200" height="250"
							src="<%=request.getContextPath()%>/image/<%=bk.getBookimg()%>"
							alt="" /></a>
					</dd>
					<dd class="price" id="price" name="price"><%=bk.getPrice()%>원
					</dd>
					<dd class="author" name="author"><%=bk.getAuthor()%>(지은이)
					</dd>
					<dd class="btm">
						<div>00구매</div>
						<div>
							<a href=""><img src="" alt="" /> 찜 21</a>
						</div>
						<span> <!--클릭시 매개변수로 책번호를 넘겨줘서 그해당 독서의 정보를 장바구니에 저장한다--> <!-- 비회원일때 는 어떻게 처리를 할것인가  비회원인경우 null이 발생한다-->
							<button
								onclick="cart(<%=bk.getBookNo()%>,<%=logginedMember.getMemberNo()%>)">장바구니
							</button></span>
					</dd>
				</dl>
			</li>
			<%
				}
			%>
		</ul>
	</div>
	<div id="pageBar">
		<%=request.getAttribute("pageBar")%>
	</div>
	<!-- 페이징처리 부분 스타일 -->
	<style>
span.page-btn {
	border:1px solid black;
	border-radius:15px;
}
.pageno{
border:1px solid black;
	border-radius:15px;
}
</style>
	<div id="push"></div>
	<form action="" name="checkcart">
		<input type="hidden" name="cproductno" /> <input type="hidden"
			name="memberno" />
	</form>
	<div id="push"></div>
</section>
<script>
    function cart(num,userno) {
      const url = "<%=request.getContextPath()%>/product/checkcart";
      const subtitle = "checkcart";
      var popupWidth = "550";
      var popupHeight = "200";
      console.log(userno);
      // 듀얼 모니터 고려한 윈도우 띄우기
      var left = (screen.availWidth - popupWidth) / 2;
      if (window.screenLeft < 0) {
        left += window.screen.width * -1;
      } else if (window.screenLeft > window.screen.width) {
        left += window.screen.width;
      }
      var top = (screen.availHeight - popupHeight) / 2 - 10;
      var options =
        "resizable=no,left=" +
        left +
        ",top=" +
        top +
        ", width=" +
        popupWidth +
        ",height=" +
        popupHeight +
        ",menubar=no, status=no, toolbar=no, location=no, scrollbars=no";
      open("", subtitle, options);
      checkcart.target = subtitle;
      checkcart.action = url;
      checkcart.method = "post";
      checkcart.cproductno.value=num;
      checkcart.memberno.value=userno;
      console.log(checkcart);
      checkcart.submit();
    }
  </script>
<%@ include file="/views/common/footer.jsp"%></Books>
