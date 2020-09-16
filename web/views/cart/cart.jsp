<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List,com.semi.product.model.vo.Books" %>
<%
	List<Books>list=(List)session.getAttribute("clist");
	System.out.println(list.size());
	

%>
<%@ include file="/views/common/header.jsp"%>

<section>
	
	<table>
		<%for(Books bk:list){%>
		<tr>
			<td>
			
			</td>
		</tr>
		<%} %>
	</table>

</section>
<%@ include file="/views/common/footer.jsp"%>