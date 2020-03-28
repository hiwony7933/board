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
				<h2>JooWon 게시판 v1.5</h2>
			</div>
		</header>
	</div>
	<aside class="main-sidebar">
		<section class="sidebar">
			<ul class="nav nav-tabs">
				<li role="presentation"><a href="../../">메인</a></li>
				
				<c:if test="${user == null}">
					<li role="presentation"><a href="/user/login">로그인</a></li>
					<li role="presentation"><a href="/user/register">회원가입</a></li>
				</c:if>

				<c:if test="${user != null}">
					<li role="presentation"><a href="/board/list">목록보기 </a></li>
					<li role="presentation"><a href="/board/register">게시물 쓰기 </a></li>
					<li role="presentation"><a href="/study/list">Study 목록보기 </a></li>
					<li role="presentation"><a href="/study/register">Study 게시물 쓰기 </a></li>
					<li role="presentation"><a href="/user/logout">로그아웃</a></li>
					<li role="presentation"><a href="/user/updateform">회원정보수정</a></li>
					<li role="presentation"><a href="/user/secession">회원탈퇴</a></li>
				
					<li role="presentation"><a href="#"> 
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
<!-- 
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="dropdown">
					<button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
						Number <span class="caret"></span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<li role="presentation"><a href="/user/logout">One11111111</a></li>
						<li role="presentation"><a href="#">Two22222222</a></li>
						<li role="presentation"><a href="#">Three333333333</a></li>
					</ul>
				</div>
			</div>
		</div>

	</div>
-->
</body>
</html>
