<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp" %>

<div class="jumbotron mt-4 border" style="background-color: #faf2db">
	<div class="container" style="width: 70%">
		<h1 class="text-center">아이디 찾기</h1>
		
		<form class="px-4 py-3" action="/auth/signIn" method="post">
			
				<div class="form-group">
					<label for="userId" class="form-label">이메일</label>
					<input type="text" class="form-control" name="username" placeholder="아이디">
				</div>
				
				<div class="form-group mt-3">
					<label class="form-label">비밀번호</label>
					<input type="password" class="form-control" name="password" placeholder="비밀번호">
				</div>

				<div class="btn-toolbar justify-content-end mt-2" role="toolbar" aria-label="Toolbar with button groups">
				  <div class="btn-group">
				    <button type="submit" class="btn border-secondary" id="loginBtn">아이디 찾기</button>
				  </div>
				</div>
		</form>
		
		<div class="text-center">
			<a href="<c:url value="/auth/signInForm"/>"><button class="btn border-secondary mt-1">돌아가기</button></a>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp" %>
