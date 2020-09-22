<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/wordingBoardWrite.css">
<script src="<%=request.getContextPath()%>/js/wordingBoardWrite.js"></script>

<section>

	
    <div id="wordingWrite-container">
    	<div class="announceTitle">글귀 작성하기</div>
        <form action="<%=request.getContextPath()%>/wording/wordingWriteEnd" method="post">
        	<input type="hidden" id="writerNo" name="writerNo" value="100">
            <table>
                <tr>
                    <td rowspan="8" class="backPicTd">
                    	<div class="imgAndText">
	                        <img src="<%=request.getContextPath()%>/image/wordingBoard/sam1.PNG">
	                        <div class="img-text"><p>글귀를 입력해주세요</p></div>
                        </div>
                    </td>
                    <th>제목</th>
                    <td><input type="text" id="wordingTitle" name="wordingTitle" placeholder="제목을 입력해주세요"></td>
                </tr>
                <tr>
                    <th>배경이미지</th>
                    <td><input type="file" id="wordingPic" name="wordingPic" ></td>
                </tr>
                <tr>
                    <th>글귀입력</th>
                    <td><input type="text" id="wordingText" name="wordingText" placeholder="글귀를 입력해주세요"></td>
                </tr>
                <tr>
                    <th>배경 밝기</th>
                    <td><input type="range" id="picDarkness" name="picDarkness" value="100" min="0" max="150"></td>
                </tr>
                <tr>
                    <th>글자크기</th>
                    <td><input type="range" id="textSize" name="textSize" value="50" min="0" max="90"></td>
                </tr>
                <tr>
                    <th>글자색</th>
                    <td><input type="color" id="textColor" name="textColor"></td>
                </tr>
               	<tr>
					<th>글자 x좌표</th>
					<td><input type="range" id="textX" name="textX" value="50" min="0" max="90"></td>
                </tr>
                <tr>
					<th>글자 y좌표</th>
					<td><input type="range" id="textY" name="textY" value="50" min="0" max="90"></td>
                </tr>
                <tr>
                    <td colspan="3">
                        <button type="submit" class="btn writeSubmitBtn" onclick="" >등록하기</button>
                        <button type="button" class="btn cancelBtn" onclick="" >취소(목록으로)</button>
                    </td>
                </tr>

            </table>

        </form>
    </div>

</section>


<%@ include file="/views/common/footer.jsp"%>