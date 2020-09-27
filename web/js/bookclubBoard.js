$(function() {
	
	
    $(".bookClubImg img").hover(function(){
        $(this).css('filter','brightness(20%)');
        $(this).parent().next().css('display','inline-block');
        $(this).closest(".bookClub").find(".clubTitle").css('display','inline-block');


    }, function(){
        $(this).css('filter','brightness(100%)');
        $(this).parent().next().css('display','none');
        $(this).closest(".bookClub").find(".clubTitle").css('display','inline-block');
    });
    
    $(".bookClubInfo").hover(function(){
       $(this).prev().children().css('filter','brightness(20%)');
        $(this).css('display','inline-block');
        $(this).closest(".bookClub").find(".clubTitle").css('display','inline-block');

    }, function(){
        $(this).prev().children().css('filter','brightness(100%)');
        $(this).css('display','none');
        $(this).closest(".bookClub").find(".clubTitle").css('display','inline-block');
    });
    
    
    
    
    
})