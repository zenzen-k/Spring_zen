<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
<script>
	function register() {
		//alert(1);
		location.href='registerForm.mb';
	}
	
	function listMember() {
		location.href='list.mb';
	}
</script>


member\memberLoginForm<br>

<form action="loginForm.mb" method="post">
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td>비번</td>
			<td><input type="text" name="password"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="로그인">
				<input type="reset" value="취소">
				<input type="button" value="회원가입" onclick="register()">
				<input type="button" value="회원목록보기" onclick="listMember()">
			</td>
		</tr>
	</table>
</form>