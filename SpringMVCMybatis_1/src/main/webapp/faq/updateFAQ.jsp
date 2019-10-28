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
	<form method='post' action="updateFaq.do?no=${faq.no}">
		<input type='hidden' name='id'		value='${faq.id}'/>
		<table align='center'>
			<tr><td>번호</td><td>${faq.no}</td><tr/>
			<tr><td>제목</td><td><input type='text' name='title' value='${faq.title}'></td><tr/>
			<tr><td>등록일</td><td>${faq.regdate}</td><tr/>
			<tr><td>내용</td><td><input type='text' name='contents' value='${faq.contents}'></td><tr/>
			<c:if  test='${not empty faq.reply}'>
				<tr><td>답변</td><td>${faq.reply}</td><tr/>
			</c:if>
			<tr><td colspan='2'>
				<input type='submit' value='수정'/><a href="faqList.do">목록</a>
			</td><tr/>
		</table>
	</form>
</body>
</html>









