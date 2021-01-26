<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/notice.css?after"
	type="text/css">
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon"
	rel="stylesheet">
<title>공지 게시판</title>
</head>
<body>
	<div align="center">
		<jsp:include page="/WEB-INF/views/FirstPage/header.jsp"></jsp:include>
		<jsp:include page="/WEB-INF/views/FirstPage/nav.jsp"></jsp:include>

		<h1>공지 게시판</h1>
		<div class="notice_table">
			<table border="1" cellspacing="0">
				<tr>
					<td>글 번호</td>
					<td>글 제목</td>
					<td>작성자</td>
					<td>등록일</td>
					<td>조회수</td>
				</tr>

				<c:forEach var='vo' items='${list}'>
					<tr>

						<td>${vo.getNotice_num()}</td>
						<%
							String num = request.getParameter("num");
						%>
						<td><a
							href="listContent.do?no=${vo.getNotice_num()}&num=<%=num%>">${vo.getnTitle()}</a></td>
						<td>${vo.getnWriter()}</td>
						<td>${vo.getnRegdate()}</td>
						<td>${vo.getNhits()}</td>


					</tr>
				</c:forEach>

			</table>

		</div>


		<div align="center">
			<div id="paging">
				<c:if test="${prev}">
					<span>[ <a href="notice?num=${startPageNum - 1}">이전</a> ]
					</span>
				</c:if>

				<c:forEach begin="${startPageNum}" end="${endPageNum}" var="num">
					<span> <c:if test="${select!=num}">


							<a href="notice?num=${num}">${num}</a>
						</c:if> <c:if test="${select==num }">
							<strong>${num}</strong>
						</c:if>
					</span>
				</c:forEach>

				<c:if test="${next}">
					<span>[ <a href="notice?num=${endPageNum + 1}">다음</a> ]
					</span>
				</c:if>
			</div>
		</div>
		<br>
		<%
			String name = (String) session.getAttribute("name");

			if (name != null && name.equals("관리자")) {
		%>
		<div>
			<form action="go_noticeWrite.do">
				<input type="submit" value="글쓰기">
			</form>
		</div>
		<%
			}
		%>

	</div>
</body>

</html>
<jsp:include page="/WEB-INF/views/FirstPage/footer.jsp"></jsp:include>