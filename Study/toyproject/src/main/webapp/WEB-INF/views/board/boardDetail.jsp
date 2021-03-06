<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<div class="jumbotron mt-4" style="background-color: #faf2db">
	<div class="container" style="width: 80%">
		<h1 class="text-center">다이어리 읽기</h1>
		<br> <input type="hidden" id="id" value="${board.id}" />

		<div class="card">
			<h5 class="card-header" style="text-align: center;">${board.title}</h5>
			<div class="card-body">
				<h5 class="card-title">작성자 ${board.user.username}</h5>
				<hr>
				<p class="card-text">${board.content}</p>
				<hr>
				<p class="card-text">
					<i class="fa-solid fa-eye"></i> ${board.view}
				</p>
			</div>
		</div>

		<c:choose>
			<c:when test="${likes.likeState == 1}">
				<button class="mt-2 mb-2" style="border: none; background-color: #faf2db;">
					<i class="fa-solid fa-heart" id="likeButton"
						onclick="boardList.likeBtn(${board.id})"></i>
				</button>
			</c:when>
			<c:otherwise>
				<button class="mt-2 mb-2" style="border: none; background-color: #faf2db;">
					<i class="fa-regular fa-heart" id="likeButton"
						onclick="boardList.likeBtn(${board.id})"></i>
				</button>
			</c:otherwise>
		</c:choose>

		<span id="likeCount">${likeCount}</span> <br> <a href="/board"><button
				class="btn border-secondary">목록으로</button></a>

		<c:if test="${board.user.username == principal.username}">
			<button id="btn-deleteById" class="btn border-danger"
				style="color: #DB4455; float: right;">삭제</button>
			<a href="/board/${board.id}/updateForm" style="float: right;"
				class="btn border-primary mr-1">수정</a>
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
			<button type="button" id="btn-commentSave" class="btn border-info">등록</button>
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
					<c:if test="${comment.user.username == principal.username}">
						<button id="commentUpdateBtn"
							onclick="boardList.commentUpdate(${board.id}, ${comment.id})"
							class="btn border-primary badge">수정</button>
					&nbsp;
					<button
							onclick="boardList.commentDelete(${board.id}, ${comment.id})"
							class="btn border-danger badge">삭제</button>
					</c:if>
				</div>
			</li>

			<form id="commentUpdateDisplay-${comment.id}" style="display: none;">
				<input type="hidden" id="commentFormId" value="${comment.id}" /> <input
					type="hidden" id="boardFormId" value="${board.id}" />
				<div class="card-body">
					<textarea id="commentUpdateContent-${comment.id}"
						name="commentUpdateContent" class="form-control"
						style="resize: none;" rows="1" required="required"></textarea>
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