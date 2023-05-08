<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

result2.jsp<br>

제목 : ${bookBean.title}<br>
저자 : ${bookBean.author}<br>
가격 : ${bookBean.price}<br>
출판사 : ${bookBean.publisher}<br>
구입 가능 서점 : ${bookBean.bookstore}<br> <!-- 알아서 쉼표랑 같이 나온당 -->
배송비 : ${bookBean.kind}<br>

