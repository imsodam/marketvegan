/**
 * 
 */
 //3자리 콤마
Number.prototype.comma = function() {
        return this.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
    };
//콤마 제거
String.prototype.unComma = function(){
	var str = this.replace(/,/g,'');
	var num = parseFloat(str);
	if( isNaN(num) ) {
		return "0";
	}
	return String(num);
}
//폰번호 하이픈 추가
String.prototype.addHyphen = function(){
	return this.replace(/(^02.{0}|^01.{1}|[0-9]{3})([0-9]+)([0-9]{4})/,"$1-$2-$3");
}



$(function(){
	
	
	
	//장바구니 담기
		$('.go_cart2').click(function(){
			var popX= (document.body.offsetWidth / 2) - (400 / 2);
			var popY= (window.screen.height / 2) - (150 / 2);
			popX += window.screenLeft;
			var product_code=$(this).parent().attr('id');
			var count=1;
			window.open("/marketvegan2/goCart.do?product_code="+product_code+"&count="+count,"go_cart","top="+popY+",left="+popX+",width=400,height=150");
		})
		
	
	//장바구니 페이지 로드시 상품유무에 따른 화면
	if($('.cart_item>li').length>0){
		$('.no_cart').css("display","none");
	}else{
		$('.no_cart').css("display","block");
		$('#checkAll').attr("disabled",true);
		$('#goOrder').addClass("disabled");
		$('#goOrder').removeClass("goOrder");
		$('#goOrder').val("상품을 담아주세요.");
		
	}
	
	//장바구니 페이지 로드시 전체 선택
	if($('input[name=checkItem]').length){
		$("#checkAll").prop("checked", true);
		$("input[name=checkItem]").prop("checked", true);
	}
	//전체선택 클릭시 아이템 모두 선택
	$('#checkAll').click(function(){
		if($("#checkAll").is(":checked")) {
			$("input[name=checkItem]").prop("checked", true);
		}
		else{
			$("input[name=checkItem]").prop("checked", false);
		}
		resetQuick();
		
	})
	//장바구니 아이템 모두 선택되면 전체선택 체크됨
	$('input[name=checkItem]').click(function(){
		var total = $('input[name=checkItem]').length;
		var checked = $('input[name=checkItem]:checked').length;
		if(total==checked) $('#checkAll').prop("checked",true);
		else $('#checkAll').prop("checked",false);
		resetQuick();
	})
	//장바구니 상단 아이템 체크수 표시
	$('input[type=checkbox]').click(function(){
		var checked = $('input[name=checkItem]:checked').length;
		$('.checkedCount').text(checked);
		//console.log('체크수'+checked);
	})
	
	//장바구니 수량 플러스
	$('.item_count>.plus').click(function(){
		var cart_num = $(this).parent().parent().attr('id');
		$.ajax({
			url:"/marketvegan2/opCount.do",
			type:"post",
			data:{cart_num:cart_num,operations:"plus"},
			success:function(cart_count){
					resetCart(cart_num,cart_count);
					resetQuick();
			},
			error: function(){
				alert("서버요청실패");
			}
		})
	});
	//수량 마이너스
	$('.item_count>.minus').click(function(){
		var cart_num = $(this).parent().parent().attr('id');
		var count = $(this).next().val();
		if(count>1){
			$.ajax({
				url:"/marketvegan2/opCount.do",
				type:"post",
				data:{cart_num:cart_num,operations:"minus"},
				success:function(cart_count){
					resetCart(cart_num,cart_count);
					resetQuick();
				},
				error: function(){
					alert("서버요청실패");
				}
			})
		}
	});
	
	//수량 변경에 따른 장바구니 리셋
	function resetCart(cart_num,cart_count){
		$('#'+cart_num+'count').val(cart_count);
		var price=$('#'+cart_num+'count').next().next().val() * cart_count;
		$('#'+cart_num+'>.item_price>span').text(price.comma());
	}
	//퀵메뉴 가격 구하기
	function resetQuick(){
		//var item=$('.item_price>span');
		var item=$('.cart_item input[name=checkItem]:checked').parent().next().next().next().next().children('span');
		var delivery=$('.cart_item input[name=checkItem]:checked').parent().parent().children('input');
		var dlv_price=2500;
		var sum=0;
		for(var i=0; i<item.length;i++){
		sum += Number(item.eq(i).text().unComma());
		if(delivery.eq(i).val()==0) dlv_price=0;
		}
		if(item.length==0) dlv_price=0;
		$('#prd_price').text(sum.comma());
		$('#dlv_price').text(dlv_price.comma());
		$('#tot_price').text((sum+dlv_price).comma());
	}
	
	//장바구니 삭제
	$('.item_delete>button').click(function(){
		if(confirm('삭제 하시겠습니까?')){
			var cart_num = $(this).parent().parent().attr('id');
			//alert(cart_num)
			$.ajax({
				url:"/marketvegan2/delCart.do",
				type:"post",
				data:{cart_num:cart_num},
				success:function(){
					$('#'+cart_num).remove();//노드제거
					resetQuick();//퀵메뉴 리셋
					var checked = $('input[name=checkItem]:checked').length;
					//console.log('체크수->'+ checked)
					$('.checkedCount').text(checked);//체크수 업뎃
					$('.allCount').text($('.cart_item>li').length);//총 상품수
					
					var total = $('input[name=checkItem]').length;
					var checked = $('input[name=checkItem]:checked').length;
					if(total==checked) $('#checkAll').prop("checked",true);
					else $('#checkAll').prop("checked",false);
					
					if(checked<1) $('#checkAll').prop("checked",false);//체크된 상품 없으면 전체선택 체크 해제
					
					
					if($('.cart_item>li').length>0){
						$('.no_cart').css("display","none");
					}else{//장구니 비면 
						$('.no_cart').css("display","block");
						$('#checkAll').attr("disabled",true);
						$('#goOrder').addClass("disabled");
						$('#goOrder').removeClass("goOrder");
						$('#goOrder').val("상품을 담아주세요.");
					}
				},
				error: function(){
					alert("서버요청실패");
				}
			})
		}else{
			return false;
		}
	});
	
	//cart->order submit
	$('.goOrder').click(function(){
		if($("input:checkbox[name=checkItem]:checked").length<1){
			alert("주문하실 상품을 1개이상 선택해주세요.");
			return false;
		}
		$('#cartForm').submit();
	})
	
	//결제수단 디폴트 선택
	$('.pay_type li').first().addClass("on");
	
	//결제수단 탭메뉴
	$('.pay_type li').click(function(){
		var idx = $(this).index();
		$('.pay_type li').removeClass('on');
		$('.pay_type li').eq(idx).addClass("on");
		$('.pay_content > div').hide();
		$('.pay_content > div').eq(idx).show();
		$('#payment_type').val($(this).attr('id'));
	})
	//배송지변경
	
	

	//order->order_end submit
	$('#orderEnd').click(function(){
		if($('#payment_type').val() != "card") {
			$('#card_type').val("");
			$('#card_month').val("");
		}
		if($("input:checkbox[name=private_agree]:checked").length<1){
			alert("결제 진행 필수 동의를 체크해주세요");
			return false;
		}
		$('#orderForm').submit();
	})
	
	//주문취소 체크 확인
	$('#orderCancel').click(function(){
		if($('input:radio[name=cancel_type]:checked').length<1){
			alert("취소 사유를 선택해주세요.");
			return false;
		}
		if($("input:checkbox[name=agree]:checked").length<1){
			alert("[주문취소 내역 동의합니다]를 체크해주세요");
			return false;
		}
		$('#cancelForm').submit();

	})
	

	
	//주문리스트 년도 검색
	$('#dateSearch').click(function(){
		if($('#sDay').val()>$('#eDay').val()){
			alert("날짜를 확인해주세요");
			return false;
		}
		$('#dateForm').submit();
	})
	
	//배송지변경
	$('#updateAddr').click(function(){
		if($(this).text()=='배송지 변경'){
			$('.curr_addr').css('display','none');
			$('.chan_addr').css('display','inline-block');
			$(this).text('변경 완료');
		}else{
			$('.curr_addr').css('display','inline-block');
			$('.chan_addr').css('display','none');
			$(this).text('배송지 변경');
			if(confirm("변경하시겠습니까")){
				$('#addressForm').submit();
			}else{
				return false;
			}
		}
		
	})
})


