//외부자바스크립트는 공통되는 부분만 모아서 실행 그해당 window안에 없으면 오류가 발생해서 다른 js가 먹히지 않는다.

var sform = document.querySelector("#searchfrom");
var sebtn = document.querySelector(".searchbtn");
	sebtn.addEventListener("click", function () {
	  if (sform.style.visibility == "hidden") {
	    sform.style.visibility = "visible";
	  } else {
	    sform.style.visibility = "hidden";
	  }
	});
	
