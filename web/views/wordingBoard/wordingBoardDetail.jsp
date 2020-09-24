<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.semi.wording.model.vo.*" %>    
<%@ include file="/views/common/header.jsp"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/wordingBoardDetail.css">    
<%
	Wording w = (Wording)request.getAttribute("w");
	WordingPic pic = (WordingPic)request.getAttribute("pic"); 
	WordingText te = (WordingText)request.getAttribute("te");
	int likeCount = (Integer)request.getAttribute("likeCount");
	List<WordingComment> listCom = (List)request.getAttribute("listCom");
%>
    <section>
      <div class="wordingDetail-container">
        <div id="wordingDetail">
        	<div class="wordingDetailTitle">
              <!-- 글 제목 -->
              <%=w.getWordingTitle() %>
          </div>
          <div class="wordingDetailImg">
              <!-- 글귀 사진 -->
              <img src="<%=request.getContextPath()%>/image/wordingBoard/<%=pic.getWordingPicName()%>" >
              <div class="img-text"><p><%=w.getWordingContent()%></p></div>
          </div>
          
          <div class="wordingDetailWriter">
              <!-- 글 작성자 -->
              <%=w.getWriter()%>
          </div>
          <div class="wordingDetailWriterPic"> <!--작성자 프로필사진(동그라미)-->
            <img src="<%=request.getContextPath()%>/image/wordingBoard/profileSample.jpg" >
          </div>
          
        </div>

		<div class="editDiv">
      		<%if(logginedMember!=null && ("admin".equals(logginedMember.getMemberId()) || w.getWriter().equals(logginedMember.getMemberId()))) {%>
      			<button type="button" class="btn editBtn">수정하기</button>
      		<%} %>
      	</div>
        
		<!-- 세부사항2 -->
        <div class="wordingDetail2">
        	<div class="wordingViewCnt">
        		<span>조회수&nbsp;&nbsp;</span>
        		<span><%=w.getWordingViewCount()%></span>
        	</div>
    
        	<div class="wordingDate">
	        	<span>작성일&nbsp;&nbsp;</span>
	        	<span><%=w.getWordingDate()%></span>
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
              <img src="<%=request.getContextPath()%>/image/wordingBoard/<%=(Integer)request.getAttribute("likeChk")==0?"unlike.png":"like.png"%>" >
            </div>
            <!-- 좋아요 개수 -->
            <div class="likeCnt"><%=likeCount%></div>
        </div>
		
		
	<!-- 기능구현때문에 안보이게 넣어놓은 div들 -->
	<div class="reply" style="display:none">
		<textarea id="replyContent" cols="85" rows="3"></textarea>
		<button class="btn replyWriteBtn">등록</button>
	</div>
     <!-- 기능구현때문에 안보이게 넣어놓은 div들 -->
	
        <!-- 댓글 부분 -->
        <div class="wordingDetailComments">
          <div class="CommentsTitle">댓글</div>
          
          <div class="Comments">
                <div class="writeComments">
                    <table>
                        <tr>
                            <td>
                              <div><textarea cols="100" rows="5" id="comContent" name="comContent"></textarea></div>
                            </td>
                            <td>
                              <div><button class="btn writeComBtn">등록</button></div>
                            </td>
                        </tr>
                    </table>
                    
                </div>
                
                <%if(listCom.size()<1 || listCom==null) {%>
               		<div class="level1Comment">
				     	<div class="commentNo" style="display:none"></div>
				     	<div class="commentHeader" style="background-color:white">
					      	<div class="commentWriter"></div>
					      	<div class="commentRight" style="display:none">
						       	<button class="btn replyBtn">답글 달기</button>
						       	<div class="commentDate"></div>
				      		</div>
				      	</div>
				     	<div class="commentContent"></div>
				     </div> 
                <%} %>
                
                <%for(WordingComment co : listCom) {%>
                	<%if(co.getComLevel()==1) {%>
		                <div class="level1Comment">
		                	<div class="commentNo" style="display:none"><%=co.getWordingComNo()%></div>
		                	<div class="commentHeader">
			                	<div class="commentWriter"><%=co.getWriter()%></div>
			                	<div class="commentRight">
				                	<button class="btn replyBtn">답글 달기</button>
				                	<div class="commentDate"><%=co.getComDate()%></div>
			                	</div>
			                </div>
		                	<div class="commentContent"><%=co.getComContent()%></div>
		                </div>
                	<%}else { %>
                		<div class="level2Comment">
		                	<div class="commentHeader">
			                	<div class="commentWriter"><%=co.getWriter()%></div>
			                	<div class="commentDate"><%=co.getComDate()%></div>
			                </div>
		                	<div class="commentContent"><%=co.getComContent()%></div>
		                </div>
                
                	<%} %>
                <%} %>
          </div>
			
      </div>
      </div>
    </section>

	<script>
	  
	$(function(){

		let picImg = $(".wordingDetailImg").children("img");
		
		picImg.css("filter","brightness("+<%=pic.getWordingPicBright()%>+"%)");
		
		picImg.next().css({
			"font-size":'<%=te.getWordingTextSize()%>'+"px",
			"left":'<%=te.getWordingTextX()%>'+"%",
			"top":'<%=te.getWordingTextY()%>'+"%",
			"color":'<%=te.getWordingTextColor()%>'
		});
		
		$(".editBtn").click(function(e) {
			location.href="<%=request.getContextPath()%>/wording/wordingEdit?wordingNo=<%=w.getWordingNo()%>";
		});
		
		
		//좋아요 ajax
		$(".likeImg").children('img').click(function(e) {
			<%if(logginedMember==null) {%>
				alert("로그인이 필요한 서비스입니다.");
			<%}else {%>
				
				let wNo = "<%=w.getWordingNo()%>";
				let mNo = "<%=logginedMember.getMemberNo()%>";
				
				$.ajax({
					url:"<%=request.getContextPath()%>/wording/wordingLike",
					type:"get",
					data:{
						wordingNo:wNo,
						memberNo:mNo
					},
					dataType:"text",
					success:function(data){
						console.log(data);
						let datas = data.split(",");
						$(".likeCnt").html(datas[0]);
						if(datas[1]==0) {
							//하트꺼짐
							$(".likeImg").children('img').attr('src','<%=request.getContextPath()%>/image/wordingBoard/unlike.png');
						}else {
							//하트켜짐
							$(".likeImg").children('img').attr('src','<%=request.getContextPath()%>/image/wordingBoard/like.png');
						}
						
					}
				
				});
			<%}%>
		});
		
		
		//댓글등록 ajax
		$(".writeComBtn").click(function(e) {
	
			$.ajax({
				url:"<%=request.getContextPath()%>/wording/writeComent",
				type:"post",
				data:{
					comLevel:1,
					comContent:$("#comContent").val(),
					writer:"<%=logginedMember.getMemberId()%>",
					memberNo:"<%=logginedMember.getMemberNo()%>",
					wordingNo:"<%=w.getWordingNo()%>"
				},
				dataType:"json",
				success:function(data){
					console.log("ajax갔다왔음")
					console.log(data);
					if(data!=null) {
						let com = $(".level1Comment").first().clone(true);
						com.find(".commentHeader").css("background-color","#EAEAEA");
						com.find(".commentWriter").html(data["writer"]);
						com.find(".commentDate").html(data["comDate"]);
						com.find(".commentContent").html(data["comContent"]);
						com.find(".commentNo").html(data["wordingComNo"]);
						com.find(".commentRight").css("display","flex");
						$(".writeComments").after(com);
					}else {
						alert("댓글등록 실패");
					}
					$("#comContent").val("");
				}
				
			});
			
		});
		
		
		
		$(".commentHeader").hover(function() {
			$(this).find(".replyBtn").css("display","flex");
		}, function() {
			$(this).find(".replyBtn").css("display","none");
		});
		
		
		
		//대댓글 창 띄우기
		$(".replyBtn").click(function(e) {
			let replyForm = $(".reply").first().clone(true);
			$(".reply").first().remove();
			replyForm.css("display","flex");
			$(this).closest(".level1Comment").after(replyForm);
		});
		
		
		
		//대댓글 등록 ajax
		$(".replyWriteBtn").click(function(e) {
			
			let parentCom = $(".reply").prev();
			console.log(parentCom);
			console.log(parentCom.nextAll(".level1Comment").first());

			$.ajax({
				url:"<%=request.getContextPath()%>/wording/writeComent",
				type:"post",
				data:{
					comLevel:2,
					comContent:$("#replyContent").val(),
					writer:"<%=logginedMember.getMemberId()%>",
					memberNo:"<%=logginedMember.getMemberNo()%>",
					wordingNo:"<%=w.getWordingNo()%>",
					refComNo:$(".reply").prev().find(".commentNo").html()
				},
				dataType:"json",
				success:function(data){
					console.log("ajax갔다왔음(reply)");
					console.log(data);
					if(data!=null) {
						let re = $(".level2Comment").first().clone();
		
						re.find(".commentWriter").html(data["writer"]);
						re.find(".commentDate").html(data["comDate"]);
						re.find(".commentContent").html(data["comContent"]);
						if(parentCom.nextAll(".level1Comment").first().length) {
							parentCom.nextAll(".level1Comment").first().before(re);
						}else {
							parentCom.nextAll(".level2Comment").last().after(re);	
						}
					}else {
						alert("댓글등록 실패");
					}
					$("#replyContent").val("");
					$(".reply").css("display","none");
				}
				
			});
			
		});
		
		
		
		
		
	})
	</script>
    
<%@ include file="/views/common/footer.jsp"%>