<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.springframework.ui.Model"%>
<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@page import="uc.ac.service.CategoryService"%>
<%@page import="uc.ac.vo.CategoryVO"%>
<%@page import="java.util.List"%>
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
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
	var values = [];
	$.ajax({
		url : "nav",
		type : "post",
		contentType : "application/json; charset=utf-8;",
		dataType : "json",

		success : function(result) {
			values = result.category;

			$.each(values, function(index, value) {
				$('#ul_id').append("<li>" + value.cateName + "</li>");
			});

		}
	});
</script>
</head>
<body ondragstart="return false">
	<div align="center">
		<div class="nav_back">
			<div class="nav">
				<ul class="mainmenu" style="-webkit-padding-start: 0px;">
					<li>카테고리
						<ul class="submenu" id="ul_id">

						</ul>
					</li>
					<li><a href="project">프로젝트 후원</a></li>
					<li><a href="NewProject">신규 프로젝트</a></li>
					<li><a href="PopularProject">인기 프로젝트</a></li>
					<li><a href="notice?num=1">공지사항</a></li>
					<li><a href="upload" style="color: blue;">프로젝트 올리기</a></li>
					<%
						String name = (String) session.getAttribute("name");

						if (name != null) {
							if (name.equals("관리자")) {
					%>

					<li><a href="Admin">관리자페이지</a></li>
					<%
						}
						}
					%>
				</ul>
			</div>
		</div>
	</div>



</body>
</html>