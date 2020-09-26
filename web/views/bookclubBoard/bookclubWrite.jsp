<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bookclubWrite.css">
<section>

	<div id="bookClubWrite-container">
		<div class="announceTitle">북클럽 만들기</div>
		<form action="<%=request.getContextPath()%>/bookclub/bookclubWriteEnd" 
		method="post">
			<input type="hidden" name="writer" value="<%=logginedMember.getMemberId()%>">
			<input type="hidden" name="memberNo" value="<%=logginedMember.getMemberNo()%>">
			<table>
				<tr>
					<td>북클럽 제목</td>
					<td><input type="text" id="title" name="title" placeholder="모임의 이름을 정해주세요" style="width:160px">
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
					<td>
						<input type="search" id="searchBook" name="searchBook" list="bookList" placeholder="책이름을 검색해주세요" style="width:165px">
						<input type="hidden" id="searchBookImgName" name="searchBookImgName">
						<input type="hidden" id="searchBookNo" name="searchBookNo">					
					</td>
					<datalist id="bookList">
					</datalist>
				</tr>
				<tr>
					<td colspan="2" class="searchBook-td">
						<div class="searchBook-area">
							<img>
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
		
		$("[name=searchBook]").keyup(e=>{
			$.ajax({
				url:"<%=request.getContextPath()%>/bookclub/bookclubSearchBook",
				data:{"keyword":$(e.target).val()}, 
				type:"post",
				dataType:"json",
				success:function(data){
					$("#bookList").html("");
					$.each(data,function(i,v){
						$("#bookList").append($("<option value='"+i+"'>").html(i));
					});
				}
			});
		});
		
		
		let bookImg = $(".searchBook-area").find("img");
		
		$("[name=searchBook]").change(function(e) {
			$.ajax({
				url:"<%=request.getContextPath()%>/bookclub/bookclubSearchBookImg",
				data:{"keyword":$(e.target).val()}, 
				type:"post",
				dataType:"json",
				success:function(data){
					$.each(data,function(i,v){
						bookImg.attr("src","<%=request.getContextPath()%>/image/book/"+v);
						$("#searchBookNo").val(i);
						$("#searchBookImgName").val(v);
					});
				}
			});
			
			
		});
		
		
		
		
		
		
		
		
		
	})
</script>

<%@ include file="/views/common/footer.jsp" %>



