<%@page import="com.semi.product.model.vo.BooksJoin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List,com.semi.product.model.vo.Books"%>
<%
	List<BooksJoin> list = (List) request.getAttribute("booklist");
	int totalprice = 0;
	if (!list.isEmpty()) {
		for (BooksJoin bk : list) {
			totalprice += bk.getPrice();
		}
	}
%>
<%@ include file="/views/common/header.jsp"%>
<section>
	<style>
#carttable {
	height: auto;
	margin: 0 auto;
	border: 2px solid black;
	width: 960px;
}

body {
	height: 100%;
}

#button-box {
	display: flex;
	justify-content: space-between;
}

#headerfont {
	font-size: 25px;
	width: 960px;
	margin: 0 auto;
}

#carttable th {
	border: 1px solid black;
}

#carttable td {
	border: 1px solid black;
}

hr {
	margin-bottom: 50px;
}

#cartcontainer {
	height: auto;
	padding-bottom: 2.5em;
	/*footer의 높이 만큼 컨테이너값에 패딩바텀을 추가해준다  */
}

td {
	width: auto;
}

#price-box {
	width: 960px;
	margin: 0 auto;
}

#totaltxt {
	margin-bottom: 100px;
}

#addresstxt {
	width: 960px;
	margin: 0 auto;
}

#push {
	heigh: 20vh;
}
</style>
	<section>
		<p id="headerfont">Order</p>
		<hr>
		<div id="cartcontainer">
			<form action="<%=request.getContextPath()%>/cart/orderend"
				method="post" id="buyfrm">
			<table id="carttable">
				<%
					for (BooksJoin bk : list) {
				%>
				<tr>
					<th colspan="2">상품명</th>
					<th class="price">가격</th>
					<th class="count">수량</th>
				</tr>
				<tr>
				<tr>
					<input type="hidden"  name="bookno"value="<%=bk.getBookno()%>">
					<td><img name="img"
						src="<%=request.getContextPath()%>/image/<%=bk.getBookimg()%>"></td>
					<td><%=bk.getTitle()%></td>
					<td><%=bk.getPrice()%>원</td>
					<td><input type="text" readonly="readonly"></td>
				</tr>

				<%
					}
				%>
			</table>
			<hr>
				<div id="addresstxt">
					<div id="totaltxt">
						<input type="hidden" name="totalprice" id="totalprice"
							value="<%=totalprice%>" /> 총금 액 :<%=totalprice%>원
					</div>
					<table>
						<tr>
							<td>주문인</td>
							<input type="hidden" name="userno"
								value="<%=logginedMember.getMemberNo()%>" />
							<td id="username"><%=logginedMember.getMemberName()%></td>

						</tr>
						<tr>
							<td>받는사람</td>
							<td><input type="text" name="Recipient" /></td>
						</tr>
						<tr>
							<td>주소</td>
							<td><input type="text" id="sample6_postcode" name="postcode"
								placeholder="우편번호" /> <input type="button"
								onclick="sample6_execDaumPostcode()" value="우편번호 찾기" /><br />
								<input type="text" name="address" id="sample6_address"
								placeholder="주소" /><br /> <input type="text"
								name="extraaddress" id="sample6_detailAddress"
								placeholder="상세주소" /><br /> <input type="text"
								name="detailaddress" id="sample6_extraAddress"
								placeholder="참고항목" /></td>
						</tr>
						<tr>
							<td>휴대폰 번호</td>
							<td><input type="tel" name="tel" id="tel"
								placeholder="-없이 입력해주세요" /></td>
						</tr>
						<tr>
							<td>배송시 요청사항</td>
							<td><textarea name="request" id="" cols="30" rows="6"></textarea><br /></td>
						</tr>
					</table>
					<div id="button-box">
						<button type="button" onclick="buy()"<%-- onclick="location.href='<%=request.getContextPath()%>/cart/orderend'" --%>>주문하기</button>
					</div>
			</form>
			<!--주문하기 누르면 아임포트api이용하기-->
		</div>

		<div class="push"></div>

		<script>
		
			function sample6_execDaumPostcode() {
				new daum.Postcode(
						{
							oncomplete : function(data) {
								// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

								// 각 주소의 노출 규칙에 따라 주소를 조합한다.
								// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
								var addr = ""; // 주소 변수
								var extraAddr = ""; // 참고항목 변수

								//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
								if (data.userSelectedType === "R") {
									// 사용자가 도로명 주소를 선택했을 경우
									addr = data.roadAddress;
								} else {
									// 사용자가 지번 주소를 선택했을 경우(J)
									addr = data.jibunAddress;
								}

								// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
								if (data.userSelectedType === "R") {
									// 법정동명이 있을 경우 추가한다. (법정리는 제외)
									// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
									if (data.bname !== ""
											&& /[동|로|가]$/g.test(data.bname)) {
										extraAddr += data.bname;
									}
									// 건물명이 있고, 공동주택일 경우 추가한다.
									if (data.buildingName !== ""
											&& data.apartment === "Y") {
										extraAddr += extraAddr !== "" ? ", "
												+ data.buildingName
												: data.buildingName;
									}
									// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
									if (extraAddr !== "") {
										extraAddr = " (" + extraAddr + ")";
									}
									// 조합된 참고항목을 해당 필드에 넣는다.
									document
											.getElementById("sample6_extraAddress").value = extraAddr;
								} else {
									document
											.getElementById("sample6_extraAddress").value = "";
								}

								// 우편번호와 주소 정보를 해당 필드에 넣는다.
								document.getElementById("sample6_postcode").value = data.zonecode;
								document.getElementById("sample6_address").value = addr;
								// 커서를 상세주소 필드로 이동한다.
								document
										.getElementById("sample6_detailAddress")
										.focus();
							},
						}).open();
			}
			function buy() {
				console.log("버튼눌림");
				let frm=document.querySelector("#buyfrm")
			     let price = document.querySelector("#totalprice").value;
				 let username = document.querySelector("#username").innerText;
			      console.log(username);
			      let tel = document.querySelector("#tel").value;
			      let email="<%=logginedMember.getEmail()%>"
			      let post=document.querySelector("#sample6_postcode").value;
			      let addrss=document.querySelector("#sample6_address").value;
			      IMP.init("imp75893840");
			      IMP.request_pay(
			        {
			          pg: "html5_inicis",
			          pay_method: "card",
			          merchant_uid: "merchant_" + new Date().getTime(),
			          name: "주문결제테스트",
			          amount: /* price */"1000",
			          buyer_email: email,
			          buyer_name: username,
			          buyer_tel: tel,
			          buyer_addr: addrss,
			          buyer_postcode: post,
			        },
			        function (rsp) {
			          if (rsp.success) {
			            var msg = "결제가 완료되었습니다.";
			            frm.submit(); 
			          } else {
			            var msg = "결제에 실패하였습니다.";
			            msg+="홈으로 돌아갑니다";
			            frm.action="<%=request.getContextPath()%>";
						alert(msg);
						frm.submit();
					}
				}

				);
			}
		</script>
	</section>
	<%@ include file="/views/common/footer.jsp"%>