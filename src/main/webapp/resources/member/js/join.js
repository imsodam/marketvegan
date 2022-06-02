//회원가입 cancle버튼
function join_cancel() {
	location.href='/marketvegan/';
}

$(function() {
	//각 항목 유효체크 변수
	var is_id = $('#user_id').val() == '' ? false : true;
	var is_password = $('#user_pwd').val() == '' ? false : true;
	var is_username = $('#user_name').val() == '' ? false : true;
	var is_email = $('#user_email').val() == '' ? false : true;
	var is_phone = $('#user_phone').val() == '' ? false : true;
	var chk_id = false;
	var chk_email = false;

	//아이디 유효체크
	$('#user_id').on("input", function() {
		var user_id = $('#user_id').val();
		if (RegExp(/^[A-Za-z0-9_\-]{6,20}$/).test(user_id)) {//아이디 유효하면 중복체크
			//du_check();
			$('#check_id').html('6자 이상의 영문 혹은 영문과 숫자를 조합');
			$('#check_id').removeClass('bad');
			$('#check_id').addClass('good');
			is_id = true;
			if (!chk_id) {
				$('#check_id2').html('아이디 중복체크를 해주세요');
				$('#check_id2').removeClass('good');
				$('#check_id2').addClass('bad');
			}
		} else {
			$('#check_id').html('6자 이상의 영문 혹은 영문과 숫자를 조합');
			$('#check_id').removeClass('good');
			$('#check_id').addClass('bad');
			is_id = false;
		}
	})

	//아이디 중복확인
	$('#chk_id').on("click", function() {
		chk_id = true;
		if (is_id == true) {
			var user_id = $('#user_id').val();
			$.ajax({
				url: "/marketvegan2/idCheck.do",
				type: "post",
				data: { user_id: user_id },
				dataType: 'json',
				success: function(result) { //result 성공여부
					if (result == "1") { //같은 아이디 존재
						$('#check_id2').html('이미 사용중인 아이디입니다');
						$('#check_id2').removeClass('good');
						$('#check_id2').addClass('bad');
					} else {
						$('#check_id2').html('아이디를 사용할 수 있습니다');
						$('#check_id2').removeClass('bad');
						$('#check_id2').addClass('good');
					}
					$('#user_id').on("click", function() {
						chk_id = false;
					})
				},
				error: function() {
					alert("서버요청실패");
				}
			}) //ajax
		} else {
			alert('6자 이상의 영문 혹은 영문과 숫자를 조합하여 입력한 후 중복체크를 해주세요');
			chk_id = false;
			$('#check_id2').html('아이디 중복체크를 해주세요');
			$('#check_id2').removeClass('good');
			$('#check_id2').addClass('bad');
		}
	})

	//비밀번호 유효 체크
	$('#user_pwd').on("input", function() {
		var user_pwd = $('#user_pwd').val();
		if (RegExp(/^(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^*()\-_=+\\\|\[\]{};:\'",.<>\/?]).{8,20}$/).test(user_pwd)) { //비밀번호 유효하면 같은지 체크
			$('#check_pwd').html('비밀번호는 8자이상 영문, 숫자, 특수문자로 구성');
			$('#check_pwd').removeClass('bad');
			$('#check_pwd').addClass('good');
			is_password = true;
		} else {
			$('#check_pwd').html('비밀번호는 8자이상 영문, 숫자, 특수문자로 구성');
			$('#check_pwd').removeClass('good');
			$('#check_pwd').addClass('bad');
			is_password = false;
		}
	})

	//비밀번호 같은지 체크
	$('#user_repwd').on("input", function() {
		var user_pwd = $('#user_pwd').val();
		var user_repwd = $('#user_repwd').val();
		if (user_pwd == user_repwd) { //비밀번호 유효하면 같은지 체크
			$('#check_repwd').html('비밀번호가 같습니다');
			$('#check_repwd').removeClass('bad');
			$('#check_repwd').addClass('good');
			is_password = true;
		} else {
			$('#check_repwd').html('비밀번호가 다릅니다');
			$('#check_repwd').removeClass('good');
			$('#check_repwd').addClass('bad');
			is_password = false;
		}
	})

	//이름 유효 체크
	$('#user_name').on("input", function() {
		$('.txt_guide').css("display", "block");
		if (RegExp(/^[가-힣]{2,6}$/).test($('#user_name').val())) {
			$('#check_username').html('이름 입력이 올바르게 되었습니다');
			$('#check_username').removeClass('bad');
			$('#check_username').addClass('good');
			is_username = true;
		} else {
			$('#check_username').html('이름을 정확하게 입력하세요');
			$('#check_username').removeClass('good');
			$('#check_username').addClass('bad');
			is_username = false;
		}
	})

	//이메일 유효 체크
	$('#user_email').on("input", function() {
		if (RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/).test($('#user_email').val())) {
			$('#check_email').html('메일주소가 유효합니다');
			$('#check_email').removeClass('bad');
			$('#check_email').addClass('good');
			is_email = true;
			if (!chk_email) {
				$('#check_email2').html('이메일 중복체크를 해주세요');
				$('#check_email2').removeClass('good');
				$('#check_email2').addClass('bad');
			}
		} else {
			$('#check_email').html('메일주소가 유효하지 않습니다');
			$('#check_email').removeClass('good');
			$('#check_email').addClass('bad');
			is_email = false
		}
	})

	//이메일 중복확인
	$('#chk_email').on("click", function() {
		chk_email = true;
		if (is_email == true) {
			var user_email = $('#user_email').val();
			$.ajax({
				url: "/marketvegan2/emailCheck.do",
				type: "post",
				data: { user_email: user_email },
				dataType: 'json',
				success: function(result) { //result 성공여부
					if (result == "1") { //같은 아이디 존재
						$('#check_email2').html('이미 사용중인 이메일입니다');
						$('#check_email2').removeClass('good');
						$('#check_eamil2').addClass('bad');
					} else {
						$('#check_email2').html('사용가능 한 이메일입니다');
						$('#check_email2').removeClass('bad');
						$('#check_email2').addClass('good');
					}
					$('#user_email').on("click", function() {
						chk_email = false;
					})
				},
				error: function() {
					alert("서버요청실패");
				}
			}) //ajax
		}else{
			alert('이메일을 입력 후 중복체크를 해주세요');
			chk_email = false;
			$('#check_email2').html('이메일 중복체크를 해주세요');
			$('#check_email2').removeClass('good');
			$('#check_email2').addClass('bad');
		}
})

	//폰번호 - 입력안되게
	$('#user_phone').keypress(function() {
		if (event.keyCode < 48 || event.keyCode > 57) {
			event.returnValue = false;
		}
	})
	//폰번호 유효 체크
	$('#user_phone').on("input", function() {
		number = $('#user_phone').val().replace(/[^0-9]/g, "");
		$('#user_phone').val(number);//폰번호 - 없애기
		if (RegExp(/^01[0179][0-9]{7,8}$/).test(number)) {
			$('#check_phone').html('핸드폰번호가 올바르게 입력되었습니다');
			$('#check_phone').removeClass('bad');
			$('#check_phone').addClass('good');
			is_phone = true;
		} else {
			$('#check_phone').html('핸드폰번호를 정확하게 입력하세요');
			$('#check_phone').removeClass('good');
			$('#check_phone').addClass('bad');
			is_phone = false;
		}
	})

	//회원가입 submit
	$('#btn_join').on("click", function() {
		if ($('#user_id').val() == '' | !is_id) {
			alert("아이디를 확인해주세요.");
			$('#user_id').focus();
			return false;
		}
		if ($('#user_pwd').val() == '' | $('#user_pwd').val() == '' | !is_password) {
			alert("비밀번호를 확인해주세요.");
			$('#user_pwd').focus();
			return false;
		}
		if ($('#user_name').val() == '' | !is_username) {
			alert("이름을 확인해주세요.");
			$('#user_name').focus();
			return false;
		}
		if ($('#user_phone').val() == '' | !is_phone) {
			alert("핸드폰번호를 확인해주세요.");
			$('#user_phone').focus();
			return false;
		}
		if ($('#user_email').val() ==  '' | !is_email) {
			alert("메일주소를 확인해주세요.");
			$('#user_email').focus();
			return false;
		}
		
		if ($('#zipcode').val() ==  '') {
			alert("우편번호를 입력해주세요.");
			$('#zipcode').focus();
			return false;
		}
		
		if ($('#addr1').val() ==  '') {
			alert("주소를 입력해주세요.");
			$('#addr1').focus();
			return false;
		}
		
		if (!chk_id) {
			alert("아이디 중복체크를 해주세요");
			return false;
		}

		if (!chk_email) {
			alert("이메일 중복체크를 해주세요");
			return false;
		}

		$("#joinForm").submit();
	})

})//전체

