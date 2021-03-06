<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<div class="jumbotron mt-4 border" style="background-color: #faf2db">
	<div class="container" style="width: 70%">
		<h1 class="text-center">아이디 찾기</h1>

		<form>
			<div class="form-group">
				<label for="userId" class="form-label">이메일</label> <input
					type="text" class="form-control" id="email" name="email"
					placeholder="회원가입시 입력하신 이메일 주소를 입력해주세요.">
			</div>
		</form>
		
		<%-- <span>${msg}</span> --%>

		<div class="btn-toolbar justify-content-end mt-2" role="toolbar"
			aria-label="Toolbar with button groups">
			<div class="btn-group">
				<button type="button" class="btn border-secondary" id="findUsernameBtn">아이디
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

