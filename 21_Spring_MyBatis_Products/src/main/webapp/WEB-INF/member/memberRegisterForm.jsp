<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>

<style>
	.err{
		color: red;
		font-size: 10px;
		font-weight: bold;
	}
</style>

<%
	String[] genderArr = {"남자", "여자"};
	String[] hobbyArr = {"마라톤", "영화감상", "게임", "공부"};
%>
<!-- MemberRegisterController 컨트롤러에서 registerForm.mb 요청 -->
memberRegisterForm.jsp<br>
<h2>회원 가입 화면</h2>
<form:form commandName="member" action="registerForm.mb" method="post">
	<p>
		<label>아이디</label>
		<input type="text" name="id" value="${member.id}">
		<form:errors cssClass="err" path="id"/>
	</p>
	<p>	
		<label>이름</label>
		<input type="text" name="name" value="${member.name}">
		<form:errors cssClass="err" path="name"/>
	</p>
	<p>	
		<label>비번</label>
		<input type="text" name="password" value="${member.password}">
		<form:errors cssClass="err" path="password"/>
	</p>
	<p>	
		<label>성별</label>
		<c:forEach var="gen" items="<%=genderArr%>">
			<input type="radio" name="gender" value="${gen}" <c:if test="${gen eq member.gender}">checked</c:if>>${gen}
		</c:forEach>
		<form:errors cssClass="err" path="gender"/>
	</p>
	<p>	
		<label>취미</label>
		<c:forEach var="ho" items="<%=hobbyArr%>">
			<input type="checkbox" name="hobby" value="${ho}" <c:if test="${fn:contains(member.hobby, ho)}">checked</c:if>>${ho}
		</c:forEach>
		<form:errors cssClass="err" path="hobby"/>
	</p>
	<p>	
		<label>주소1</label>
		<input type="text" name="address1" value="${member.address1}">
		<form:errors cssClass="err" path="address1"/>
	</p>
	<p>	
		<label>주소2</label>
		<input type="text" name="address2" value="${member.address2}">
	</p>
	<p>	
		<label>적립포인트</label>
		<input type="text" name="mpoint" value="${member.mpoint}">
	</p>
	<p>	
		<input type="submit" value="추가하기">
	</p>
</form:form>