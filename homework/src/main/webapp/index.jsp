<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		
		<script type="text/javascript">
			$(function(){
				$('#listSearch').click(function(){
					console.log('LIST SEARCH');
					$.ajax({
						url: 'product',
						type: 'GET',
						contentType: "application/json; charset=UTF-8",
						dataType: 'json',
						success: listProductView,
						error: function(err){
							console.log(err);
						}
					})
				})
				$('#addProduct').click(function(){
					console.log('ADD PRODUCT');
					var primary = $('#num').val();
					if(primary == '') {
						alert("상품번호를 입력해주세요.");
					}
					else{
						$.ajax({
							url: 'product',
							type: 'POST',
							data: JSON.stringify({
								num:$('#num').val(),
								title:$('#title').val(),
								price:$('#price').val(),
								description:$('#desc').val()
							}),
							contentType: "application/json; charset=UTF-8",
							dataType: 'json',
							success: function(jdata, status, xhr){
								$('#num').val('');
								$('#title').val('');
								$('#price').val('');
								$('#desc').val('');
								$('#resultmsg').val('추가완료');
								//listProductView(jdata,status,xhr);
							},
							error: function(err){
								console.log(err);
							}
						})
					}
				})
				$('#updateProduct').click(function(){
					console.log('UPDATE PRODUCT');
					$.ajax({
						url: 'product',
						type: 'PUT',
						data: JSON.stringify({
							num:$('#num').val(),
							title:$('#title').val(),
							price:$('#price').val(),
							description:$('#desc').val()
						}),
						contentType: "application/json; charset=UTF-8",
						dataType: 'json',
						success: function(jdata, status, xhr){
							$('#num').val('');
							$('#title').val('');
							$('#price').val('');
							$('#desc').val('');
							$('#resultmsg').val('추가완료');
							//listProductView(jdata,status,xhr);
						},
						error: function(err){
							console.log(err);
						}
					})
				})
				$('#deleteProduct').click(function(){
					console.log('DELETE PRODUCT');
				})
			})
			function detail(id){
				//$('#result').css("display","block");
				$.ajax({
					url: 'product/'+id,
					type: 'GET',
					contentType: "application/json; charset=UTF-8",
					dataType: 'json',
					success: function(jdata,status,xhr){
						$('#num').val(id);
						$('#num').attr('readonly',true);
						$('#title').val(jdata.data.title);
						$('#price').val(jdata.data.price + "원");
						$('#desc').val(jdata.data.description);
					},
					error: function(err){
						console.log(err);
					}
				})
			}
			function listProductView(jdata,status, xhr){
				var data = jdata.data;
				console.log(data);
				var html = "";
				$.each(data, function(index, item){
					console.log(item.num);
					html += "<li onclick=detail('"+item.num+"') style="+'cursor:pointer'+">"+item.num+"</li>";
				})
				$(".unorderedList").html(html);
			}
			
		</script>
		<style type="text/css">
			.product_contents{
				padding-left:10px;
			}	
		</style>
	</head> 
	<body>
		<h1 align='center'>Welcome To SSAFY</h1>
		<hr>
		<h1>상품 관리</h1>
		<input type='button' value='목록조회' id='listSearch'> (상세 내용을 조회하기 위해서 목록의 아이템을 클릭하세요.)
		
		<div class="list">
			<ul class="unorderedList"></ul>
		</div>
		
		<div>
			<input type='button' value='추가' id='addProduct'>
			<input type='button' value='수정' id='updateProduct'>
			<input type='button' value='삭제' id='deleteProduct'>
		</div>
		
		<div class='product-form'>
			
		</div>
		
		
		
		<div class='product-info-result' id="result">
			<table width=780 border=0 cellpadding=0 cellspacing=0 style="padding-top:25px">
				<tr>
				  <td width="20"></td>
				  <td>
			  <!--contents-->
				  <table width=590 border=0 cellpadding=0 cellspacing=0>
					  <tr>
						<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>상품 조회</b></td>
					  </tr>
				  </table>  
				  <br>
				  <!-- write Form  -->
				  <table border="0" cellpadding="0" cellspacing="1" width="590" bgcolor="BBBBBB">
					  <tr>
						<td width=100 align=center bgcolor="E6ECDE" height="22">상품번호</td>
						<td width=490 bgcolor="ffffff" class="product_contents">
							<input type="text" id="num">
						</td>
					  </tr>
					  <tr>
						<td width=100 align=center bgcolor="E6ECDE" height="22">상 품 명</td>
						<td width=490 bgcolor="ffffff" class="product_contents">
							<input type="text" id="title">
						</td>
					  </tr>
					  <tr>
						<td width=100 align=center bgcolor="E6ECDE" height="22">가&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;격</td>
						<td width=490 bgcolor="ffffff" class="product_contents">
							<input type="text" id="price">
						
						</td>
					  </tr>
					  <tr>
						<td width=100 align=center bgcolor="E6ECDE" height="22">설명</td>
						<td width=490 bgcolor="ffffff" class="product_contents">
							<textarea id="desc"></textarea>
						</td>
					  </tr>		  
				  </table>
				  <br>
				  </td>
				</tr>
			</table>  
		</div>
		<div id="resultmsg"></div>
	</body>
</html>
