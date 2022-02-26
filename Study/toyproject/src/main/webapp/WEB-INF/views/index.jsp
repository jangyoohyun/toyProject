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
		1. 기본적인 CRUD 구현<br><br> 
		2. 회원가입 및 로그인 처리<br><br>
		3. 페이징 처리, 파일 업로드<br><br>
		4. 스프링 시큐리티 적용<br><br>
		위 사항들에 대해서 적용한 항목은 취소선을 적용하여 표시할 것입니다.<br><br>
		</div>


<%@ include file="/WEB-INF/views/layout/footer.jsp" %>