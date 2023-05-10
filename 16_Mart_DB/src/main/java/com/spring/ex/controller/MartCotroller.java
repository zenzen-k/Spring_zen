package com.spring.ex.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.ex.command.MCommand;
import com.spring.ex.command.MDeleteCommand;
import com.spring.ex.command.MDeleteSelCommand;
import com.spring.ex.command.MInsertCommand;
import com.spring.ex.command.MListCommand;
import com.spring.ex.command.MUpdateCommand;
import com.spring.ex.command.MUpdateFormCommand;
import com.spring.ex.dto.MartDto;

@Controller
public class MartCotroller {
	MCommand command;
	
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String insert() {
		return "insertForm";
	}
	
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(Model model, @ModelAttribute("martDto") @Valid MartDto martDto, BindingResult result) {
		
		if(result.hasErrors()) {
			return "insertForm";
		}
		else {
			//model.addAttribute(martDto);
			command = new MInsertCommand();
			command.execute(model);
			
			return "redirect:/list";
		}
	}
	
	@RequestMapping("list")
	public String list(Model model) {
		command = new MListCommand();
		command.execute(model);
		
		return "list";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(Model model, HttpServletRequest request) {
		model.addAttribute("num", request.getParameter("num"));
		
		command = new MUpdateFormCommand();
		command.execute(model);
		
		return "updateForm";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(Model model, @ModelAttribute("martDto") @Valid MartDto martDto, BindingResult result) {
		
		if(result.hasErrors()) {
			return "updateForm";
		}
		else {
			command = new MUpdateCommand();
			command.execute(model);
			return "redirect:/list";
		}
	}
	
	@RequestMapping("delete")
	public String delete(Model model, HttpServletRequest request) {
		model.addAttribute("num", request.getParameter("num"));
		
		command = new MDeleteCommand();
		command.execute(model);
		
		return "redirect:/list";
	}
	
	@RequestMapping("deleteSel")
	public String deleteAll(Model model, HttpServletRequest request) {
		model.addAttribute("selectDel", request.getParameterValues("rowcheck"));
		
		command = new MDeleteSelCommand();
		command.execute(model);
		
		return "redirect:/list";
	}
}
