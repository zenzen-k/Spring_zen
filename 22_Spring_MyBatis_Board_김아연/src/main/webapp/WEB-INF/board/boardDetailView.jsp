<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- boardDetailView.jsp -->
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
		width: 500px;
		height: 50px;
	}
	td:nth-child(odd) {
		background-color: #b0e0e6;
	}
	td{
		width: 25%;
		height: 30px;
	}
</style>

<b>글내용 보기</b>
<table>
	<tr>
		<td>글번호</td>
		<td>${board.num}</td>
		<td>조회수</td>
		<td>${board.readcount}</td>
	</tr>
	
	<tr>
		<td>작성자</td>
		<td>${board.writer}</td>
		<td>작성일</td>
		<td>
			<fmt:parseDate value="${board.regdate}" var="day" pattern="yyyy-MM-dd"/>
			<fmt:formatDate value="${day}" pattern="yyyy-MM-dd"/>
		</td>
	</tr>
	
	<tr>
		<td>글제목</td>
		<td colspan="3">${board.subject}</td>
	</tr>
	
	<tr>
		<td>글내용</td>
		<td colspan="3" align="left"><pre>${board.content}</pre></td>
	</tr>
	
	<tr>
		<td colspan="4" align="right">
			<input type="button" value="글수정" onClick="location.href='update.br?num=${board.num}&pageNumber=${pageNumber}'">
			<input type="button" value="글삭제" onClick="location.href='delete.br?num=${board.num}&pageNumber=${pageNumber}'">
			<input type="button" value="답글쓰기" onClick="location.href='reply.br?ref=${board.ref}&restep=${board.restep}&relevel=${board.relevel}&pageNumber=${pageNumber}'">
			<input type="button" value="글목록" onclick="location.href='list.br?pageNumber=${pageNumber}'">
		</td>
	</tr>
</table>
