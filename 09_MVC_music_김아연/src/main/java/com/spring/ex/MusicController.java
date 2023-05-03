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
	// request �޾Ƽ� console, result1.jsp ���� ���
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
	// @RequestParam �޾Ƽ� console, result2.jsp ���� ���
	@RequestMapping("input2")
	public String input2(@RequestParam("title") String title, @RequestParam("singer") String singer, @RequestParam("price") String price) {
		System.out.println("title : " + title);
		System.out.println("singer : " + singer);
		System.out.println("price : " + price);
		return "music/result2";
	}
	
	// input3 -> music/result3.jsp
	// command ��ü�� ���� console, result3.jsp ���� ���
	@RequestMapping("input3")
	public String input3(MusicBean mb) {
		System.out.println("title : " + mb.getTitle());
		System.out.println("singer : " + mb.getSinger());
		System.out.println("price : " + mb.getPrice());
		
		return "music/result3";
	}
		
	// input4 -> music/result4.jsp
	// command ��ü�� ����� ��Ī�����ϱ� console, result4.jsp ���� ���
	@RequestMapping("input4")
	public String input4(@ModelAttribute("mb") MusicBean mb) {
		System.out.println("title : " + mb.getTitle());
		System.out.println("singer : " + mb.getSinger());
		System.out.println("price : " + mb.getPrice());
		
		return "music/result4";
	}
		
}
