<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
write_Form.jsp<br>

<form action="write" method="post">
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>나이</td>
			<td><input type="text" name="age"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="입력"></td>
		</tr>
	
	</table>
</form>
