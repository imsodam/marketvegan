

/* 상품수량, 가격  */
let basket = {
    totalCount: 0, 
    totalPrice: 0,
    //체크한 장바구니 상품 비우기
    delCheckedItem: function(){
        document.querySelectorAll("input[name=buy]:checked").forEach(function (item) {
            item.parentElement.parentElement.parentElement.remove();
        });
        //AJAX 서버 업데이트 전송
    
        //전송 처리 결과가 성공이면
        this.reCalc();
        this.updateUI();
    },
    //장바구니 전체 비우기
    delAllItem: function(){
        document.querySelectorAll('.row.data').forEach(function (item) {
            item.remove();
          });
          //AJAX 서버 업데이트 전송
        
          //전송 처리 결과가 성공이면
          this.totalCount = 0;
          this.totalPrice = 0;
          this.reCalc();
          this.updateUI();
    },
    //재계산
    reCalc: function(){
        this.totalCount = 0;
        this.totalPrice = 0;
        document.querySelectorAll(".p_num").forEach(function (item) {
            if(item.parentElement.parentElement.parentElement.previousElementSibling.firstElementChild.firstElementChild.checked == true){
                var count = parseInt(item.getAttribute('value'));
                this.totalCount += count;
                var price = item.parentElement.parentElement.previousElementSibling.firstElementChild.getAttribute('value');
                this.totalPrice += count * price;
            }
        }, this); // forEach 2번째 파라메터로 객체를 넘겨서 this 가 객체리터럴을 가리키도록 함. - thisArg
    },
    //화면 업데이트
  	 updateUI: function () {
        document.querySelector('#sum_p_num').textContent = '상품갯수: ' + this.totalCount.formatNumber() + '개';
        document.querySelector('#sum_p_price').textContent = '합계금액: ' + this.totalPrice.formatNumber() + '원';
    },
    //개별 수량 변경
    changePNum: function (pos) {
        var item = document.querySelector('input[name=p_num'+pos+']');
        var p_num = parseInt(item.getAttribute('value'));
        var newval = event.target.classList.contains('up') ? p_num+1 : event.target.classList.contains('down') ? p_num-1 : event.target.value;
        
        if (parseInt(newval) < 1 || parseInt(newval) > 99) { return false; }

        item.setAttribute('value', newval);
        item.value = newval;

        var price = item.parentElement.parentElement.previousElementSibling.firstElementChild.getAttribute('value');
        item.parentElement.parentElement.nextElementSibling.textContent = (newval * price).formatNumber()+"원";
        //AJAX 업데이트 전송

        
        //전송 처리 결과가 성공이면    
        this.reCalc();
        this.updateUI();
    },
    checkItem: function () {
        this.reCalc();
        this.updateUI();
    },
    delItem: function () {
        event.target.parentElement.parentElement.parentElement.remove();
        this.reCalc();
        this.updateUI();
    }
}


// 숫자 3자리 콤마찍기
/*Number.prototype.formatNumber = function(){
    if(this==0) return 0;
    let regex = /(^[+-]?\d+)(\d{3})/;
    let nstr = (this + '');
    while (regex.test(nstr)) nstr = nstr.replace(regex, '$1' + ',' + '$2');
    return nstr;
};
*/

//상품등록 
 function productSubmit(){
 	
	if(document.productForm.product_name.value==""){
		alert("상품명을 입력하세요.");
		document.productForm.product_name.focus();
		return; //return false;
	}
	if(document.productForm.product_content.value==""){
		alert("상품설명을 입력하세요.");
		document.productForm.product_content.focus();
		return; //return false;
	}
	if(document.productForm.product_price.value==""){
		alert("상품가격을 입력하세요.");
		document.productForm.product_price.focus();
		return; //return false;
	}
	if(document.productForm.product_delivery_charge.value==""){
		alert("배송비를 입력하세요.");
		document.productForm.product_delivery_charge.focus();
		return; //return false;
	}
	if(document.productForm.product_discount.value==""){
		alert("할인율을 입력하세요.");
		document.productForm.product_discount.focus();
		return; //return false;
	}
	var url=window.location.href;
	console.log(url)
if(url.indexOf('product_code')<0){
	//신규등록
	if(document.productForm.product_img1.value==""){
		alert("이미지를 선택하세요.");
		document.productForm.product_img1.focus();
		return; //return false;
	}
	if(document.productForm.product_img2.value==""){
		alert("이미지를 선택하세요.");
		document.productForm.product_img2.focus();
		return; //return false;
	}
	if(document.productForm.product_img3.value==""){
		alert("이미지를 선택하세요.");
		document.productForm.product_img3.focus();
		return; //return false;
	}
	if(document.productForm.product_img4.value==""){
		alert("이미지를 선택하세요.");
		document.productForm.product_img4.focus();
		return; 
		//return false;
	}
}
	$('#productForm').submit();
}

 
 	
 