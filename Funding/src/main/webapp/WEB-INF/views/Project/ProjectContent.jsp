<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<style>
.wrap {
	min-height: 100%;
	position: relative;
	padding-bottom: 330px; /* footer height */
}

.comment {
	width: 1000px;
}
</style>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/project.css"
	type="text/css">

<link
	href="https://fonts.googleapis.com/css?family=Nanum+Gothic|Nanum+Myeongjo&display=swap"
	rel="stylesheet">

<meta charset="UTF-8">
<title>프로젝트 후원 메인</title>
</head>
<body>
	<div class="wrap">
		<jsp:include page="/WEB-INF/views/FirstPage/header.jsp"></jsp:include>
		<jsp:include page="/WEB-INF/views/FirstPage/nav.jsp"></jsp:include>

		<div class="fund_detail">

			<div class="product_title">${result.getPtitle()}</div>
			<div class="product_creater">${result.getNickname()}</div>
			<div class="fund_content">
				<!-- 개별 내용 -->
				<div class="fund_each_detail">
					<!-- 개별 이미지 -->
					<div class="detail_img">
						<img src="resources/photoUpload/${result.getPpic1()}">
					</div>
					<!-- 개별 이미지 end -->


				</div>



				<!-- 개별 내용 -->
				<div class="fund_each_detail2">
					<table>


						<tr>
							<th>목표금액</th>

						</tr>
						<tr>
							<td><fmt:formatNumber value="${result.getPmoney()}"
									pattern="###,###,###" />/<fmt:formatNumber
									value="${result.getTotMoney()}" pattern="###,###,###" /></td>

						</tr>

						<tr>
							<th>마감일</th>

						</tr>

						<tr>

							<td>${result.getPdate()}</td>
						</tr>
						<tr>
							<th>남은 수량</th>

						</tr>
						<tr>
							<td>${countRes.getProdCount()}</td>
						</tr>

					</table>
					<br> <br>
					<!-- 개별 내용 end -->
					<div class="addcart">
						<form action="addCart?pnum=${result.getProject_num()}"
							method="post">
							<input type="hidden" name="prodNum_fk"
								value="${count.getProdNum()}"> <input type="hidden"
								name="project_num_fk" value="${vo.getProject_num()}"> <input
								type="submit" value="장바구니 담기">
						</form>
					</div>

				</div>

			</div>
			<!-- 개별 타이틀 end-->
			<div align="center">
				<div class="prod_info">
					<div class="prod_info_content">
						${result.getPdate()}${result.getPcontent()}</div>

				</div>
				<div id="comment">
					&lt; 댓글 &gt; <br> <input type="text" id="write_comment">
					<input type="button" value="등록" id="addComment">
				</div>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/FirstPage/footer.jsp"></jsp:include>
	</div>
</body>
</html>