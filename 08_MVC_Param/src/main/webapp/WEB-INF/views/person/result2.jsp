<%@page import="com.spring.ex.PersonBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
person/input2 요청 -> person/result2.jsp <br>

id : <%=request.getParameter("id") %><br>
id : <%=request.getAttribute("id") %><br><!-- null -->
id : ${param.id}<br>
id : ${param["id"]}<br><br>

pw : <%=request.getParameter("passwd") %><br>
pw : ${param.passwd}<br>
pw : ${param["passwd"]}<br><br>

addr : <%=request.getParameter("addr") %><br>
addr : ${param.addr}<br>
addr : ${param['addr']}<br><br>

============================<br><br>
<%
	PersonBean pb = (PersonBean)request.getAttribute("pb");
%>

pb.id : <%= pb.getId() %><br>
pb.id : ${pb.id}<br>
pb.id : ${pb.getId()}<br><br>

pb.pw : <%= pb.getPasswd() %><br>
pb.pw : ${pb.passwd}<br>
pb.pw : ${pb.getPasswd()}<br><br>

pb.addr : <%= pb.getAddr() %><br>
pb.addr : ${pb.addr}<br>
pb.addr : ${pb.getAddr()}<br><br>

