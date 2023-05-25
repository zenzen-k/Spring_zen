<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- boardDelete.jsp -->

<%@ include file="../common/common.jsp" %>
<%@ include file="../color.jsp" %>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/style.css">
<style type="text/css">
	body, table{
		text-align: center;
		background-color: #e0ffff;
	}
	table{
		margin: auto;
		width: 350px;
		height: 50px;
	}
	tr:nth-child(odd) {
		background-color: #b0e0e6;
	}
	td{
		height: 30px;
	}
	.err{
		color: red;
		font-size: 10px;
		font-weight: bold;
	}
</style>

<b>글삭제</b>
<form:form commandName="boardBean" action="delete.br" method="post">
<input type="hidden" name="num" value="${param.num}">
<input type="hidden" name="pageNumber" value="${param.pageNumber}">
<table>
	<tr>
		<td><B>비밀번호를 입력해 주세요.</B></td>
	</tr>
	
	<tr>
		<td>
			비밀번호 : <input type="password" name="passwd" size="10">
			<form:errors cssClass="err" path="passwd"/>	
		</td>
	</tr>
	
	<tr>
		<td>
			<input type="submit" value="글삭제">
			<input type="button" value="글목록" onclick="location.href='list.br?pageNumber=${param.pageNumber}'">
		</td>
	</tr>
</table>
</form:form>
