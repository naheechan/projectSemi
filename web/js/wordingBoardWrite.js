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
	
	
	
	$("#wordingPic").change(function(){
		console.log(this.files);

		for(let i=0; i<this.files.length; i++) {
			if(this.files[i].type.includes("image")) {
				let reader = new FileReader();
				reader.onload = function(e) {
					$(".backPicTd").css("background-color","white");
					let img = $("<img>").attr({"src":e.target.result,"width":"600px","height":"400px"});
					$(".imgAndText").children('img').remove();
					$(".imgAndText").prepend(img);
				}
				reader.readAsDataURL(this.files[i]);
			}
		}
	});
		
	
})
	