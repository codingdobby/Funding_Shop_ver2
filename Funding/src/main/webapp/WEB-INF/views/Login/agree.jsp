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

<style type="text/css">
#wrap {
	position: relative;
	min-height: 100%;
	margin: 0;
	border: 1px solid black;
}
</style>

<script src="//code.jquery.com/jquery.min.js"></script>



</head>
<body>

	<jsp:include page="/WEB-INF/views/FirstPage/header.jsp"></jsp:include>
	<div id="wrap">
		<div align="center">
			<div id="top_title">원할한 회원 가입을 위해 아래 동의 사항을 체크하세요</div>
		</div>
		<form action="go_insert.do" method="post" name="iform"
			onsubmit="return checkNec()">
			<div id="put" align="center">
				<!-- 회원 가입 약관 -->
				<table border='1' id="agree">

					<tr>
						<td><span>회원가입약관</span> <input type="checkbox" name="chk"
							value="1"></td>
					</tr>
					<tr>
						<td><iframe src="${pageContext.request.contextPath}/resources/Agree/infoAgree.html" width="100%"></iframe></td>
					</tr>




				</table>
				<br>
				<!-- 개인 정보 처리 방침 -->
				<table border='1' id="agree">

					<tr>
						<td><span>개인정보처리방침안내</span> <input type="checkbox" name="chk"
							value="1"></td>
					</tr>
					<tr>
						<td><iframe src="${pageContext.request.contextPath}/resources/Agree/service.html" width="100%"></iframe></td>
					</tr>
				</table>
				<br>

				<!-- 마켓팅 동의 -->
				마켓팅 수신 동의 <input type="checkbox" name="chk" value="1"> <br>
				<div id="checkAll">
					모든 약관에 동의 <input type="checkbox" id="chkAll" value="1">
					<script
						src="${pageContext.request.contextPath}/resources/js/AgreeCheck.js"></script>

				</div>
				<input type="submit" value="다음">
			</div>
		</form>
	</div>
	<jsp:include page="/WEB-INF/views/FirstPage/footer.jsp"></jsp:include>

</body>
</html>