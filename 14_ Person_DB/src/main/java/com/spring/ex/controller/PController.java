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
import com.spring.ex.command.PDeleteCommand;
import com.spring.ex.command.PListCommand;
import com.spring.ex.command.PUpdateCommand;
import com.spring.ex.command.PUpdateFormCommand;
import com.spring.ex.command.PWriteCommand;

@Controller
public class PController {
	PCommand command;
	// writeForm ��û -> writeForm.jsp
	@RequestMapping("writeForm")
	public String form() {
		return "write_Form";
	}
	
	// writeForm.jsp (submit) -> write ��û
	@RequestMapping("write")
	public String write(Model model, HttpServletRequest request) {
		System.out.println("PController-write()");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println(id + "/" + name + "/" + age + "\n");
		
		model.addAttribute("req", request); // request ��ü��ü�� �� �Ӽ����� �ѱ��. 
		
		command = new PWriteCommand();
		command.execute(model); // �޼��� ȣ����. request�� model �� �ѱ��.
		
		// ���� �Ϸ� �� ��Ϻ��� �������� list ��û�� �Ѵ�.
		return "redirect:/list"; 
	}
	
	// delete -> list ��û
	// update -> list ��û
	// write ��Ʈ�ѷ� -> list ��Ʈ�ѷ���û
	@RequestMapping("list")
	public String list(Model model) {
		System.out.println("PController-list()");
		
		command = new PListCommand();
		command.execute(model);
		
		return "list";
	}
	
	// list.jsp(num) -> updateForm��û
	@RequestMapping("updateForm")
	public String updateForm(HttpServletRequest request, Model model) { // �Ѿ���°� ����غ����� �ۼ���.
		System.out.println("PController-updateForm()");
		
		String num = request.getParameter("num");
		System.out.println("num : " + num);
		
		model.addAttribute("req", request);
		command = new PUpdateFormCommand();
		command.execute(model);
		
		return "update_form";
	}
	
	// updateForm.jsp -> ������ư -> update ��û��
	@RequestMapping("update")
	public String update(Model model, HttpServletRequest request) {
		model.addAttribute("req", request);
		command = new PUpdateCommand();
		command.execute(model);
		
		return "redirect:/list";
	}
	
	// list.jsp���� delete ��û
	@RequestMapping("delete")
	public String delete(Model model, HttpServletRequest request) {
		model.addAttribute("num", request.getParameter("num"));
		command = new PDeleteCommand();
		command.execute(model);
		
		return "redirect:/list";
	}
}