<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/basic.css" rel="stylesheet" type="text/css" /> 

<script type="text/javascript" src="js/jquery-1.10.1.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
<h1 align='center'> Welcome to SSAFY </h1>
<hr>
<form method="post" action="productInsert.do" >
	<table align='center'>
		<caption><h3>상품 등록</h3></caption>
		<tbody>
			<tr height="50">
				<td><label for="num">시리얼</label></td>
			    <td><input type="text" name="num" id="num"/></td>
			</tr>
			<tr height="50">
				<td><label for="title">상품명</label></td>
			    <td><input type="text" name="title" id="title"/></td>
			</tr>
			<tr height="50">
				<td><label for="category">카테고리</label></td>
			    <td><input type="text" name="category" id="category"/></td>
			</tr>
			<tr height="50">
				<td><label for="price">가격</label></td>
			    <td><input type="text" name="price" id="price"/></td>
			</tr>
			<tr height="50">
				<td><label for="description">설명</label></td>
			    <td><input type="text" name="description" id="description"/></td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="제출"/>
				</td>
			</tr>
		</tfoot>
	</table>
</form>
</body>
</html>