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
<h1 align='center'> Welcome to SSAFY </h1>
<hr>
	<div class="main">
		<table	align='center'>
			<tr align="center">
				<td width="50">시리얼</td>
				<td width="150">상품명</td>
				<td width="50">가격</td>
				<td width="100">설명</td>
			</tr>
			<tbody id="data-container">
				<c:forEach	items="${list}"	var='product'>
					<tr>
					  <td>${product.num}</td>
					  <td>${product.title}</a></td>
					  <td>${product.price}</td>
					  <td>${product.description}</td>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div align="center">
		<a href="insertProduct.jsp">상품 등록하기</a>
	</div>
</body>
</html>













