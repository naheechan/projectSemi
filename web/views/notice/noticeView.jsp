<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.semi.notice.model.vo.*,java.util.List"%>
<%
	Notice n = (Notice) request.getAttribute("n");
List<NoticeComment> list = (List) request.getAttribute("list");
%>
<%@ include file="/views/common/header.jsp"%>
<section>
	<style>
section>div#notice-container {
	width: 600px;
	margin: 0 auto;
	text-align: center;
}

section>div#notice-container h2 {
	margin: 10px 0;
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

div#comment-container button#btn-insert {
	width: 60px;
	height: 50px;
	color: white;
	background-color: #3300FF;
	position: relative;
	top: -20px;
}
/*댓글테이블*/
table#tbl-comment {
	width: 580px;
	margin: 0 auto;
	border-collapse: collapse;
	clear: both;
}

table#tbl-comment tr td {
	border-bottom: 1px solid;
	border-top: 1px solid;
	padding: 5px;
	text-align: left;
	line-height: 120%;
}

table#tbl-comment tr td:first-of-type {
	padding: 5px 5px 5px 50px;
}

table#tbl-comment tr td:last-of-type {
	text-align: right;
	width: 100px;
}

table#tbl-comment button.btn-reply {
	display: none;
}

table#tbl-comment button.btn-delete {
	display: none;
}

table#tbl-comment tr:hover {
	background: lightgray;
}

table#tbl-comment tr:hover button.btn-reply {
	display: inline;
}

table#tbl-comment tr:hover button.btn-delete {
	display: inline;
}

table#tbl-comment tr.level2 {
	color: gray;
	font-size: 14px;
}

table#tbl-comment sub.comment-writer {
	color: navy;
	font-size: 14px
}

table#tbl-comment sub.comment-date {
	color: tomato;
	font-size: 10px
}

table#tbl-comment tr.level2 td:first-of-type {
	padding-left: 100px;
}

table#tbl-comment tr.level2 sub.comment-writer {
	color: #8e8eff;
	font-size: 14px
}

table#tbl-comment tr.level2 sub.comment-date {
	color: #ff9c8a;
	font-size: 10px
}
/*답글관련*/
table#tbl-comment textarea {
	margin: 4px 0 0 0;
}

table#tbl-comment button.btn-insert2 {
	width: 60px;
	height: 23px;
	color: white;
	background: #3300ff;
	position: relative;
	top: -5px;
	left: 10px;
}
</style>

	<div id="notice-container">
		<h2>공지사항</h2>
		<table id="tbl-notice">
			<tr>
				<th>번호</th>
				<td><%=n.getNoticeNo()%></td>
			</tr>
			<tr>
				<th>제 목</th>
				<td><%=n.getNoticeTitle()%></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><%=n.getNoticeWriter()%></td>
			</tr>
			<tr>
				<th>조회수</th>
				<td><%=n.getNoticeViews()%></td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td>
					<%
						if (n.getFilepath() != null) {
					%> <a
					href="<%=request.getContextPath()%>/notice/noticefiledown?fname=<%=n.getFilepath()%>">
						<img src="<%=request.getContextPath()%>/image/file.png"
						width="20" height="20">
				</a> <%
 	}
 %>
				</td>
			</tr>
			<tr>
				<th>내 용</th>
				<td><%=n.getNoticeContent()%></td>
			</tr>
			<%--글작성자/관리자인경우 수정삭제 가능 --%>
			<tr>
				<th colspan="2">
					<%
						if (logginedMember != null
							&& (logginedMember.getMemberId().equals(n.getNoticeWriter()) || logginedMember.getMemberId().equals("admin"))) {
					%> <input
					type="button" value="수정하기"
					onclick="location.replace('<%=request.getContextPath()%>/notice/noticeUpdete?noticeNo=<%=n.getNoticeNo()%>')">

					<input type="button" value="삭제하기"
					onclick="location.replace('<%=request.getContextPath()%>/notice/noticeDelete?noticeNo=<%=n.getNoticeNo()%>')">
					<%
						}
					%>
					<button type="button"
						onclick="location.replace('<%=request.getContextPath()%>/notice/noticeList')">목록으로</button>
				</th>
			</tr>
		</table>
		<div id="comment-container">
			<div class="comment-editor">
				<form
					action="<%=request.getContextPath()%>/notice/noticeCommentInsert"
					method="post">
					<input type="hidden" name="noticeRef" value="<%=n.getNoticeNo()%>">
					<input type="hidden" name="noticeCommentWriter"
						value="<%=logginedMember != null ? logginedMember.getMemberId() : ""%>">
					<input type="hidden" name="noticeCommentLevel" value="1"> <input
						type="hidden" name="noticeCommentRef" value="0">
					<textarea name="noticeCommentContent" cols="55" rows="3"></textarea>
					<button type="submit" id="btn-insert">등록</button>
				</form>
			</div>
		</div>
		<table id="tbl-comment">
			<%
				for (NoticeComment nc : list) {
				if (nc.getNoticeCommentLevel() == 1) {
			%>
			<tr class="level1">
				<td><sub class="comment-writer"><%=nc.getNoticeCommentWriter()%></sub>
					<sub class="comment-date"><%=nc.getNoticeCommentDate()%></sub> <br>
					<%=nc.getNoticeCommentContent()%></td>
				<td>
					<button class="btn-reply" value="<%=nc.getNoticeCommentNo()%>">답글</button>
					<%
						if (logginedMember.getMemberId().equals(nc.getNoticeCommentWriter()) || logginedMember.getMemberId().equals("admin")) {
					%>
					<button class="btn-delete" value="<%=nc.getNoticeCommentNo()%>">삭제</button>
					<%
						}
					%>
				</td>
			</tr>
			<%
				} else {
			%>
			<tr class="level2">
				<td><sub><%=nc.getNoticeCommentWriter()%></sub> <sub><%=nc.getNoticeCommentDate()%></sub>
					<br> <%=nc.getNoticeCommentContent()%></td>
				<td></td>
			</tr>
			<%
				}
			}
			%>
		</table>

		<%-- <script>
	    	$(function(){
	    		//로그인이 안된사람이 댓글을 창을 클릭했을때 로그인하라는 메세지 띄워주기
	    		$("[name=boardCommentContent]").focus(e => {
	    			if(<%=logginedMember == null%>){
	    				alert("로그인 후 이용해주세요!");
	    				$("#userId").focus();
	    			}
	    		})
	    		//답글에 대한 클릭이벤트설정
	    		$(".btn-reply").click(e => { 
	    			<%if (logginedMember != null) {%>
	    				let tr=$("<tr>");
	    				let form=$(".comment-editor>form").clone();
	    				form.find("textarea").attr("rows","1");
	    				form.find("[name=noticeCommentLevel]").val("2");
	    				form.find("[name=noticeCommentRef]").val(e.target.value);
	    				form.find("button").addClass("btn-insert2")
	    				let td=$("<td>").attr("colspan","2");
	    				tr.find("td").css("display","none");
	    				tr.append(td.append(form));
	    			
						tr.insertAfter($(e.target).parents("tr")).children("td").slideDown(800);
						$(e.target).off("click");//이벤트제거
	    			<%}%>
	    		})
	    		
	    	});
	    </script> --%>
	</div>
</section>
<%@ include file="/views/common/footer.jsp"%>




















