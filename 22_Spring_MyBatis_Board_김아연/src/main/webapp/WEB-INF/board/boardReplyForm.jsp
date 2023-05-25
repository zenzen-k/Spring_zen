<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- boardReplyForm.jsp -->
<%@ include file="../common/common.jsp" %>
<%@ include file="../color.jsp" %>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/style.css">
<style>
	body{
		text-align: center;
		background-color: #e0ffff;
	}
	table{
		margin: auto;
		width: 650px;
	}
	td:nth-child(1) {
		text-align: center;
		background-color: #b0e0e6;
	}
	tr:first-child td:first-child{
		text-align: right;
	}
	.err{
		color: red;
		font-size: 10px;
		font-weight: bold;
	}
</style>

<b>답글쓰기</b>
<form:form commandName="board" method="post" action="reply.br">
<input type="hidden" name="pageNumber" value="${pageNumber}">
<input type="hidden" name="ref" value="${ref}">
<input type="hidden" name="restep" value="${restep}">
<input type="hidden" name="relevel" value="${relevel}">
	<table>
		<tr>
			<td colspan="2">
				<a href="list.br">글목록</a>
			</td>
		</tr>
		
		<tr>
			<td>이 름</td>
			<td>
				<input type="text" name="writer" size="60" value="${board.writer}">
				<form:errors cssClass="err" path="writer"/>
			</td>
		</tr>
		
		<tr>
			<td>제 목</td>
			<td>
				<input type="text" name="subject" size="80" value="${board.subject}">
				<form:errors cssClass="err" path="subject"/>
			</td>
		</tr>
		
		<tr>
			<td>Email</td>
			<td>
				<input type="text" name="email" size="80" value="${board.email}">
			</td>
		</tr>
		
		<tr>
			<td>내 용</td>
			<td>
				<textarea rows="20" cols="75" name="content">${board.content}</textarea>
				<form:errors cssClass="err" path="content"/>
			</td>
		</tr>
		
		<tr>
			<td>비밀번호</td>
			<td>
				<input type="password" name="passwd">
				<form:errors cssClass="err" path="passwd"/>
			</td>
		</tr>
		
		<tr height="30">
			<td colspan="2" align="center" >
				<input type="submit" value="글쓰기">
				<input type="reset" value="다시작성">
				<input type="button" value="목록보기" onclick="location.href='list.br'">
			</td>
		</tr>
	</table>
</form:form>