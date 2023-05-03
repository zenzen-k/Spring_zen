<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

member/list 요청 -> member/list.jsp<br>

name : <%=request.getParameter("name") %><br> <!-- null -->
name : <%=request.getAttribute("name") %><br>
name : ${param.name}<br> <!-- "" -->
name : ${name}<br>
name : ${requestScope.name}<br>

age : <%=request.getParameter("age") %><br> <!-- null -->
age : <%=request.getAttribute("age") %><br>
age : ${param.age}<br> <!-- "" -->
age : ${age}<br>
age : ${requestScope.age}<br>