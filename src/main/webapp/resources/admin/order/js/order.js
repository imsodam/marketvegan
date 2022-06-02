/**
 * 
 */

 $(function(){
		//전체선택 클릭시 
	$('#checkAll').click(function(){
		if($("#checkAll").is(":checked")) {
			$("input[name=checkItem]").prop("checked", true);
		}
		else{
			$("input[name=checkItem]").prop("checked", false);
		}
		
	})
	//장바구니 아이템 모두 선택되면 전체선택 체크됨
	$('input[name=checkItem]').click(function(){
		var total = $('input[name=checkItem]').length;
		var checked = $('input[name=checkItem]:checked').length;
		if(total==checked) $('#checkAll').prop("checked",true);
		else $('#checkAll').prop("checked",false);
	})
	
	
	//numberOnly인풋박스 숫자만 입력가능
	 $("input:text[numberOnly]").on("keyup", function() {
	    $(this).val($(this).val().replace(/[^0-9]/g,""));
	  });


	//주문목록페이지 검색
	$('#listSearch').click(function(){
		if($('#sDay').val()>$('#eDay').val()){
			alert("날짜를 확인해주세요");
			return false;
		}
		$('#searchForm').submit();
	})
	
	//주문상태 변경
	$('.change_state').change(function(){
		var order_state=$(this).parent().attr('class');
		var change_state=$(this).val()
		var order_num=$(this).parent().parent().attr('id');
		var invoice=$(this).parent().next().children().first().val();
		console.log("order_state->"+order_state);
		console.log("change_state->"+change_state);
		console.log("order_num->"+order_num);
		//주문완료 상태로는 변경불가
		if(change_state=='ordr_c'){
			alert('변경할 수 없습니다.');
			location.reload();
			return false; 
		}
		//주문완료 상태에서는 취소외 기능은 불가
		if((order_state=='ordr_c') && (change_state!='cncl_a' &&change_state!='cncl_c' )){
			alert('결제를 하지않아 처리 불가능합니다.');
			location.reload();
			return false;
		}
		//취소완료건은 변경불가
		if(order_state=='cncl_c') {
			alert('취소처리된 주문 입니다.');
			return false;
		}
		//배송준비중은 송장번호 입력으로 처리할것
		if(change_state=='dlvr_r' && invoice==''){
			alert('송장번호를 입력해주세요');
			location.reload();
			return false;
		}
		//배송중,배송완료는 송장번호 없을때 처리불가
		if((change_state=='dlvr_p' || change_state=='dlvr_c') && invoice==''){
			alert('송장번호 입력후 처리가능합니다.');
			location.reload();
			return false;
		}
		//배송준비중에서 배송중,배송완료만 가능
		if((order_state=='dlvr_r') && (change_state!='dlvr_p' &&change_state!='dlvr_c' )){
			alert('배송진행중입니다. 처리 불가능합니다.');
			location.reload();
			return false;
		}
		//배송중에는 배송완료만 가능
		if((order_state=='dlvr_p') && change_state!='dlvr_c' ){
			alert('배송중입니다. 처리 불가능합니다.');
			location.reload();
			return false;
		}
		//배송완료-아무처리 불가능
		if((order_state=='dlvr_c')){
			alert('배송이 완로되었습니다. 처리 불가능합니다.');
			location.reload();
			return false;
		}
		
		//변경처리
		if(confirm("변경하시겠습니까?")){
			if(change_state=='cncl_a' || change_state=='cncl_c'){
				location.href="/marketvegan2/admin/orderCancel.do?order_num="+order_num+"&change_state="+change_state+"&order_state="+order_state;
			}else{
				location.href="/marketvegan2/admin/changeState.do?order_num="+order_num+"&change_state="+change_state;
			}
		}else{
			location.reload();
			return false;
		}
	})
	//취소 주문은 송장번호 입력 불가
	$('.cncl_a').next().children().attr("disabled", true);
	$('.cncl_p').next().children().attr("disabled", true);
	$('.cncl_c').next().children().attr("disabled", true);
	
	
	//송장번호 입력
	$('.insertInvoice').click(function(){
		var invoice=$(this).prev().val();
		var order_num=$(this).parent().parent().attr('id');
		var order_state=$(this).parent().prev().attr('class')
		var change_state='dlvr_r';
		if(order_state=='ordr_c'){
			alert('결제를 하지않아 처리 불가능합니다.');
			return false;
		}
		if(order_state=='cncl_a' || order_state=='cncl_p' || order_state=='cncl_c') {
			alert('취소처리된 주문 입니다.');
			return false;
		}
		if(invoice.length!=12) {
			alert('송장번호를 12자리 입력해주세요.');
			return false;
		}
		//alert( invoice+","+order_num)
		location.href="/marketvegan2/admin/changeState.do?order_num="+order_num+"&invoice="+invoice+"&change_state="+change_state;
	})
	
	//주소변경 버튼
	$('#updateSubmit').click(function(){
		if(confirm("변경하시겠습니까?")){
			$('#addressForm').submit();
		}else{
			return false;
		}
	})
})
