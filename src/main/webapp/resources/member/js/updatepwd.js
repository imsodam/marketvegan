function pwdCheck(){
	if(document.form.user_pwd.value==""){
		alert("비밀번호를 입력해 주세요.");
		document.form.user_pwd.focus();
		return;
	}
	document.form.submit();
}
