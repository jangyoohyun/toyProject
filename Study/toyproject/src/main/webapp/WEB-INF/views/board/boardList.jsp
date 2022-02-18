<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<table class="table table-hover table-striped mt-4 rounded"
	style="text-align: center">
	<thead>
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>작성일</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${board.content}" var="board">
			<tr>
				<td>${board.id}</td>
				<td>${board.writer}</td>
				<td><a href="/board/${board.id}">${board.title}</a></td>
				<td>${board.createDate}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<hr />

<div class="text-right float-right">
	<a href="<c:url value="/board/writeForm"/>"><button
			class="btn btn-secondary">글쓰기</button></a>
</div>

<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center">
  
  <c:choose>
  	<c:when test="${list.pageable.pageNumber == 1}">
  		<li class="page-item disabled">
     		<a class="page-link" href="" tabindex="-1">처음</a>
    	</li>
  	</c:when>
  	<c:otherwise>
  		<li class="page-item">
     		<a class="page-link" href="/board/page=${nowPage - 1}" tabindex="-1">이전</a>
    	</li>
  	</c:otherwise>
    
  </c:choose>
    
    <c:forEach begin="${startPage}" end="${endPage}" var="i">
    	<c:choose>
    		<c:when test="${nowPage == i}">
    			 <li class="page-item disabled"><a class="page-link" href="/board?page=${i-1}">${i}</a></li>
    		</c:when>
    		<c:otherwise>
    			 <li class="page-item"><a class="page-link" href="/board?page=${i-1}">${i}</a></li>
    		</c:otherwise>
    	</c:choose>
   
    </c:forEach>
    
    <c:choose>
	  	<c:when test="${list.last}">
	  		<li class="page-item disabled">
	      <a class="page-link" href="/board/page=${endPage}">마지막</a>
	    </li>
	  	</c:when>
	  	<c:otherwise>
	  		<li class="page-item">
		      <a class="page-link" href="/board/page=${nowPage + 1}">마지막</a>
		    </li>
	  	</c:otherwise>
    </c:choose>
 
    
  </ul>
</nav>


<script type="text/javascript">
	
</script>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>