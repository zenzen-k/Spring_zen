<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
<style>
	.err{
		color: red;
		font-size: 10px;
		font-weight: bold;
	}
</style>

<h2 align="center">상품 수정 화면<br>(ProductUpdateForm.jsp)</h2>
<center>
<form:form commandName="product" action="update.prd" method="post" enctype="multipart/form-data">
	<input type="hidden" name="num" value="${product.num}">
	<input type="hidden" name="pageNumber" value="${param.pageNumber}">
	<table border="1">
		<tr>
			<th>*상품명</th>
			<td>
				<input type="text" name="name" id="name" value="${product.name}">
				<form:errors cssClass="err" path="name"/>
			</td>
		</tr>
		<tr>
			<th>제조 회사</th>
			<td>
				<input type="text" name="company" id="company" value="${product.company}">
			</td>
		</tr>
		<tr>
			<th>*가격</th>
			<td>
				<input type="text" name="price" id="price"  value="${product.price}">
				<form:errors cssClass="err" path="price"/>
			</td>
		</tr>
		<tr>
			<th>재고 수량</th>
			<td>
				<input type="text" name="stock" id="stock" value="${product.stock}">
			</td>
		</tr>
		<tr>
			<th>적립 포인트</th>
			<td>
				<input type="text" name="point" id="point" value="${product.point}">
			</td>
		</tr>
		<tr>
			<th>*설명</th>
			<td>
				<input type="text" name="contents" id="contents" value="${product.contents}">
				<form:errors cssClass="err" path="contents"/>
			</td>
		</tr>
		<tr>
			<th>*그림 파일</th>
			<td>
				<img src="<%=request.getContextPath()%>/resources/${product.image}" width="100" height="100">
				<br>
				<input type="file" name="upload" id="upload">
				<input type="hidden" name="upload2" value="${product.image}">
				<form:errors cssClass="err" path="image"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="수정하기">
			</td>
		</tr>
	</table>
</form:form>
</center>