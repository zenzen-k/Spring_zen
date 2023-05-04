<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
music\result1.jsp<br>

<!-- parameter -->
title1 : ${param.title}<br>
title2 : ${param['title']}<br>
title3 : ${param["title"]}<br>
title4 : <%=request.getParameter("title") %><br><br>

singer1 : ${param.singer}<br>
singer2 : ${param['singer']}<br>
singer3 : ${param["singer"]}<br>
singer4 : <%=request.getParameter("singer") %><br><br>

price1 : ${param.price}<br>
price2 : ${param['price']}<br>
price3 : ${param["price"]}<br>
price4 : <%=request.getParameter("price") %><br><br>

<!-- 만약 속성도 설정했었다면 -->
title1 : ${title}
title2 : ${requestScope.title}
title3 : <%=request.getAttribute("title")%>