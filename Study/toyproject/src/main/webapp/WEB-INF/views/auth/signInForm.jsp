<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<div class="jumbotron mt-4 border" style="background-color: #faf2db">
	<div class="container" style="width: 70%">
		<h1 class="text-center">로그인</h1>

		<form class="px-4 py-3" action="/auth/signIn" method="post">

			<div class="form-group">
				<label for="userId" class="form-label">아이디</label> <input
					type="text" class="form-control" name="username" placeholder="아이디">
			</div>
			<div class="form-group mt-3">
				<label class="form-label">비밀번호</label> <input type="password"
					class="form-control" name="password" placeholder="비밀번호">
			</div>

			<c:if test="${!empty error}">
				<span style="color: red;">${exception}</span>
			</c:if>

			<div class="btn-toolbar justify-content-end mt-2" role="toolbar"
				aria-label="Toolbar with button groups">
				<div class="btn-group">
					<button type="submit" class="btn border-secondary" id="loginBtn">로그인</button>
				</div>
			</div>
		</form>

		<div class="text-center mb-1">
			<button style="background-color: #faf2db; border: 0; font-weight: 600; font-size: 15px;"
				onclick="javascript:location.href=`/oauth2/authorization/facebook`">
				<i class="fab fa-facebook-square" style="color: #385185;"></i> <span>Facebook으로 로그인</span>
			</button>
		</div>

		<div class="align-center" style="text-align: center;">
			<a href="/auth/findUsernameForm"><span>아이디 찾기</span></a>&nbsp;/&nbsp;<a
				href="/auth/findPasswordForm"><span>비밀번호 찾기</span></a>
		</div>


		<h5 class="text-center mt-3">
			아직 회원이 아니라면 <br />가입하기 버튼을 눌러주세요.
		</h5>
		<div class="text-center">
			<a href="<c:url value="/auth/signUpForm"/>"><button
					class="btn border-secondary mt-1">가입하기</button></a>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>

