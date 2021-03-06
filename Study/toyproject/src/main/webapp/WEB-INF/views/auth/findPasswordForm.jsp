<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<div class="jumbotron mt-4 border" style="background-color: #faf2db">
	<div class="container" style="width: 70%">
		<h1 class="text-center">비밀번호 찾기</h1>

		<form>
			<div class="form-group">
				<label for="userId" class="form-label">아이디</label> <input
					type="text" class="form-control" id="FPusername" name="username" placeholder="아이디">
			</div>
			<div class="form-group mt-3">
				<label class="form-label">이메일</label> <input type="email"
					class="form-control" id="FPemail" name="email" placeholder="이메일">
			</div>
		</form>

		<div class="btn-toolbar justify-content-end" role="toolbar"
			aria-label="Toolbar with button groups">
			<div class="btn-group">
				<button type="button" class="btn border-secondary" id="findPasswordBtn">비밀번호
					찾기</button>
			</div>
		</div>

		<div class="text-center">
			<a href="<c:url value="/auth/signInForm"/>"><button
					class="btn border-secondary mt-1">돌아가기</button></a>
		</div>
	</div>
</div>

<script src="/js/auth.js"></script>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>

