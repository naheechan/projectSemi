<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.semi.product.model.vo.*" %>
<%@ include file="/views/common/header.jsp" %>
<%
	BookDetailView bookdetail = (BookDetailView)request.getAttribute("bookdetail");
	StarView star = (StarView)request.getAttribute("star");
	List<BuyerView> buyerList = (List)request.getAttribute("buyerList");
	List<BookComView> comList = (List)request.getAttribute("comList");
	
	int oneStar = 0;
	int twoStar = 0;
	int threeStar = 0;
	int fourStar = 0;
	int fiveStar = 0;
	double totalStar = 0;
	double avgStar = 0;
	double avgStarScore = 0;
	
	int teenMan = 0;
	int teenWo = 0;
	int twMan = 0;
	int twWo = 0;
	int thMan = 0;
	int thWo = 0;
	int foMan = 0;
	int foWo = 0;
	int fiMan = 0;
	int fiWo = 0;
	int etcMan = 0;
	int etcWo = 0;
	int totalBuyer = 1;
	//totalBuyer = teenMan+teenWo+twMan+twWo+thMan+thWo+foMan+++++++
	
	for(BuyerView buyer : buyerList) {
		if(buyer.getAge()>9 && buyer.getAge()<60) {
			if(buyer.getGender().equals("M")) {
				switch(buyer.getAge()/10) {
				case 1: teenMan++; break;
				case 2: twMan++; break;
				case 3: thMan++; break;
				case 4: foMan++; break;
				case 5: fiMan++; break;
				}
			}else {
				switch(buyer.getAge()/10) {
				case 1: teenWo++; break;
				case 2: twWo++; break;
				case 3: thWo++; break;
				case 4: foWo++; break;
				case 5: fiWo++; break;
				}
			}
		}else {
			if(buyer.getGender().equals("M")) {
				etcMan++;
			}else {
				etcWo++;
			}
		}
		totalBuyer++;
	}
	if(totalBuyer!=1) {
		totalBuyer--;
	}

	if(star!=null) {
		oneStar = star.getOneStar();
		twoStar = star.getTwoStar();
		threeStar = star.getThreeStar();
		fourStar = star.getFourStar();
		fiveStar = star.getFiveStar();
		totalStar = (double)oneStar+twoStar+threeStar+fourStar+fiveStar;
		avgStar = totalStar/5;
		avgStarScore = Math.round((oneStar+twoStar*2+threeStar*3+fourStar*4+fiveStar*5)/totalStar*100)/100.0;
	}
%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/productDetail.css">
<section>
    <div id="bookDetail-container">
        <div id="bookInfoDiv">
            <div id="bookImg">
                <img src="<%=request.getContextPath()%>/image/book/<%=bookdetail.getBookImg()%>">
            </div>
            <div id="bookText">
                <table>
                    <tr>
                        <td>책 제목</td>
                        <td><%=bookdetail.getBookTitle()%></td>
                    </tr>
                    <tr>
                        <td>지은이</td>
                        <td><%=bookdetail.getBookAuthor()%></td>
                    </tr>
                    <tr>
                        <td>출판사</td>
                        <td><%=bookdetail.getBookPublisher()%></td>
                    </tr>
                    <tr>
                        <td>출판일</td>
                        <td><%=bookdetail.getBookPublicationdate()%></td>
                    </tr>
                    <tr>
                        <td>가격</td>
                        <td><%=bookdetail.getBookPrice()%>원</td>
                    </tr>
                    <tr>
                        <!-- 총 별 평점 -->
                        <td colspan="2">
                        	<div class="starAvgTop">
	                            <div class="starRev">
	                                <span class="starR1">별1_왼쪽</span>
	                                <span class="starR2">별1_오른쪽</span>
	                                <span class="starR1">별2_왼쪽</span>
	                                <span class="starR2">별2_오른쪽</span>
	                                <span class="starR1">별3_왼쪽</span>
	                                <span class="starR2">별3_오른쪽</span>
	                                <span class="starR1">별4_왼쪽</span>
	                                <span class="starR2">별4_오른쪽</span>
	                                <span class="starR1">별5_왼쪽</span>
	                                <span class="starR2">별5_오른쪽</span>
	                            </div>
                           	</div>
                            <div class="starRevScore"><%=avgStarScore%></div>
                        </td>
                    </tr>
                    <tr>
                        <td>수량</td>
                        <td><input type="number" name="bookCnt" id="bookCnt" value="1"></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <button id="buyBtn" class="btn">바로 구매</button>
                            <button id="basketBtn" class="btn">장바구니</button>
                            <button id="rentBtn" class="btn">대여하기</button>
                        </td>
                    </tr>
                    
                </table>
            </div>
        </div>

        <hr class="divHr">
        <div class="bookContent">
            <div class="bookContentTitle">책소개</div>
            <div class="bookContentText">
                <%=bookdetail.getBookintro()%>
            </div>
            
        </div>

        <hr>
        <div class="buyerStatement">
            <div class="buyerTitle">구매자 분포도</div>
            <table>
                <tr>
                    <td class="buyer10FPerc"><%=Math.round((double)teenWo/totalBuyer*1000)/10.0%>%</td>
                    <td class="buyer10FBar"><progress value="<%=Math.round((double)teenWo/totalBuyer*1000)/10.0%>" max="100"></progress></td>
                    <td class="buyerAgeText">10대</td>
                    <td class="buyer10MBar"><progress value="<%=Math.round((double)teenMan/totalBuyer*1000)/10.0%>" max="100"></progress></td>
                    <td class="buyer10MPerc"><%=Math.round((double)teenMan/totalBuyer*1000)/10.0%>%</td>
                </tr>
                <tr>
                    <td class="buyer20FPerc"><%=Math.round((double)twWo/totalBuyer*1000)/10.0%>%</td>
                    <td class="buyer20FBar"><progress value="<%=Math.round((double)twWo/totalBuyer*1000)/10.0%>" max="100"></progress></td>
                    <td class="buyerAgeText">20대</td>
                    <td class="buyer20MBar"><progress value="<%=Math.round((double)twMan/totalBuyer*1000)/10.0%>" max="100"></progress></td>
                    <td class="buyer20MPerc"><%=Math.round((double)twMan/totalBuyer*1000)/10.0%>%</td>
                </tr>
                <tr>
                    <td class="buyer30FPerc"><%=Math.round((double)thWo/totalBuyer*1000)/10.0%>%</td>
                    <td class="buyer30FBar"><progress value="<%=Math.round((double)thWo/totalBuyer*1000)/10.0%>" max="100"></progress></td>
                    <td class="buyerAgeText">30대</td>
                    <td class="buyer30MBar"><progress value="<%=Math.round((double)thMan/totalBuyer*1000)/10.0%>" max="100"></progress></td>
                    <td class="buyer30MPerc"><%=Math.round((double)thMan/totalBuyer*1000)/10.0%>%</td>
                </tr>
                <tr>
                    <td class="buyer40FPerc"><%=Math.round((double)foWo/totalBuyer*1000)/10.0%>%</td>
                    <td class="buyer40FBar"><progress value="<%=Math.round((double)foWo/totalBuyer*1000)/10.0%>" max="100"></progress></td>
                    <td class="buyerAgeText">40대</td>
                    <td class="buyer40MBar"><progress value="<%=Math.round((double)foMan/totalBuyer*1000)/10.0%>" max="100"></progress></td>
                    <td class="buyer40MPerc"><%=Math.round((double)foMan/totalBuyer*1000)/10.0%>%</td>
                </tr>
                <tr>
                    <td class="buyer50FPerc"><%=Math.round((double)fiWo/totalBuyer*1000)/10.0%>%</td>
                    <td class="buyer50FBar"><progress value="<%=Math.round((double)fiWo/totalBuyer*1000)/10.0%>" max="100"></progress></td>
                    <td class="buyerAgeText">50대</td>
                    <td class="buyer50MBar"><progress value="<%=Math.round((double)fiMan/totalBuyer*1000)/10.0%>" max="100"></progress></td>
                    <td class="buyer50MPerc"><%=Math.round((double)fiMan/totalBuyer*1000)/10.0%>%</td>
                </tr>
                <tr>
                    <td class="buyerOverFPerc"><%=Math.round((double)etcWo/totalBuyer*1000)/10.0%>%</td>
                    <td class="buyerOverFBar"><progress value="<%=Math.round((double)etcWo/totalBuyer*1000)/10.0%>" max="100"></progress></td>
                    <td class="buyerAgeText">그 이상</td>
                    <td class="buyerOverMBar"><progress value="<%=Math.round((double)etcMan/totalBuyer*1000)/10.0%>" max="100"></progress></td>
                    <td class="buyerOverMPerc"><%=Math.round((double)etcMan/totalBuyer*1000)/10.0%>%</td>
                </tr>
                <tr>
                    <td></td>
                    <td class="buyerFText">여자</td>
                    <td></td>
                    <td class="buyerMText">남자</td>
                    <td></td>
                </tr>
            
            </table>

        </div>
            
        


        <hr>
        <!-- 별 평점 분포도 -->
        <div class="starDistri-container">
            <div class="starAvg">
                <div class="starDistriTitle">평점 분포</div>
                <div class="starRev">
                    <span class="starR1">별1_왼쪽</span>
                    <span class="starR2">별1_오른쪽</span>
                    <span class="starR1">별2_왼쪽</span>
                    <span class="starR2">별2_오른쪽</span>
                    <span class="starR1">별3_왼쪽</span>
                    <span class="starR2">별3_오른쪽</span>
                    <span class="starR1">별4_왼쪽</span>
                    <span class="starR2">별4_오른쪽</span>
                    <span class="starR1">별5_왼쪽</span>
                    <span class="starR2">별5_오른쪽</span>
                </div>
                <div class="starRevScore"><%=avgStarScore%></div>
            </div>
            
            <div class="starDistriDetail">
                <div class="star">
                    <div class="starRevFive">
                        <span class="starR1 on">별1_왼쪽</span>
                        <span class="starR2 on">별1_오른쪽</span>
                        <span class="starR1 on">별2_왼쪽</span>
                        <span class="starR2 on">별2_오른쪽</span>
                        <span class="starR1 on">별3_왼쪽</span>
                        <span class="starR2 on">별3_오른쪽</span>
                        <span class="starR1 on">별4_왼쪽</span>
                        <span class="starR2 on">별4_오른쪽</span>
                        <span class="starR1 on">별5_왼쪽</span>
                        <span class="starR2 on">별5_오른쪽</span>
                    </div>
                    <div class="starRevFiveBar">
                        <progress value="<%=Math.round(fiveStar/totalStar*1000)/10.0%>" max="100"></progress>
                    </div>
                    <div class="starRevFivePerc">
                        <%=Math.round(fiveStar/totalStar*1000)/10.0%>%
                    </div>
                </div>
                <div class="star">
                    <div class="starRevFour">
                        <span class="starR1 on">별1_왼쪽</span>
                        <span class="starR2 on">별1_오른쪽</span>
                        <span class="starR1 on">별2_왼쪽</span>
                        <span class="starR2 on">별2_오른쪽</span>
                        <span class="starR1 on">별3_왼쪽</span>
                        <span class="starR2 on">별3_오른쪽</span>
                        <span class="starR1 on">별4_왼쪽</span>
                        <span class="starR2 on">별4_오른쪽</span>
                        <span class="starR1">별5_왼쪽</span>
                        <span class="starR2">별5_오른쪽</span>
                    </div>
                    <div class="starRevFourBar">
                        <progress value="<%=Math.round(fourStar/totalStar*1000)/10.0%>" max="100"></progress>
                    </div>
                    <div class="starRevFourPerc">
                        <%=Math.round(fourStar/totalStar*1000)/10.0%>%
                    </div>
                </div>
                <div class="star">
                    <div class="starRevThree">
                        <span class="starR1 on">별1_왼쪽</span>
                        <span class="starR2 on">별1_오른쪽</span>
                        <span class="starR1 on">별2_왼쪽</span>
                        <span class="starR2 on">별2_오른쪽</span>
                        <span class="starR1 on">별3_왼쪽</span>
                        <span class="starR2 on">별3_오른쪽</span>
                        <span class="starR1">별4_왼쪽</span>
                        <span class="starR2">별4_오른쪽</span>
                        <span class="starR1">별5_왼쪽</span>
                        <span class="starR2">별5_오른쪽</span>
                    </div>
                    <div class="starRevThreeBar">
                        <progress value="<%=Math.round(threeStar/totalStar*1000)/10.0%>" max="100"></progress>
                    </div>
                    <div class="starRevThreePerc">
                        <%=Math.round(threeStar/totalStar*1000)/10.0%>%
                    </div>
                </div>
                <div class="star">
                    <div class="starRevTwo">
                        <span class="starR1 on">별1_왼쪽</span>
                        <span class="starR2 on">별1_오른쪽</span>
                        <span class="starR1 on">별2_왼쪽</span>
                        <span class="starR2 on">별2_오른쪽</span>
                        <span class="starR1">별3_왼쪽</span>
                        <span class="starR2">별3_오른쪽</span>
                        <span class="starR1">별4_왼쪽</span>
                        <span class="starR2">별4_오른쪽</span>
                        <span class="starR1">별5_왼쪽</span>
                        <span class="starR2">별5_오른쪽</span>
                    </div>
                    <div class="starRevTwoBar">
                        <progress value="<%=Math.round(twoStar/totalStar*1000)/10.0%>" max="100"></progress>
                    </div>
                    <div class="starRevTwoPerc">
                        <%=Math.round(twoStar/totalStar*1000)/10.0%>%
                    </div>
                </div>
                <div class="star">
                    <div class="starRevOne">
                        <span class="starR1 on">별1_왼쪽</span>
                        <span class="starR2 on">별1_오른쪽</span>
                        <span class="starR1">별2_왼쪽</span>
                        <span class="starR2">별2_오른쪽</span>
                        <span class="starR1">별3_왼쪽</span>
                        <span class="starR2">별3_오른쪽</span>
                        <span class="starR1">별4_왼쪽</span>
                        <span class="starR2">별4_오른쪽</span>
                        <span class="starR1">별5_왼쪽</span>
                        <span class="starR2">별5_오른쪽</span>
                    </div>
                    <div class="starRevOneBar">
                        <progress value="<%=Math.round(oneStar/totalStar*1000)/10.0%>" max="100"></progress>
                    </div>
                    <div class="starRevOnePerc">
                        <%=Math.round(oneStar/totalStar*1000)/10.0%>%
                    </div>
                </div>
            </div>
        </div>

        <hr>
        <div class="makeBookClub">
            <button class="makeBookClubBtn btn" 
            	onclick="location.href='<%=request.getContextPath()%>/bookclub/bookclubWrite?bNo=<%=bookdetail.getBookNo()%>&bTitle=<%=bookdetail.getBookTitle()%>&bImg=<%=bookdetail.getBookImg()%>'">
            	이 책으로 독서모임 만들기
            </button>
        </div>

        <div class="bookComments-container">
            <div class="bookCommentsTitle">한줄평</div>
            
            <div class="bookComments">
                <div class="starRevReview">
                    <span class="starR on">별1</span>
                    <span class="starR">별2</span>
                    <span class="starR">별3</span>
                    <span class="starR">별4</span>
                    <span class="starR">별5</span>
                  </div>
                  <div class="writeComments">
                      <table>
                          <tr>
                              <td>
                                <div><textarea class="commentTextarea" cols="110" rows="5"></textarea></div>
                              </td>
                              <td>
                                <div><button class="btn writeBtn" >등록</button></div>
                              </td>
                          </tr>
                      </table>
                     
                  </div>
                  
                  
                   <div class="comment-area"> <!-- 달린댓글부분 -->
                      <%for(BookComView com : comList) {%>
                      <div class="comPer">
	                	
	                	<div class="commentHeader">
		                	<div class="commentWriter"><%=com.getMemberId()%></div>
		                	<div class="commentWriterNo" style="display:none"><%=com.getMemberNo()%></div>
		                	<div class="starRevPer">
			                    <span class="starR on">별1</span>
			                    <%if(com.getScore()<2) {%>
			                    	<span class="starR">별2</span>
			                    <%}else { %>
			                    	<span class="starR on">별2</span>
			                    <%} %>
			                    <%if(com.getScore()<3) {%>
			                    	<span class="starR">별3</span>
			                    <%}else { %>
			                    	<span class="starR on">별3</span>
			                    <%} %>
			                    <%if(com.getScore()<4) {%>
			                    	<span class="starR">별4</span>
			                    <%}else { %>
			                    	<span class="starR on">별4</span>
			                    <%} %>
			                    <%if(com.getScore()<5) {%>
			                    	<span class="starR">별5</span>
			                    <%}else { %>
			                    	<span class="starR on">별5</span>
			                    <%} %>
			                  </div>
		                	
		                </div>
		               	<div class="commentBody">
		                	<div class="commentContent"><%=com.getCom()%></div>
			                <div class="commentDate"><%=com.getComDate()%></div>
		                </div>
		                <%if(logginedMember.getMemberNo()==com.getMemberNo()) {%>
			                <div class="commentEdit">
			                	<button class="btn editBtn">수정</button>
			                	<button class="btn deleteBtn">삭제</button>
			                </div>
		                <%} %>
                      </div>
                      <%} %>
                   </div>
                  
                  
            </div>

        </div>
    </div>

</section>

<script>
    $(function() {
    	
    	//댓글삭제
    	$(".deleteBtn").click(function(e) {
    		location.href="<%=request.getContextPath()%>/product/productDeleteCom?mNo=<%=logginedMember.getMemberNo()%>&bNo=<%=bookdetail.getBookNo()%>";
    	});
    	
    	
    	
    	//댓글수정
    	$(".editBtn").click(function(e) {
    		let myCom = $(this).closest(".comPer");
    		console.log(myCom);
    		$(this).next().before('<button class="btn editEndBtn">수정완료</button>');
    		$(this).next().next().remove();
    		$(this).remove();
    		myCom.find(".starRevPer").before($(".starRevReview").clone(true));
    		myCom.find(".starRevPer").remove();
    		let myText = myCom.find(".commentContent").html();
    		myCom.find(".commentContent").before('<textarea class="editTextarea" cols="70" rows="5"></textarea>');
    		$(".editTextarea").val(myText);
    		myCom.find(".commentContent").next().remove();
    		myCom.find(".commentContent").remove();
    		
    		
    		$(".editEndBtn").click(function(e) {
        		location.href="<%=request.getContextPath()%>/product/productEditCom?mNo=<%=logginedMember.getMemberNo()%>&bNo=<%=bookdetail.getBookNo()%>&score="+myCom.find('.starRevReview').find('.on').length+"&com="+$('.editTextarea').val();                                               
        	});
    		
    	});
    	
    	
    	
    	
    	$(".writeBtn").click(function(e) {
    		let mNo = <%=logginedMember.getMemberNo()%>;
    		let chk = true;
    		<%for(BookComView com : comList) {%>
    			if(<%=com.getMemberNo()%>==mNo) {
    				chk = false;
    			}
    		<%}%>
    		if(chk==false) {
    			alert("이미 한줄평을 등록하셨습니다.");
    		}else {
    			<%-- mNo
    			<%=bookdetail.getBookNo()%>
    			$(".commentTextarea").val()
    			$(".starRevReview").find(".on").length --%>
    			location.href="<%=request.getContextPath()%>/product/productWriteComment?mNo="+mNo+"&bNo=<%=bookdetail.getBookNo()%>&score="+$('.starRevReview').find('.on').length+"&com="+$('.commentTextarea').val();
    		}
    	});
    	
    	
    	//댓글부분에 별점 선택
	    $('.starRevReview span').click(function(){
	        $(this).parent().children('span').removeClass('on');
	        $(this).addClass('on').prevAll('span').addClass('on');
	        return false;
	        });
	    
    	//평균별점 색칠
	    let halfStar = $(".starAvgTop").find("span").first();
	    let halfStarBottom = $(".starAvg").find("span").first();
	    for(let i=0; i<<%=Math.floor(avgStarScore*2)%>; i++) {
	    	halfStar.addClass("on");
	    	halfStarBottom.addClass("on");
	    	halfStar = halfStar.next();
	    	halfStarBottom = halfStarBottom.next();
	    };
	    
	    
	    
	    
	    
	    
	    
	    
	    
    });
</script>

<%@ include file="/views/common/footer.jsp" %>