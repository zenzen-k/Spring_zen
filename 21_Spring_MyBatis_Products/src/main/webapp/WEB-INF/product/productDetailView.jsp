<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<style>
	table{
		border-collapse: collapse;
		width: 60%;
	}
	td{
		padding: 10px;
	}
	th{
		background-color:#B0DBF4;
	}
	.err{
		color:red;
		font-weight: bold;
	}
</style>
<center>
productDetail.jsp<br>

<h2>상품 상세 화면(<%=request.getContextPath() %>)</h2>
<!-- C:\Users\user\Downloads\spring-tool-suite-3.9.17.RELEASE\sts-bundle\pivotal-tc-server\instances\Spring3\wtpwebapps\20_Spring_MyBatis_Products -->
<table border="1">
	<tr>
		<td rowspan="6">
			<img src="<%=request.getContextPath() %>/resources/${product.image}" width="100" height="100">
		</td>
		<th width="150px">상품명</th>
		<td>${product.name}</td>
	</tr>
	<tr>
		<th>가격</th>
		<td>${product.price}</td>
	</tr>
	<tr>
		<th>재고 수량</th>
		<td>${product.stock}</td>
	</tr>
	<tr>
		<th>설명</th>
		<td>${product.contents}</td>
	</tr>
	<tr>
		<th>주문 수량</th>
		<td>
			주문 수량
			<input type="text" name="">
			<input type="button" value="주문">
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="button" value="상품 리스트" onClick="location.href='list.prd?pageNumber=${param.pageNumber}'">
		</td>
	</tr>
</table>
</center>