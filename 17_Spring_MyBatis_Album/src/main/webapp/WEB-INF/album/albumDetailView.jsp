<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
albumDetailView<br>

<table border="1">
	<tr>
		<td>번호</td>
		<td>${album.num}</td>
	</tr>
	
	<tr>
		<td>제목</td>
		<td>${album.title}</td>
	</tr>
	
	<tr>
		<td>가수</td>
		<td>${album.singer}</td>
	</tr>
	
	<tr>
		<td>가격</td>
		<td>${album.price}</td>
	</tr>
	
	<tr>
		<td>발매일</td>
		<td>${album.day}</td>
	</tr>
	
</table>


