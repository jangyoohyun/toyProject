<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<div class="jumbotron mt-4 border" style="background-color: #faf2db">
	<div class="container" style="width: 80%">
		<h1 class="text-center">다이어리 수정</h1>
		
		<input type="hidden" id="id" value="${board.id}"/>
		
		<br>
		<form id="write_form"
			onsubmit="return confirm('글을 수정하시겠습니까?');">
			<div class="form-group">
				<label class="form-label">제목</label> 
				<input type="text" value="${board.title}"
					class="form-control" id="title" name="title" placeholder="제목" required="required"/>
			</div>
			<br>
			<div class="form-group">
				<label class="from-label">내용</label>
				<textarea style="resize: none" rows="10" class="form-control mt-1" id="content"
					name="content" placeholder="내용" required="required">${board.content}</textarea>
			</div>
		</form>
		
		<button id="btn-update" form="write_form"
			class="btn border-primary float-right">수정하기</button>
		<a href="<c:url value="/board/${board.id}"/>"><button
				class="btn float-end border-danger">돌아가기</button></a>
	</div>
</div>

<script src="/js/board.js"></script>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>