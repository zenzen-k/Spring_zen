<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
list.jsp<br>

<table border="1">
	<tr>
		<td>번호</td>
		<td>아이디</td>
		<td>이름</td>
		<td>나이</td>
		<td>삭제</td>
	</tr>
	
	<c:forEach var="plist" items="${plist}">
		<tr>
			<td>${plist.num}</td>
			<td><a href="updateForm?num=${plist.num}">${plist.id}</a></td>
			<td>${plist.name}</td>
			<td>${plist.age}</td>
			<td><a href="delete">삭제</a></td>
		</tr>
	</c:forEach>
</table>
<br>

<!-- WEB-INF의 jsp 파일들은 컨트롤러 통해서만 가야해서 .jsp로 갈 수 없다. -->
<!-- 따라서 write_Form.jsp가 아닌 컨트롤러 writeForm 요청함 -->
<a href="writeForm">삽입</a>