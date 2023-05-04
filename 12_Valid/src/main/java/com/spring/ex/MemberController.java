package com.spring.ex;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	
	// ��û���� ������Ʈ ������ ����!!!!�ߺ��Ǹ� �ȵ� ����
	// �ٵ� method �����ϴ°� ����
	@RequestMapping(value = "form", method = RequestMethod.GET)
	public String form() {
		return "form";
	}
	
	//submit �������� ����ȴ�.
	@RequestMapping(value = "form", method = RequestMethod.POST)
	public String input( @Valid MemberBean mb, BindingResult result) {
		
		// model.addAttribute("memberBean", mb);
		
		// @Valid : ��ȿ�� �˻縦 �ϸ鼭 ��ü�� ������
		// BindingResult : ���� �����Ǿ��ִٸ� �̰��� ������ �߻��ߴٴ� ������ ��
		System.out.println("result.hasErrors() : "+result.hasErrors());
		// result.hasErrors() -> true : �����߻�����
		// result.hasErrors() -> false : �����߻�����
		
		String page = "result"; // �Ѿ ������ ����
		if(result.hasErrors()) { // ���̸� �����߻�����
			page = "form";
		}
		return page;
		// web-inf/views/result(or form).jsp
	}
}
