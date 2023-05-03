package com.spring.ex;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller // ������̼� �ۼ������� ������ �ȵȴ�. �ü�����
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	// get��� ������ ��û!!!!!
	// @RequestMapping : � ��û�� �ۼ��Ѵ�.
	// ex ) @RequestMapping(value="/update.per", method = RequestMethod.POST)
	// jsp�� form���� �ۼ����� ������ get ����̾�����, ���⼭�� method�� �����Ѵٸ� post, get ��� ó���Ѵ�.
	// ���� ����� �Ӽ��� �ϳ��ۿ� ���ٸ� , @RequestMapping("/") �̷��� �ۼ� ������
	
	public String home(Locale locale, Model model) {
		// ���� ����ϱ� ���ؼ��� ���� �Ű������� �޾ƾ��Ѵ�.
		
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date(); // 2023 05 03 10:18 
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		// ��¥ ������ �����Ҽ� �ִ� DateFormat Ŭ������ getDateTimeInstance �޼��带 �̿��Ͽ� ��� ǥ���ȴ�.
		
		String formattedDate = dateFormat.format(date);
		// formattedDate�� �ش� ��¥�� ���信 ���� ����
		
		// view�� ������ ������ ���� �� model�� �Ӽ������ϵ��� ������ �ؾ��Ѵ�.
		// ��, view �� ������ ������ model�� ��Ƽ� �����ϴ� ��!
		model.addAttribute("serverTime", formattedDate );
		// request �Ӽ� �����ϴ°Ͱ� ���ٰ� ���� �ȴ�.
		// �� ��¥ ������ ����Ÿ������ �Ӽ������� �Ѵ�.
		
		return "home"; // view ����
		// ������ home�� �Ʊ� �߰��� �����Ǵ�, /WEB-INF/views/ ~~ .jsp ������ ~~ �� ����.
		// ���� / ��û�� �ϸ鼭 home.jsp�� �̵��ϰ� �Ǵ� ���̴�.
	} // home
	
	// ��Ʈ�ѷ� Ŭ�����̹Ƿ� �������� ��û�� ó���� �� �ִ�.
	@RequestMapping(value="/member/view") // ���������� get, post ��� ����
	// �� ��û�� ó���ϴ� �޼��尡 �����ؾ��ϸ�, ��� ��� ���� ���ؾ��Ѵ�.
	public String view() { // �ش� �޼��带 ȣ���ϴ°� ����, /member/view �� ��û�Ҷ� �޼��尡 ����Ǵ°�
		return "member/memberView"; // /WEB-INF/views/member/memberView.jsp �� �ȴ�!
	}
	
	//member/input ��û -> member/insertForm.jsp �̵�
	@RequestMapping("member/input")
	public String input(Model model, HttpServletRequest request) {
		// �������� ���� ���� ���� ��!
		model.addAttribute("id", "kim");
		request.setAttribute("passwd", "1234");
		
		return "member/insertForm"; // /WEB-INF/views/member/insertForm.jsp
	}
	
	// member/list ��û -> member/list.jsp �̵�
	@RequestMapping("member/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		// ModelAndView : ������ ������, ���� �������� ������ �� �ִ� ��ü
		mav.addObject("name","����");
		mav.addObject("age",30); // ����
		mav.setViewName("member/list"); // ����
		
		return mav; // ���ϰ��� mav�� ������ �����Ѵ�.
	}
	
	// member/list2 ��û -> member/list2.jsp �̵�
	@RequestMapping("member/list2")
	public ModelAndView list2() {
		ModelAndView mav = new ModelAndView("member/list2");
		
		return mav; 
	}
}
