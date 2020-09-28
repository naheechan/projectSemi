<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.semi.wording.model.vo.*" %>     
<%@ include file="/views/common/header.jsp"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/wordingBoardWrite.css">
<script src="<%=request.getContextPath()%>/js/wordingBoardWrite.js"></script>
<%
	Wording w = (Wording)request.getAttribute("w");
	WordingPic pic = (WordingPic)request.getAttribute("pic"); 
	WordingText te = (WordingText)request.getAttribute("te");
	boolean isEdit = false;
	if(w!=null && pic!=null && te!=null) {
		isEdit = true;
	}
%>
<section>

	
    <div id="wordingWrite-container">
    	<div class="announceTitle">글귀 작성하기</div>
        <form action="<%=request.getContextPath()%>/wording/<%=isEdit?"wordingEditEnd":"wordingWriteEnd"%>" 
        method="post" enctype="multipart/form-data">
        	<input type="hidden" id="writerNo" name="writerNo" value="<%=logginedMember.getMemberNo()%>">
        	<input type="hidden" id="writerId" name="writerId" value="<%=logginedMember.getMemberId()%>">
        	<%=isEdit?"<input type='hidden' name='wordingNo' value='"+w.getWordingNo()+"' >":""%>
            <table>
                <tr>
                    <td rowspan="8" class="backPicTd" <%=isEdit?"style='background-color:white'":""%>>
                    	<div class="imgAndText">
	                        <%=isEdit?"<img src='"+request.getContextPath()+"/image/wordingBoard/"+pic.getWordingPicName()+"' style='filter:brightness("+pic.getWordingPicBright()+"%)'>":"<img>"%>
	                        <div class="img-text" <%=isEdit?"style='font-size:"+te.getWordingTextSize()+"px; left:"+te.getWordingTextX()+"%; top:"+te.getWordingTextY()+"%; color:"+te.getWordingTextColor()+"'":""%>>
	                        	<p><%=isEdit?w.getWordingContent():"글귀를 입력해주세요"%></p>
	                        </div>
                        </div>
                    </td>
                    <th>제목</th>
                    <td><input type="text" id="wordingTitle" name="wordingTitle" placeholder="제목을 입력해주세요" 
                    		<%=isEdit?"value='"+w.getWordingTitle()+"'":""%>></td>
                </tr>
                <tr>
                    <th>배경이미지</th>
                    <td><input type="file" id="wordingPic" name="wordingPic" ></td>
                </tr>
                <tr>
                    <th>글귀입력</th>
                    <td><input type="text" id="wordingText" name="wordingText" placeholder="글귀를 입력해주세요"
                    		<%=isEdit?"value='"+w.getWordingContent()+"'":""%>></td>
                </tr>
                <tr>
                    <th>배경 밝기</th>
                    <td><input type="range" id="picDarkness" name="picDarkness" <%=isEdit?"value='"+pic.getWordingPicBright()+"'":"100"%> min="0" max="150"></td>
                </tr>
                <tr>
                    <th>글자크기</th>
                    <td><input type="range" id="textSize" name="textSize" <%=isEdit?"value='"+te.getWordingTextSize()+"'":"50"%> min="0" max="90"></td>
                </tr>
                <tr>
                    <th>글자색</th>
                    <td><input type="color" id="textColor" name="textColor" <%=isEdit?"value='"+te.getWordingTextColor()+"'":""%>></td>
                </tr>
               	<tr>
					<th>글자 x좌표</th>
					<td><input type="range" id="textX" name="textX" <%=isEdit?"value='"+te.getWordingTextX()+"'":"50"%> min="0" max="90" ></td>
                </tr>
                <tr>
					<th>글자 y좌표</th>
					<td><input type="range" id="textY" name="textY" <%=isEdit?"value='"+te.getWordingTextY()+"'":"50"%> min="0" max="90"></td>
                </tr>
                <tr>
                    <td colspan="3">
                        <button type="submit" class="btn writeSubmitBtn" onclick="" ><%=isEdit?"수정하기":"등록하기"%></button>
                        <button type="button" class="btn cancelBtn">취소(목록으로)</button>
                    </td>
                </tr>

            </table>

        </form>
    </div>

</section>

<script>
$(function(){
	
	
	$(".cancelBtn").click(function(e) {
		location.href="<%=request.getContextPath()%>/wording/wordingList";
	});


})
</script>

<%@ include file="/views/common/footer.jsp"%>