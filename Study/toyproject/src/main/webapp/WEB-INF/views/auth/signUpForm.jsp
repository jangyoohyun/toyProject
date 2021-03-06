<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<div class="jumbotron mt-4" style="background-color: #faf2db">
	<div class="container" style="width: 70%">
		<h1 class="text-center">회원가입</h1>

		<form>
			<div class="form-group">
				<label class="form-label">아이디</label> <input type="text"
					class="form-control mb-1" id="username" name="username"
					placeholder="아이디" required="required"> 
					<span id="checkUsername"></span>
			</div>

			<div class="form-group mt-3">
				<label class="form-label">비밀번호</label> <input type="password"
					class="form-control mb-1" id="password" name="password"
					placeholder="비밀번호" required="required">
					<span id="checkPassword"></span>
			</div>

			<div class="form-group mt-3">
				<label class="form-label">이름</label> <input type="text"
					class="form-control" id="name" name="name" placeholder="이름"
					required="required">
					<span id="checkName"></span>
			</div>
			
			<div class="form-group mt-3">
				<label class="form-label">이메일</label> <input type="email"
					class="form-control" id="email" name="email" placeholder="이메일"
					required="required">
					<span id="checkEmail"></span>
			</div>

		</form>

		<div class="btn-toolbar justify-content-end mt-3" role="toolbar"
			aria-label="Toolbar with button groups">
			<div class="btn-group">
				<button id="signUpBtn" class="btn border-secondary">가입하기</button>
			</div>
		</div>



	</div>
	<h5 class="text-center mt-3">로그인을 하시려면 돌아가기 버튼을 눌러주세요.</h5>
	<div class="text-center">
		<a href="<c:url value="/auth/signInForm"/>"><button
				class="btn border-secondary mt-1">돌아가기</button></a>
	</div>
</div>

<script src="/js/auth.js"></script>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
