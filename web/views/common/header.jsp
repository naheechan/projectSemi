
<%@page import="oracle.net.aso.l"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.semi.member.model.vo.Member"%>
<%@ page import="java.util.List" %>
<%
	Member logginedMember = (Member) session.getAttribute("logginedMember");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script src="https://kit.fontawesome.com/464965a728.js"
	crossorigin="anonymous"></script>
<script defer src="<%=request.getContextPath()%>/js/main.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery-3.5.1.min.js"></script>
<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	 <script
      type="text/javascript"
      src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"
    ></script>
<link rel="shortcut icon" href="/image/favicon.ico" type="image/x-icon">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css" />
<title>Main</title>
</head>
<body>
		<div id="main_container">
			<header id="main_logo"> <!--  <span id="header_img"><img src="/image/logo.png" height="40" /></span> -->
			<span id="header_logo"><a
				href="<%=request.getContextPath()%>/index.jsp">GP BOOK STORE</a></span> </header>
			<nav id="search_menu">
			<div id="search_container">
				<%
					if (logginedMember == null) {
				%>
				<div id="header_nav">
					<ul>
						<li class="searchbtn"><i class="fas fa-search"></i></li>
						<li><a href="<%=request.getContextPath()%>/login"><i
								class="fas fa-user"></i>Login</a></li>
						<li><a href="<%=request.getContextPath()%>/enrollMember"><i
								class="fas fa-user-plus"></i>Sing Up</a></li>
						<li><a
							href="<%=request.getContextPath()%>/views/cart/cart.jsp"><i
								class="fas fa-shopping-cart"></i> Cart</a></li>
					</ul>
				</div>
			</div>
			<%
				} else {
			%>
			<div id="header_nav">
				<ul>
					<li>
						<p>
							<%=logginedMember.getMemberId()%>님
						<p>
					</li>
					<li class="searchbtn"><i class="fas fa-search"></i></li>
					<li><a
						href="<%=request.getContextPath()%>/myinfomove?userId=<%=logginedMember.getMemberId()%>"><i
							class="fas fa-user"></i>MyInfo</a></li>
					<li><a href="<%=request.getContextPath()%>/logout"><i
							class="fas fa-user"></i>LogOut</a></li>
					<li><a
						href="<%=request.getContextPath()%>/cart/cartmove?userno=<%=logginedMember.getMemberNo()%>"><i
							class="fas fa-shopping-cart"></i> Cart</a></li>
				</ul>
			</div>
		</div>
		<%
			}
		%>

		<div id="nav_menu">
			<ul>
				<li><a href="<%=request.getContextPath()%>/index.jsp">Home</a></li>
				<li><a href="<%=request.getContextPath()%>/product/productmain">BOOK</a></li>
				<li><a href="<%=request.getContextPath()%>/seatMove">STUDYROOM</a></li>
				<li><a href="<%=request.getContextPath()%>/notice/noticeList">공지사항</a></li>
				<li><a href="<%=request.getContextPath()%>/wording/wordingList">글귀게시판</a></li>
				<li><a href="#">북클럽</a></li>
			</ul>
		</div>
		</nav>

		
		<script>
		
		</script>


