/**
 * 
 */

function checkValues(htmlForm) {
	let url = "boardwrite?";

	const title = document.getElementById("title").value;
	const main = document.getElementById("main").value;

	let check = true;

	if (title !== "") { url += "&title=" + title; }
	if (main !== "") { url += "&main=" + main; }

	if (title === "") {
		alert('제목을 입력해주세요');
		check = false;
	} else if (main === "") {
		alert('본문을 입력해주세요');
		check = false;
	}

	if (check === false) {
		location.href = url;
	}
	else {
		htmlForm.submit();
	}

}