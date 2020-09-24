<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bookClubBoard.css">
<script src="<%=request.getContextPath()%>/js/bookClubBoard.js"></script>
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
                <button class="btn makeclubBtn">책 모임 만들기</button>
                <div></div>
            </div>

            <!-- 게시글 1개 -->
            <div class="bookClub">
                <div class="bookClubDiv">
                    <div class="bookClubImg">
                        <img src="<%=request.getContextPath()%>/image/8967358024_1.jpg" >
                    </div>
                    
                    <!-- hover시 나타나는 정보들 -->
                    <div class="bookClubInfo">
                        <div class="clubTitle">북클럽 제목</div>
                        <table>
                            <tr class="clubLeader">
                                <td>조장</td>
                                <td>user15</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/woman.png"></td>
                            </tr>
                            
                            <tr class="clubMember">
                                <td>참여자</td>
                                <td>user01</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/woman.png"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>user02</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/man.png"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>user03</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/woman.png"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>user04</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/man.png"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>user05</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/man.png"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>user06</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/man.png"></td>
                            </tr>
                        </table>
                    </div>
                </div>
                <div class="clubCount">
                    <span>현재인원 : </span>
                    <span class="joinedCnt">n명</span>
                </div>
                <div class="bookClubBtn">
                    <button class="joinBtn btn">참여하기</button>
                    <button class="cancelBtn btn">취소하기</button>
                </div>
            </div>
            <!-- 게시글 1개 -->


            <!-- 게시글 1개 -->
            <div class="bookClub">
                <div class="bookClubDiv">
                    <div class="bookClubImg">
                        <img src="<%=request.getContextPath()%>/image/8967358024_1.jpg" >
                    </div>
                    
                    <!-- hover시 나타나는 정보들 -->
                    <div class="bookClubInfo">
                        <div class="clubTitle">북클럽 제목</div>
                        <table>
                            <tr class="clubLeader">
                                <td>조장</td>
                                <td>user15</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/woman.png"></td>
                            </tr>
                            
                            <tr class="clubMember">
                                <td>참여자</td>
                                <td>user01</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/woman.png"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>user02</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/man.png"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>user03</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/woman.png"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>user04</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/man.png"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>user05</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/man.png"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>user06</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/man.png"></td>
                            </tr>
                        </table>
                    </div>
                </div>
                <div class="clubCount">
                    <span>현재인원 : </span>
                    <span class="joinedCnt">n명</span>
                </div>
                <div class="bookClubBtn">
                    <button class="joinBtn btn">참여하기</button>
                    <button class="cancelBtn btn">취소하기</button>
                </div>
            </div>
            <!-- 게시글 1개 -->
            <!-- 게시글 1개 -->
            <div class="bookClub">
                <div class="bookClubDiv">
                    <div class="bookClubImg">
                        <img src="<%=request.getContextPath()%>/image/8967358024_1.jpg" >
                    </div>
                    
                    <!-- hover시 나타나는 정보들 -->
                    <div class="bookClubInfo">
                        <div class="clubTitle">북클럽 제목</div>
                        <table>
                            <tr class="clubLeader">
                                <td>조장</td>
                                <td>user15</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/woman.png"></td>
                            </tr>
                            
                            <tr class="clubMember">
                                <td>참여자</td>
                                <td>user01</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/woman.png"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>user02</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/man.png"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>user03</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/woman.png"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>user04</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/man.png"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>user05</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/man.png"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>user06</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/man.png"></td>
                            </tr>
                        </table>
                    </div>
                </div>
                <div class="clubCount">
                    <span>현재인원 : </span>
                    <span class="joinedCnt">n명</span>
                </div>
                <div class="bookClubBtn">
                    <button class="joinBtn btn">참여하기</button>
                    <button class="cancelBtn btn">취소하기</button>
                </div>
            </div>
            <!-- 게시글 1개 -->
            <!-- 게시글 1개 -->
            <div class="bookClub">
                <div class="bookClubDiv">
                    <div class="bookClubImg">
                        <img src="<%=request.getContextPath()%>/image/8967358024_1.jpg" >
                    </div>
                    
                    <!-- hover시 나타나는 정보들 -->
                    <div class="bookClubInfo">
                        <div class="clubTitle">북클럽 제목</div>
                        <table>
                            <tr class="clubLeader">
                                <td>조장</td>
                                <td>user15</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/woman.png"></td>
                            </tr>
                            
                            <tr class="clubMember">
                                <td>참여자</td>
                                <td>user01</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/woman.png"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>user02</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/man.png"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>user03</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/woman.png"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>user04</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/man.png"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>user05</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/man.png"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>user06</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/man.png"></td>
                            </tr>
                        </table>
                    </div>
                </div>
                <div class="clubCount">
                    <span>현재인원 : </span>
                    <span class="joinedCnt">n명</span>
                </div>
                <div class="bookClubBtn">
                    <button class="joinBtn btn">참여하기</button>
                    <button class="cancelBtn btn">취소하기</button>
                </div>
            </div>
            <!-- 게시글 1개 -->
            <!-- 게시글 1개 -->
            <div class="bookClub">
                <div class="bookClubDiv">
                    <div class="bookClubImg">
                        <img src="<%=request.getContextPath()%>/image/8967358024_1.jpg" >
                    </div>
                    
                    <!-- hover시 나타나는 정보들 -->
                    <div class="bookClubInfo">
                        <div class="clubTitle">북클럽 제목</div>
                        <table>
                            <tr class="clubLeader">
                                <td>조장</td>
                                <td>user15</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/woman.png"></td>
                            </tr>
                            
                            <tr class="clubMember">
                                <td>참여자</td>
                                <td>user01</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/woman.png"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>user02</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/man.png"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>user03</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/woman.png"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>user04</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/man.png"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>user05</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/man.png"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>user06</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/man.png"></td>
                            </tr>
                        </table>
                    </div>
                </div>
                <div class="clubCount">
                    <span>현재인원 : </span>
                    <span class="joinedCnt">n명</span>
                </div>
                <div class="bookClubBtn">
                    <button class="joinBtn btn">참여하기</button>
                    <button class="cancelBtn btn">취소하기</button>
                </div>
            </div>
            <!-- 게시글 1개 -->
            <!-- 게시글 1개 -->
            <div class="bookClub">
                <div class="bookClubDiv">
                    <div class="bookClubImg">
                        <img src="<%=request.getContextPath()%>/image/8967358024_1.jpg" >
                    </div>
                    
                    <!-- hover시 나타나는 정보들 -->
                    <div class="bookClubInfo">
                        <div class="clubTitle">북클럽 제목</div>
                        <table>
                            <tr class="clubLeader">
                                <td>조장</td>
                                <td>user15</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/woman.png"></td>
                            </tr>
                            
                            <tr class="clubMember">
                                <td>참여자</td>
                                <td>user01</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/woman.png"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>user02</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/man.png"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>user03</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/woman.png"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>user04</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/man.png"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>user05</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/man.png"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>user06</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/man.png"></td>
                            </tr>
                        </table>
                    </div>
                </div>
                <div class="clubCount">
                    <span>현재인원 : </span>
                    <span class="joinedCnt">n명</span>
                </div>
                <div class="bookClubBtn">
                    <button class="joinBtn btn">참여하기</button>
                    <button class="cancelBtn btn">취소하기</button>
                </div>
            </div>
            <!-- 게시글 1개 -->
            <!-- 게시글 1개 -->
            <div class="bookClub">
                <div class="bookClubDiv">
                    <div class="bookClubImg">
                        <img src="<%=request.getContextPath()%>/image/8967358024_1.jpg" >
                    </div>
                    
                    <!-- hover시 나타나는 정보들 -->
                    <div class="bookClubInfo">
                        <div class="clubTitle">북클럽 제목</div>
                        <table>
                            <tr class="clubLeader">
                                <td>조장</td>
                                <td>user15</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/woman.png"></td>
                            </tr>
                            
                            <tr class="clubMember">
                                <td>참여자</td>
                                <td>user01</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/woman.png"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>user02</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/man.png"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>user03</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/woman.png"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>user04</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/man.png"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>user05</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/man.png"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>user06</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/man.png"></td>
                            </tr>
                        </table>
                    </div>
                </div>
                <div class="clubCount">
                    <span>현재인원 : </span>
                    <span class="joinedCnt">n명</span>
                </div>
                <div class="bookClubBtn">
                    <button class="joinBtn btn">참여하기</button>
                    <button class="cancelBtn btn">취소하기</button>
                </div>
            </div>
            <!-- 게시글 1개 -->
            <!-- 게시글 1개 -->
            <div class="bookClub">
                <div class="bookClubDiv">
                    <div class="bookClubImg">
                        <img src="<%=request.getContextPath()%>/image/8967358024_1.jpg" >
                    </div>
                    
                    <!-- hover시 나타나는 정보들 -->
                    <div class="bookClubInfo">
                        <div class="clubTitle">북클럽 제목</div>
                        <table>
                            <tr class="clubLeader">
                                <td>조장</td>
                                <td>user15</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/woman.png"></td>
                            </tr>
                            
                            <tr class="clubMember">
                                <td>참여자</td>
                                <td>user01</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/woman.png"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>user02</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/man.png"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>user03</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/woman.png"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>user04</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/man.png"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>user05</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/man.png"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>user06</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/man.png"></td>
                            </tr>
                        </table>
                    </div>
                </div>
                <div class="clubCount">
                    <span>현재인원 : </span>
                    <span class="joinedCnt">n명</span>
                </div>
                <div class="bookClubBtn">
                    <button class="joinBtn btn">참여하기</button>
                    <button class="cancelBtn btn">취소하기</button>
                </div>
            </div>
            <!-- 게시글 1개 -->
            <!-- 게시글 1개 -->
            <div class="bookClub">
                <div class="bookClubDiv">
                    <div class="bookClubImg">
                        <img src="<%=request.getContextPath()%>/image/8967358024_1.jpg" >
                    </div>
                    
                    <!-- hover시 나타나는 정보들 -->
                    <div class="bookClubInfo">
                        <div class="clubTitle">북클럽 제목</div>
                        <table>
                            <tr class="clubLeader">
                                <td>조장</td>
                                <td>user15</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/woman.png"></td>
                            </tr>
                            
                            <tr class="clubMember">
                                <td>참여자</td>
                                <td>user01</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/woman.png"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>user02</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/man.png"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>user03</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/woman.png"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>user04</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/man.png"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>user05</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/man.png"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>user06</td>
                                <td><img src="<%=request.getContextPath()%>/image/bookClubBoard/man.png"></td>
                            </tr>
                        </table>
                    </div>
                </div>
                <div class="clubCount">
                    <span>현재인원 : </span>
                    <span class="joinedCnt">n명</span>
                </div>
                <div class="bookClubBtn">
                    <button class="joinBtn btn">참여하기</button>
                    <button class="cancelBtn btn">취소하기</button>
                </div>
            </div>
            <!-- 게시글 1개 -->



             







        </div>
    </section>  
    
<%@ include file="/views/common/footer.jsp"%>