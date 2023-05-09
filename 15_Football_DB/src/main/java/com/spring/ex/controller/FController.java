package com.spring.ex.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.ex.command.FCommand;
import com.spring.ex.command.FDeleteCommand;
import com.spring.ex.command.FInsertCommand;
import com.spring.ex.command.FListCommand;
import com.spring.ex.command.FUpdateCommand;
import com.spring.ex.command.FUpdateFormCommand;
import com.spring.ex.dto.FDto;

@Controller
public class FController {
	
	FCommand command;
	
	// insert 요청 -> insertForm.jsp
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String insert() {
		return "insertForm";
	}
	
	// insertForm.jsp (submit) -> insert 요청
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	// BindingResult는 반드시 객체 다음에 작성해야한다.
	// model 은 상관없지만 @valid 객체 쓰고 BindingResult !! 순서기억하기 !!
	public String insert(@ModelAttribute("fDto") @Valid FDto fDto , BindingResult result, Model model) {
		
		// model.addAttribute("fDto", fDto); // 밑에서 설정했다면 누락됐을때도 해야함. 
		// 또는 @ModelAttribute 어노테이션을 사용해서 자동으로 모델을 설정할 수 있다

		if(result.hasErrors()) {
			return "insertForm"; // 유효성검사 - 누락되었으면(ture) insertForm.jsp
		}
		else {
		
			// request를 쓸수도있지만 fdto 커맨드 객체를 사용해도 된다.
			model.addAttribute("fDto", fDto);
			// 자바로 넘어갈땐 자동으로 설정된 model 객체를 가지고갈수없당.
			
			// fdto.setRound16 에서 자동으로 쉼표연결되어 들어간당!!!!
			command = new FInsertCommand();
			command.execute(model);
			
			return "redirect:/list";
		}
	}
	
	// list요청
	@RequestMapping("list")
	public String list(Model model) {
		command = new FListCommand();
		command.execute(model);
		return "list";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	//@RequestMapping("updateForm")
	public String updateForm(Model model, HttpServletRequest request) {
		//System.out.println("request.getMethod()" + request.getMethod());
		
		model.addAttribute("num", request.getParameter("num"));
		command = new FUpdateFormCommand();
		command.execute(model);
		return "updateForm";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	//@RequestMapping("update")
	public String update(@ModelAttribute("fDto") @Valid FDto fDto , BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			//return "redirect:/updateForm?num=" + fDto.getNum();
			return "updateForm";
		}else {
			model.addAttribute("fDto", fDto);
			command = new FUpdateCommand();
			command.execute(model);
			return "redirect:/list";
		}
	}
	
	@RequestMapping("delete")
	public String delete(Model model, HttpServletRequest request) {
		model.addAttribute("num", request.getParameter("num"));
		command = new FDeleteCommand();
		command.execute(model);
		return "redirect:/list";
	}
}
