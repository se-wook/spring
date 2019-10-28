<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록과 등록</title>
<link href="css/basic.css" rel="stylesheet" type="text/css" /> 
</head>
<body style="text-align: center">
<h1 style="font-size: 400%">상품목록</h1>
	<div class="main">
		<table align='center'>
			<tr align="center">
				<td width="200">아이디</td>
				<td width="200">이름</td>
				<td width="150">가격</td>
				<td width="250">상품설명</td>
			</tr>
			<tbody id="data-container">
				<c:forEach items="${list}" var='product'>
					<tr align="center">
						<td>${product.no}</td>
						<td>${product.name}</td>
						<td>${product.price}</td>
						<td>${product.info}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<p style="text-align: left;"><a href="productReg.do">새 상품 등록</a></p>
</body>
</html>




