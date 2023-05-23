<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>


CartListController -> cartList.jsp<br>
장바구니 목록보기
<br><br>


<h2 align="center">주문 내역</h2>
<center>
	<table border="1">
		<tr>
			<td colspan="5" align="center">주문자 정보 : ${loginInfo.name}(${loginInfo.id})</td>
		</tr>
		<tr>
			<th>상픔 번호</th>
			<th>상픔명</th>
			<th>주문 수량</th>
			<th>단가</th>
			<th>금액</th>
		</tr>
		<c:forEach var="shopInfo" items="${slist}">
			<tr>
				<td align="center">${shopInfo.pnum}</td>
				<td align="center">${shopInfo.pname}</td>
				<td align="center">${shopInfo.qty}</td>
				<td align="right">
					<fmt:formatNumber value="${shopInfo.price}" pattern="###,###"/>
				</td>
				<td align="right">
					<fmt:formatNumber value="${shopInfo.amount}" pattern="###,###"/>
				</td>
			</tr>
		</c:forEach>
		
		<tr>
			<td colspan="3" align="center">
				<a href="">결제하기</a>
				<a href="list.prd">추가주문</a>
			</td>
			<td colspan="2" align="center">
				총 금액 : <fmt:formatNumber value="${totalAmount}" pattern="###,###"/>
			</td>
		</tr>
	</table>
</center>