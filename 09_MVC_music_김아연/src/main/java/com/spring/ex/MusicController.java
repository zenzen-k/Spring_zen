package com.spring.ex;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MusicController {
	
	//form -> form.jsp
	@RequestMapping("form")
	public String form() {
		return "form";
	}
	
	// input1 -> music/result1.jsp
	// request 받아서 console, result1.jsp 에서 출력
	@RequestMapping("input1")
	public String input1(HttpServletRequest request) {
		String title = request.getParameter("title");
		String singer = request.getParameter("singer");
		String price = request.getParameter("price");
		
		System.out.println("title : " + title);
		System.out.println("singer : " + singer);
		System.out.println("price : " + price);
		return "music/result1";
	}
	
	// input2 -> music/result2.jsp
	// @RequestParam 받아서 console, result2.jsp 에서 출력
	@RequestMapping("input2")
	public String input2(@RequestParam("title") String title, @RequestParam("singer") String singer, @RequestParam("price") String price) {
		System.out.println("title : " + title);
		System.out.println("singer : " + singer);
		System.out.println("price : " + price);
		return "music/result2";
	}
	
	// input3 -> music/result3.jsp
	// command 객체로 만들어서 console, result3.jsp 에서 출력
	@RequestMapping("input3")
	public String input3(MusicBean mb) { //커맨드객체를 쓰려면 매개변수없는 생성자가 반드시 필요하다!
		
		/*
		 * 커맨드 객체에는 다음과 같은 코드가 자동생성된다.
		MusicBean mb = new MusicBean();
		String title = request.getParameter("title");
		String singer = request.getParameter("singer");
		String price = request.getParameter("price");
		mb.setTitle(title);
		mb.setSinger(singer);
		mb.setPrice(Integer.parseInt(price));
		model.addAttribute("musicBean", mb);
		*/
		
		System.out.println("title : " + mb.getTitle());
		System.out.println("singer : " + mb.getSinger());
		System.out.println("price : " + mb.getPrice());
		
		return "music/result3";
	}
		
	// input4 -> music/result4.jsp
	// command 객체로 만들고 별칭설정하기 console, result4.jsp 에서 출력
	@RequestMapping("input4")
	public String input4(@ModelAttribute("mb") MusicBean mb) {
		System.out.println("title : " + mb.getTitle());
		System.out.println("singer : " + mb.getSinger());
		System.out.println("price : " + mb.getPrice());
		
		// model.addAttribute("mb", mb);
		
		return "music/result4";
	}
		
}
