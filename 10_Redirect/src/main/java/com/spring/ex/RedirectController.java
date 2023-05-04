package com.spring.ex;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectController {

	// form -> form.jsp
	@RequestMapping("form")
	public String form() {
		return "form";
	}

	@RequestMapping("input")
	// RedirectAttributes : redirect ��û �� ���� ��û���� �ѱ�� ���� �����Ͱ� ���� �� ���⿡ ��Ƽ� �ѱ��.
	public String input(HttpServletRequest request, RedirectAttributes redirectAttr) { 
		System.out.println("input()");
		
		String name = request.getParameter("name");
		System.out.println("name : " + name);
		
		// �Ӽ�����
		request.setAttribute("name", name);
		
		// �Ӽ��� �Ķ���� ��� ��Ʈ�ѷ��� �ѱ����� Map�� �����
		// Ű�� String, ���� �ƹ��ų� ����
		Map<String,Object> map = new HashMap<String,Object>();
		// map�� ���� ������ add�� �ƴ� put�� ����Ѵ�.
		map.put("mname", name); // mname = "������";
		
		redirectAttr.addFlashAttribute("redirectMap", map);
		
		// return "result"; // jsp��û
		return "redirect:/input2"; // ��Ʈ�ѷ���û
		// ������ request�� ���������������� ���� ������ input2�� ���� �ȳѾ.
	}

	@RequestMapping("input2")
	public String input2(HttpServletRequest request, RedirectAttributes redirectAttr) {
		System.out.println("input2()");
		System.out.println("name(param) : " + request.getParameter("name")); //null
		System.out.println("name(attri) : " + request.getAttribute("name")); //null
		
		// ? : ���� ���� ������ϰڴٴ� �ǹ�
		Map<String,?> map = redirectAttr.getFlashAttributes();
		Object obj = map.get("mname");
		
		System.out.println("map : " + obj);
		
		return "result";
	}
	

}
