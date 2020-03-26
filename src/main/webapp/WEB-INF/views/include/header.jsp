<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC Board</title>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<!-- Bootstrap 3.3.4 -->
<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.comrespond/1.4.2respond.min.js"></script>
<![endif ]-->
</head>
<script src="${pageContext.request.contextPath}/resources/jquery/jquery.min.js"></script>
<body class="skin-blue sidebar-mini">
	<div class="wrapper">
		<header class="main-header">
			<div class="page-header">
				<h1>Spring MVC 게시판</h1>
			</div>
		</header>
	</div>
	<aside class="main-sidebar">
		<section class="sidebar">
			<ul class="nav nav-tabs">
				<li role="presentation" class="active"><a href="#">메인</a></li>
				<li role="presentation"><a href="#">목록보기 </a></li>
				<li role="presentation"><a href="#">게시물 쓰기 </a></li>
				<c:if test="${user == null}">
					<li role="presentation">
						<a href="user/register">회원가입</a></li>
				</c:if>
				<c:if test="${user != null}">
					<li role="presentation">
						<a href="#"> 
							<span class="badge">
								<img src="${pageContext.request.contextPath}/userimage/${user.image}" width="20" height="20" />
							</span>
								${user.nickname}님
						</a>
					</li>
				</c:if>
			</ul>
		</section>
	</aside>
</body>
</html>

