<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>


<div class="jumbotron mt-4 border" style="background-color: #faf2db">
	<div class="container" style="width: 70%">
		<h1 class="text-center">회원정보 수정</h1>

		<form id="userUpdate">
		
			<input type="hidden" id="userId" value="${principal.user.id}" />

			<div class="form-group mt-3">
				<label class="form-label">비밀번호</label> <input type="password"
					class="form-control" id="password" name="password"
					required="required">
					<span id="checkPassword"></span>
			</div>

			<div class="form-group mt-3">
				<label class="form-label">이름</label> <input type="text"
					class="form-control" id="name" name="name"
					value="${principal.user.name}" required="required">
					<span id="checkName"></span>
			</div>
			
			<div class="form-group mt-3">
				<label class="form-label">이메일</label> <input type="email"
					class="form-control" id="email" name="email"
					value="${principal.user.email}" required="required">
					<span id="checkEmail"></span>
			</div>

		</form>
		
		<div class="btn-toolbar justify-content-end mt-3" role="toolbar"
				aria-label="Toolbar with button groups">
				<div class="btn-group">
					<button type="button" id="btnUserUpdate" class="btn border-dark">회원정보수정</button>
				</div>
			</div>

		<h5 class="text-center mt-3">회원정보 변경을 원하지 않으시면 돌아가기 버튼을 눌러주세요.</h5>
		<div class="text-center">
			<a href="<c:url value="/"/>"><button class="btn border-danger">돌아가기</button></a>
		</div>
	</div>
</div>

<script src="/js/auth.js"></script>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>