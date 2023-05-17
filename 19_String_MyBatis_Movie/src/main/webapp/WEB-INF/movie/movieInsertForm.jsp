<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>

<style>
.err, #titleMessage {
	color: red;
	font-size: 10px;
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
		//alert(1);

		f.continent.options[0] = new Option("대륙 선택하세요", "");
		f.nation.options[0] = new Option("나라 선택하세요", "");

		for (i = 0; i < f_selbox.length; i++) {
			f.continent.options[i + 1] = new Option(f_selbox[i]);

			/* 
			if(form.continent[i+1].value == c){
				form.continent[i+1].selected == true; 
			} */
		}
	}

	function changeContinent(f) {
		cIndex = f.continent.selectedIndex;
		//alert(cIndex);
		//cValue = form.continent[cIndex].value;

		// 초기화
		for (i = f.nation.length; i > 0; i--) {
			f.nation.options[i] = null;
		}

		for (i = 0; i < s_selbox[cIndex - 1].length; i++) {
			//alert(s_selbox[cIndex-1][i]);
			f.nation.options[i + 1] = new Option(s_selbox[cIndex - 1][i]);

		}

		/* document.write(<c:if test="${fn:contains(movie.nation, nation)}">selected</c:if>); */
	}

	$(function() {
		//alert('js');
		
		var isCheck = false;
		var use = "";
		
		$("#title_check").click(function() {
			//alert(1);
			
			isCheck = true;
			
			$.ajax({
				url : "title_check_proc.mv",
				data : ({
					title : $('input[name = title]').val()
				}),
				success : function(data) { // 위에 data는 반드시 data지만 옆에 data는 변수명이라 암거나 ㄱㅊ
					//alert(data.length);
					
					if($('input[name=title]').val() == ""){
						$('#titleMessage').html('제목을 입력하세요');
						$('input[name=title]').focus();
					}
					// 원래 trim을 써서 공백을 제거해주어야 했는데, 여기는 공백제거 하지 않아도 된다.
					// return할때 딱 딱 N이랑 Y만 넘어옴!!
					//else if($.trim(data) == "N"){
					else if(data == "N"){
						$('#titleMessage').html("이미 등록한 영화제목입니다");
						$('input[name=title]').select();
						use = "impossible";
						$('#titleMessage').show();
					}
					else if(data == "Y"){
						$('#titleMessage').html("사용가능.");
						use = "possible";
						$('#titleMessage').show();
					}
				},
				error : function() {
					alert("error");
				}
			});
		}); // chk
		
		
		$("#sub").click(function () { // 추가하기 버튼 클릭했을 때
			if(!isCheck){
				alert("중복체크를 먼저 해주세요");
				return false;
			}
			else if(use == "impossible"){
				alert("이미 존재하는 영화입니다");
				$('input[name=title]').select();
				return false;
			}
			else if($('input[name=title]').val() == ""){
				alert("제목을 입력하세요");
				$('input[name=title]').focus();
				return false;
			}
		}); // sub
		
		
		$('input[name=title]').keydown(function () {
			use = "";
			isCheck = false;
			$('#titleMessage').css('display','none');
		}); // keydown

	});
</script>

movieInsertForm.jsp
<br>

<%
String[] genreArr = { "액션", "스릴러", "코미디", "판타지", "애니메이션" };
String[] gradeArr = { "19", "15", "12", "7" };
%>

<body onload="init(form)">
	<h2>영화 정보 등록 화면</h2>
	<form:form commandName="movie" action="insert.mv" method="post"
		name="form">
		<label>영화 제목 :</label>
		<input type="text" name="title" value="${movie.title}">
		<input type="button" value="중복체크" id="title_check">
		<span id="titleMessage"></span>
		<form:errors cssClass="err" path="title" />
		<br>

		<label>대륙 :</label>
		<%-- <input type="text" name="continent" value="${movie.continent}" > --%>
		<select name="continent" onchange="changeContinent(form)"></select>
		<%-- <input type="hidden" name="con" value="${movie.continent}"> --%>
		<form:errors cssClass="err" path="continent" />

		<!-- id="continent" id="nation" 
		> 함수 호출하면서 form 정보를 넘기니까 id 속성 설정을 하지 않아도 ㄱㅊ앗움 
	-->

		<label>나라 :</label>
		<%-- <input type="text" name="nation" value="${movie.nation}"> --%>
		<select name="nation"></select>
		<form:errors cssClass="err" path="nation" />
		<br>

		<label>장르 :</label>
		<c:forEach var="genre" items="<%=genreArr%>">
			<input type="checkbox" name="genre" value="${genre}"
				<c:if test="${fn:contains(movie.genre, genre)}">checked</c:if>>${genre}
	</c:forEach>
		<form:errors cssClass="err" path="genre" />
		<br>

		<label>등급 :</label>
		<c:forEach var="grade" items="<%=gradeArr%>">
			<input type="radio" name="grade" value="${grade}"
				<c:if test="${fn:contains(movie.grade, grade)}">checked</c:if>>${grade}
	</c:forEach>
		<form:errors cssClass="err" path="grade" />
		<br>

		<label>출연 배우 :</label>
		<input type="text" name="actor" value="${movie.actor}">
		<form:errors cssClass="err" path="actor" />
		<br>

		<input type="submit" value="추가하기" id="sub">
	</form:form>
</body>