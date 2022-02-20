<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<div class="jumbotron mt-4 bg-white border">
	<div class="container" style="width: 100%">
	<h1 class="text-center">사진첩 게시판</h1>
		<div class="d-flex mt-5">
		
			<c:forEach items="${photo.content}" var="photo">
			<div class="card ml-1">
				<img class="card-img-top img-thumbnail" style="width: 200px; height: 150px;" src="/upload/${photo.postImageUrl}"/>
				<div class="card-body">
					<h5 class="card-title"><a href="/photo/${photo.id}">${photo.title}</a></h5>
					<p class="card-text">${photo.content}</p>
				</div>
			</div>
			</c:forEach>
			
		</div>
	</div>

</div>


<div class="text-right float-right">
	<a href="<c:url value="/photo/photoForm"/>"><button
			class="btn btn-secondary">글쓰기</button></a>
</div>

<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center">
  
  <c:choose>
  
  	<c:when test="${nowPage == startPage}">
  		<li class="page-item disabled">
     		<a class="page-link" href="/photo?page=${startPage - 1}" tabindex="-1">이전</a>
    	</li>
  	</c:when>
  	<c:otherwise>
  		<li class="page-item">
     		<a class="page-link" href="/photo?page=${startPage - 1}" tabindex="-1">이전</a>
    	</li>
  	</c:otherwise>
    
  </c:choose>
    
    <c:forEach begin="${startPage}" end="${endPage}" var="i">
    	<c:choose>
    		<c:when test="${nowPage == i}">
    			 <li class="page-item disabled"><a class="page-link" href="/photo?page=${i-1}">${i}</a></li>
    		</c:when>
    		<c:otherwise>
    			 <li class="page-item"><a class="page-link" href="/photo?page=${i-1}">${i}</a></li>
    		</c:otherwise>
    	</c:choose>
   
    </c:forEach>
    
    <c:choose>
	  	<c:when test="${endPage == nowPage}">
	  		<li class="page-item disabled">
	      	  <a class="page-link" href="/photo?page=${endPage - 1}">다음</a>
	    	</li>
	  	</c:when>
	  	<c:otherwise>
	  		<li class="page-item">
		      <a class="page-link" href="/photo?page=${endPage - 1}">다음</a>
		    </li>
	  	</c:otherwise>
	  	
    </c:choose>
    
  </ul>
</nav>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>