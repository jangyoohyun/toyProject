<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<div class="jumbotron mt-4 bg-light border">
	<div class="container" style="width: 80%">
	
		<h1 class="text-center">사진첩 수정</h1>
		<br>
		<form action="/photo/photoUpdate/${photo.id}" method="post" enctype="multipart/form-data" id="photo_write"
			onsubmit="return confirm('글을 수정하시겠습니까?');">
			
			<input type="hidden" id="id" value="${photo.id}"/>
			
			<img class="card-img-top border mb-3" id="photoImageUrl" style="width: height: 100px;" src="/upload/${photo.postImageUrl}"/>
			
			<div class="form-group">
				<label class="form-label">제목</label> 
				<input type="text" value="${photo.title}" class="form-control" id="title" name="title"
					placeholder="제목" required="required" />
			</div>
			<br>
			<div class="form-group">
				<label class="from-label">내용</label>
				<textarea style="resize: none" rows="10" class="form-control mt-1"
					id="content" name="content" placeholder="내용" required="required">${photo.content}</textarea>
			</div>
			<br>
			<div class="form-group">
				<label for="userPhoto" class="form-lable">이미지</label><br> 
				<input class="mt-1" type="file" id="photoImageUrl" name="photoImageUrl"
					multiple="multiple" />
			</div>
			<br>
			
		</form>
		
		<button type="submit" form="photo_write"
			class="btn btn-secondary float-right">수정하기</button>
		<a href="<c:url value="/photo"/>"><button
				class="btn float-end" style="background-color: #d3d3d3">목록으로</button></a>
	</div>
</div>

<script src="/js/photo.js"></script>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>