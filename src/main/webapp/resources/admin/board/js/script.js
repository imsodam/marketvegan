 $(function(){
	
	//submit
	$('#boardSubmit').on("click",function(){
		console.log('클릭됨')
		if($('#board_title').val()==''){
			alert('제목을 입력해주세요.');
			$('#board_title').focus();
			return false;
		}
		if($('#board_content').val()==''){
			alert('내용을 입력해주세요.');
			$('#board_content').focus();
			return false;
		}
		console.log('유효체크완료');
		$('#boardForm').submit();
		console.log('서브밋완료');
		
	})
	
	//삭제
	$('#boardDelete').on("click",function(){
		if(confirm('삭제하시겠습니까?')){
			var board_num=$(this).data('num');
			var board_group=$(this).data('group');
			//console.log(board_group)
			location.href="/marketvegan2/admin/deleteBoard.do?board_num="+board_num+"&board_group="+board_group;
		}else{
			return false;
		}
	})
	
	
})
