<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>

<style>
	th{
		background-color: lightgray;
	}
	.err{
		color: red;
		font-size: 10px;
		font-weight: bold;
	}
</style>

<script>
	var firstArr = new Array('pc','console');
	var secondArr = new Array();
	secondArr[0] = new Array('윈도우','macOS');
	secondArr[1] = new Array('PS4','XBOX','Nintendo');
	
	function init(f) {
		for(var i=0; i<firstArr.length; i++){
			f.device.options[i+1] = new Option(firstArr[i]);
		}
		
		for(var i=0; i<firstArr.length; i++){
			if(f.device.options[i+1].value == '${game.device}'){
				f.device.options[i+1].selected = true;
			}
		}
		secondSel(f);
	}
	
	function secondSel(f) {
		fIndex = f.device.selectedIndex;
		
		for(i=f.platform.length; i>0; i--){
			f.platform.options[i] = null;
		}
		
		for(i=0; i<secondArr[fIndex-1].length; i++){
			f.platform.options[i+1] = new Option(secondArr[fIndex - 1][i]);
		}
		
		for(var i=0; i<secondArr[fIndex-1].length; i++){
			if(f.platform.options[i+1].value == '${game.platform}'){
				f.platform.options[i+1].selected = true;
			}
		}
	}
</script>

gameUpdateForm.jsp<br>
<%
	String[] genreArr = {"슈팅","AOS","액션","어드벤처","RPG"};
	String[] gradeArr = {"19세","17세","15세","12세","7세","전체"};
%>
<h2 align="center">게임 수정</h2>

<body onload="init(updateForm)">
	<form:form commandName="game" action="update.gm" method="post" name="updateForm">
		<input type="hidden" name="num" value="${game.num}">
		<input type="hidden" name="pageNumber" value="${pageNumber}">
		<table border="1" style="margin: auto;">
			<tr>
				<th>제목</th>
				<td colspan="3">
					<input type="text" name="title" value="${game.title}">
					<form:errors cssClass="err" path="title"/>
				</td>
			</tr>
			<tr>
				<th>개발회사</th>
				<td colspan="3">
					<input type="text" name="company" value="${game.company}">
					<form:errors cssClass="err" path="company"/>
				</td>
			</tr>
			<tr>
				<th>기기</th>
				<td>
					<select name="device" onchange="secondSel(updateForm)">
						<option value="">플레이 기종을 선택하세요
					</select>
					<form:errors cssClass="err" path="device"/>
				</td>
				<th>플랫폼</th>
				<td>
					<select name="platform">
						<option value="">플랫폼을 선택하세요
					</select>
					<form:errors cssClass="err" path="platform"/>
				</td>
			</tr>
			<tr>
				<th>장르</th>
				<td colspan="3">
					<c:forEach var="genre" items="<%=genreArr%>">
						<input type="checkbox" name="genre" value="${genre}" <c:if test="${fn:contains(game.genre, genre)}">checked</c:if>>${genre}
					</c:forEach>
					<form:errors cssClass="err" path="genre"/>
				</td>
			</tr>
			<tr>
				<th>연령등급</th>
				<td colspan="3">
					<c:forEach var="grade" items="<%=gradeArr%>">
						<input type="radio" name="grade" value="${grade}" <c:if test="${game.grade == grade}">checked</c:if>>${grade}
					</c:forEach>
					<form:errors cssClass="err" path="grade"/>
				</td>
			</tr>
			<tr>
				<th>가격</th>
				<td colspan="3">
					<input type="text" name="price" value="${game.price}">
					<form:errors cssClass="err" path="price"/>
				</td>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<input type="submit" value="등록하기">
				</td>
			</tr>
		</table>
	</form:form>
</body>