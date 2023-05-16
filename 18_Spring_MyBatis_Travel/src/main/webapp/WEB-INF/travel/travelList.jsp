<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>

<script>
	function insert() {
		location.href='insert.tv';
	}
	
	function goUpdate(num, pageNumber) {
		//alert(num + " , " + pageNumber);
		location.href='update.tv?num=' + num + '&pageNumber=' + pageNumber;
	}
</script>

travelList.jsp<br>
<h2 align="center">여행 리스트 화면(total:${pageInfo.totalCount})</h2>
<center>
	<form action="list.tv" method="get">
		<!-- 전체검색, 지역,(관심지역), 여행타입 -->
		<select name="whatColumn">
			<option value="">전체 검색</option>
			<option value="area">지역</option>
			<option value="style">여행 타입</option>
		</select>
		<input type="text" name="keyword">
		<input type="submit" value="검색">
	</form>
</center>

<center>
	<table border="1">
		<tr>
			<td colspan="8" align="right">
				<input type="button" value="추가하기" onclick="insert()">
			</td>
		</tr>
		
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>나이</th>
			<th>관심지역</th>
			<th>여행타입</th>
			<th>예상비용</th>
			<th>삭제</th>
			<th>수정</th>
		</tr>
		
		<c:if test="${empty lists}">
			<tr>
				<td colspan="8" align="center">검색 결과가 없습니다.</td>
			</tr>
		</c:if>
		
		<%-- ${fn:length(lists) != 0} --%>
		<c:if test="${not empty lists}">
		<c:forEach var="travel" items="${lists}">
			<tr>
				<td align="center">${travel.num}</td>
				<td align="center"><a href="detail.tv?num=${travel.num}&pageNumber=${pageInfo.pageNumber}">${travel.name}</a></td>
				<td align="right">${travel.age}</td>
				<td>${travel.area}</td>
				<td>${travel.style}</td>
				<td>${travel.price}</td>
				<td>
					<a href="delete.tv?num=${travel.num}&pageNumber=${pageInfo.pageNumber}">삭제</a>
				</td>
				<td>
					<input type="button" value="수정" onclick="goUpdate('${travel.num}','${pageInfo.pageNumber}')">
				</td>
			</tr>
		</c:forEach>
		</c:if>
	</table>
</center>

<center>
	${pageInfo.pagingHtml}
</center>
