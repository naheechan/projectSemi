<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/wordingBoard.css">
<script src="<%=request.getContextPath()%>/js/wordingBoard.js"></script>
<section>

	

	<!-- 순위 div -->
     <div id="wordingRanking">
         <div class="ranktitle">인기 글귀</div>
         <hr>

		<div>
             <!-- <span class="rankText">2등</span>
            <span class="rankText">1등</span>
            <span class="rankText">3등</span> -->
            <img src="<%=request.getContextPath()%>/image/wordingBoard/second.PNG" class="rankText">
            <img src="<%=request.getContextPath()%>/image/wordingBoard/first.PNG" class="rankText">
            <img src="<%=request.getContextPath()%>/image/wordingBoard/third.PNG" class="rankText">
        </div>
        
        <!-- 2등 -->
        <div class="rankedWording">
            <div class="wordingArticleImg"> <!--글귀 사진-->
                <img src="<%=request.getContextPath()%>/image/wordingBoard/sam9.PNG" >
            </div>
            <div class="wordingArticleText">
                <div class="wordingArticleTitle"> <!--글귀 제목-->
                    행복
                </div>
                <div class="wordingArticleWriter">
                    <div class="wordingArticleWriterId"> <!--작성자 아이디-->
                        User01
                    </div>
                    <div class="wordingArticleWriterPic"> <!--작성자 프로필사진(동그라미)-->
                        <img src="<%=request.getContextPath()%>/image/wordingBoard/profileSample.jpg" >
                    </div>
                </div>
            </div>
        </div>

        <!-- 1등 -->
        <div class="rankedWording">
            <div class="wordingArticleImg"> <!--글귀 사진-->
                <img src="<%=request.getContextPath()%>/image/wordingBoard/sam10.PNG" >
            </div>
            <div class="wordingArticleText">
                <div class="wordingArticleTitle"> <!--글귀 제목-->
                    당신의 하루가 별보다 빛나길
                </div>
                <div class="wordingArticleWriter">
                    <div class="wordingArticleWriterId"> <!--작성자 아이디-->
                        User01
                    </div>
                    <div class="wordingArticleWriterPic"> <!--작성자 프로필사진(동그라미)-->
                        <img src="<%=request.getContextPath()%>/image/wordingBoard/profileSample.jpg" >
                    </div>
                </div>
            </div>
        </div>

        <!-- 3등 -->
        <div class="rankedWording">
            <div class="wordingArticleImg"> <!--글귀 사진-->
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
            </div>
        </div>
        
        
    </div>
    
    <div class="makeWording">
		<button class="btn makeWordingBtn" onclick="location.href='<%=request.getContextPath()%>/wording/wordingWrite'">글귀 작성하기</button>
		<div></div>
	</div>

    <hr class="hr2">
    <!-- 게시글 div -->
    <div id="wordingList">

        <!-- 게시글 하나 -->
        <div class="wordingArticle">
            <div class="wordingArticleImg"> <!--글귀 사진-->
                <img src="<%=request.getContextPath()%>/image/wordingBoard/sam10.PNG" >
            </div>
            <div class="wordingArticleText">
                <div class="wordingArticleTitle"> <!--글귀 제목-->
                    	당신의 하루가 별보다 빛나길
                </div>
                <div class="wordingArticleWriter">
                    <div class="wordingArticleWriterId"> <!--작성자 아이디-->
                        User01
                    </div>
                    <div class="wordingArticleWriterPic"> <!--작성자 프로필사진(동그라미)-->
                        <img src="<%=request.getContextPath()%>/image/wordingBoard/profileSample.jpg" >
                    </div>
                </div>
            </div>
        </div>
        <!-- 게시글 하나 -->
        
        <!-- 게시글 하나 -->
        <div class="wordingArticle">
            <div class="wordingArticleImg"> <!--글귀 사진-->
                <img src="<%=request.getContextPath()%>/image/wordingBoard/sam10.PNG" >
            </div>
            <div class="wordingArticleText">
                <div class="wordingArticleTitle"> <!--글귀 제목-->
                    	당신의 하루가 별보다 빛나길
                </div>
                <div class="wordingArticleWriter">
                    <div class="wordingArticleWriterId"> <!--작성자 아이디-->
                        User01
                    </div>
                    <div class="wordingArticleWriterPic"> <!--작성자 프로필사진(동그라미)-->
                        <img src="<%=request.getContextPath()%>/image/wordingBoard/profileSample.jpg" >
                    </div>
                </div>
            </div>
        </div>
        <!-- 게시글 하나 -->
        <!-- 게시글 하나 -->
        <div class="wordingArticle">
            <div class="wordingArticleImg"> <!--글귀 사진-->
                <img src="<%=request.getContextPath()%>/image/wordingBoard/sam10.PNG" >
            </div>
            <div class="wordingArticleText">
                <div class="wordingArticleTitle"> <!--글귀 제목-->
                    	당신의 하루가 별보다 빛나길
                </div>
                <div class="wordingArticleWriter">
                    <div class="wordingArticleWriterId"> <!--작성자 아이디-->
                        User01
                    </div>
                    <div class="wordingArticleWriterPic"> <!--작성자 프로필사진(동그라미)-->
                        <img src="<%=request.getContextPath()%>/image/wordingBoard/profileSample.jpg" >
                    </div>
                </div>
            </div>
        </div>
        <!-- 게시글 하나 -->
        <!-- 게시글 하나 -->
        <div class="wordingArticle">
            <div class="wordingArticleImg"> <!--글귀 사진-->
                <img src="<%=request.getContextPath()%>/image/wordingBoard/sam10.PNG" >
            </div>
            <div class="wordingArticleText">
                <div class="wordingArticleTitle"> <!--글귀 제목-->
                    	당신의 하루가 별보다 빛나길
                </div>
                <div class="wordingArticleWriter">
                    <div class="wordingArticleWriterId"> <!--작성자 아이디-->
                        User01
                    </div>
                    <div class="wordingArticleWriterPic"> <!--작성자 프로필사진(동그라미)-->
                        <img src="<%=request.getContextPath()%>/image/wordingBoard/profileSample.jpg" >
                    </div>
                </div>
            </div>
        </div>
        <!-- 게시글 하나 -->
        <!-- 게시글 하나 -->
        <div class="wordingArticle">
            <div class="wordingArticleImg"> <!--글귀 사진-->
                <img src="<%=request.getContextPath()%>/image/wordingBoard/sam10.PNG" >
            </div>
            <div class="wordingArticleText">
                <div class="wordingArticleTitle"> <!--글귀 제목-->
                    	당신의 하루가 별보다 빛나길
                </div>
                <div class="wordingArticleWriter">
                    <div class="wordingArticleWriterId"> <!--작성자 아이디-->
                        User01
                    </div>
                    <div class="wordingArticleWriterPic"> <!--작성자 프로필사진(동그라미)-->
                        <img src="<%=request.getContextPath()%>/image/wordingBoard/profileSample.jpg" >
                    </div>
                </div>
            </div>
        </div>
        <!-- 게시글 하나 -->
        <!-- 게시글 하나 -->
        <div class="wordingArticle">
            <div class="wordingArticleImg"> <!--글귀 사진-->
                <img src="<%=request.getContextPath()%>/image/wordingBoard/sam10.PNG" >
            </div>
            <div class="wordingArticleText">
                <div class="wordingArticleTitle"> <!--글귀 제목-->
                    	당신의 하루가 별보다 빛나길
                </div>
                <div class="wordingArticleWriter">
                    <div class="wordingArticleWriterId"> <!--작성자 아이디-->
                        User01
                    </div>
                    <div class="wordingArticleWriterPic"> <!--작성자 프로필사진(동그라미)-->
                        <img src="<%=request.getContextPath()%>/image/wordingBoard/profileSample.jpg" >
                    </div>
                </div>
            </div>
        </div>
        <!-- 게시글 하나 -->
        <!-- 게시글 하나 -->
        <div class="wordingArticle">
            <div class="wordingArticleImg"> <!--글귀 사진-->
                <img src="<%=request.getContextPath()%>/image/wordingBoard/sam10.PNG" >
            </div>
            <div class="wordingArticleText">
                <div class="wordingArticleTitle"> <!--글귀 제목-->
                    	당신의 하루가 별보다 빛나길
                </div>
                <div class="wordingArticleWriter">
                    <div class="wordingArticleWriterId"> <!--작성자 아이디-->
                        User01
                    </div>
                    <div class="wordingArticleWriterPic"> <!--작성자 프로필사진(동그라미)-->
                        <img src="<%=request.getContextPath()%>/image/wordingBoard/profileSample.jpg" >
                    </div>
                </div>
            </div>
        </div>
        <!-- 게시글 하나 -->
        <!-- 게시글 하나 -->
        <div class="wordingArticle">
            <div class="wordingArticleImg"> <!--글귀 사진-->
                <img src="<%=request.getContextPath()%>/image/wordingBoard/sam10.PNG" >
            </div>
            <div class="wordingArticleText">
                <div class="wordingArticleTitle"> <!--글귀 제목-->
                    	당신의 하루가 별보다 빛나길
                </div>
                <div class="wordingArticleWriter">
                    <div class="wordingArticleWriterId"> <!--작성자 아이디-->
                        User01
                    </div>
                    <div class="wordingArticleWriterPic"> <!--작성자 프로필사진(동그라미)-->
                        <img src="<%=request.getContextPath()%>/image/wordingBoard/profileSample.jpg" >
                    </div>
                </div>
            </div>
        </div>
        <!-- 게시글 하나 -->
        <!-- 게시글 하나 -->
        <div class="wordingArticle">
            <div class="wordingArticleImg"> <!--글귀 사진-->
                <img src="<%=request.getContextPath()%>/image/wordingBoard/sam10.PNG" >
            </div>
            <div class="wordingArticleText">
                <div class="wordingArticleTitle"> <!--글귀 제목-->
                    	당신의 하루가 별보다 빛나길
                </div>
                <div class="wordingArticleWriter">
                    <div class="wordingArticleWriterId"> <!--작성자 아이디-->
                        User01
                    </div>
                    <div class="wordingArticleWriterPic"> <!--작성자 프로필사진(동그라미)-->
                        <img src="<%=request.getContextPath()%>/image/wordingBoard/profileSample.jpg" >
                    </div>
                </div>
            </div>
        </div>
        <!-- 게시글 하나 -->
        
        


        
    </div>
</section>



<%@ include file="/views/common/footer.jsp"%>