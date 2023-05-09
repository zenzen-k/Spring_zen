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

<%
	String[] winarr = {"한국","미국","독일","스페인"};
	String[] round16arr = {"한국","독일","브라질","잉글랜드","이탈리아","네덜란드","이란"};
%>

updateForm.jsp<br>


<form:form commandName="fDto" action="update" method="post">
	<input type="hidden" name="num" value="${fDto.num}">
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
			<td>우승 예상국가</td>
			<td>
				<c:forEach var="winarr" items="<%=winarr%>">
					<input type="radio" name="win" value="${winarr}" <c:if test="${fDto.win eq winarr}">checked</c:if>>${winarr}
				</c:forEach>
				<form:errors cssClass="err" path="win"/>
			</td>
		</tr>
		<tr>
			<td>16강 예상국가</td>
			<td>
				<c:forEach var="round" items="<%=round16arr%>">
					<input type="checkbox" name="round16" value="${round}" <c:if test="${fn:contains(fDto.round16, round)}">checked</c:if>>${round}
				</c:forEach>
				<form:errors cssClass="err" path="round16"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="수정">
				<input type="button" value="초기화" onclick="location.href='update?num=${fDto.num}'">
			</td>
		</tr>
	</table>
</form:form>
