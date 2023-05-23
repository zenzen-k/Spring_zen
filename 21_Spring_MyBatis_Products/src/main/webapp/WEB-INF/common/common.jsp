<%@page import="member.model.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


접속자 아이디1 : <%=session.getAttribute("loginInfo") %><br>
<!-- member.model.MemberBean@26881dc7 -->

<% MemberBean mb = (MemberBean)session.getAttribute("loginInfo"); %>
<% if(mb != null){ %>
	접속자 아이디2 : <%=mb.getId()%>
<%} %><br>

접속자 아이디3 : ${sessionScope.loginInfo.id}<br>

접속자 아이디4 : ${loginInfo.id}<br>
<!-- 현재페이지 - request - session -->

<%-- 이것도 null체크 해야할듯 
접속자 아이디5 : <%=((MemberBean)session.getAttribute("loginInfo").getId()%> --%>

<a href="<%=request.getContextPath()%>/start.jsp">시작하기</a><br>
<a href="<%=request.getContextPath()%>/list.mall">장바구니</a><br><br>