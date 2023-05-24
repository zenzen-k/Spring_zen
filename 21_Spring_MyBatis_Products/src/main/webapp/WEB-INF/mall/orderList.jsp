<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
orderList.jsp<br>

<h2 align="center">주문 내역</h2>
<center>
	<table border="1">
		<tr>
			<td colspan="3" align="center">
				주문자 정보 : ${loginInfo.name}(${loginInfo.id})
			</td>
		</tr>
		<tr>
			<th>주문 번호</th>
			<th>주문 일자</th>
			<th>상세 보기</th>
		</tr>
		
		<c:if test="${fn:length(olist) == 0 }">
			<tr>
				<td colspan="3" align="center">
					주문정보가 없습니다.
				</td>
			</tr>
		</c:if>
		
		<c:if test="${fn:length(olist) != 0 }">
			<c:forEach var="order" items="${olist}">
				<tr>
					<td align="center">${order.oid}</td>
					<td align="center">${order.orderdate}</td>
					<td align="center">
						<a href="orderDetail.mall?oid=${order.oid}">상세 보기</a>
						<!-- OrderDetailContoller -->
					</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</center>