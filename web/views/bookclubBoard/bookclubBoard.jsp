<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.semi.bookclub.model.vo.*, java.util.Map" %>    
<%@ include file="/views/common/header.jsp"%>
<%
	List<BookclubView> list = (List)request.getAttribute("list");
	List<BookclubPartiView> listParti = (List)request.getAttribute("listParti");
	Map<Integer,Integer> mapPartiCnt = (Map)request.getAttribute("mapPartiCnt");
%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bookclubBoard.css">
<script src="<%=request.getContextPath()%>/js/bookclubBoard.js"></script>
<section>
        <div class="clubList">
            <div class="clubSort">
                <span>최근날짜 순</span>
                <span>|</span>
                <span>지난날짜 순</span>
                <span>|</span>
                <span>관심분야 순</span>
            </div>
            <div class="makeclub">
                <button class="btn makeclubBtn" onclick="location.href='<%=request.getContextPath()%>/bookclub/bookclubWrite'">책 모임 만들기</button>
                <div></div>
            </div>
		<div class="bookClub_container">
			<%for(BookclubView bc : list) { %>
	            <div class="bookClub">
	                <div class="bookClubDiv">
	                	<input type="hidden" class="bookclubNo" value="<%=bc.getBookclubNo()%>">
	                    <div class="bookClubImg">
	                        <img src="<%=request.getContextPath()%>/image/book/<%=bc.getBookclubImg()%>" >
	                    </div>
	                    <!-- hover시 나타나는 정보들 -->
	                    <div class="bookClubInfo">
	                        <div class="clubTitle"><%=bc.getBookclubTitle()%></div>
	                        <table>
	                            <tr class="clubLeader">
	                                <td>조장</td>
	                                <td><%=bc.getWriter()%></td>
	                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/<%=bc.getGender().equals("M")?"man.png":"woman.png"%>"></td>
	                            </tr>
	                            
	                        </table>
	                        <hr style="visibility: hidden">
	                        
	                        <table class="partiTable">
	                        	<tr>
	                        		<td>조원</td>
	                        	</tr>
	                        	<%for(BookclubPartiView pv : listParti) {%>
	                        		
	                        		 <%if(pv.getBookclubNo()==bc.getBookclubNo()) {%>
			                        	<tr class="partiTr">
			                        		<td></td>
			                        		<td><%=pv.getMemberId()%></td>
			                        		<td><img src="<%=request.getContextPath()%>/image/bookClubBoard/<%=pv.getGender().equals("M")?"man.png":"woman.png"%>"></td>
			                        	</tr>
	                        		<%} 
	                        	}%>
	                        </table>
	                    </div>
	                </div>
	                <div class="clubTitleAgain"><%=bc.getBookclubTitle()%></div>  <!-- 이거 보이게하셈 -->
	                <div class="clubCount">
	                    <div class="maxPer">최대인원 : <%=bc.getMaxPerson()%>명</div>
	                    <input type="hidden" class="max" value="<%=bc.getMaxPerson()%>">
	                    <span class="nowPer">현재인원 : </span>
	                    <span class="joinedCnt"><%=mapPartiCnt.containsKey(bc.getBookclubNo())?mapPartiCnt.get(bc.getBookclubNo()):"0"%></span>
	                    <span>명</span>
	                </div>
	                <div class="bookClubBtn">
	                	<%if(logginedMember!=null) { %>
	                		<%boolean partied = false;
	                		for(BookclubPartiView pv : listParti) {
	                			if(bc.getBookclubNo()==pv.getBookclubNo() && logginedMember.getMemberId().equals(pv.getMemberId())) {
	                				partied = true;
	                				break;
	                			}
	                		} %>
	                		<%if(partied) {%>
	                			<!-- 내가 참가자일때 -->
	                			<button class="cancelBtn btn">참여 취소하기</button>
	                		<%}else if(logginedMember.getMemberNo()==bc.getMemberNo()) {%>
	                			<button class="deleteClubBtn btn">북클럽 삭제하기</button>
	                		<%}else { %>
		                    	<button class="joinBtn btn">북클럽 참여하기</button>
		                 	<%} %>
	                    <%}else { %>
	                    	<button class="joinBtn btn">북클럽 참여하기</button>
	                    <%} %>
	                </div>
	            </div>
			<%} %>
			</div>
        </div>
        
        <div class="pageBar">
    		<%=request.getAttribute("pageBar")%>
    	</div>
    </section>  
<script>
	$(function(){
		//참여하기
		$(".joinBtn").click(function(e) {
			let rootDiv = $(this).closest(".bookClub");
			let partiCnt = rootDiv.find(".joinedCnt").html();
			partiCnt *= 1;
			let maxCnt = rootDiv.find(".max").val();
			maxCnt *= 1;
			if(<%=logginedMember==null%>) {
				alert("로그인이 필요한 서비스입니다.");	
			}else if(maxCnt<=partiCnt) {
				alert("이미 최대인원이 참여중입니다.");
			}else {
				location.href="<%=request.getContextPath()%>/bookclub/bookclubJoin?memberNo=<%=logginedMember.getMemberNo()%>&memberId=<%=logginedMember.getMemberId()%>&bookclubNo="+$(this).closest('.bookClub').find('.bookclubNo').val();
			}
		});
		//취소
		$(".cancelBtn").click(function(e) {
			if(<%=logginedMember==null%>) {
				alert("로그인이 필요한 서비스입니다.");	
			}else {
				location.href="<%=request.getContextPath()%>/bookclub/bookclubDeleteJoin?memberNo=<%=logginedMember.getMemberNo()%>&bookclubNo="+$(this).closest('.bookClub').find('.bookclubNo').val();
			}
		});
		//삭제
		$(".deleteClubBtn").click(function(e) {
			if(<%=logginedMember==null%>) {
				alert("로그인이 필요한 서비스입니다.");	
			}else {
				location.href="<%=request.getContextPath()%>/bookclub/bookclubDelete?bookclubNo="+$(this).closest('.bookClub').find('.bookclubNo').val();
			}
		});
	})
</script>
<%@ include file="/views/common/footer.jsp"%>