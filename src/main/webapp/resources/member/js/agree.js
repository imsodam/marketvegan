$(document).ready(function() {

	//전체선택,해제
	$("#allcheck").click(function() {
		if ($("#allcheck").is(":checked")) $("input[type=checkbox]").prop("checked", true);
		else $("input[type=checkbox]").prop("checked", false);
	});


	$("input[name=agree]").click(function() {
		var total = $("input[name=agree]").length;
		var checked = $("input[name=agree]:checked").length;

		if (total != checked) $("#allcheck").prop("checked", false);
		else $("#allcheck").prop("checked", true);
	});

	//이용약관 전체 선택시 다음페이지로 이동
	$('.check_agree').on('click', check_agree);
	function check_agree(e) {
		var checkboxLength = $('input[name="agree"]').length; //checkbox 총 개수 
		var checkedLength = $('input[name="agree"]:checked').length; //실제로 체크되어있는 개수

		if (checkboxLength != checkedLength) {
			alert("이용약관에 동의해야 가입하실 수 있습니다.");
			e.preventDefault();
		} else {  //모두 체크 되었으면 회원가입 창으로 이동
			location.href = "/marketvegan2/join.do";
		}
	}
	
	//up버튼
	$(window).scroll(function() {
		// top button controll
		if ($(this).scrollTop() > 500) {
			$('#topButton').fadeIn();
		} else {
			$('#topButton').fadeOut();
		}
	});

	$("#topButtonImg").click(function() {
		$('html, body').animate({ scrollTop: 0 }, '300');
	});
});

//취소버튼 누르면 전페이지로 이동
function join_cancel() {
	history.go(-1);
}