<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<section>
<div>고객님의 주문이 완료 되었습니다</div>
<button onclick="location.replace('<%=request.getContextPath()%>')">홈으로</button>
</section>
<%@ include file="/views/common/footer.jsp"%>