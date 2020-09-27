<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.semi.member.model.vo.Member" %>
<%@ page import="java.util.List" %>
<%@ page import="com.semi.wording.model.vo.*, java.util.Map" %>    
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/wordingBoard.css">
<script src="<%=request.getContextPath()%>/js/wordingBoard.js"></script>
<%@ include file="/views/common/header.jsp" %>
<%
		//서버에서 보낸 데이터 받기
		Member m=(Member)request.getAttribute("member");
		List<Wording> list = (List)request.getAttribute("list");
		List<WordingPic> listPic = (List)request.getAttribute("listPic");
		List<WordingText> listText = (List)request.getAttribute("listText");
		Map<Integer,Integer> mapLike = (Map)request.getAttribute("mapLike");
%>


<style>

	.sectionInfo{
		display : flex;
        justify-content: center;
	}
	.divInfo{
		display: block;
	}
	.p1{
        font-size: 20px;
        font-weight: bold;
    }
    .p2{
    	font-size: 15px;
        font-weight: bold;
    }
    .myinfo{
    	margin-top: 20px;
        display : flex;
        justify-content: left;
        flex-flow: nowrap row;
    }
    .info-side-bar{
    	margin-top: 40px;
        display: inline-block;
        float: left;
        flex-direction: column;
        width: 200px;
        height: 500px;
    }
    .info-side-bar>div{
        width: 200px;
        height: 50px;
        margin-top:5px;
        background-color: rgb(121,122,126);
        color:white;
        text-align: center;
        line-height: 50px;

    }
    .info-side-bar>.mypage{
    	background-color: rgb(40, 123, 98);
    	color : white;
    	font-size: 18px;
    	font-weight: bold;
    
    }
    .a:link { color: white; text-decoration: none;}
    .a:visited { color:  white; text-decoration: none;}
    .a:hover { color:  white; text-decoration: none;}

    .info-side-bar>div:hover, .info-side-bar>div:active,.info-side-bar>div:focus {
          background-color: rgb(40, 123, 98); 
        }
    .info-content{
    	margin-top:10px;
        display: inline-block;
        float: left;
        margin-left: 50px;
        width: 800px;
        background-color: white;
    }


    #mypages5{
    		background-color: rgb(40, 123, 98);
    }
	.wordingArticle{
    width: 300px;
    height: 200px;
    background-color: white;
    display: inline-block;
    margin-top: 30px;
    border-radius: 5%;

	}

	.wordingArticleImg{
    width: 250px;
    height: 150px;
    padding: 0px;

	}
	
	.wordingArticleImg img{
    float: left;
    width:250px;
    height:150px;
    border-radius: 5% 5% 5% 5%;
	}
	
	.img-text{
	padding: 2.5px 5px;
	background-color: rgba( 255, 255, 255, 0);
	color: black;
	font-size:25px;
	text-align: center;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate( -50%, -50% );
	}
	
	.wordingArticleText{
    width: 250px;
    height: 100px;
    float: left;
	}
	
	.wordingArticleTitle{
    width: 250px;
    height: 30px;
    font-size: 15px;
    text-align: center;
    padding-top: 5%;
    font-weight: bolder;
	}
	
	.likeCnt{
	float:left;
	padding-top:20px;
	}
	
	.wordingArticleWriterId{
    float: right;
    padding-top: 8%;
}
.wordingArticleWriterPic{
    width: 50px;
    height: 50px;
    float: right;
}

.wordingArticleWriterPic img{
    width:50px;
    height:50px;
    border-radius: 50%;
}
</style>

<section class="sectionInfo">
<div class="divInfo">
    <div class="myinfo">
        <div class="info-side-bar">
            <div class="mypage">마이페이지</div>
            <div class="mypages" id="mypages1" onclick="choiceBtn(event)"><a class="a" href="<%=request.getContextPath()%>/infoMove?userId=<%=logginedMember.getMemberId()%>">회원정보</a></div>
            <div class="mypages" id="mypages2" onclick="choiceBtn(event)"><a class="a" href="<%=request.getContextPath()%>/myinfo/passwordUpdate?userId=<%=logginedMember.getMemberId()%>">비밀번호 변경</a></div>
            <div class="mypages" id="mypages3" onclick="choiceBtn(event)"><a class="a" href="<%=request.getContextPath()%>/myinfo/buylist?userno=<%=logginedMember.getMemberNo()%>">주문내역</a></div>
            <div class="mypages" id="mypages4" onclick="choiceBtn(event)"><a class="a" href="<%=request.getContextPath()%>/myinfo/studyroomOrderlist?userNo=<%=logginedMember.getMemberNo()%>">스터디룸</a></div>
            <div class="mypages" id="mypages5" onclick="choiceBtn(event)"><a class="a" href="<%=request.getContextPath()%>/myinfo/myWordingList?userId=<%=logginedMember.getMemberId()%>">도서글귀</a></div>
            <div class="mypages" id="mypages7" onclick="choiceBtn(event)"><a class="a" href="<%=request.getContextPath()%>/myinfo/myBookclubList?userId=<%=logginedMember.getMemberId()%>">북클럽</a></div>
            <div class="mypages" id="mypages8" onclick="choiceBtn(event)"><a class="a" href="<%=request.getContextPath()%>/cart/cartmove?userno=<%=logginedMember.getMemberNo()%>">장바구니</a></div>
            <div class="mypages" id="mypages9" onclick="choiceBtn(event)"><a class="a" href="<%=request.getContextPath()%>/myinfo/point?userId=<%=logginedMember.getMemberId()%>">포인트</a></div>
        </div>
        <div class="info-content">
            <div class="myinfo-title">
                <label><p class="p1">나의 도서 글귀</p></label>
            </div>
            <div class="memberInfo">
			            	<!-- 게시글 div -->
			    <div id="wordingList">
			
					<%if(!list.isEmpty()) { %>
						<%for(Wording w : list) { %>
							<!-- 게시글 하나 -->
					        <div class="wordingArticle">
					            <div class="wordingArticleImg"> <!--글귀 사진-->
			
									<img src="" alt="<%=w.getWordingNo()%>">             															
			               			<div class="img-text"><p><%=w.getWordingContent()%></p></div>
			               			console.log(<%=w.getWordingContent()%>);
				                															
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
            </div>
        </div>
    </div>
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

<%@ include file="/views/common/footer.jsp" %>