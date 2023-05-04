<%@page import="com.spring.ex.MusicBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
music\result3.jsp<br>

<!-- attribute -->
title1 : ${musicBean.title}<br>
title2 : ${musicBean['title']}<br>
title3 : ${musicBean["title"]}<br>
title4 : ${musicBean.getTitle()}<br>
title5 : ${requestScope.musicBean.getTitle()}<br>
title6 : <%= ((MusicBean)request.getAttribute("musicBean")).getTitle() %><br>
title7 : <%= request.getParameter("title") %><br>
title8 : ${param.title}<br><br> 
<!-- form에서 입력한 항목이 파라미터로 요청넘어왔다기 여기까지 넘어오기때문엥 파라미터가능ㅎ -->

singer1 : ${musicBean.singer}<br>
singer2 : ${musicBean['singer']}<br>
singer3 : ${musicBean["singer"]}<br>
singer4 : ${musicBean.getSinger()}<br>
singer5 : ${requestScope.musicBean.getSinger()}<br>
singer6 : <%= ((MusicBean)request.getAttribute("musicBean")).getSinger() %><br>
singer7 : <%= request.getParameter("singer") %><br>
singer8 : ${param.singer}<br><br>

price1 : ${musicBean.price}<br>
price2 : ${musicBean['price']}<br>
price3 : ${musicBean["price"]}<br>
price4 : ${musicBean.getPrice()}<br>
price5 : ${requestScope.musicBean.getPrice()}<br>
price6 : <%= ((MusicBean)request.getAttribute("musicBean")).getPrice() %><br>
price7 : <%= request.getParameter("price") %><br>
price8 : ${param.price}<br><br>
