package com.spring.ex.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.ex.DTO.PDto;
import com.spring.ex.command.PCommand;
import com.spring.ex.command.PListCommand;
import com.spring.ex.command.PUpdateFormCommand;
import com.spring.ex.command.PWriteCommand;

@Controller
public class PController {
	PCommand command;
	// writeForm 요청 -> writeForm.jsp
	@RequestMapping("writeForm")
	public String form() {
		return "write_Form";
	}
	
	// writeForm.jsp (submit) -> write 요청
	@RequestMapping("write")
	public String write(Model model, HttpServletRequest request) {
		System.out.println("PController-write()");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println(id + "/" + name + "/" + age + "\n");
		
		model.addAttribute("req", request); // request 객체자체를 모델 속성으로 넘긴다. 
		
		command = new PWriteCommand();
		command.execute(model); // 메서드 호출함. request를 model 로 넘긴다.
		
		// 삽입 완료 후 목록보기 띄우기위해 list 요청을 한다.
		return "redirect:/list"; 
	}
	
	// write 컨트롤러 -> list 컨트롤러요청
	@RequestMapping("list")
	public String list(Model model) {
		System.out.println("PController-list()");
		
		command = new PListCommand();
		command.execute(model);
		
		return "list";
	}
	
	// list.jsp(num) -> updateForm요청
	@RequestMapping("updateForm")
	public String updateForm(HttpServletRequest request, Model model) { // 넘어오는거 출력해보려고 작성함.
		System.out.println("PController-updateForm()");
		
		String num = request.getParameter("num");
		System.out.println("num : " + num);
		
		model.addAttribute("req", request);
		command = new PUpdateFormCommand();
		command.execute(model);
		
		return "update_form";
	}
	
	//
	@RequestMapping("update")
	public String update(Model model, HttpServletRequest request) {
		
		
		return "";
	}
}
