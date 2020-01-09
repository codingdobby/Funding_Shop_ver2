<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/notice.css"
	type="text/css">
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon"
	rel="stylesheet">
<title>공지사항 상세보기</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/FirstPage/header.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/views/FirstPage/nav.jsp"></jsp:include>
	<div align="center">
		<div class="detailView">
			<table border="1" cellspacing="0">
				<tr>
					<th>글 번호</th>
					<td>${vo.getNotice_num()}
					</td>
					<th>날짜</th>
					<td>${vo.getnRegdate()}</td>
					<th>조회수</th>
					<td>${vo.getNhits()}</td>
				</tr>
				<tr>
					<th>글 제목</th>
					<td colspan="3">${vo.getnTitle()}</td>
					<th>작성자</th>
					<td>${vo.getnWriter()}</td>

				</tr>

				<tr>

					<td class="text-area" colspan="6" style="word-break: break-all">${vo.getnContent()}</td>
				</tr>

			</table>
		</div>
		
			
		<%
			String name = (String) session.getAttribute("name");

			if (name != null && name.equals("관리자")) {
		%>
		<div id="admin" align="right">
			<a href="notice_update.do">수정하기</a>
			<a href="notice_delete.do?num=${vo.getNotice_num()}">삭제하기</a>
		
		</div>
			<%
			}
			
			%>
		
		
		
		<div id="main">
			<a href="notice?num=<%=request.getParameter("num")%>">게시판 메인으로 가기</a>
		</div>
		
	
	</div>
	<!-- align="center end" -->
	<jsp:include page="/WEB-INF/views/FirstPage/footer.jsp"></jsp:include>
</body>
</html>