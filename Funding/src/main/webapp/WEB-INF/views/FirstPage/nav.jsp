<%@page import="org.springframework.ui.Model"%>
<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@page import="uc.ac.service.CatService"%>
<%@page import="uc.ac.vo.CatVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<!-- 글꼴다운 -->
<link
	href="https://fonts.googleapis.com/css?family=Nanum+Gothic|Nanum+Myeongjo|Nanum+Pen+Script&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/Nav.css"
	type="text/css">

</head>
<body ondragstart="return false">

	<div align="center">
		<div class="nav_back">
			<div class="nav">
				<ul class="mainmenu" style="-webkit-padding-start: 0px;">
					<li>카테고리
						<ul class="submenu">

							<li>테크</li>
							<li>test</li>
							<li>미용</li>


						</ul>
					</li>
					<li><a href="project">프로젝트 후원</a></li>
					<li><a href="NewProject">신규 프로젝트</a></li>
					<li><a href="PopularProject">인기 프로젝트</a></li>
					<li><a href="notice?num=1">공지사항</a></li>
					<li><a href="upload" style="color: blue;">프로젝트 올리기</a></li>
					<!-- 	<li><a href="Admin">관리자페이지</a></li> -->
				</ul>
			</div>
		</div>
	</div>



</body>
</html>