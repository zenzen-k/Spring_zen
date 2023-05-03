package com.spring.ex;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonController {
	// person/input1 ��û -> person/result1.jsp �̵�
	
	// get����� �ѱ����� ���� url�� ���� �Է��ص� ��
	// http:://loacalhost:8080/ex/person/input?name=kim&age=20
	@RequestMapping(value="person/input1")
	public String input1(HttpServletRequest request, Model model) {
		// �츮�� ��� parameter ���� �޾ƿ��� ���.
		// request ��ü�� ��û�� �ҋ����� �����������.
		// HttpServletRequest request = new HttpServletRequest();
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		model.addAttribute("name", name+"��!"); // �Ӽ�����
		
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		// dispatcher.forward(request, response); ���������� �̷��� �ڵ尡 �����ִ�.
		return "person/result1";
	}
	
	// person/input2 ��û -> person/result2.jsp �̵�
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
		// String pw = request.getParameter("passwd") �̴�.
		// ��, jsp������ pw�� �ƴ�, passwd�� �̿��Ͽ� ���� �����;��Ѵ�.
		
		//�Ѿ���� 3���� �ѹ�������
		PersonBean pb = new PersonBean(id, pw, juso);
		PersonBean pb2 = new PersonBean();
		pb2.setId(id);
		pb2.setPasswd(pw);
		pb2.setAddr(juso);
		
		// request.setAttribute("pb", pb);
		// �Ǵ� 
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
}
