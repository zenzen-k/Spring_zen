<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
result.jsp<br>

제목 : ${param.title}<br>
저자 : ${param.author}<br>
가격 : ${param.price}<br>
출판사 : ${param.publisher}<br>
구입 가능 서점 : 
<c:if test="${empty paramValues.bookstore}">
	구입가능 서점 없음
</c:if>
<c:if test="${paramValues.bookstore != null}">
	<c:forEach var="bookstore" items="${paramValues.bookstore}" varStatus="status">
		${bookstore}
		<c:if test="${!status.last}">,</c:if>
	</c:forEach>
</c:if>
<br>
배송비 : ${param.kind}<br>