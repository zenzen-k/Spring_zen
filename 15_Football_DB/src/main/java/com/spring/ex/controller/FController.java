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
	
	// insert ��û -> insertForm.jsp
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String insert() {
		return "insertForm";
	}
	
	// insertForm.jsp (submit) -> insert ��û
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	// BindingResult�� �ݵ�� ��ü ������ �ۼ��ؾ��Ѵ�.
	// model �� ��������� @valid ��ü ���� BindingResult !! ��������ϱ� !!
	public String insert(@ModelAttribute("fDto") @Valid FDto fDto , BindingResult result, Model model) {
		
		// model.addAttribute("fDto", fDto); // �ؿ��� �����ߴٸ� ������������ �ؾ���. 
		// �Ǵ� @ModelAttribute ������̼��� ����ؼ� �ڵ����� ���� ������ �� �ִ�

		if(result.hasErrors()) {
			return "insertForm"; // ��ȿ���˻� - �����Ǿ�����(ture) insertForm.jsp
		}
		else {
		
			// request�� ������������ fdto Ŀ�ǵ� ��ü�� ����ص� �ȴ�.
			model.addAttribute("fDto", fDto);
			// �ڹٷ� �Ѿ�� �ڵ����� ������ model ��ü�� ������������.
			
			// fdto.setRound16 ���� �ڵ����� ��ǥ����Ǿ� ����!!!!
			command = new FInsertCommand();
			command.execute(model);
			
			return "redirect:/list";
		}
	}
	
	// list��û
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
