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

<!-- 검색한 레코드 개수일수있고 전체 일수도 있다. -->
<h2 align="center">상품 리스트 화면(전체 레코드 수 : ${pageInfo.totalCount})</h2>
<center>
	<form action="" method="get">
		<!-- 
			whatColumn = title
			whatColumn = singer
			
			keyword = 입력한 값. 검색할 ㅇㅇ 
			keyword = 마
			keyword = 이
		 -->
		<select name="whatColumn">
			<option value="">전체검색</option>
			<option value="title">노래제목</option>
			<option value="singer">가수명</option>
		</select>
		<input type="text" name="keyword">
		<input type="submit" value="검색">
	</form>

	<table border="">
		<tr>
			<td colspan="7" align="right">
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
			<td>수정</td>
		</tr>
		<c:forEach var="alist" items="${albumLists}">
			<tr>
				<td>${alist.num}</td>
				<td><a href="detail.ab?num=${alist.num}">${alist.title}</a></td>
				<td>${alist.singer}</td>
				<td>${alist.price}</td>
				<td>
					<fmt:parseDate value="${alist.day}" var="day" pattern="yyyy-MM-dd"/>
					<fmt:formatDate var="fNewDay" value="${day}" pattern="yyyy-MM-dd"/>
				</td>
				<td><a href="delete.ab?num=${alist.num}">삭제</a></td>
				<td><a href="update.ab?num=${alist.num}">수정</a></td>
			</tr>
		</c:forEach>
	</table>
</center>

<center>
	${pageInfo.pagingHtml} <!-- getPagingHtml 메서드 호출함! -->
	<!-- 1 2 3 4 5 [다음] -->
</center>