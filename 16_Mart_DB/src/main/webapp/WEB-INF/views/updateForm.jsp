<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
updateForm.jsp<br>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<style>
	.err{
		color: red;
		font-size: 10;
		font-weight: bold;
	}
</style>

<%
	String[] product = {"식품","의류","도서","가구"};
	String[] time = {"9시~11시","11시~1시","1시~5시","5시~9시"};
	String[] approve = {"카드", "핸드폰"};
%>

<h2> 이마트 상품 구매 내역 </h2>
<form:form commandName="martDto" METHOD="post" ACTION="update">
	
	<input type="hidden" name="num" value="${martDto.num}">
	
	<span>아이디 :</span> <INPUT TYPE="text" NAME="id" value="${martDto.id}">
	<form:errors cssClass="err" path="id"/><br>
	<span>비번 :</span> <INPUT TYPE="text" NAME="pw" value="${martDto.pw}">
	<form:errors cssClass="err" path="pw"/><br>
  <p> 
 
 
<span>구매상품:</span>
	<c:forEach var="parr" items="<%=product%>">
		<input type="checkbox" name="product" value="${parr}" <c:if test="${fn:contains(martDto.product, parr)}">checked</c:if>>${parr}
	</c:forEach>
	<form:errors cssClass="err" path="product"/>
<p>

<span>배송시간 :</span> 
 	<SELECT NAME="time">
 		<OPTION VALUE="">선택</OPTION>
 		<c:forEach var="tarr" items="<%=time%>">
			<OPTION VALUE="${tarr}" <c:if test="${tarr eq martDto.time}">selected</c:if>>${tarr}</OPTION>
		</c:forEach>
	</SELECT>
	<form:errors cssClass="err" path="time"/>
<p>

<span>결제방법:</span>
	<c:forEach var="aparr" items="<%=approve%>">
		${aparr} <INPUT TYPE="radio" NAME="approve" VALUE="${aparr}" <c:if test="${aparr eq martDto.approve}">checked</c:if>>
	</c:forEach>
	<form:errors cssClass="err" path="approve"/>
<p>

<span>결제 동의합니다. </span>  
	<INPUT TYPE="checkbox" NAME="agree" value="동의함" <c:if test="${martDto.agree eq '동의함'}">checked</c:if> > 
	<form:errors cssClass="err" path="agree"/>
<p>

<INPUT TYPE="submit" value="수정">
<INPUT TYPE="button" onclick="location.href='update?num=${martDto.num}'" value="초기화">
</form:form>