<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bookClubWrite.css">
<section>

	<div id="bookClubWrite-container">
		<div class="announceTitle">북클럽 만들기</div>
		<form action="" method="post">
			<table>
				<tr>
					<td>북클럽 제목</td>
					<td><input type="text" id="title" name="title" style="width:160px">
				</tr>
				<tr>
					<td>참여자 최대인원</td>
					<td>
						<input type="range" id="maxPerson" name="maxPerson" min="1" max="6" value="3">
						<span>3명</span>
					</td>
				</tr>
				<tr>
					<td>주제책 검색</td>
					<td><input type="search" id="searchBook" name="searchBook" style="width:165px"></td>
				</tr>
				<tr>
					<td colspan="2" class="searchBook-td">
						<div class="searchBook-area">
							<img src="">
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="submit" class="btn writeSubmitBtn">북클럽 만들기</button>
						<button type="button" class="btn cancelBtn">취소(목록으로)</button>
					</td>
				</tr>
				
				
			</table>
		</form>
	
	</div>

</section>

<script>
	$(function(){
		$("#maxPerson").on('input',function(e) {
			$(this).next().html($(this).val()+"명");
		});
		
		
	})
</script>

<%@ include file="/views/common/footer.jsp" %>



