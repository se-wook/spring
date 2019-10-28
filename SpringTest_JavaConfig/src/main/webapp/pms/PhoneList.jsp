<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width=780 border=0 cellpadding=0 cellspacing=0>
	<tr>
	  <td width="20"></td>
	  <td>
  <!--contents-->
	  <table width=590 border=0 cellpadding=0 cellspacing=0>
		  <tr>
			<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>핸드폰 관리 - 핸드폰 등록</b></td>
		  </tr>
	  </table>  
	  <br>
	  
	  <!-- write Form  -->
	  <form method="post" action="deletePhone.do">
	  <table border="0" cellpadding="0" cellspacing="1" width="600" bgcolor="BBBBBB">
		  <tr>
			<td width='100' align=center bgcolor="E6ECDE" height="22">모델번호</td>
			<td width='200' align=center bgcolor="E6ECDE" height="22">모델이름</td>
			<td width='100' align=center bgcolor="E6ECDE" height="22">가격</td>
			<td width='100' align=center bgcolor="E6ECDE" height="22">제조사명</td>
			<td width='100' align=center bgcolor="E6ECDE" height="22">삭제</td>

		  </tr>
		  <c:forEach items="${list }" var="phone">
		  	<tr>
		  		<td><a href='search.do?num=${phone.num }'>${phone.num }</a></td>
		  		<td>${phone.model }</td>
		  		<td>${phone.price }</td>
		  		<td>${phone.vcode }</td>
		  		<td><input type='checkbox' name='num' value='${phone.num }'/></td>
		  	</tr>
		  </c:forEach>	  
	  </table>
		<table>
	  		<tr>
		  		<td align="center" colspan="5">
		  			<a href="regPhone.do">추가등록</a>
		  			<input type='submit' value='선택항목 삭제'/>
		  		</td>
		  	</tr>
  	</table>
	  <br>
	  </form>
	  </td>
	</tr>
</table>  
</body>
</html>