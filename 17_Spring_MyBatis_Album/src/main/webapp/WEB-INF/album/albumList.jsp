<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>

<script>
	function insert() {
		//alert(1);
		location.href="insert.ab";
	}

</script>


albumList.jsp<br>

<form>
	<table border="">
		<tr>
			<td colspan="6" align="right">
				<input type="button" value="추가하기" onclick="insert()">
			</td>
		</tr>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>가수</td>
			<td>가격</td>
			<td>발매일</td>
			<td>삭제</td>
		</tr>
		<c:forEach var="alist" items="${albumLists}">
			<tr>
				<td>${alist.num}</td>
				<td><a href="detail.ab?num=${alist.num}">${alist.title}</a></td>
				<td>${alist.singer}</td>
				<td>${alist.price}</td>
				<td>${alist.day}</td>
				<td><a href="delete.ab?num=${alist.num}">삭제</a></td>
			</tr>
		</c:forEach>
	</table>
</form>