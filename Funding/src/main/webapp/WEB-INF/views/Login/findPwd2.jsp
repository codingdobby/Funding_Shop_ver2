<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>

<link href="https://fonts.googleapis.com/css?family=Do Hyeon"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/pwd.css"
	type="text/css">
<style type="text/css">
input[type="password"] {
	width: 100%;
}

input[type="text"] {
	width: 100%;
	height: 100%;
}

input[type="submit"] {
	width: 100%;
	display: block;
	box-sizing: border-box;
	background-color: #FF6F61;
	padding: 10px;
	border: 1px solid #eeeeee;
	border-radius: 3px;
	font-family: 'Do Hyeon', sans-serif;
	font-size: 100%;
	outline: none;
	color: #FFFFFF;
}

input[type="submit"]:hover, /*foucs는 탭으로 갔을때*/ input[type="submit"]:focus
	{
	border: 2px solid black;
	box-shadow: inset 2px 2px 2px rgba(0, 0, 0, .13)
}

.findPWD {
	border: 1px solid black;
	width: 500px;
	padding: 30px;
}
</style>

<script src="https://code.jquery.com/jquery-latest.js"></script>
<script>
window.onload = function() {
	document.getElementById("send").onclick = chkData;

}
	function chkData() {
		if (document.iform.pwd.value == "") { //isNaN에 의해서 숫자는 처리 불가
			iform.pwd.focus(); //request는 생략 가능(java)
			alert("비밀번호를 입력하세요");
			return false;
		}

		if (iform.pwd.value.length < 8 || iform.pwd.value.length > 20) {
			alert("비밀번호는 8~20자 이내로 입력 가능합니다!");
			iform.pwd.focus();//입력한 문자를 선택 상태로 만듬.
			return false;
		}
		if (iform.pwd.value != iform.pwd2.value) {
			iform.pwd2.focus();
			alert("비밀번호가 일치하지 않습니다.");
			return false;

		}
	}
</script>

</head>
<body>
	<jsp:include page="/WEB-INF/views/FirstPage/header.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/views/FirstPage/nav.jsp"></jsp:include>


	<form action="update_pwd.do" method="post" name="iform"
		onsubmit="return check()">
		<div align="center">
			<div class="findPWD">
				<table>

					<tr>
						<th colspan="2">비밀번호 재설정</th>
					</tr>

					<tr>
						<td>비밀번호 입력</td>

						<td><input type="text" name="pwd"></td>
					</tr>
					<tr>
						<td>비밀번호 확인</td>
						<td><input type="text" name="pwd2"></td>
					</tr>

					<tr>

						<td colspan="2"><input type="submit" value="확인" id="send"></td>



					</tr>

				</table>

			</div>
		</div>

	</form>

	<jsp:include page="/WEB-INF/views/FirstPage/footer.jsp"></jsp:include>
</body>
</html>