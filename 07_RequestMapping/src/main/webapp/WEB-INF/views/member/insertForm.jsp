<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
member/input 요청 -> member/insertForm.jsp<br>

id : <%= request.getParameter("id")%> <br> <!-- null임,,! 속성으로 설정했기때문엥! 속성으로 가져와야함 -->
id : <%= request.getAttribute("id")%> <br> 
id : ${param.id}<br> <!-- 아무것도 안넘어옴! -->
id : ${id}<br> <!-- page 속성으로 설정한것이 없으므로 그 다음 범위인 request에서 id를 찾아서 가져온다 -->
id : ${requestScope.id}<br>


passwd : <%= request.getParameter("passwd")%> <br> 
passwd : <%= request.getAttribute("passwd")%> <br> 
passwd : ${param.passwd}<br> 
passwd : ${passwd}<br> 
passwd : ${requestScope.passwd}<br>

-> 결과를 보면 model 과 request의 속성을 가져다 쓸 때 똑같음을 알 수 있당!