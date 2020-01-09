<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style>
#result{
width: 1000px;
margin-top: 20px;
font-size: 15pt;
}
</style>
<meta charset="UTF-8">
<title>검색완료</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/FirstPage/header.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/views/FirstPage/nav.jsp"></jsp:include>
	<div class="search_result">

		<c:if test="${empty search }">
			<div align="center">
				<div id="result">일치하는 결과없음</div>

			</div>
		</c:if>
		<c:if test="${not empty search }">
			<table border="1" style="width: 1000px;">

				<tr>
					<th rowspan="4"><img
						src="resources/photoUpload/${search.getPpic1()}"></th>
					<td>글 제목 : <a
						href="fundDetail.do?pnum=${search.getProject_num()}">${search.getPtitle()}</a>
				</tr>

				<tr>
					<td>마감기간 :${search.getPdate()}</td>

				</tr>
				<tr>
					<td>목표금액 : ${search.getTotMoney()}</td>

				</tr>


			</table>

		</c:if>

	</div>
	<jsp:include page="/WEB-INF/views/FirstPage/footer.jsp"></jsp:include>
</body>
</html>