<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/wordingBoardDetail.css">    

    <section>
      <div class="wordingDetail-container">
        <div id="wordingDetail">
        	<div class="wordingDetailTitle">
              <!-- 글 제목 -->
              당신의 하루가 별보다 빛나길
          </div>
          <div class="wordingDetailImg">
              <!-- 글귀 사진 -->
              <img src="<%=request.getContextPath()%>/image/wordingBoard/sam10.PNG" >
          </div>
          
          <div class="wordingDetailWriter">
              <!-- 글 작성자 -->
              User01
          </div>
          <div class="wordingDetailWriterPic"> <!--작성자 프로필사진(동그라미)-->
            <img src="<%=request.getContextPath()%>/image/wordingBoard/profileSample.jpg" >
          </div>
        </div>

        
        <hr class="wordingReferHr">
        <!-- 책정보 -->
        <div id="wordingRefer">
            <div class="wordingReferTitle">책 정보</div>
            <div class="referBookImg">
                <!-- 책의 작은 사진 -->
                <img src="<%=request.getContextPath()%>/image/8967358024_1.jpg" >
            </div>
            <div class="referBookTitle">
              <!-- 책 제목  -->
              매우 예민한 사람들을 위한 책
            </div>
            <div class="referBookWriter"> 
              전홍진
            </div>
          
        </div>

        
        <!-- 좋아요 -->
        <div id="wordingLike">
            <!-- "좋아요" 이미지 -->
            <div class="likeImg">
              <img src="<%=request.getContextPath()%>/image/wordingBoard/like.png" >
            </div>
            <!-- 좋아요 개수 -->
            <div class="likeCnt">150</div>
        </div>

        <!-- 댓글 부분 -->
        <div class="wordingDetailComments">
          <div class="CommentsTitle">댓글</div>
          
          <div class="Comments">
                <div class="writeComments">
                    <table>
                        <tr>
                            <td>
                              <div><textarea cols="100" rows="5"></textarea></div>
                            </td>
                            <td>
                              <div><button class="btn writeBtn">등록</button></div>
                            </td>
                        </tr>
                    </table>
                    
                    
                    <hr>
                </div>
          </div>

      </div>
      </div>
    </section>
    
<%@ include file="/views/common/footer.jsp"%>