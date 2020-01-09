<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/project.css"
	type="text/css">

<link
	href="https://fonts.googleapis.com/css?family=Nanum+Gothic|Nanum+Myeongjo&display=swap"
	rel="stylesheet">
<title>프로젝트 후원 메인</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	%>
	<jsp:include page="/WEB-INF/views/FirstPage/header.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/views/FirstPage/nav.jsp"></jsp:include>
	<!-- 본문 내용 -->
	<div id="top">
		<a href="#"><img src="${pageContext.request.contextPath}/resources/image/top2.png"></a>
	</div>


	<div align="center">
		<!-- 개별 내용 -->
		<h3>조회수가 가장 많은 프로젝트입니다</h3>

		<div class="fund_each">
			<c:forEach var='vo' items='${projectBotari}'>
				<table border="1">

					<tr>
						<th colspan="2"><a
							href="fundDetail?pnum=${vo.getProject_num()}"><img
								src="${pageContext.request.contextPath}/resources/photoUpload/${vo.getPpic1()}"></a></th>

					</tr>

					<tr>
						<td colspan="2"><a
							href="fundDetail?pnum=${vo.getProject_num()}">${vo.getPtitle()}</a></td>

					</tr>
					<tr>

						<td colspan="2">${vo.getNickname()}</td>

					</tr>
					<tr>

						<td>${vo.getPdate()}</td>
						<td><fmt:formatNumber value="${vo.getTotMoney()}"
								pattern="###,###,###" />원</td>
					</tr>
				</table>
			</c:forEach>
		</div>
		<!-- 개별 타이틀 end-->



	</div>






	<%-- <jsp:include page="/WEB-INF/views/FirstPage/footer.jsp"></jsp:include> --%>
</body>
</html>