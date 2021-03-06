<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<div class="jumbotron mt-4 border" style="background-color: #faf2db">
	<div class="container" style="width: 70%">
		<h1 class="text-center">아이디 찾기</h1>
		<br>
		<h2>조회하신 아이디는 ${username} 입니다.</h2>
		<br>
		<div class="text-center">
			<a href="<c:url value="/auth/signInForm"/>"><button
					class="btn border-secondary mt-1">로그인</button></a>
		</div>
	</div>
</div>

<script src="/js/auth.js"></script>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>