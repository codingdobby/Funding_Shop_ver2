<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Funding_Main</title>

<script src="https://code.jquery.com/jquery-latest.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/swiper.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/slide.js"></script>

<!-- 요소 디자인 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main_css.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/swiper.min.css"
	type="text/css">

</head>
<jsp:include page="/WEB-INF/views/FirstPage/header.jsp"></jsp:include>
<body>
	<jsp:include page="/WEB-INF/views/FirstPage/nav.jsp"></jsp:include>
	<div id="wrap">
		<div align="center">
			<div class="swiper-container gallery-top">
				<div class="swiper-wrapper">
					<c:forEach var='vo' items='${newBotari}'>
						<div class="swiper-slide">
							<a href="fundDetail?pnum=${vo.getProject_num()}"><img
								src="resources/photoUpload/banner1.png"></a>
						</div>
					</c:forEach>
				</div>
				<!-- Add Arrows -->
				<div class="swiper-button-next swiper-button-white"></div>
				<div class="swiper-button-prev swiper-button-white"></div>
			</div>
			<div class="swiper-container gallery-thumbs">
				<div class="swiper-wrapper">
					<c:forEach var='vo' items='${newBotari}'>
						<div class="swiper-slide"
							style="background-image: url('resources/photoUpload/banner1.png')">
							<a href="fundDetail?pnum=${vo.getProject_num()}"></a>
						</div>
					</c:forEach>
				</div>
			</div>
			<!-- 배너 슬라이드 end -->
			<br>
			
			<h2>최다 조회수 상품</h2>
			<div class="fund_each">
				<c:forEach var='vo' items='${hitBotari}'>
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

							<td>${vo.getPdate()} <span id="text">마감</span></td>
							<td><fmt:formatNumber value="${vo.getTotMoney()}"
									pattern="###,###,###" /><span id="text">원 달성</span></td>
						</tr>
					</table>
				</c:forEach>
			</div>
			
			<!-- 개별 타이틀 end-->
			<h2>최신 상품</h2>
				<div class="fund_each">
				<c:forEach var='vo' items='${newBotari}'>
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

							<td><span id="big_text">${vo.getPdate()}</span> <span id="text">마감</span></td>
							<td><span id="big_text"><fmt:formatNumber value="${vo.getTotMoney()}"
									pattern="###,###,###" /></span><span id="text">원 달성</span></td>
						</tr>
					</table>
				</c:forEach>
				<br>
			</div>
			
			<br>
<!-- align center end -->

		</div>

<!-- wrap end -->
	</div>
	

	<!-- end wrap -->

	

</body>
</html>
<jsp:include page="/WEB-INF/views/FirstPage/footer.jsp"></jsp:include>