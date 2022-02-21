<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<div class="jumbotron mt-4" style="background-color: #E2E2E2">
	<div class="container" style="width: 80%">
		<h1 class="text-center">다이어리 읽기</h1>
		<br>
		
		<input type="hidden" id="id" value="${photo.id}"/>
		
		<div class="card">
			<img class="card-img-top" style="width: height: 100px;" src="/upload/${photo.postImageUrl}"/>
			<h5 class="card-header" style="text-align: center;">${photo.title}</h5>
			<div class="card-body">
				<h5 class="card-title">작성자 ${photo.user.username}</h5>
				<hr>
				<p class="card-text">${photo.content}</p>
			</div>
		</div>
		<br>
		<a href="/photo"><button class="btn btn-secondary">목록으로</button></a>
		
		<c:if test="${photo.user.username == principal.username}">
			<a href="/photo/${photo.id}/photoUpdateForm" class="btn btn-warning">수정</a>
			<button id="btn-deleteById" class="btn btn-danger">삭제</button>
		</c:if>

	</div>
</div>

<script src="/js/photo.js"></script>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>