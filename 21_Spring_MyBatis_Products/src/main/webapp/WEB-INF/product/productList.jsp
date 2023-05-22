<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>

<%
// 자동생성됨
//HttpSession session = new HttpSession();
//session.getAttribute("name");
%>

<h2 align="center">상품 리스트 화면<br>
productList.jsp</h2>

<center>
	<form action="list.prd">
		<select name="whatColumn">
			<option value="">전체검색
			<option value="name">상품명
			<option value="contents">설명
		</select>
		<input type="text" name="keyword">
		<input type="submit" value="검색">
	</form>
</center>

<center>
	<table border="1">
		<tr>
			<td colspan="6" align="right">
				<input type="button" value="추가하기" onclick="location.href='insert.prd'">
			</td>
		</tr>
		<tr>
			<th>상품번호</th>
			<th>상품명</th>
			<th>설명</th>
			<th>가격</th>
			<th>삭제</th>
			<th>수정</th>
		</tr>
		
		<c:if test="${empty productLists}">
			<tr>
				<td colspan="6" align="center">등록된 상품이 없습니다.</td>
			</tr>
		</c:if>
		
		<c:if test="${not empty productLists}">
			<c:forEach var="product" items="${productLists}">
				<tr>
					<td align="center">${product.num}</td>
					<td align="center">
						<a href="detail.prd?num=${product.num}&pageNumber=${pageInfo.pageNumber}">${product.name}</a>
					</td>
					<td>${product.contents}</td>
					<td align="right">${product.price}</td>
					<td align="center">
						<a href="delete.prd?num=${product.num}&pageNumber=${pageInfo.pageNumber}">삭제</a>
					</td>
					<td align="center">
						<a href="update.prd?num=${product.num}&pageNumber=${pageInfo.pageNumber}">수정</a>
					</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</center>

<center>
	${pageInfo.pagingHtml}
</center>