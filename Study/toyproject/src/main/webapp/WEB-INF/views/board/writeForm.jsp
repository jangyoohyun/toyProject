<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<div class="jumbotron mt-4" style="background-color: #faf2db">
	<div class="container" style="width: 80%">
		<h1 class="text-center">다이어리 쓰기</h1>
		<br>
		<form>
			<div class="form-group">
				<label class="form-label">제목</label> 
				<input type="text" class="form-control" id="title" name="title" placeholder="제목" required="required"/>
			</div>
			<br>
			<div class="form-group">
				<label class="from-label">내용</label>
				<textarea style="resize: none" rows="10" class="form-control mt-1"
					id="content" name="content" placeholder="내용" required="required"></textarea>
			</div>
		</form>
		
		<button id="btn-save"
			class="btn btn-secondary float-right">등록하기</button>
		<a href="<c:url value="/board"/>"><button
				class="btn float-end btn-info">목록으로</button></a>
	</div>
</div>

<script src="/js/board.js"></script>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>