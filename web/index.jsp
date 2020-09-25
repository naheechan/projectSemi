<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
    <script defer src="<%=request.getContextPath()%>/js/event.js"></script>
<section id="">
	<div id="mainimage">
		 <body>
    <div class="slideshow-container">
      <div class="mySlides fade">
        <div class="numbertext">1 / 3</div>
        <img src="http://placehold.it/1150x500" style="width: 100%" />
        <div class="text"> One</div>
      </div>

      <div class="mySlides fade">
        <div class="numbertext">2 / 3</div>
       <img src="http://placehold.it/1150x500" style="width: 100%" />
        <div class="text"> Two</div>
      </div>

      <div class="mySlides fade">
        <div class="numbertext">3 / 3</div>
       <img src="http://placehold.it/1150x500" style="width: 100%" />
        <div class="text"> Three</div>
      </div>
      <div style="text-align: center">
      <span class="dot"></span>
      <span class="dot"></span>
      <span class="dot"></span>
    </div>
    </div>
    <br />
    <style>
     * {
        box-sizing: border-box;
      }

      .mySlides {
        display: none;
      }
      img {
        vertical-align: middle;
      }

      /* Slideshow container */
      .slideshow-container {
        max-width: 1000px;
        position: relative;
        margin: auto;
      }

      /* Caption text */
      .text {
        color: #000000;
        font-size: 15px;
        padding: 8px 12px;
        position: absolute;
        bottom: 8px;
        width: 100%;
        text-align: center;
      }

      /* Number text (1/3 etc) */
      .numbertext {
        color: #f2f2f2;
        font-size: 12px;
        padding: 8px 12px;
        position: absolute;
        top: 0;
      }

      /* The dots/bullets/indicators */
      .dot {
        height: 15px;
        width: 15px;
        margin: 0 2px;
        background-color: #bbb;
        border-radius: 50%;
        display: inline-block;
        transition: background-color 0.6s ease;
      }

      .active {
        background-color: #717171;
      }

      /* Fading animation */
      .fade {
        -webkit-animation-name: fade;
        -webkit-animation-duration: 2.5s;
        animation-name: fade;
        animation-duration: 2.5s;
      }

      @-webkit-keyframes fade {
        from {
          opacity: 0.4;
        }
        to {
          opacity: 1;
        }
      }

      @keyframes fade {
        from {
          opacity: 0.4;
        }
        to {
          opacity: 1;
        }
      }
    </style>
	</div>
	<!--깃허브 브런치 테스트  -->
	<div class="slides_wrapper">
		<ul class="slides">
			<li><img src="http://placehold.it/300x300" alt=""></li>
			<li><img src="http://placehold.it/300x300" alt=""></li>
			<li><img src="http://placehold.it/300x300" alt=""></li>
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
	  var slideIndex = 0;
      showSlides();

      function showSlides() {
        var i;
        var slides2 = document.getElementsByClassName("mySlides");
        var dots = document.getElementsByClassName("dot");
        for (i = 0; i < slides2.length; i++) {
          slides2[i].style.display = "none";
        }
        slideIndex++;
        if (slideIndex > slides2.length) {
          slideIndex = 1;
        }
        for (i = 0; i < dots.length; i++) {
          dots[i].className = dots[i].className.replace(" active", "");
        }
        slides2[slideIndex - 1].style.display = "block";
        dots[slideIndex - 1].className += " active";
        setTimeout(showSlides, 4000); //
      }
</script>

<%@ include file="/views/common/footer.jsp"%>