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
<jsp:include page="/welcome.jsp" />
	<article id="content">
		<jsp:include page="/product/productReg.jsp" />
	</article>
</body>
</html>




