<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- 돋보기-->
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<!-- 글꼴다운 -->
<link
	href="https://fonts.googleapis.com/css?family=Nanum+Gothic|Nanum+Myeongjo|Nanum+Pen+Script&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/Header.css?after"
	type="text/css">


<style>
</style>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/search.css"
	type="text/css">
<meta charset="UTF-8">
<%
	if (session.getAttribute("name") == null)
%>
</head>
<body>
	<div align="center">
		<%
			String name = (String) session.getAttribute("name");

			if (name != null) {
		%>

		<!-- 로그인 성공 -->

		<div class="header">
			<ul>
				<li><a href="main.do"><img
						src="resources/image/logoTest.png"></a></li>
				<li>
					<form class="test" action="searchPage?ptitle=?">
						<div class="box">
							<div class="container-3">
								<span class="icon"><i class="fa fa-search"></i></span> <input
									type="search" id="search" placeholder="Search..." name="search" />
							</div>
						</div>
					</form>
				</li>


				<li><a href="mypage"><%=name%>님</a></li>
				<li><a href="logout.do">로그아웃</a></li>

			</ul>
		</div>
		<%
			}

			//로그인 성공하기 전 메인 화면
			else {
		%>
		<div class="header">
			<ul>

				<li><a href="main.do"><img
						src="resources/image/logoTest.png"></a></li>
				<li>
					<form class="test" action="searchPage">
						<div class="box">
							<div class="container-3">
								<span class="icon"><i class="fa fa-search"></i></span> <input
									type="search" id="search" placeholder="Search..." name="search"/>
							</div>
						</div>
					</form>
				</li>

				<li><a href="go_login.do">로그인</a></li>
				<li><a href="agree.do">회원가입</a></li>

			</ul>
		</div>
		<%
			}
		%>
	</div>
</body>
</html>