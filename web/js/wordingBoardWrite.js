$(function() {
	$("#picDarkness").on('input',function(e) {
		console.log($(this).val());
		$(".imgAndText").children('img').css("filter","brightness("+$(this).val()+"%)");
	});
	
	$("#wordingText").keyup(function(e) {
		console.log($(this).val());
		$(".img-text").children().html($(this).val());
	});
	
	$("#textSize").on('input',function(e) {
		console.log($(this).val());
		$(".img-text").css("font-size",$(this).val()+"px");
	});
	$("#textX").on('input', function(e) {
		console.log($(this).val());
		$(".img-text").css("left",$(this).val()+"%");
	});
	$("#textY").on('input', function(e) {
		console.log($(this).val());
		$(".img-text").css("top",$(this).val()+"%");
	});
	$("#textColor").on('input', function(e) {
		console.log($(this).val());
		$(".img-text").css("color",$(this).val());
	});
	
	
})
	