<%@page import="com.spring.ex.PersonBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
person/result5.jsp<br>

${abcd.id}<br>
${abcd['id']}<br>
${abcd["passwd"]}<br>
${abcd.getAddr()}<br>
<%=((PersonBean)request.getAttribute("abcd")).getAddr()%><br>