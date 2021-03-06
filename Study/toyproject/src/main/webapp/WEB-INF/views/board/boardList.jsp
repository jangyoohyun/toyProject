<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<script src="https://kit.fontawesome.com/67f4370b70.js" crossorigin="anonymous"></script>

<table class="table table-hover table-striped mt-4 rounded border"
	style="text-align: center">
	<thead>
		<tr style="background-color: #faf2db">
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${board.content}" var="board">
			<tr>
				<td>${board.id}</td>
				<td>${board.user.username}</td>
				<td><a href="/board/${board.id}">${board.title}</a></td>
				<td>${board.createDate}</td>
				<td>${board.view}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<hr />

<div class="text-right float-right">
	<a href="<c:url value="/board/writeForm"/>"><button
			class="btn border-secondary">글쓰기</button></a>
</div>

<nav aria-label="Page navigation example" style="margin: auto;">
	<ul class="pagination justify-content-center">
		<c:choose>

			<c:when test="${nowPage == startPage}">
				<li class="page-item disabled"><a class="page-link"
					href="/board?page=${startPage - 1}&keyword=${keyword}" tabindex="-1">이전</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link"
					href="/board?page=${startPage - 1}&keyword=${keyword}" tabindex="-1">이전</a></li>
			</c:otherwise>

		</c:choose>

		<c:forEach begin="${startPage}" end="${endPage}" var="i">
			<c:choose>
				<c:when test="${nowPage == i}">
					<li class="page-item disabled"><a class="page-link"
						href="/board?page=${i-1}&keyword=${keyword}">${i}</a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link"
						href="/board?page=${i-1}&keyword=${keyword}">${i}</a></li>
				</c:otherwise>
			</c:choose>

		</c:forEach>

		<c:choose>
			<c:when test="${endPage == nowPage}">
				<li class="page-item disabled"><a class="page-link"
					href="/board?page=${endPage - 1}&keyword=${keyword}">다음</a>
				</li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link"
					href="/board?page=${endPage - 1}&keyword=${keyword}">다음</a>
				</li>
			</c:otherwise>
		</c:choose>
	</ul>

	<form action="/board" method="get">
		<div class="input-group mb-3 w-50" style="margin: auto;">
			<input type="text" class="form-control"
				placeholder="검색" name="keyword">
			<div class="input-group-append">
				<button class="btn btn-outline-secondary" type="submit">검색</button>
			</div>
		</div>
	</form>
</nav>


<script type="text/javascript">
	
</script>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>