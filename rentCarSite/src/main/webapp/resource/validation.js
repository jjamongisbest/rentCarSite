/**
 * 
 */

function checkValues(htmlForm) {
	let url = "regist?";

	const userid = document.getElementById("userid").value;
	const name = document.getElementById("name").value;
	const phone = document.getElementById("phone").value;
	const password = document.getElementById("password").value;
	const signdate = document.getElementById("signdate").value;
	const email = document.getElementById("email").value;

	let check = true;

	if (userid !== "") { url += "&userid=" + userid; }
	if (name !== "") { url += "&name=" + name; }
	if (phone !== "") { url += "&phone=" + phone; }
	if (password !== "") { url += "&password=" + password; }
	if (signdate !== "") { url += "&signdate=" + signdate; }
	if (email !== "") { url += "&email=" + email; }

	if(userid === ""){
		alert('아이디가 입력되지 않았습니다.');
		check = false;		
	}
	else if(name === ""){
		alert('회원 성명이 입력되지 않았습니다.');
		check = false;
	}
	else if(phone === ""){
		alert('전화번호가 입력되지 않았습니다.');
		check = false;
	}
	else if(password === ""){
		alert('비밀번호가 입력되지 않았습니다.');
		check = false;
	}
	else if(email === ""){
		alert('이메일이 입력되지 않았습니다.');
		check = false;
	}
	
	if(check === false){
		location.href=url;
	}
	else{
		htmlForm.submit();
	}
	

}