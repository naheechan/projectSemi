<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List,com.semi.product.model.vo.Books" %>
<%
	List<Books>list=(List)session.getAttribute("clist");

	

%>
<%@ include file="/views/common/header.jsp"%>
<style>
#carttable{
	height:50vh;
	margin:0 auto;
	border: 2px solid black;
}


.push{
	height:200px;
}
</style>
<section>
	<table id="carttable">
		<%for(Books bk:list){%>
		<tr>
			<th colspan=2>상품명</th>
			<th>가격</th>
			<th>수량</th>
			<th>삭제</th>
		</tr>
		<tr>
			<td>1</td>
			<td>2</td>
			<td>3</td>
			<td>4</td>
			<td>5</td>
		</tr>
		<tr>
			<td>1</td>
			<td>2</td>
			<td>3</td>
			<td>4</td>
			<td>5</td>
		</tr>
		<tr>
			<td>1</td>
			<td>2</td>
			<td>3</td>
			<td>4</td>
			<td>5</td>
		</tr>
		<tr>
			<td>1</td>
			<td>2</td>
			<td>3</td>
			<td>4</td>
			<td>5</td>
		</tr>
		<%} %>
	</table>
	<div class="push"></div>
</section>
<%@ include file="/views/common/footer.jsp"%>