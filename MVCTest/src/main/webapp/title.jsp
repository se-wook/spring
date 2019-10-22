<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
#private {
	width: 100%;
	text-align: right
}

#head {
	display: flex;
	width: 100%;
	align-items: center;
}

#head>#title {
	width: 80%;
	text-align: center;
}
</style>
<c:url value="/" var="ctx"></c:url>
<div id="head">
	<div id="logo">
		<img src="${ctx }/images/logo.png" />
	</div>
	<div id="title">
		<h1>Board Manager</h1>
		<nav id="private">
			<ul>
				<!-- TODO: 03 id 속성의 여부에 따라 id가 없을 경우 loginform.do, 있을 경우 logout.log와 memberUpdateForm.log를 호출할 수 있는 링크를 구성하시오. -->
				
				<%-- <%
					String id = (String) session.getAttribute("id");
					if(id == null){%>
						<a href="loginform.do">로그인폼</a>
				<%  } else {%>
						<a href="logout.log"> 로그아웃</a> <br/>
						<a href="memberUpdateForm.log">업데이트</a>
				<%  }
				
				%> --%>
				
				<c:choose>
					<c:when test="${empty id}">
						<li><a href="${ctx }loginform.do">로그인</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="${ctx }logout.do"> 로그아웃</a></li>
						<li><a href="${ctx }memberUpdateForm.log">회원정보 수정</a></li>
					</c:otherwise>
				</c:choose>
				
				
				<!-- END: -->
			</ul>
		</nav>
	</div>
</div>
<hr>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<!-- TODO: 01 el 영역에 메시지가 있으면 alert()으로 출력 후 메시지를 삭제하시오. -->

<script>
	<c:if test="${!empty msg}">
		alert('${msg}');
		<c:remove var='msg'></c:remove>
	</c:if>	
</script>




