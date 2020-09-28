<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<% int userno=(int)(request.getAttribute("userno"));


%>
</head>
<style>
#maintcontent {
	margin-left:120px;
}
button {
	background: #8fa3ad;
	color: #fff;
	border: none;
	position: relative;
	height: 35px;
	font-size: 15px;
	padding: 0 2em;
	cursor: pointer;
	transition: 800ms ease all;
	outline: none;
	margin-top:18px;
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
#maintext{
margin-left:60px;
}

button:hover:before, button:hover:after {
	width: 100%;
	transition: 800ms ease all;
}
</style>
<body>
	<section>
	
	<div id="maintcontent">
		<div id="maintext">장바구니에 등록되었습니다</div>
		<div>
		<button onclick="selfclose();">계속쇼핑하기</button>
		<button onclick="movecart();">장바구니가기</button>
		</div>
	</div>
	</section>
	<script>
	function movecart()
	{
		opener.document.location.href='<%=request.getContextPath()%>/cart/cartmove';
	<%-- 	//?userno=<%=userno%> --%>
	
		self.close();
		/* window.close(); */
	}
	function selfclose() {
		self.close();
	}
	
	</script>
</body>
</html>