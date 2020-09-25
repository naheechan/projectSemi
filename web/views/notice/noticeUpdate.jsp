<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.semi.notice.model.vo.Notice"%>
<%
	Notice n = (Notice) request.getAttribute("notice");
%>
<%
	String noticeTitle = request.getParameter("noticeTitle");
String noticeContnent = request.getParameter("noticeContent");
String filepath = request.getParameter("filepath");
%>
<style>
section#notice-container {
	width: 600px;
	margin: 0 auto;
	text-align: center;
}

section#notice-container h2 {
	margin: 10px 0;
	text-align: center;
}

table#tbl-notice {
	width: 500px;
	margin: 0 auto;
	border: 1px solid black;
	border-collapse: collapse;
	clear: both;
}

table#tbl-notice th {
	width: 125px;
	border: 1px solid;
	padding: 5px 0;
	text-align: center;
}

table#tbl-notice td {
	border: 1px solid;
	padding: 5px 0 5px 10px;
	text-align: left;
}
</style>
<section>
	<div id="notice-container">
		<h2>공지사항 수정</h2>
		<form action="<%=request.getContextPath()%>/notice/NoticeUpdateEnd"
			method="post" enctype="multipart/form-data">
			<input type="hidden" name="notice value="
				<%=request.getParameter("notice")%>>"
			<table id="tbl-notice">
				<tr>
					<th>제 목</th>
					<td><input type="text" name="title" id="title" required></td>

				</tr>
				<tr>
					<th>내용</th>
					<td><textarea cols="50" rows="5" name="content"></textarea></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td><input type="file" name="upfile"></td>

				</tr>
				<tr>
					<th colspan="2">
						<button type="button" onclick="#" value="수정하기">수정하기</button>
						<button type="button" onclick="#" value="삭제하기">삭제하기</button>
					</th>
				</tr>
			</table>
		</form>
	</div>
	<%--  <script>
	function fn_delete_member(){
			if(confirm("정말로 삭제하시겠습니까?")){
				location.replace('<%=request.getContextPath()%>/notice/noticeDelete?noticeNo=<%=n.getNoticeNo()%>');
			}
				
		}
	function fn_update_notice(){
			const frm=$("#noticeUpdate");
			const url="<%=request.getContextPath()%>/notice/noticeUpdateEnd";
			frm.attr({
				"action":url,
				"method":"post",
			});
			frm.submit();
		}
  </script> --%>
</section>