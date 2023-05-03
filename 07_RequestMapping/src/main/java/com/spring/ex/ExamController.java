package com.spring.ex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board") // �������� ���Ǵ� ��û�� �̷��� �ۼ��� �� ����
public class ExamController {
	// board/form ��û -> board/form.jsp �� �̵�
	@RequestMapping(value="/form") // ��û �տ� ������( / ) ���� ����!
	public String form() {
		return "board/form"; // /WEB-INF/views/board/form.jsp
	}
	
	// �� �� �� ��
//	@RequestMapping("member/list")
//	public ModelAndView list() {
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("key","����");
//		mav.addObject("age",30); 
//		mav.setViewName("member/list"); 
//		
//		return mav; 
//	}
	// �� ������ �߻��ϳ� ? 
	// ���� ������Ʈ�ȿ� ��û���� �ߺ��Ǹ� �ȵȴ�. �� �Ѱ���!!!!
	
	
	// member�� �ƴ� board �� �����ϸ� �ߵ�
	@RequestMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("name","����");
		mav.addObject("age",30); 
		mav.setViewName("board/list"); 
		
		return mav; 
	}
}





//ȸ�� �Է��� �ϰ� ���� �� insert ��û�� �ؾ��Ѵ�. �� insert�� ȸ��, ��ǰ, ��� �� �� ����..
//��� ���̺� ������ ��û������ ���� member/insert product/insert board/insert �̷������� ����Ѵ�.

