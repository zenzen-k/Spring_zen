package com.spring.ex;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	
	// 요청명은 프로젝트 내에서 절대!!!!중복되면 안됨 ㅇㅇ
	// 근데 method 구분하는건 ㄱㅊ
	@RequestMapping(value = "form", method = RequestMethod.GET)
	public String form() {
		return "form";
	}
	
	//submit 눌렀을때 실행된다.
	@RequestMapping(value = "form", method = RequestMethod.POST)
	public String input( @Valid MemberBean mb, BindingResult result) {
		
		// model.addAttribute("memberBean", mb);
		
		// @Valid : 유효성 검사를 하면서 객체를 만들어라
		// BindingResult : 만약 누락되어있다면 이곳에 에러가 발생했다는 정보가 들어감
		System.out.println("result.hasErrors() : "+result.hasErrors());
		// result.hasErrors() -> true : 에러발생ㅇㅇ
		// result.hasErrors() -> false : 에러발생ㄴㄴ
		
		String page = "result"; // 넘어갈 페이지 설정
		if(result.hasErrors()) { // 참이면 에러발생ㅇㅇ
			page = "form";
		}
		return page;
		// web-inf/views/result(or form).jsp
	}
}
