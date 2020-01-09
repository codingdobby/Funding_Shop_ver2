<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<link href="https://fonts.googleapis.com/css?family=Do+Hyeon"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/upload.css"
	type="text/css">
<title>프로젝트 목록</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/FirstPage/header.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/views/FirstPage/nav.jsp"></jsp:include>

	<div class="Upload_name">
		<h2>프로젝트 리스트</h2>
	</div>
	<div class="projectList">

		<c:if test="${empty boardList }">
			<div align="center">
				<div id="list_empty">
					<h3>진행중인 프로젝트가 없네요!</h3>
					<br>
				</div>
			</div>
		</c:if>
	

		<c:if test="${not empty boardList}">
			<table border="1" cellspacing="0">
				<tr>
					<th>글 번호</th>
					<th>글 제목</th>
					<th>작성자</th>
					<th>등록일</th>
					<th>승인여부</th>
				</tr>

				<c:forEach var='vo' items='${boardList}'>
					<tr>
						<td>${vo.getProject_num()}</td>
						<td><a href="fundDetail?pnum=${vo.getProject_num()}">${vo.getPtitle()}</a></td>
						<td>${vo.getNickname()}</td>
						<td>${vo.getRegdate()}</td>
						<td>${vo.getpVerify()}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>





	</div>

	<form action="go_insertProd" method="post">
		<input type="submit" value="프로젝트 생성">
	</form>

	<jsp:include page="/WEB-INF/views/FirstPage/footer.jsp"></jsp:include>

</body>
</html>