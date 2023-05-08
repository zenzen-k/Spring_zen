<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<style>
	.err{
		font-weight: bold;
		color: red;
		font-size: 10px;
	}
</style>


bookForm.jsp<br>

<!-- commandName 작성해주어야함! 커맨드객체의 이름! -->
<form:form action="form" method="post" commandName="bookBean">
	제목 : <input type="text" name="title" value="${bookBean.title}"> 
		<form:errors cssClass="err" path="title"/><br> <!-- BookBean의 title변슈 -->
	저자 : <input type="text" name="author" value="${bookBean.author}"> 
		<form:errors cssClass="err" path="author"/><br>
	가격 : <input type="text" name="price" value="${bookBean.price}"> 
		<form:errors cssClass="err" path="price"/><br>
	출판사 : <input type="text" name="publisher" value="${bookBean.publisher}"> 
		<form:errors cssClass="err" path="publisher"/><br>
	구입 가능 서점 : 
		<input type="checkbox" name="bookstore" value="교보문고" <c:if test="${bookBean.bookstore.contains('교보문고')}">checked</c:if>>교보문고  
		<input type="checkbox" name="bookstore" value="알라딘" <c:if test="${bookBean.bookstore.contains('알라딘')}">checked</c:if>>알라딘  
		<input type="checkbox" name="bookstore" value="yes24" <c:if test="${bookBean.bookstore.contains('yes24')}">checked</c:if>>yes24  
		<input type="checkbox" name="bookstore" value="영풍문고" <c:if test="${bookBean.bookstore.contains('영풍문고')}">checked</c:if>>영풍문고 
		<form:errors cssClass="err" path="bookstore"/><br>
		
		<!-- 또는 반복문!! -->
		<%-- 
		<c:forEach var="bs" items="교보문고,알라딘,yes24,영풍문고">
			<input type="checkbox" name="bookstore" value="${bs}" <c:if test="${bookBean.bookstore.contains(bs)}">checked</c:if>>${bs}
		</c:forEach>
		 --%>
		 
		<!-- function -->
		<%-- 
		<input type="checkbox" name="bookstore" value="교보문고" <c:if test="${fn:contains(bookBean.bookstore,'교보문고')}">checked</c:if>>교보문고
		 --%>  
		 
	배송비 : 
		<input type="radio" name="kind" value="유료" <c:if test="${bookBean.kind.equals('유료')}">checked</c:if>>유료 
		<input type="radio" name="kind" value="무료" <c:if test="${bookBean.kind == '무료'}">checked</c:if>>무료
		<!-- EL코드는 eq 문자비교 == 된다는ㅁ점 --> 
		<form:errors cssClass="err" path="kind"/><br><br>
	
	<input type="submit" value="전송">
</form:form>