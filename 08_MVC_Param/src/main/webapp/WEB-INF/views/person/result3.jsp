<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
person/form 요청 -> /person/form.jsp -> person/input3 -> result3.jsp<br>

<%-- 
id : ${pb.id} <br>
passwd : ${pb.passwd}<br>
addr : ${pb.addr}<br>
 --%>
 
id : ${param.id}<br>
passwd : ${param.passwd}<br>
addr : ${param.addr}<br>