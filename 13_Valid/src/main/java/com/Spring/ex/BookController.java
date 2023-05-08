package com.Spring.ex;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {
	
	// form ��û -> bookForm.jsp
	@RequestMapping(value = "form", method = RequestMethod.GET)
	public String form(HttpServletRequest request) {
		
		System.out.println("method : " + request.getMethod());
		return "bookForm";
	}
	
	// bookForm.jsp -> form ��û(post) -> result.jsp
	@RequestMapping(value = "form", method = RequestMethod.POST)
	public String form2(@Valid BookBean bb, BindingResult result) {
		
		//System.out.println("method : " + request.getMethod());
		
		if(result.hasErrors()) {
			return "bookForm";
		}
		
		return "result2";
	}
	
}
