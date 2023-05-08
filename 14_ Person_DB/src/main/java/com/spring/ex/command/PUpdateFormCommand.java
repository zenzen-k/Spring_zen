package com.spring.ex.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.ex.DTO.PDto;
import com.spring.ex.Dao.PDao;

public class PUpdateFormCommand implements PCommand{

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap(); // Å°. °ª
		HttpServletRequest request = (HttpServletRequest)map.get("req");
		
		PDao pdao = PDao.getInstance();
		PDto pd = pdao.getPersonByNum(request.getParameter("num"));
		
		model.addAttribute("pd", pd);
	}
	
}
