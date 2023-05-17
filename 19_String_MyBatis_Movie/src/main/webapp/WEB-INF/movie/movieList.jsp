<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>

<script>
	function up(num, pageNumber) {
		location.href="update.mv?num=" + num + "&pageNumber=" + pageNumber;
	}
	function del(num, pageNumber) {
		location.href="delete.mv?num=" + num + "&pageNumber=" + pageNumber;
	}
</script>

movieList.jsp<br>

<h2 align="center">영화 정보 리스트 화면(${pageInfo.totalCount})</h2>
<center>
	<form action="list.mv" method="get">
		<select name="whatColumn">
			<option value="">전체 검색
			<option value="genre">장르
			<option value="grade">등급
			<option value="actor">배우
		</select>
		
		<input type="text" name="keyword">
		<input type="submit" value="검색">
	</form>
</center>

<center>
<table border="1" align="center">
	<tr>
		<td colspan="9" align="right">
			<input type="button" value="추가하기" onclick="location.href='insert.mv'">
		</td>
	</tr>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>대륙</th>
		<th>제작국가</th>
		<th>장르</th>
		<th>등급</th>
		<th>출연배우</th>
		<th>삭제</th>
		<th>수정</th>
	</tr>
	
	<c:if test="${empty list}">
		<tr>
			<td colspan="9" align="center">검색결과가 없습니다.</td>
		</tr>
	</c:if>
	
	<c:forEach var="list" items="${list}">
		<tr>
			<td>${list.num}</td>
			<td><a href='detail.mv?num=${list.num}&pageNumber=${pageInfo.pageNumber}'>${list.title}</a></td>
			<td>${list.continent}</td>
			<td>${list.nation}</td>
			<td>${list.genre}</td>
			<td>${list.grade}</td>
			<td>${list.actor}</td>
			<td>
				<input type="button" value="삭제" onclick="del('${list.num}','${pageInfo.pageNumber}')">
			</td>
			<td>
				<input type="button" value="수정" onclick="up('${list.num}','${pageInfo.pageNumber}')">
			</td>
		</tr>
	</c:forEach>
</table>
</center>

<center>
	${pageInfo.pagingHtml}
</center>