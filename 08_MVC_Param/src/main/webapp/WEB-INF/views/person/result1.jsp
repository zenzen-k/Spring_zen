<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
person/input 요청 -> person/result1.jsp<br>

name1 : <%=request.getParameter("name") %><br>
name2 : ${param.name}<br>
name3 : ${param['name']}<br><br>

name1 : <%=request.getAttribute("name") %><br> <!-- null -->
name2 : ${name}<br> <!-- "" -->

age1 : <%=request.getParameter("age") %><br>
age2 : ${param.age}<br>
age3 : ${param['age']}<br>

