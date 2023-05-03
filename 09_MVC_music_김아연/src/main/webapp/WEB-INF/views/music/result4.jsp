<%@page import="com.spring.ex.MusicBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
result4.jsp<br>

<!-- attribute -->
title1 : ${mb.title}<br>
title2 : ${mb['title']}<br>
title3 : ${mb["title"]}<br>
title4 : ${mb.getTitle()}<br>
title5 : ${requestScope.mb.getTitle()}<br>
title6 : <%= ((MusicBean)request.getAttribute("mb")).getTitle() %><br>
title7 : <%= request.getParameter("title") %><br><br>

singer1 : ${mb.singer}<br>
singer2 : ${mb['singer']}<br>
singer3 : ${mb["singer"]}<br>
singer4 : ${mb.getSinger()}<br>
singer5 : ${requestScope.mb.getSinger()}<br>
singer6 : <%= ((MusicBean)request.getAttribute("mb")).getSinger() %><br>
singer7 : <%= request.getParameter("singer") %><br><br>

price1 : ${mb.price}<br>
price2 : ${mb['price']}<br>
price3 : ${mb["price"]}<br>
price4 : ${mb.getPrice()}<br>
price5 : ${requestScope.mb.getPrice()}<br>
price6 : <%= ((MusicBean)request.getAttribute("mb")).getPrice() %><br>
price7 : <%= request.getParameter("price") %><br><br>
