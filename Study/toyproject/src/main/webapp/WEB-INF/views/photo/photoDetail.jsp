<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<div class="jumbotron mt-4" style="background-color: #faf2db">
	<div class="container" style="width: 80%">
		<h1 class="text-center">사진첩 읽기</h1>
		<br> <input type="hidden" id="id" value="${photo.id}" />

		<div class="card">
			<img class="card-img-top" style="width: height: 100px;"
				src="/upload/${photo.postImageUrl}" />
			<h5 class="card-header" style="text-align: center;">${photo.title}</h5>
			<div class="card-body">
				<h5 class="card-title">작성자 ${photo.user.username}</h5>
				<hr>
				<p class="card-text">${photo.content}</p>
			</div>
		</div>
		<br> <a href="/photo"><button class="btn border-secondary">목록으로</button></a>

		<c:if test="${photo.user.username == principal.username}">
			<button id="btn-deleteById" style="float: right;" class="btn border-danger">삭제</button>
			<a href="/photo/${photo.id}/photoUpdateForm" style="float: right;" class="btn border-primary mr-1">수정</a>
		</c:if>

	</div>
</div>


<div class="card mb-4">
	<form>
		<input type="hidden" id="userId" value="${principal.user.id}" /> <input
			type="hidden" id="photoId" value="${photo.id}" />
		<div class="card-body">
			<textarea id="photoCommentContent" name="photoCommentContent"
				class="form-control" style="resize: none;" rows="1"
				required="required"></textarea>
		</div>
		<div class="card-footer">
			<button type="button" id="btn-photoCommentSave"
				class="btn border-info">등록</button>
		</div>
	</form>
</div>


<div class="card mb-4">
	<div class="card-header" style="background-color: #faf2db">댓글 리스트</div>
	<ul id="reply-box" class="list-group">
	
		<c:forEach var="comment" items="${photo.photoComments}">

			<li id="reply-${comment.id}"
				class="list-group-item d-flex justify-content-between">
				<div>${comment.photoCommentContent}</div>
				<div class="d-flex">
					<div class="font-italic">작성자: ${comment.user.username} &nbsp;</div>
					<c:if test="${comment.user.username == principal.username}">
						<button id="commentUpdateBtn"
							onclick="photoList.commentUpdate(${photo.id}, ${comment.id})"
							class="btn border-primary badge">수정</button>
					&nbsp;
					<button
							onclick="photoList.commentDelete(${photo.id}, ${comment.id})"
							class="btn border-danger badge">삭제</button>
					</c:if>
				</div>
			</li>

			<form id="commentUpdateDisplay-${comment.id}" style="display: none;">
				<input type="hidden" id="commentId" value="${comment.id}" />
				<div class="card-body">
					<textarea id="commentUpdateContent-${comment.id}"
						class="form-control" style="resize: none;" rows="1"
						required="required"></textarea>
				</div>
				<div class="card-footer">
					<button type="button" id="btn-photoCommentUpdate-${comment.id}"
						class="btn btn-primary">수정</button>
				</div>
			</form>

		</c:forEach>

	</ul>

</div>

<script src="/js/photo.js"></script>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>