package com.spring.ex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board") // 공통으로 사용되는 요청을 이렇게 작성할 수 있음
public class ExamController {
	// board/form 요청 -> board/form.jsp 로 이동
	@RequestMapping(value="/form") // 요청 앞에 슬래시( / ) 생략 가능!
	public String form() {
		return "board/form"; // /WEB-INF/views/board/form.jsp
	}
	
	// 오 류 발 생
//	@RequestMapping("member/list")
//	public ModelAndView list() {
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("key","윤아");
//		mav.addObject("age",30); 
//		mav.setViewName("member/list"); 
//		
//		return mav; 
//	}
	// 왜 오류가 발생하냐 ? 
	// 같은 프로젝트안에 요청명이 중복되면 안된다. 꼭 한개만!!!!
	
	
	// member가 아닌 board 로 변경하면 잘됨
	@RequestMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("name","윤아");
		mav.addObject("age",30); 
		mav.setViewName("board/list"); 
		
		return mav; 
	}
}





//회원 입력을 하고 싶을 땐 insert 요청을 해야한다. 이 insert는 회원, 상품, 등등 일 수 있음..
//어느 테이블 관련한 요청인지에 따라서 member/insert product/insert board/insert 이런식으로 사용한다.

