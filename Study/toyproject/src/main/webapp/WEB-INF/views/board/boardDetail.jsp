<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<div class="jumbotron mt-4" style="background-color: #E2E2E2">
	<div class="container" style="width: 80%">
		<h1 class="text-center">다이어리 읽기</h1>
		<br>
		
		<input type="hidden" id="id" value="${board.id}"/>
		
		<div class="card">
			<h5 class="card-header" style="text-align: center;">${board.title}</h5>
			<div class="card-body">
				<h5 class="card-title">작성자 ${board.writer}</h5>
				<hr>
				<p class="card-text">${board.content}</p>
			</div>
		</div>
		<br>
		<button class="btn btn-secondary" onclick="history.back()">돌아가기</button>
		
		<c:if test="${board.writer == principal.username}">
			<a href="/board/${board.id}/updateForm" class="btn btn-warning">수정</a>
			<button id="btn-deleteById" class="btn btn-danger">삭제</button>
		</c:if>

	</div>
</div>

<script src="/js/board.js"></script>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>