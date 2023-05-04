<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<style>
	.err{
		font-size: 9pt;
		color: red;
		font-weight: bold;
	}
</style>

form 요청 -> form.jsp<br>

<!-- 누락된 정보를 memberBean이 가지고 있으며 그 정보를 model속성설정을 해서 form으로 다시 돌아옴 -->


form네임스페이스 필요 <br>
<form:form commandName="memberBean" action="form" method="post">
	아이디 : <input type="text" name="id">
	<!-- .err는 클래스 err임! -->
	<!-- path 는 누락된 변수명 -->
	<form:errors cssClass="err" path="id"/>
	<br>
	
	비밀번호 : <input type="text" name="passwd">
	<form:errors cssClass="err" path="passwd"/>
	<br>
	
	<input type="submit" value="전송">
</form:form>


