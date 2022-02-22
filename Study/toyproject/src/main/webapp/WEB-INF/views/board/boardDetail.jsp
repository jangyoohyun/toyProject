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
		<input type="hidden" id="userId" value="${principal.user.id}" /> <input
			type="hidden" id="boardId" value="${board.id}" />
		<div class="card-body">
			<textarea id="commentContent" name="commentContent"
				class="form-control" style="resize: none;" rows="1"
				required="required"></textarea>
		</div>
		<div class="card-footer">
			<button type="button" id="btn-commentSave" class="btn btn-primary">등록</button>
		</div>
	</form>
</div>


<div class="card mb-4">
	<div class="card-header">댓글 리스트</div>
	<ul id="reply-box" class="list-group">
		<c:forEach var="comment" items="${board.boardComments}">

			<li id="reply-${comment.id}"
				class="list-group-item d-flex justify-content-between">
				<div>${comment.commentContent}</div>
				<div class="d-flex">
					<div class="font-italic">작성자: ${comment.user.username} &nbsp;</div>
					<button id="commentUpdateBtn"
						onclick="boardList.commentUpdate(${board.id}, ${comment.id})"
						class="btn btn-primary badge">수정</button>
					&nbsp;
					<button
						onclick="boardList.commentDelete(${board.id}, ${comment.id})"
						class="btn btn-danger badge">삭제</button>
				</div>
			</li>

			<form id="commentUpdateDisplay-${comment.id}" style="display: none;">
			<input type="hidden" id="commentId" value="${comment.id}" />
				<div class="card-body">
					<textarea id="commentUpdateContent" name="commentUpdateContent"
						class="form-control" style="resize: none;" rows="1"
						required="required">${comment.commentContent}</textarea>
				</div>
				<div class="card-footer">
					<button type="button" id="btn-commentUpdate-${comment.id}"
						class="btn btn-primary">수정</button>
				</div>
			</form>
		</c:forEach>
		
	</ul>
	
</div>

<script src="/js/board.js"></script>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>