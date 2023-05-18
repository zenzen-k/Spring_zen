<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
gameList.jsp<br>

<h2 align="center">게임 목록 보기</h2>
<center>
	<form action="list.gm">
		<select name="whatColumn">
			<option value="">전체 검색
			<option value="title">제목
			<option value="company">회사
			<option value="genre">장르
		</select>
		<input type="text" name="keyword">
		<input type="submit" value="검색">
	</form>
</center>

<center>
	<table border="1">
		<tr>
			<td colspan="9" align="right">
				<input type="button" value="추가하기" onclick="location.href='insert.gm'">
			</td>
		</tr>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>개발회사</th>
			<th>플랫폼</th>
			<th>장르</th>
			<th>연령제한</th>
			<th>가격</th>
			<th>삭제</th>
			<th>수정</th>
		</tr>
		
		<c:if test="${empty lists}">
			<tr>
				<td colspan="9">데이터가 없습니다.</td>
			</tr>
		</c:if>
		
		<c:if test="${not empty lists}">
		<c:forEach var="gameBean" items="${lists}">
			<tr>
			<td>${gameBean.num}</td>
			<td>
				<a href="detail.gm?num=${gameBean.num}&pageNumber=${pageInfo.pageNumber}">${gameBean.title}</a>
			</td>
			<td>${gameBean.company}</td>
			<td>${gameBean.platform}</td>
			<td>${gameBean.genre}</td>
			<td>${gameBean.grade}</td>
			<td>
				<c:if test="${gameBean.price == 0}">무료</c:if>
				<c:if test="${gameBean.price != 0}">${gameBean.price}원</c:if>
			</td>
			<td>
				<a href="delete.gm?num=${gameBean.num}&pageNumber=${pageInfo.pageNumber}">삭제</a>
			</td>
			<td>
				<a href="update.gm?num=${gameBean.num}&pageNumber=${pageInfo.pageNumber}">수정</a>
			</td>
		</tr>
		</c:forEach>
		</c:if>
	</table>
</center>

<center>
	${pageInfo.pagingHtml}
</center>