
$(function() {

	// 휴대폰으로 찾기, 아이디로 찾기 선택
	$('.id_certification > button').first().addClass('on');
	$('#toggle > .email_search').hide();
	$('.id_certification > button').click(function() {
		var idx = $(this).index();
		$('.id_certification > button').removeClass('on');
		$('.id_certification > button').eq(idx).addClass('on');
		$('#toggle > div').hide();
		$('#toggle > div').eq(idx).show();
		$('#user_name').val('');
		
		console.log(idx)
		if(idx==1){
			$('#user_phone').val('');
		}
		if(idx==0){
			$('#user_email').val('');
		}
	})
	
	$('#find_id1').on("click",function(){
		if(($('#user_name').val()!='' && $('#user_phone').val()!='') || ($('#user_name').val()!='' && $('#user_email').val()!='')){
			$('#idSearchForm').submit();
		}else{
			alert('입력해주세요');
		}
	})
	
})