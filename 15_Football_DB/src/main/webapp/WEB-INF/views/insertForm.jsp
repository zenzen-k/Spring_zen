<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<style>
	.err{
		color: red;
		font-weight: bold;
		font-size: 10px;
	}
</style>

insertForm.jsp<br>

<form:form commandName="fDto" action="insert" method="post">
	<table border="1">
		<tr>
			<td>아이디</td>
			<td>
				<input type="text" name="id" value="${fDto.id}">
				<form:errors cssClass="err" path="id"/>
			</td>
		</tr>
		<tr>
			<td>비번</td>
			<td>
				<input type="text" name="pw" value="${fDto.pw}">
				<form:errors cssClass="err" path="pw"/>
			</td>
		</tr>
		<tr>
			<td>우승예상국가</td>
			<td>
				<input type="radio" name="win" value="한국" <c:if test="${fDto.win eq '한국'}">checked</c:if>>한국
				<input type="radio" name="win" value="미국" <c:if test="${fDto.win eq '미국'}">checked</c:if>>미국
				<input type="radio" name="win" value="독일" <c:if test="${fDto.win eq '독일'}">checked</c:if>>독일
				<input type="radio" name="win" value="스페인" <c:if test="${fDto.win eq '스페인'}">checked</c:if>>스페인
				<form:errors cssClass="err" path="win"/>
			</td>
		</tr>
		<tr>
			<td>16강 예상국가</td>
			<td>
				<c:forEach var="fd" items="한국,독일,브라질,잉글랜드,이탈리아,네덜란드,이란">
					<input type="checkbox" name="round16" value="${fd}" <c:if test="${fn:contains(fDto.round16, fd)}">checked</c:if>>${fd}
				</c:forEach>
			
				<!-- 
				<input type="checkbox" name="round16" value="한국" <c:if test="${fn:contains(fDto.round16, fd)}">checked</c:if>>한국
				<input type="checkbox" name="round16" value="독일" <c:if test="${fn:contains(fDto.round16, fd)}">checked</c:if>>독일
				<input type="checkbox" name="round16" value="브라질" <c:if test="${fn:contains(fDto.round16, fd)}">checked</c:if>>브라질
				<input type="checkbox" name="round16" value="잉글랜드" <c:if test="${fn:contains(fDto.round16, fd)}">checked</c:if>>잉글랜드
				<input type="checkbox" name="round16" value="이탈리아" <c:if test="${fn:contains(fDto.round16, fd)}">checked</c:if>>이탈리아
				<input type="checkbox" name="round16" value="네덜란드" <c:if test="${fn:contains(fDto.round16, fd)}">checked</c:if>>네덜란드
				<input type="checkbox" name="round16" value="이란" <c:if test="${fn:contains(fDto.round16, fd)}">checked</c:if>>이란
				 -->
				<form:errors cssClass="err" path="round16"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="입력">
			</td>
		</tr>
	</table>
</form:form>