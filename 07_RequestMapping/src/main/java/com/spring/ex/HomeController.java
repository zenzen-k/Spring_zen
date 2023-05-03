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
@Controller // 어노테이션 작성해주지 않으면 안된당. 올수없음
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	// get방식 슬래시 요청!!!!!
	// @RequestMapping : 어떤 요청을 작성한다.
	// ex ) @RequestMapping(value="/update.per", method = RequestMethod.POST)
	// jsp의 form에서 작성하지 않으면 get 방식이었지만, 여기서는 method를 생략한다면 post, get 모두 처리한다.
	// 만약 써야할 속성이 하나밖에 없다면 , @RequestMapping("/") 이렇게 작성 가능함
	
	public String home(Locale locale, Model model) {
		// 모델을 사용하기 위해서는 모델을 매개변수로 받아야한다.
		
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date(); // 2023 05 03 10:18 
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		// 날짜 포맷을 설정할수 있는 DateFormat 클래스의 getDateTimeInstance 메서드를 이용하여 길게 표현된다.
		
		String formattedDate = dateFormat.format(date);
		// formattedDate에 해당 날짜를 포멧에 맞춰 넣음
		
		// view에 전달할 내용이 있을 때 model에 속성설정하듯이 설정을 해야한다.
		// 즉, view 에 전달할 내용을 model에 담아서 전달하는 것!
		model.addAttribute("serverTime", formattedDate );
		// request 속성 설정하는것과 같다고 보면 된다.
		// 긴 날짜 형식을 서버타임으로 속성설정을 한다.
		
		return "home"; // view 설정
		// 여기의 home은 아까 중간에 설정되는, /WEB-INF/views/ ~~ .jsp 사이의 ~~ 에 들어간다.
		// 따라서 / 요청을 하면서 home.jsp로 이동하게 되는 것이다.
	} // home
	
	// 컨트롤러 클래스이므로 여러가지 요청을 처리할 수 있다.
	@RequestMapping(value="/member/view") // 생략했으니 get, post 모두 가능
	// 위 요청을 처리하는 메서드가 존재해야하며, 어느 뷰로 갈지 정해야한다.
	public String view() { // 해당 메서드를 호출하는게 ㄴㄴ, /member/view 를 요청할때 메서드가 실행되는것
		return "member/memberView"; // /WEB-INF/views/member/memberView.jsp 가 된당!
	}
	
	//member/input 요청 -> member/insertForm.jsp 이동
	@RequestMapping("member/input")
	public String input(Model model, HttpServletRequest request) {
		// 가져가고 싶은 값이 있을 때!
		model.addAttribute("id", "kim");
		request.setAttribute("passwd", "1234");
		
		return "member/insertForm"; // /WEB-INF/views/member/insertForm.jsp
	}
	
	// member/list 요청 -> member/list.jsp 이동
	@RequestMapping("member/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		// ModelAndView : 무엇을 가지고, 어디로 갈것인지 설정할 수 있는 객체
		mav.addObject("name","윤아");
		mav.addObject("age",30); // 무엇
		mav.setViewName("member/list"); // 어디로
		
		return mav; // 리턴값은 mav를 가지고 가야한다.
	}
	
	// member/list2 요청 -> member/list2.jsp 이동
	@RequestMapping("member/list2")
	public ModelAndView list2() {
		ModelAndView mav = new ModelAndView("member/list2");
		
		return mav; 
	}
}
