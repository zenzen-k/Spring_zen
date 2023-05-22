<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
<script>
	function insert() {
		location.href='registerForm.mb';
	}
	function update(id, pageNumber) {
		location.href='update.mb?id=' + id + "&pageNumber=" + pageNumber;
	}
</script>
<h2 align="center">회원 리스트 화면<br>memberList.jsp</h2>
<center>
	<form action="list.mb" method="get">
		<select name="whatColumn">
			<option value="">전체 검색
			<option value="name">이름
			<option value="gender">성별
		</select>
		<input type="text" name="keyword">
		<input type="submit" value="검색">
	</form>
</center>


<center>
	<table border="1">
		<tr>
			<td colspan="9" align="right">
				<input type="button" value="추가하기" onclick="insert()">
			</td>
		</tr>
		<tr>
			<th>ID</th>
			<th>이름</th>
			<th>비번</th>
			<th>성별</th>
			<th>취미</th>
			<th>주소</th>
			<th>포인트</th>
			<th>삭제</th>
			<th>수정</th>
		</tr>
		
		<c:if test="${empty lists}">
			<tr>
				<td colspan="9" align="center">
					검색어에 해당하는 레코드가 없습니다.
				</td>
			</tr>
		</c:if>
		
		<c:if test="${not empty lists}">
			<c:forEach var="lists" items="${lists}">
				<tr>
					<td>${lists.id}</td>
					<td><a herf='detail.mb?id=${lists.id}'>${lists.name}</a></td>
					<td>${lists.password}</td>
					<td>${lists.gender}</td>
					<td>${lists.hobby}</td>
					<td>${lists.address1} ${lists.address2}</td>
					<td>${lists.mpoint}</td>
					<td><a href="delete.mb?id=${lists.id}&pageNumber=${param.pageNumber}">삭제</a></td>
					<td>
						<%-- <a href="update.mb?id=${lists.id}&pageNumber=${param.pageNumber}">수정</a> --%>
						<input type="button" value="수정" onclick="update('${lists.id}','${param.pageNumber}')">
					</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</center>

<center>
	${pageInfo.pagingHtml}
</center>