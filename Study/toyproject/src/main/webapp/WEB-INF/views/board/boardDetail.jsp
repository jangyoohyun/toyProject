<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<div class="jumbotron mt-4" style="background-color: #E2E2E2">
	<div class="container" style="width: 80%">
		<h1 class="text-center">다이어리 읽기</h1>
		<br> <input type="hidden" id="id" value="${board.id}" />

		<div class="card">
			<h5 class="card-header" style="text-align: center;">${board.title}</h5>
			<div class="card-body">
				<h5 class="card-title">작성자 ${board.user.username}</h5>
				<hr>
				<p class="card-text">${board.content}</p>
			</div>
		</div>
		<br> <a href="/board"><button class="btn btn-secondary">목록으로</button></a>

		<c:if test="${board.user.username == principal.username}">
			<a href="/board/${board.id}/updateForm" class="btn btn-warning">수정</a>
			<button id="btn-deleteById" class="btn btn-danger">삭제</button>
		</c:if>

	</div>
</div>

<div class="card mb-4">
	<form>
		<input type="hidden" id="userId" value="${principal.user.id}" /> 
		<input type="hidden" id="boardId" value="${board.id}" />
		<div class="card-body">
			<textarea id="content" name="content" class="form-control" rows="1" required="required"></textarea>
		</div>
		<div class="card-footer">
			<button type="button" id="btn-commentSave" class="btn btn-primary">등록</button>
		</div>
	</form>
</div>


<%-- <div class="card">
	<div class="card-header">댓글 리스트</div>
	<ul id="reply-box" class="list-group">
		<c:forEach var="reply" items="${board.boardComments}">

			<li id="reply-${reply.id}"
				class="list-group-item d-flex justify-content-between">
				<div>${reply.content}</div>
				<div class="d-flex">
					<div class="font-italic">작성자: ${reply.user.username} &nbsp;</div>
					<button onclick="index.replyDelete(${board.id}, ${boardComments.id})"
						class="btn btn-secondary badge">삭제</button>
				</div>
			</li>
		</c:forEach>
	</ul>
</div> --%>

<script src="/js/board.js"></script>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>