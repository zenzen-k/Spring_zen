<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>

<style>
	.err{
		color : red;
		font-size: 10px;
		font-weight: bold;
	}
</style>

<%
	String[] areaArr = {"유럽", "동남아", "일본", "중국"};
	String[] styleArr = {"패키지","크루즈","자유여행","골프여행"};
	String[] priceArr = {"100~200","200~300","300~400","400~500"};
%>
travelInsertForm.jsp<br>

<h2>여행 정보 등록 화면</h2>
<form:form commandName="travel" action="insert.tv" method="post">
	<p>
		<label>이름 </label> 
		<input type="text" name="name" value="${travel.name}">
		<form:errors cssClass="err" path="name"/>
	</p>
	<p>
		<label>나이 </label> 
		<input type="text" name="age" value="${travel.age}">
		<form:errors cssClass="err" path="age"/><br>
	</p>
	<p>
		<label>관심지역 </label> 
		<c:forEach var="area" items="<%=areaArr%>">
			<input type="checkbox" name="area" value="${area}" <c:if test="${fn:contains(travel.area, area)}">checked</c:if>>${area}
		</c:forEach>
		<form:errors cssClass="err" path="area"/><br>
	</p>
	<p>
		<label>여행타입 </label> 
		<c:forEach var="style" items="<%=styleArr%>">
			<input type="radio" name="style" value="${style}" <c:if test="${travel.style eq style}">checked</c:if>>${style}
		</c:forEach>
		<form:errors cssClass="err" path="style"/><br>
	</p>
	<p>
		<label>가격 </label> 
		<select name="price">
			<option value="">선택하세요</option>
			<c:forEach var="price" items="<%=priceArr%>">
				<option value="${price}" <c:if test="${travel.price == price}">selected</c:if>>${price}</option>
			</c:forEach>
		</select>
		<form:errors cssClass="err" path="price"/><br>
	</p>
	
	<input type="submit" value="추가하기">
</form:form>