<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
gameDetailView.jsp<br>

<center>
<table border="1">
	<tr>
		<th>번호</th>
		<td>${game.num}</td>
	</tr>
	<tr>
		<th>제목</th>
		<td>${game.title}</td>
	</tr>
	<tr>
		<th>회사</th>
		<td>${game.company}</td>
	</tr>
	<tr>
		<th>기기</th>
		<td>${game.device}</td>
	</tr>
	<tr>
		<th>플랫폼</th>
		<td>${game.platform}</td>
	</tr>
	<tr>
		<th>장르</th>
		<td>${game.genre}</td>
	</tr>
	<tr>
		<th>등급</th>
		<td>${game.grade}</td>
	</tr>
	<tr>
		<th>가격</th>
		<td>
			<c:if test="${game.price == 0}">무료</c:if>
			<c:if test="${game.price != 0}">${gameBean.price}원</c:if>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<a href="list.gm?pageNumber=${param.pageNumber}">목록으로</a>
		</td>
	</tr>
</table>
</center>