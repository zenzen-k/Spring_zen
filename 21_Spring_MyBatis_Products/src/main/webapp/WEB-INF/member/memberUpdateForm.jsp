<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
<style>
	.err{
		color: red;
		font-size: 10px;
		font-weight: bold;
	}
</style>

<%
	String[] genderArr = {"남자", "여자"};
	String[] hobbyArr = {"마라톤", "영화감상", "게임", "공부"};
%>
<h2 align="center">회원 수정 화면(memberUpdateForm.jsp)</h2>

<center>
	<form:form commandName="member" action="update.mb" method="post">
		<input type="hidden" name="pageNumber" value="${param.pageNumber}">
		<input type="hidden" name="id" value="${member.id}">
		<table border="1">
			<tr>
				<th>아이디</th>
				<td>
					<%-- <input type="text" name="id" value="${member.id}" disabled> 
					-> disabled는 submit 불가넝
					--%>
					<%-- <input type="text" name="id" value="${member.id}" readonly>  --%>
					${member.id}
				</td>
			</tr>
			<tr>
				<th>비번</th>
				<td>
					<input type="text" name="password" value="${member.password}">
					<form:errors cssClass="err" path="password"/>
				</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>
					<input type="text" name="name" value="${member.name}">
					<form:errors cssClass="err" path="name"/>
				</td>
			</tr>
			<tr>
				<th>성별</th>
				<td>
					<c:forEach var="gen" items="<%=genderArr%>">
						<input type="radio" name="gender" value="${gen}" <c:if test="${gen eq member.gender}">checked</c:if>>${gen}
					</c:forEach>
					<form:errors cssClass="err" path="gender"/>
				</td>
			</tr>
			<tr>
				<th>취미</th>
				<td>
					<c:forEach var="ho" items="<%=hobbyArr%>">
						<input type="checkbox" name="hobby" value="${ho}" <c:if test="${fn:contains(member.hobby, ho)}">checked</c:if>>${ho}
					</c:forEach>
					<form:errors cssClass="err" path="hobby"/>
				</td>
			</tr>
			<tr>
				<th>주소1</th>
				<td>
					<input type="text" name="address1" value="${member.address1}">
					<form:errors cssClass="err" path="address1"/>
				</td>
			</tr>
			<tr>
				<th>주소2</th>
				<td>
					<input type="text" name="address2" value="${member.address2}">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="수정하기">
				</td>
			</tr>
		</table>
	</form:form>
</center>