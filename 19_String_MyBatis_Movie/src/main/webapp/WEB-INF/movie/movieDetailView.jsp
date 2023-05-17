<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
movieDetailView.jsp<br>

<h2 align="center">영화 상세 화면</h2>
<center>
	<table border="1">
		<tr>
			<td>번호</td>
			<td>${movie.num}</td>
		</tr>
		<tr>
			<td>영화제목</td>
			<td>${movie.title}</td>
		</tr>
		<tr>
			<td>제작국가</td>
			<td>${movie.nation}</td>
		</tr>
		<tr>
			<td>장르</td>
			<td>${movie.genre}</td>
		</tr>
		<tr>
			<td>등급</td>
			<td>${movie.grade}</td>
		</tr>
		<tr>
			<td>배우</td>
			<td>${movie.actor}</td>
		</tr>
		<tr>
			<td colspan="2">
				<!-- 컨트롤러에서 속성 설정 안하고 그냥 별도 설정 없이 parameter로 받을 수 있다. -->
				<!-- 왜냐하면 다음 view jsp로 파라미터가 자동으로 넘어가기 때문이다. -->
				<%-- 
				<a href="list.mv?pageNumber=${param.pageNumber}">영화 리스트 화면으로 돌아감</a> 
				--%>
				<!-- 컨트롤러에서 model로 속성 설정했을 때 -->
				<!-- requestScope.pageNumber / requestScope 생략가넝  -->
				<a href="list.mv?pageNumber=${pageNumber}">영화 리스트 화면으로 돌아감</a>
			</td>
		</tr>
	</table>
</center>