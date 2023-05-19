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
productInsertForm.jsp<br>

<!-- ServletContext application = new ServletContext() -->
<!-- 
ServletContext 객체를 관리하는 참조변수. 프로젝트 당 하나만 만들어지며, 프로젝트 전반에 걸쳐 사용될 설정을 할 수 있다.
jsp 에서는 application, 자바에서는 ServletContext
 -->
<%
	application.getAttribute("A");
%>
<h2>상품 추가 화면</h2>
<form:form commandName="product" action="insert.prd" method="post" enctype="multipart/form-data">
	<p>
		<label for="name">*상품명</label>
		<input type="text" name="name" id="name" value="${product.name}">
		<form:errors cssClass="err" path="name"/>
	</p>
	
	<p>
		<label for="company">제조 회사</label>
		<input type="text" name="company" id="company" value="${product.company}">
	</p>
	
	<p>
		<label for="price">*가격</label>
		<input type="text" name="price" id="price"  value="${product.price}">
		<form:errors cssClass="err" path="price"/>
	</p>
	
	<p>
		<label for="stock">재고 수량</label>
		<input type="text" name="stock" id="stock" value="${product.stock}">
	</p>
	
	<p>
		<label for="point">적립 포인트</label>
		<input type="text" name="point" id="point" value="${product.point}">
	</p>
	
	<p>
		<label for="contents">*설명</label>
		<input type="text" name="contents" id="contents" value="${product.contents}">
		<form:errors cssClass="err" path="contents"/>
	</p>
	
	<p>
		<label for="upload">*상품 이미지</label>
		<input type="file" name="upload" id="upload">
		<form:errors cssClass="err" path="image"/>
	</p>
	
	<p>
		<label for="inputdate">입고 일자</label>
		<input type="date" name="inputdate" id="inputdate" value="${product.inputdate}">
	</p>
	
	<p>
		<input type="submit" value="추가하기">
	</p>
</form:form>