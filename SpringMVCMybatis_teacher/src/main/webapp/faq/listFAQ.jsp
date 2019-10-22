<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<title>Board Project</title>
<style type="text/css">
	.boardSub { display: none;}
	.boardView{ display: block;}
</style>
<link rel="stylesheet" type="text/css" href="css/basic.css" />
<link rel="stylesheet" type="text/css" href="https://pagination.js.org/dist/2.1.4/pagination.css">
<script type="text/javascript"  src="js/jquery-3.3.1.js"></script>
</head>
<body>
	<div class="main">
		<table	align='center'>
			<tr align="center">
				<td width="50">번 호</td>
				<td width="150">제 목</td>
				<td width="50">아이디</td>
				<td width="100">게시일</td>
				<td width="50">수정</td>
				<td width="50">삭제</td>
			</tr>
			<tbody id="data-container">
				<c:forEach	items="${list}"	var='faq'>
					<tr>
					  <td>${faq.no}</td>
					  <td><a href="searchFaq.do?no=${faq.no}">${faq.title}</a></td>
					  <td>${faq.id}</td>
					  <td>${faq.regdate}</td>
					  <td><a href="updateFaqForm.do?no=${faq.no}">수정</a></td>
					  <td><a href="deleteFaq.do?no=${faq.no}">삭제</a></td>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>













