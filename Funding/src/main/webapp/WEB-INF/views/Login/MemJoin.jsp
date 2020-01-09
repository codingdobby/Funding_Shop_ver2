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
	href="${pageContext.request.contextPath}/resources/css/test.css"
	type="text/css">


<script type="text/javascript">
	function ok() {
		alert("회원가입 완료");

	}
</script>

<script
	src="${pageContext.request.contextPath}/resources/js/JoinCheck.js"></script>



</head>
<body>

	<jsp:include page="/WEB-INF/views/FirstPage/header.jsp"></jsp:include>

	<div id="insert" align="center">
		<form name="iform" method="post">

			<table border="1">
				<tr>
					<td>이름</td>
				</tr>
				<tr>

					<td><input type="text" placeholder="사용하실 닉네임을 입력하세요"
						name="nickname" id="userId"></td>

				</tr>
				<tr>
					<td>아이디</td>

				</tr>

				<tr>
					<td colspan="2"><input type="text" placeholder="이메일을 입력하세요"
						name="id"></td>

				</tr>

				<tr>
					<td>비밀번호</td>
				</tr>


				<tr>
					<td colspan="2"><input type="password" name="pwd"
						placeholder="비밀번호를 입력하세요">
				</tr>


				<tr>
					<td colspan="2"><input type="password" name="pwd1"
						placeholder="비밀번호를 입력하세요"></td>
				</tr>

				<tr>
					<td>폰번호</td>
				</tr>
				<tr>
					<td colspan="2"><input type="text" name="phone"
						placeholder="폰번호를 입력하세요(선택)" maxlength="15">
				</tr>
				<tr>
					<td>주소</td>
				</tr>
				<tr>
					<td colspan="2"><input type="text" name="address"
						placeholder="주소를 입력하세요(선택)"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" id="send" value="다음"></td>
				</tr>


			</table>

		</form>
	</div>

	<jsp:include page="/WEB-INF/views/FirstPage/footer.jsp"></jsp:include>

</body>
</html>