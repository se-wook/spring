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
<link rel="stylesheet" type="text/css" href="css/basic.css" />

</head>
<body>
	<div class="main" id="viewBoard">
		<form id="frm">
			<input type="hidden" name="no" id="no" value='' />

			<input type="hidden" name="query" id="query" />
			<table border="1" width='400'>
				<tr>
					<th colspan="4">게시글 보기</th>
				</tr>
				<tbody>
					<tr>
						<td width='100'>
							<label for="title">제목</label>
						</td>
						<td colspan="3"></td>
					</tr>
					<tr>
						<td>글쓴이</td>
						<td></td>
						<td>게시일</td>
						<td></td>
					</tr>
					<tr>
						<td colspan="4" valign="top" height="200">
							<pre></pre>
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="4" align="center">
							<a href="#" onclick="listBoard()">목록</a>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</body>
<script type="text/javascript">
<!-- TODO: 13-2 updateForm(), deleteBoard(), listBoard() 함수를 구현하시오. -->
	// @@ updateBoardForm() 호출 시 form의 action을 updateBoardForm.do로 변경 후 submit 한다. 	
	// @@ deleteBoard() 호출 시 form의 action을 deleteBoard.do로 변경 후 submit 한다.
	// @@ listBoard() 호출 시 request의 queryString을 이용해서 listBoard.do를 호출한다.
<!-- END: -->
	function listBoard() {
		let target = "listBoard.do?${pageContext.request.queryString}"
		location.href=target;
	}
</script>
</html>






















