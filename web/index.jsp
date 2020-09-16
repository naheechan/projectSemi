<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
    <script defer src="<%=request.getContextPath()%>/js/event.js"></script>
<section id="">
	<div id="mainimage">
		<img src="http://placehold.it/1150x500" alt="">
	</div>
	<!--깃허브 브런치 테스트  -->
	<div class="slides_wrapper">
		<ul class="slides">
			<li><img src="http://placehold.it/300x300" alt="">1</li>
			<li><img src="http://placehold.it/300x300" alt="">2</li>
			<li><img src="http://placehold.it/300x300" alt="">3</li>
			<li><img src="http://placehold.it/300x300" alt=""></li>
			<li><img src="http://placehold.it/300x300" alt=""></li>
			<li><img src="http://placehold.it/300x300" alt=""></li>
			<li><img src="http://placehold.it/300x300" alt=""></li>
			<li><img src="http://placehold.it/300x300" alt=""></li>
		</ul>
	</div>
	<p class="controls">
		<button class="prev" onclick="perBtn()">&lt</button>
		<button class="next" onclick="nextBtn1()">&gt</button>
	</p>
	<article id="section_text">
		<div class="slide">
			<ul>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
			</ul>
		</div>
	</article>
</section>
<script>
	var slides = document.querySelector(".slides");
	var slide = document.querySelectorAll(".slides li");
	var currentIdx = 0;
	var slideWidth = 300;
	var slideMargin = 30;
	var slideCount = slide.length;
	var prevBtn = document.querySelector(".prev");
	var nextBtn = document.querySelector(".next");
	slides.style.width = (slideWidth + slideMargin) * slideCount - slideMargin
			+ "px";
	function moveSlide(num) {
		slides.style.left = -num * 330 + "px";
		currentIdx = num;
	}
	function perBtn() {
		if (currentIdx > 0) {
			moveSlide(currentIdx - 1);
		} else {
			moveSlide(slideCount - 3);
		}
	};
	function nextBtn1() {
		if (currentIdx < slideCount - 3) {
			moveSlide(currentIdx + 1);
		} else {
			moveSlide(0);
		}
	};
</script>

<%@ include file="/views/common/footer.jsp"%>