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
<h1 style="font-size: 400%">상품등록</h1>

<form method="post" action="productInsert.do" onsubmit="if(this.id.value != '' && this.name.value != '') return true; else{alert('아이디와 상품명은 필수입력입니다.'); return false;}">
	<p>	<span>아이디</span><input type="text" name="no" id="no"/>
		<span>상품명</span><input type="text" name="name" id="name"/>
	</p>
	<p>
		<span>가격</span><input type="number" name="price" id="price" min=0 value="0"/>
		<span>설명</span><input type="text" name="info" id="info"/>
		<input type="submit" value="제출"/>
</p>
</form>
<p><a href="productList.do">목록보기</a></p>
</body>
</html>




