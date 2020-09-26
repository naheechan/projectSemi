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
	display: flex;
	justify-content: center;
	align-content: center;
}
</style>
<body>
	<section>
	
	<div id="maintcontent">
		<div>장바구니에 등록되었습니다</div>
		<button onclick="selfclose();">계속쇼핑하기</button>
		<button onclick="movecart();">장바구니가기</button>
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