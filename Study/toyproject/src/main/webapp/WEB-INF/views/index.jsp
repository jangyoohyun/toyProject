<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp" %>

		<div class="jumbotron mt-4 border" style="background-color: #faf2db">
		안녕하세요.<br><br>
		<c:if test="${principal.username != null}">
			${principal.username}님 환영합니다.<br><br>
		</c:if>
		여기는 공부를 위해 만든 웹사이트입니다.<br><br>
		이 웹사이트를 개발하면서 적용할 목표는 다음과 같습니다.<br><br>
		1. 간단한 스프링 시큐리티를 적용한 회원가입 및 로그인, 회원정보수정<br><br>
		2. 글 게시판과 사진 게시판의 CRUD<br><br>
		3. 각 게시판의 검색, 페이징 처리, 파일 업로드 및 수정<br><br>
		4. 각 게시판의 댓글 작성, 수정, 삭제<br><br>
		</div>
		
		<h3>최다 추천 게시글 순위</h3>
		<div class="jumbotron mt-4 border" style="background-color: #faf2db">
		안녕하세요.<br><br>
		여기는 공부를 위해 만든 웹사이트입니다.<br><br>
		이 웹사이트를 개발하면서 적용할 목표는 다음과 같습니다.<br><br>
		1. 간단한 스프링 시큐리티를 적용한 회원가입 및 로그인, 회원정보수정<br><br>
		2. 글 게시판과 사진 게시판의 CRUD<br><br>
		3. 각 게시판의 검색, 페이징 처리, 파일 업로드 및 수정<br><br>
		4. 각 게시판의 댓글 작성, 수정, 삭제<br><br>
		</div>


<%@ include file="/WEB-INF/views/layout/footer.jsp" %>