<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../common/common.jsp" %>
<style>
	.err{
		color: red;
	}
</style>
albumUpdateForm.jsp<br>

<!-- commandName="album" 의 album은 @Model~~~ 설정한 이름을 작성한ㄴ -->
<form:form commandName="album" action="update.ab" method="post">
	<input type="hidden" name="num" value="${album.num}">
	
	<p>
		<!-- label의 for속성 - input의 id와 연결된다 -->
		<label for="title">노래제목</label>
		<input type="text" name="title" id="title" value="${album.title}">
		<form:errors cssClass="err" path="title"/>
	</p>
	
	<p>
		<label for="singer">가수명</label>
		<input type="text" name="singer" id="singer" value="${album.singer}">
		<form:errors cssClass="err" path="singer"/>
	</p>
	
	<p>
		<label for="price">가격</label>
		<input type="text" name="price" id="price" value="${album.price}">
		<form:errors cssClass="err" path="price"/>
	</p>
	
	<!-- 문자열 날짜형식으로 변환함 -->
	<fmt:parseDate value="${album.day}" var="day" pattern="yyyy-MM-dd" scope="page"/>
	<fmt:formatDate var="newDay" value='${day}' pattern='yyyy-MM-dd'></fmt:formatDate>
	<p>
		<label for="day">발매일</label>
		<input type="text" name="day" id="day" value="${newDay}">
	</p>
	<p>
		<input type="submit" value="수정하기">
	</p>
</form:form>


