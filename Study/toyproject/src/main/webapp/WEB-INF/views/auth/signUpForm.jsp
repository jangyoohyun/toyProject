<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<div class="jumbotron mt-4" style="background-color: #E2E2E2">
	<div class="container" style="width: 70%">
		<h1 class="text-center">회원가입</h1>

		<form action="/auth/signUp" method="post">
			<div class="form-group">
				<label for="usernameCheck" class="form-label">아이디</label> <input
					type="text" class="form-control mb-1" id="usernameCheck"
					name="username" placeholder="아이디" required="required" value="${signUpDto.username}"> 
					<%-- <span style="color: red">${valid_username}</span> --%>
					<Font id="checkFont"></Font>
			</div>

			<div class="form-group mt-3">
				<label class="form-label">비밀번호</label> <input type="password"
					class="form-control mb-1" id="passwordCheck" name="password"
					placeholder="비밀번호" required="required" value="${signUpDto.password}"> 
					<%-- <span style="color: red">${valid_password}</span> --%>
					<Font id="passwordCheckFont"></Font>
			</div>

			<div class="form-group mt-3">
				<label class="form-label">이름</label> <input type="text"
					class="form-control" id="nameCheck" name="name" placeholder="이름"
					required="required" value="${signUpDto.name}"> 
					<Font id="nameCheckFont"></Font>
			</div>

			<div class="btn-toolbar justify-content-end mt-3" role="toolbar"
				aria-label="Toolbar with button groups">
				<div class="btn-group">
					<button type="submit" id="signUpBtn" class="btn btn-secondary">가입하기</button>
				</div>
			</div>
		</form>



	</div>
	<h5 class="text-center mt-3">로그인을 하시려면 돌아가기 버튼을 눌러주세요.</h5>
	<div class="text-center">
		<a href="<c:url value="/auth/signInForm"/>"><button
				class="btn btn-secondary mt-1">돌아가기</button></a>
	</div>
</div>

<script src="/js/auth.js"></script>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
