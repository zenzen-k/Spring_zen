<%@page import="com.spring.ex.PersonBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
person/input4 -> person/result4.jsp<br>

id : ${personBean.id}<br>
passwd : ${personBean.getPasswd()}<br>
addr : <% PersonBean pb = (PersonBean)request.getAttribute("personBean");
		out.print(pb.getAddr());%><br>
		<!-- 위 코드 줄이는 방법 (아래) -->
		<%=((PersonBean)request.getAttribute("personBean")).getAddr()%><br>

또는 <br>

id : ${personBean['id']}<br>
id : ${personBean["id"]}<br>
id : ${requestScope.personBean.id}<br>
id : <%=request.getParameter("id") %><br> 
<!-- 
아무것도 안써도 알아서 파라미터값으로도 넘어온다. 
즉, 파라미터로 id, passwd, addr 가 들어오며
커맨드객체로 만들었다면 한묶음씩가져온다.
-->