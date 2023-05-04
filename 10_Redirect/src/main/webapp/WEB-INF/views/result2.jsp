<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
result2.jsp<br>

title : ${redirectMap.title}<br>
singer : ${requestScope.redirectMap.singer}<br>
price : ${redirectMap['price']}<br>

<% //((Map)request.getAttribute("redirectMap")).get("price") 
	// 이건 안됨,, request 로 속성설정한게 아니라서그런듯? %>