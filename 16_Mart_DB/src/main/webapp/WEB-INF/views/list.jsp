<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript" >
	function allChk(obj) {
		
		//alert(1);
		
		var rchk = document.getElementsByName("rowcheck");
		
		if(obj.checked){
			for(var i=0; i<rchk.length; i++){
				rchk[i].checked = true;
			}
		}else{
			for(var i=0; i<rchk.length; i++){
				rchk[i].checked = false;
			}
		}
	}
	
	
	function selectChk() {
		//alert(2);
		
		var rchk = document.getElementsByName("rowcheck");
		var flag = false;
		
		for(var i=0; i<rchk.length; i++){
			if(rchk[i].checked){
				flag = true;
				break;
			}
		}
		
		if(!flag){
			alert('한개 이상 선택하세요');
			return;
		}else{
			document.form.submit();
		}
	}
</script>

list.jsp<br>

<form name="form" action="deleteSel">
<table border="1">
	<tr>
		<td><input type="checkbox" name="allcheck" onclick="allChk(this)"></td>
		<td>번호</td>
		<td>아이디</td>
		<td>비번</td>
		<td>상품</td>
		<td>시간대</td>
		<td>결제</td>
		<td>동의</td>
		<td>수정</td>
		<td>삭제</td>
	</tr>
	
	<c:forEach var="mdto" items="${lists}">
		<tr>
			<td><input type="checkbox" name="rowcheck" value="${mdto.num}"></td>
			<td>${mdto.num}</td>
			<td>${mdto.id}</td>
			<td>${mdto.pw}</td>
			<td>${mdto.product}</td>
			<td>${mdto.time}</td>
			<td>${mdto.approve}</td>
			<td>${mdto.agree}</td>
			<td><a href="update?num=${mdto.num}">수정</a></td>
			<td><a href="delete?num=${mdto.num}">삭제</a></td>
		</tr>
	</c:forEach>
</table>
</form>

<a href="insert">삽입</a>

<input type="button" value="삭제" onclick="selectChk()">