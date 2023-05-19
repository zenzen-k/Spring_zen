<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
start.jsp<br>
<%
	String viewProduct = "list.prd";
	//String viewProduct = "/list.prd";
	// http://localhost:8080/list.prd ex 가 빠짐
	// 즉, / 를 붙이면 8080/까지가 기본 위치, 안붙이면 ex/까지 기본위치
	
	// 아니면 request.getContextPath()+"/list.prd" 이렇게 작성해도 된다.
	// 즉 위처럼 작성하고자 할때에는 / 필수~! 즉 ex/ 가아닌 ex 까지만 가져옴 

%>
<a href="<%=viewProduct%>">상품 목록 보기</a><br><br>