<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<div class="jumbotron border" style="background-color: #faf2db">
	<div class="container" style="width: 80%">
	
		<h1 class="text-center">사진첩 쓰기</h1>
		<br>
		<form action="/photo/photoWrite" method="post" enctype="multipart/form-data" id="photo_write"
			onsubmit="return confirm('글을 등록하시겠습니까?');">
			<div class="form-group">
				<label class="form-label">제목</label> <input type="text"
					class="form-control" id="title" name="title"
					placeholder="제목" required />
			</div>
			<br>
			<div class="form-group">
				<label class="from-label">내용</label>
				<textarea style="resize: none" rows="10" class="form-control mt-1"
					id="content" name="content" placeholder="내용" required></textarea>
			</div>
			<br>
			<div class="form-group">
				<label for="userPhoto" class="form-lable">이미지</label><br> 
				<input class="mt-1" type="file" id="userPhoto" name="file"
					multiple="multiple" />
			</div>
			<br>
			
		</form>
		<button form="photo_write"
			class="btn btn-secondary float-right">등록하기</button>
		<a href="<c:url value="/photo/photoMain?num=1"/>"><button
				class="btn float-end" style="background-color: #d3d3d3">목록으로</button></a>
	</div>
</div>
<%@ include file="/WEB-INF/views/layout/footer.jsp"%>