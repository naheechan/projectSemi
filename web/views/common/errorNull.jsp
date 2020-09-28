<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/error.css">
<section>

<div class="errorDiv">
	<img src=<%=request.getContextPath()%>/image/errorSorry.gif>
	<div class="headerErrorMsg">요청하신 페이지를 찾을 수 없습니다.</div>
	<div class="bodyErrorMsg">입력하신 주소가 정확한지 다시 한번 확인해 주시기 바랍니다.<br>또는 로그인 후 다시 시도하여 주시기 바랍니다.</div>
	<div class="ErrorMsg">error code : NullPointerException</div>
</div>

</section>

<%@ include file="/views/common/footer.jsp" %>