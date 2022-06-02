$(document).ready(function() {
  
    //2depth 열기/닫기
    $('ul.dropdownmenu').hover(
       function() { 
          $('ul.dropdownmenu li.menu ul').fadeIn('normal',function(){$(this).stop();}); //모든 서브를 다 열어라
          $('#headerArea').animate({height:450},'fast').clearQueue();
       },function() {
          $('ul.dropdownmenu li.menu ul').fadeOut('fast'); //모든 서브를 다 닫아라
          $('#headerArea').animate({height:240},'normal').clearQueue();
     });

     //좌우슬라이딩
     setInterval(function(){ 
         $('.gallery>ul').delay(2500); 
         $('.gallery>ul').animate({marginLeft: "-1920px"}) 
         $('.gallery>ul').delay(2500); 
         $('.gallery>ul').animate({marginLeft: "-3840px"}) 
         $('.gallery>ul').delay(2500); 
         $('.gallery>ul').animate({marginLeft: "0px"}) 
        });

});