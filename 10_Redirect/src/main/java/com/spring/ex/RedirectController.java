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
	// RedirectAttributes : redirect 요청 시 다음 요청으로 넘기고 싶은 데이터가 있을 때 여기에 담아서 넘긴다.
	public String input(HttpServletRequest request, RedirectAttributes redirectAttr) { 
		System.out.println("input()");
		
		String name = request.getParameter("name");
		System.out.println("name : " + name);
		
		// 속성설정
		request.setAttribute("name", name);
		
		// 속성과 파라미터 모두 컨트롤러로 넘길수없어서 Map을 사용함
		// 키는 String, 값은 아무거나 가능
		Map<String,Object> map = new HashMap<String,Object>();
		// map은 값을 넣을때 add가 아닌 put을 사용한다.
		map.put("mname", name); // mname = "아이유";
		
		redirectAttr.addFlashAttribute("redirectMap", map);
		
		// return "result"; // jsp요청
		return "redirect:/input2"; // 컨트롤러요청
		// 하지만 request는 다음페이지까지만 가기 때문에 input2로 값이 안넘어감.
	}

	@RequestMapping("input2")
	public String input2(HttpServletRequest request, RedirectAttributes redirectAttr) {
		System.out.println("input2()");
		System.out.println("name(param) : " + request.getParameter("name")); //null
		System.out.println("name(attri) : " + request.getAttribute("name")); //null
		
		// ? : 뭐가 오든 상관ㄴ하겠다는 의미
		Map<String,?> map = redirectAttr.getFlashAttributes();
		Object obj = map.get("mname");
		
		System.out.println("map : " + obj);
		
		return "result";
	}
	

}
