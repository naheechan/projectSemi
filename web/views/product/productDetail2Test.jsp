<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/productDetail.css">
<script>
    $(function() {
    $('.starRev span').click(function(){
        $(this).parent().children('span').removeClass('on');
        $(this).addClass('on').prevAll('span').addClass('on');
        return false;
        });
    });

</script>

<section>
    <div id="bookDetail-container">
        <div id="bookInfoDiv">
            <div id="bookImg">
                <img src="<%=request.getContextPath()%>/image/8967358024_1.jpg">
            </div>
            <div id="bookText">
                <table>
                    <tr>
                        <td>책 제목</td>
                        <td>매우 예민한 사람들을 위한 책</td>
                    </tr>
                    <tr>
                        <td>지은이</td>
                        <td>전홍진</td>
                    </tr>
                    <tr>
                        <td>출판사</td>
                        <td>글항아리</td>
                    </tr>
                    <tr>
                        <td>출판일</td>
                        <td>2020-07-23</td>
                    </tr>
                    <tr>
                        <td>가격</td>
                        <td>18,000원</td>
                    </tr>
                    <tr>
                        <!-- 총 별 평점 -->
                        <td colspan="2">
                            <div class="starRev">
                                <span class="starR1 on">별1_왼쪽</span>
                                <span class="starR2 on">별1_오른쪽</span>
                                <span class="starR1 on">별2_왼쪽</span>
                                <span class="starR2 on">별2_오른쪽</span>
                                <span class="starR1 on">별3_왼쪽</span>
                                <span class="starR2 on">별3_오른쪽</span>
                                <span class="starR1 on">별4_왼쪽</span>
                                <span class="starR2">별4_오른쪽</span>
                                <span class="starR1">별5_왼쪽</span>
                                <span class="starR2">별5_오른쪽</span>
                            </div>
                            <div class="starRevScore">3.5</div>
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
                지난 10여 년간 삼성서울병원 정신건강의학과 전문의로서 1만 명 이상의 환자를 상담·치료해온 전홍진 교수의 저서. 
                서양인과 한국인의 우울증 양상 차이, 국내 스트레스와 자살 연구 등을 대규모로 주도해온 그는 그간의 임상시험 및 상담 사례를 대거 방출한다.<br><br>

                정신건강의학과에 온 이들 대부분은 우울증이라는 진단이 나와도 ‘나는 우울증이 아니’라고 대답한다. 
                이때 말을 바꿔 ‘당신은 매우 예민한가’라고 물으면 그들은 ‘맞다, 나는 예민한 편이다’라며 수긍한다. 
                더욱이 자기 분야에서 뛰어난 성과와 사회적 성공을 이룬 사람들 가운데 다수가 ‘나는 매우 예민한 편’임을 인정한다. 
                저자는 바로 이 때문에 『매우 예민한 사람들을 위한 책』을 썼다. ‘매우 예민하다’는 성격적 특성에 주의만 기울인다면 정신과 상담이나 약물 치료 없이도 증상이 호전될 수 있다. 
                이 책에서 전 교수는 특별히 골라낸 40명의 사례를 통해 예민성을 줄이고 삶의 질을 높이는 방법을 알려주고 있다.
            </div>
            
        </div>

        <hr>
        <div class="buyerStatement">
            <div class="buyerTitle">구매자 분포도</div>
            <table>
                <tr>
                    <td class="buyer10FPerc">0.5%</td>
                    <td class="buyer10FBar"><progress value="1" max="100"></progress></td>
                    <td class="buyerAgeText">10대</td>
                    <td class="buyer10MBar"><progress value="1" max="100"></progress></td>
                    <td class="buyer10MPerc">0.1%</td>
                </tr>
                <tr>
                    <td class="buyer20FPerc">16.8%</td>
                    <td class="buyer20FBar"><progress value="15" max="100"></progress></td>
                    <td class="buyerAgeText">20대</td>
                    <td class="buyer20MBar"><progress value="3" max="100"></progress></td>
                    <td class="buyer20MPerc">3.5%</td>
                </tr>
                <tr>
                    <td class="buyer30FPerc">25.2%</td>
                    <td class="buyer30FBar"><progress value="25" max="100"></progress></td>
                    <td class="buyerAgeText">30대</td>
                    <td class="buyer30MBar"><progress value="6" max="100"></progress></td>
                    <td class="buyer30MPerc">5.8%</td>
                </tr>
                <tr>
                    <td class="buyer40FPerc">25.3%</td>
                    <td class="buyer40FBar"><progress value="25" max="100"></progress></td>
                    <td class="buyerAgeText">40대</td>
                    <td class="buyer40MBar"><progress value="7" max="100"></progress></td>
                    <td class="buyer40MPerc">6.6%</td>
                </tr>
                <tr>
                    <td class="buyer50FPerc">9.2%</td>
                    <td class="buyer50FBar"><progress value="9" max="100"></progress></td>
                    <td class="buyerAgeText">50대</td>
                    <td class="buyer50MBar"><progress value="5" max="100"></progress></td>
                    <td class="buyer50MPerc">4.6%</td>
                </tr>
                <tr>
                    <td class="buyerOverFPerc">1.1%</td>
                    <td class="buyerOverFBar"><progress value="1" max="100"></progress></td>
                    <td class="buyerAgeText">그 이상</td>
                    <td class="buyerOverMBar"><progress value="1" max="100"></progress></td>
                    <td class="buyerOverMPerc">1.3%</td>
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
                    <span class="starR1 on">별1_왼쪽</span>
                    <span class="starR2 on">별1_오른쪽</span>
                    <span class="starR1 on">별2_왼쪽</span>
                    <span class="starR2 on">별2_오른쪽</span>
                    <span class="starR1 on">별3_왼쪽</span>
                    <span class="starR2 on">별3_오른쪽</span>
                    <span class="starR1 on">별4_왼쪽</span>
                    <span class="starR2">별4_오른쪽</span>
                    <span class="starR1">별5_왼쪽</span>
                    <span class="starR2">별5_오른쪽</span>
                </div>
                <div class="starRevScore">3.5</div>
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
                        <progress value="50" max="100"></progress>
                    </div>
                    <div class="starRevFivePerc">
                        50.5%
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
                        <progress value="40" max="100"></progress>
                    </div>
                    <div class="starRevFourPerc">
                        32.2%
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
                        <progress value="20" max="100"></progress>
                    </div>
                    <div class="starRevThreePerc">
                        22.2%
                    </div>
                </div>
                <div class="star">
                    <div class="starRevTwo">
                        <span class="starR1 on">별1_왼쪽</span>
                        <span class="starR2 on">별1_오른쪽</span>
                        <span class="starR1 on">별2_왼쪽</span>
                        <span class="starR2">별2_오른쪽</span>
                        <span class="starR1">별3_왼쪽</span>
                        <span class="starR2">별3_오른쪽</span>
                        <span class="starR1">별4_왼쪽</span>
                        <span class="starR2">별4_오른쪽</span>
                        <span class="starR1">별5_왼쪽</span>
                        <span class="starR2">별5_오른쪽</span>
                    </div>
                    <div class="starRevTwoBar">
                        <progress value="10" max="100"></progress>
                    </div>
                    <div class="starRevTwoPerc">
                        13.1%
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
                        <progress value="5" max="100"></progress>
                    </div>
                    <div class="starRevOnePerc">
                        3.0%
                    </div>
                </div>
            </div>
        </div>

        <hr>
        <div class="makeBookClub">
            <button class="makeBookClubBtn btn">이 책으로 독서모임 만들기</button>
        </div>

        <div class="bookComments-container">
            <div class="bookCommentsTitle">한줄평</div>
            
            <div class="bookComments">
                <div class="starRev">
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
                                <div><textarea cols="110" rows="5"></textarea></div>
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

<%@ include file="/views/common/footer.jsp" %>