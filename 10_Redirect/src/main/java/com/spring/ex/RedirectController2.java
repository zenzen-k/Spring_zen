package com.spring.ex;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectController2 {
	
	//form2 -> form2.jsp
	@RequestMapping("form2")
	public String form2() {
		return "form2";
	}
	
	//input3 -> input4
	@RequestMapping("input3")
	public String input3(RedirectAttributes redirectAttr, HttpServletRequest request) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("title", request.getParameter("title"));
		map.put("singer", request.getParameter("singer"));
		map.put("price", request.getParameter("price"));
		
		redirectAttr.addFlashAttribute("redirectMap", map);
		
		return "redirect:/input4";
	}
	
	
	//input4 -> result2.jso
	@RequestMapping("input4")
	public String input4() {
		
		return "result2";
	}
	
}
