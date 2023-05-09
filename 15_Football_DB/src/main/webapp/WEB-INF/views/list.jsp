<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
list.jsp<br>

<table border="1">
	<tr>
		<td>번호</td>
		<td>아이디</td>
		<td>비밀번호</td>
		<td>우승예상국가</td>
		<td>16강 예상국가</td>
		<td>삭제</td>
	</tr>
	<c:forEach var="fd" items="${lists}">
		<tr>
			<td>${fd.num}</td>
			<td><a href="update?num=${fd.num}">${fd.id}</a></td>
			<td>${fd.pw}</td>
			<td>${fd.win}</td>
			<td>${fd.round16}</td>
			<td><a href="delete?num=${fd.num}">삭제</a></td>
		</tr>
	</c:forEach>
</table>


<br><br>
<a href="insert">삽입</a>