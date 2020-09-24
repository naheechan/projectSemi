/*$(function(){
	console.log("dd");

	let s = "";
	
	$(".wordingArticleImg").children("img").each(function(index,item){
		console.log($(item).attr("alt"));
	
		'for(WordingPic pic : listPic) {'
			'if(w.getWordingNo()==pic.getWordingNo()) {'
					s = "'<%=request.getContextPath()%>/image/wordingBoard/<%=pic.getWordingPicName()%>'";
					$(".wordingArticleImg").children("img").each(function(index, item){
						console.log(s);
						console.log($(item));
						$(item).attr("src",s);
						
					})
				'break;'
			'}'
		'}'
	
	});

<%for(WordingPic pic : listPic) {
	if(w.getWordingNo()==pic.getWordingNo()) {%>
			s = "<%=request.getContextPath()%>/image/wordingBoard/<%=pic.getWordingPicName()%>";
			$(".wordingArticleImg").children("img").each(function(index, item){
				console.log(s);
				console.log($(item));
				$(item).attr("src",s);
				
			})
		<%break;
	}
}%>
})*/