<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
<%@ include file="../color.jsp" %>
<!-- boardList.jsp -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/style.css">
<style>
	body{
		text-align: center;
		background-color: #e0ffff;
	}
	table{
		margin: auto;
		width: 700px;
	}
</style>

<h2 align="center">게시판 목록보기</h2>

<center>
	<form action="list.br">
		<select name="whatColumn">
			<option value="">전체 검색</option>
			<option value="subject">제목</option>
			<option value="writer">작성자</option>
		</select>
		<input type="text" name="keyword">
		<input type="submit" value="검색">
	</form>
</center>

<center>
	글목록(전체 글 : ${pageInfo.totalCount})
	<table>
		<tr>
			<td colspan="6" align="right" bgcolor="<%=value_c%>">
				<input type="button" value="추가하기" onclick="location.href='insert.br'">
			</td>
		</tr>
		<tr height="30" bgcolor="<%=title_c%>">
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
			<th>IP</th>
		</tr>
		
		<c:if test="${empty lists}">
			<tr>
				<td colspan="6" align="center" bgcolor="<%=value_c%>">
					검색결과가 없습니다.
				</td>
			</tr>
		</c:if>
		
		<c:if test="${not empty lists}">
		<c:forEach var="lists" items="${lists}" varStatus="status">
			<tr height="30" align="center" bgcolor="<%=value_c%>">
				<!-- 전체 레코드 수 - ( (현재 페이지 번호 - 1) * 한 페이지당 보여지는 레코드 수 + 현재 게시물 출력 순서 ) -->
				<td>${pageInfo.totalCount - (pageInfo.pageNumber - 1) * pageInfo.pageSize - status.index}</td>
				<td align="left">
					<c:set var="wid" value="20"/>
					<c:if test="${lists.relevel > 0}">
						<c:set var="wid" value="${20 * lists.relevel}"/>
						<img src="<%=request.getContextPath()%>/resources/images/level.gif" width="${wid}" height="10">
						<img src="<%=request.getContextPath()%>/resources/images/re.gif">
					</c:if>
					<a href='detail.br?num=${lists.num}&pageNumber=${pageInfo.pageNumber}'>${lists.subject}</a>
				</td>
				<td>${lists.writer}</td>
				<td>${lists.regdate}</td>
				<td>${lists.readcount}</td>
				<td>${lists.ip}</td>
			</tr>
		</c:forEach>
		</c:if>
	</table>
</center>

<center>
	${pageInfo.pagingHtml}
</center>