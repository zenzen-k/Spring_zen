package com.spring.ex;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonController {
	// person/input1 요청 -> person/result1.jsp 이동
	
	// get방식은 넘기고싶은 값을 url에 직접 입력해도 됨
	// http:://loacalhost:8080/ex/person/input?name=kim&age=20
	@RequestMapping(value="person/input1")
	public String input1(HttpServletRequest request, Model model) {
		// 우리가 평소 parameter 값을 받아오던 방식.
		// request 객체는 요청을 할떄마다 만들어졌었다.
		// HttpServletRequest request = new HttpServletRequest();
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		model.addAttribute("name", name+"님!"); // 속성설정
		
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		// dispatcher.forward(request, response); 내부적으로 이러한 코드가 숨어있다.
		return "person/result1";
	}
	
	// person/input2 요청 -> person/result2.jsp 이동
	// http://localhost:8080/ex/person/input2?id=kim&passwd=1234&addr=seoul
	@RequestMapping("/person/input2")
	
	// String id = request.getParameter(id);
	public String input2(
				@RequestParam("id") String id, 
				@RequestParam("passwd") String pw, 
				@RequestParam("addr") String juso, 
				HttpServletRequest request,
				Model model) { 
		
		System.out.println("id : " + id);
		System.out.println("pw : " + pw);
		System.out.println("addr : " + juso);
		// String pw = request.getParameter("passwd") 이다.
		// 즉, jsp에서는 pw가 아닌, passwd를 이용하여 값을 가져와야한다.
		
		//넘어오는 3가지 한묶음으로
		PersonBean pb = new PersonBean(id, pw, juso);
		PersonBean pb2 = new PersonBean();
		pb2.setId(id);
		pb2.setPasswd(pw);
		pb2.setAddr(juso);
		
		// request.setAttribute("pb", pb);
		// 또는 
		model.addAttribute("pb", pb);
		
		return "person/result2";
	}
	
	
	@RequestMapping("person/form")
	public String form() {
		return "person/form";
	}
	
	@RequestMapping("person/input3")
	public String input3() {
		return "person/result3";
	}
	
	@RequestMapping("person/input4")
	public String input4(PersonBean per) {
		
//		PersonBean per = new PersonBean();
//		per.setId(reqeust.getParameter("id"));
//		per.setPasswd(reqeust.getParameter("passwd"));
//		per.setAddr(reqeust.getParameter("addr"));
//		model.addAttribute("personBean", per);
		// 클래스명과 같지만, 첫글자가 소문자로 변경된것으로 바뀐다.(따라서 jsp 넘어가서는 personBean으로 접근하기)
//		위의 작업이 자동으로 이루어진다.
		
		System.out.println(per.getId());
		System.out.println(per.getPasswd());
		System.out.println(per.getAddr());
		return "person/result4";
	}
	
	@RequestMapping("person/input5")
	public String input5(@ModelAttribute("abcd") PersonBean per) {
		//model.addAttribute("personBean", per); 자동으로 됨~~~
		return "person/result5";
	}
}
