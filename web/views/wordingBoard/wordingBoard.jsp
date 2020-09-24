<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.semi.wording.model.vo.*, java.util.Map" %>    
<%@ include file="/views/common/header.jsp"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/wordingBoard.css">
<script src="<%=request.getContextPath()%>/js/wordingBoard.js"></script>
<%
	List<Wording> list = (List)request.getAttribute("list");
	List<WordingPic> listPic = (List)request.getAttribute("listPic");
	List<WordingText> listText = (List)request.getAttribute("listText");
	Map<Integer,Integer> mapLike = (Map)request.getAttribute("mapLike");
	List<Wording> listRanking = (List)request.getAttribute("listRanking");
%>
<section>
	

	<!-- 순위 div -->
     <div id="wordingRanking">
         <div class="ranktitle">인기 글귀</div>
         <hr>

		<div class="rankImg">
             <!-- <span class="rankText">2등</span>
            <span class="rankText">1등</span>
            <span class="rankText">3등</span> -->
            <img src="<%=request.getContextPath()%>/image/wordingBoard/second.PNG" class="rankText">
            <img src="<%=request.getContextPath()%>/image/wordingBoard/first.PNG" class="rankText">
            <img src="<%=request.getContextPath()%>/image/wordingBoard/third.PNG" class="rankText">
        </div>
        
        <!-- 2등 -->
        <div class="rankedWording">
            <div class="wordingArticle">
	            <div class="wordingArticleImg"> <!--글귀 사진-->

					<img src="" alt="<%=listRanking.get(1).getWordingNo()%>">             															
              			<div class="img-text"><p><%=listRanking.get(1).getWordingContent()%></p></div>
                															
	            </div>
	            <div class="wordingArticleText">
	                <div class="wordingArticleTitle"> <!--글귀 제목-->
	                    <span><%=listRanking.get(1).getWordingTitle() %></span>
	                </div>
	                <div class="likeCnt"> <!-- 좋아요수 -->
	                	<img src="<%=request.getContextPath()%>/image/wordingBoard/like.png" witdh="20px" height="20px">
	                	<span><%=mapLike.get(listRanking.get(1).getWordingNo())%></span>
	                </div>
	                <div class="wordingArticleWriter">
	                    <div class="wordingArticleWriterId"> <!--작성자 아이디-->
	                        <span><%=listRanking.get(1).getWriter() %></span>
	                    </div>
	                    <div class="wordingArticleWriterPic"> <!--작성자 프로필사진(동그라미)-->
	                        <img src="<%=request.getContextPath()%>/image/wordingBoard/profileSample.jpg" >
	                    </div>
	                </div>
	            </div>
	        </div>
        

        <!-- 1등 -->
            <div class="wordingArticle">
	            <div class="wordingArticleImg"> <!--글귀 사진-->

					<img src="" alt="<%=listRanking.get(0).getWordingNo()%>">             															
              			<div class="img-text"><p><%=listRanking.get(0).getWordingContent()%></p></div>
                															
	            </div>
	            <div class="wordingArticleText">
	                <div class="wordingArticleTitle"> <!--글귀 제목-->
	                    <span><%=listRanking.get(0).getWordingTitle() %></span>
	                </div>
	                <div class="likeCnt"> <!-- 좋아요수 -->
	                	<img src="<%=request.getContextPath()%>/image/wordingBoard/like.png" witdh="20px" height="20px">
	                	<span><%=mapLike.get(listRanking.get(0).getWordingNo())%></span>
	                </div>
	                <div class="wordingArticleWriter">
	                    <div class="wordingArticleWriterId"> <!--작성자 아이디-->
	                        <span><%=listRanking.get(0).getWriter() %></span>
	                    </div>
	                    <div class="wordingArticleWriterPic"> <!--작성자 프로필사진(동그라미)-->
	                        <img src="<%=request.getContextPath()%>/image/wordingBoard/profileSample.jpg" >
	                    </div>
	                </div>
	            </div>
	        </div>
        

        <!-- 3등 -->
	        <div class="wordingArticle">
	            <div class="wordingArticleImg"> <!--글귀 사진-->

					<img src="" alt="<%=listRanking.get(2).getWordingNo()%>">             															
              			<div class="img-text"><p><%=listRanking.get(2).getWordingContent()%></p></div>
                															
	            </div>
	            <div class="wordingArticleText">
	                <div class="wordingArticleTitle"> <!--글귀 제목-->
	                    <span><%=listRanking.get(2).getWordingTitle() %></span>
	                </div>
	                <div class="likeCnt"> <!-- 좋아요수 -->
	                	<img src="<%=request.getContextPath()%>/image/wordingBoard/like.png" witdh="20px" height="20px">
	                	<span><%=mapLike.get(listRanking.get(2).getWordingNo())%></span>
	                </div>
	                <div class="wordingArticleWriter">
	                    <div class="wordingArticleWriterId"> <!--작성자 아이디-->
	                        <span><%=listRanking.get(2).getWriter() %></span>
	                    </div>
	                    <div class="wordingArticleWriterPic"> <!--작성자 프로필사진(동그라미)-->
	                        <img src="<%=request.getContextPath()%>/image/wordingBoard/profileSample.jpg" >
	                    </div>
	                </div>
	            </div>
            </div>
			
            <%-- <div class="wordingArticleImg"> <!--글귀 사진-->
                <img src="<%=request.getContextPath()%>/image/wordingBoard/sam8.PNG" >
            </div>
            <div class="wordingArticleText">
                <div class="wordingArticleTitle"> <!--글귀 제목-->
                    네가 두려워할 사람
                </div>
                <div class="wordingArticleWriter">
                    <div class="wordingArticleWriterId"> <!--작성자 아이디-->
                        User01
                    </div>
                    <div class="wordingArticleWriterPic"> <!--작성자 프로필사진(동그라미)-->
                        <img src="<%=request.getContextPath()%>/image/wordingBoard/profileSample.jpg" >
                    </div>
                </div>
            </div> --%>
        </div>
        
        
    </div>
    
    <div class="makeWording">
		<button class="btn makeWordingBtn" onclick="location.href='<%=request.getContextPath()%>/wording/wordingWrite'">글귀 작성하기</button>
		<div></div>
	</div>

    <hr class="hr2">
    <!-- 게시글 div -->
    <div id="wordingList">

		<%if(!list.isEmpty()) { %>
			<%for(Wording w : list) { %>
				<!-- 게시글 하나 -->
		        <div class="wordingArticle">
		            <div class="wordingArticleImg"> <!--글귀 사진-->

						<img src="" alt="<%=w.getWordingNo()%>">             															
               			<div class="img-text"><p><%=w.getWordingContent()%></p></div>
	                															
		            </div>
		            <div class="wordingArticleText">
		                <div class="wordingArticleTitle"> <!--글귀 제목-->
		                    <span><%=w.getWordingTitle() %></span>
		                </div>
		                <div class="likeCnt"> <!-- 좋아요수 -->
		                	<img src="<%=request.getContextPath()%>/image/wordingBoard/like.png" witdh="20px" height="20px">
		                	<span><%=mapLike.get(w.getWordingNo())%></span>
		                </div>
		                <div class="wordingArticleWriter">
		                    <div class="wordingArticleWriterId"> <!--작성자 아이디-->
		                        <span><%=w.getWriter() %></span>
		                    </div>
		                    <div class="wordingArticleWriterPic"> <!--작성자 프로필사진(동그라미)-->
		                        <img src="<%=request.getContextPath()%>/image/wordingBoard/profileSample.jpg" >
		                    </div>
		                </div>
		            </div>
		        </div>
		        <!-- 게시글 하나 -->
			<%} %>
		<%} %>
	
    </div>
    
    <div class="pageBar">
    	<%=request.getAttribute("pageBar")%>
    </div>
    
</section>

<script>
$(function(){

	let s = "";
	
	$(".wordingArticleImg").children("img").each(function(index,item){
		//console.log($(item).attr("alt"));
	
		<%for(WordingPic pic : listPic) {%>
			if($(item).attr("alt")=='<%=pic.getWordingNo()%>') {
				s = "<%=request.getContextPath()%>/image/wordingBoard/<%=pic.getWordingPicName()%>";
				$(item).each(function(index, item){
					//console.log(s);
					//console.log($(item));
					$(item).attr("src",s);
					$(item).css("filter","brightness("+<%=pic.getWordingPicBright()%>+"%)")
					
				});
				
			}
		<%}%>
		
		
		<%for(WordingText te : listText) {%>
			if($(item).attr("alt")=='<%=te.getWordingNo()%>') {
				$(item).each(function(index, item){
					$(item).next().css({
						"font-size":'<%=te.getWordingTextSize()%>'/2+"px",
						"left":'<%=te.getWordingTextX()%>'+"%",
						"top":'<%=te.getWordingTextY()%>'+"%",
						"color":'<%=te.getWordingTextColor()%>'
					});

				});
				
			}
		<%}%>
	});
	
	$(".wordingArticle").click(function(e) {
		console.log($(this));
		location.href="<%=request.getContextPath()%>/wording/wordingDetail?wordingNo="+$(this).children('.wordingArticleImg').children('img').attr('alt');
	});

})
</script>


<%@ include file="/views/common/footer.jsp"%>