<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
travelDetailView.jsp<br>

<h2 align="center">상세보기</h2>
<center>
	<table border="1" align="center">
		<tr>
			<th width="100">번호</th>
			<td width="200">${travel.num}</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${travel.name}</td>
		</tr>
		<tr>
			<th>나이</th>
			<td>${travel.age}</td>
		</tr>
		<tr>
			<th>관심지역</th>
			<td>${travel.area}</td>
		</tr>
		<tr>
			<th>여행타입</th>
			<td>${travel.style}</td>
		</tr>
		<tr>
			<th>예상비용</th>
			<td>${travel.price}</td>
		</tr>
		<tr>
			<td align="center" colspan="2">
				<a href="list.tv?&pageNumber=${param.pageNumber}">목록보기</a>
			</td>
		</tr>
	</table>
</center>