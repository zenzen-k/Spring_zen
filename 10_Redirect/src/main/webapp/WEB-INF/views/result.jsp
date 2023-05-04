<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

result.jsp<br>

name1 : ${param.name}<br>
name2 : ${param['name']}<br>
name3 : <%=request.getParameter("name") %><br>
name4 : ${name}<br>

name5 : ${redirectMap.mname}<br>
