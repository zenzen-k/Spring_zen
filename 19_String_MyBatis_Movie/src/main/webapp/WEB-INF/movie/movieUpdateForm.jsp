<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>

<style>
	.err{
		color: red;
		font-size: 9px;
		font-weight: bold;
	}
</style>

<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
<script>
var f_selbox = new Array('아시아', '아프리카', '유럽', '아메리카', '오세아니아');

var s_selbox = new Array();
s_selbox[0] = new Array('한국', '중국', '베트남', '네팔');
s_selbox[1] = new Array('케냐', '가나', '세네갈');
s_selbox[2] = new Array('스페인', '영국', '덴마크', '러시아', '체코');
s_selbox[3] = new Array('미국', '캐나다');
s_selbox[4] = new Array('뉴질랜드', '오스트레일리아');

function init(f) { // form의 정보를 받는다.
	
	for (i = 0; i < f_selbox.length; i++) {
		f.continent.options[i + 1] = new Option(f_selbox[i]);
	}
	
	for (i = 0; i < f_selbox.length; i++) {
		if(f.continent.options[i + 1].value == "${movie.continent}"){
			f.continent[i + 1].selected = true;
			// f.continent[i + 1].setAttribute("selected","selected");
		}
	}
	changeContinent(f);
}

function changeContinent(f) {
	cIndex = f.continent.selectedIndex;
	// 초기화
	for (i = f.nation.length; i > 0; i--) {
		f.nation.options[i] = null;
	}

	for (i = 0; i < s_selbox[cIndex - 1].length; i++) {
		f.nation.options[i + 1] = new Option(s_selbox[cIndex - 1][i]);
	}
	
	for (i = 0; i < s_selbox[cIndex - 1].length; i++) {
		if(f.nation.options[i + 1].value == "${movie.nation}"){
			f.nation[i + 1].selected = true;
		}
	}
}
</script>


movieUpdateForm.jsp<br>
<body onload="init(myform)">
<h2>영화 수정 화면</h2>
	<form:form commandName="movie" action="update.mv" method="post" name="myform">
		<input type="hidden" name="pageNumber" value="${param.pageNumber}">
		<input type="hidden" name="num" value="${movie.num}">
		<table border="1">
			<tr>
				<th>영화 제목</th>
				<td>
					<input type="text" name="title" value="${movie.title}">
					<form:errors cssClass="err" path="title"/>
				</td>
			</tr>
			<tr>
				<th>대륙</th>
				<td>
					<select name="continent" onchange="changeContinent(myform)">
						<option value="">대륙을 선택하세요.
					</select>
					<form:errors cssClass="err" path="continent"/>
				</td>
			</tr>
			<tr>
				<th>나라</th>
				<td>
					<select name="nation">
						<option value="">나라를 선택하세요.
					</select>
					<form:errors cssClass="err" path="nation"/>
				</td>
			</tr>
			<tr>
				<th>장르</th>
				<td>
					<c:forEach var="genreArr" items="액션,스릴러,코미디,판타지,애니메이션">
						<input type="checkbox" name="genre" value="${genreArr}"
						<c:if test="${fn:contains(movie.genre, genreArr)}">checked</c:if>>${genreArr}
					</c:forEach>
					<form:errors cssClass="err" path="genre" />
				</td>
			</tr>
			<tr>
				<th>등급</th>
				<td>
					<c:forEach var="gradeArr" items="19,15,12,7">
						<input type="radio" name="grade" value="${gradeArr}"
						<c:if test="${fn:contains(movie.grade, gradeArr)}">checked</c:if>>${gradeArr}
					</c:forEach>
					<form:errors cssClass="err" path="grade" />
				</td>
			</tr>
			<tr>
				<th>출연 배우</th>
				<td>
					<input type="text" name="actor" value="${movie.actor}">
					<form:errors cssClass="err" path="actor"/>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="수정하기" onclick=""></td>
			</tr>
		</table>
	</form:form>
</body>