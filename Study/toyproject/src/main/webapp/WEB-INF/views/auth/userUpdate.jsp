<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>


<div class="jumbotron mt-4" style="background-color: #E2E2E2">
	<div class="container" style="width: 70%">
		<h1 class="text-center">회원정보 수정</h1>
		<p class="text-center mt-3">
			회원정보를 변경하시면 로그아웃되며 로그인창으로 이동합니다. <br /> 불편하시더라도 재로그인 부탁드립니다.
		</p>



		<form id="userUpdate">
		
			<input type="hidden" id="userId" value="${principal.user.id}" />

			<div class="form-group mt-3">
				<label class="form-label">아이디</label> <input type="text"
					class="form-control" id="username" name="username"
					value="${principal.user.username}" readonly="readonly">
			</div>

			<div class="form-group mt-3">
				<label class="form-label">비밀번호</label> <input type="password"
					class="form-control" id="password" name="password"
					required="required">
			</div>

			<div class="form-group mt-3">
				<label class="form-label">이름</label> <input type="text"
					class="form-control" id="name" name="name"
					value="${principal.user.name}" required="required">
			</div>

			<div class="form-group mt-3">
				<label class="form-label">휴대폰번호</label> <input type="tel"
					class="form-control" id="phone" name="phone"
					value="${principal.user.phone}" required="required">
			</div>

		</form>
		
		<div class="btn-toolbar justify-content-end mt-3" role="toolbar"
				aria-label="Toolbar with button groups">
				<div class="btn-group">
					<button type="button" id="btnUserUpdate" class="btn btn-secondary">회원정보수정</button>
				</div>
			</div>

		<h5 class="text-center mt-3">회원정보 변경을 원하지 않으시면 돌아가기 버튼을 눌러주세요.</h5>
		<div class="text-center">
			<a href="<c:url value="/"/>"><button class="btn"
					style="background-color: #d3d3d3">돌아가기</button></a>
		</div>
	</div>
</div>

<script src="/js/auth.js"></script>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>