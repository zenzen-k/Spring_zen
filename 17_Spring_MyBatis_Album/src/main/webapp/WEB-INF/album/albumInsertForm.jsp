<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
<style>
	.err{
		color: red;
	}
</style>
albumInsertForm.jsp <br>

<!-- commandName="album" 의 album은 @Model~~~ 설정한 이름을 작성한ㄴ -->
<form:form commandName="album" action="insert.ab" method="post">
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
	
	<p>
		<label for="day">발매일</label>
		<input type="text" name="day" id="day" value="${album.day}">
	</p>
	
	<p>
		<input type="submit" value="추가하기">
	</p>
</form:form>