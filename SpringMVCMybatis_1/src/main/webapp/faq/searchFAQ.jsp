<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table align='center'>
		<tr><td>번호</td><td>${faq.no}</td><tr/>
		<tr><td>제목</td><td>${faq.title}</td><tr/>
		<tr><td>등록일</td><td>${faq.regdate}</td><tr/>
		<tr><td>내용</td><td>${faq.contents}</td><tr/>
		<c:if  test='${not empty faq.reply}'>
			<tr><td>답변</td><td>${faq.reply}</td><tr/>
		</c:if>
		<tr><td colspan='2'><a href="faqList.do">목록</a></td><tr/>
	</table>
</body>
</html>









