<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal" />
</sec:authorize>

<!DOCTYPE html>
<html>
<head>
<!-- Fontawesome -->
<script src="https://kit.fontawesome.com/67f4370b70.js" crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>

<meta charset="UTF-8">

<title>Insert title here</title>
</head>
<body>
	<div class="container mt-5 w-75">
		<nav class="navbar navbar-expand-lg navbar-light rounded"
			style="background-color: #958D85">
			<div class="container-fluid">
				<a class="navbar-brand text-white" href="<c:url value="/"/>">HOME</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarNav"
					aria-controls="navbarNav" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav">
						<li class="nav-item "><a class="nav-link text-white"
							href="<c:url value="/board?page=0"/>">게시판</a></li>
						<li class="nav-item"><a class="nav-link text-white"
							href="<c:url value="/photo"/>">사진첩</a></li>
						<c:choose>
							<c:when test="${principal.username == null}">
								<li class="nav-item"><a class="nav-link text-white"
									href="<c:url value="/auth/signInForm"/>">회원가입/로그인</a></li>
							</c:when>
							<c:otherwise>
								<li class="nav-item"><a class="nav-link text-white"
									onclick="return confirm('로그아웃 하시겠습니까?');"
									href="<c:url value="/logout"/>">로그아웃</a></li>
								<li class="nav-item"><a class="nav-link text-white"
									href="<c:url value="/auth/userUpdate"/>">회원정보수정</a></li>
							</c:otherwise>
						</c:choose>

					</ul>
				</div>
			</div>
		</nav>